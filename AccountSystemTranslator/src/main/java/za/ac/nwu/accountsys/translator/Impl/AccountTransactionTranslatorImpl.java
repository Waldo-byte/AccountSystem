package za.ac.nwu.accountsys.translator.Impl;

import domain.dto.AccountTransactionDTO;
import domain.dto.AccountTypeDTO;
import domain.persistance.AccountTransaction;
import domain.persistance.AccountTyoe;
import domain.persistance.AccountUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import za.ac.nwu.accountsys.repo.persistence.AccountTransactionRepository;

import za.ac.nwu.accountsys.repo.persistence.AccountTypeRepository;
import za.ac.nwu.accountsys.repo.persistence.AccountUserRepository;
import za.ac.nwu.accountsys.translator.AccountTransactionTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan("za.ac.nwu.accountsys.repo.persistence")
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private final AccountTransactionRepository accountTransactionRepository;
    private final AccountTypeRepository accountTypeRepository;
    private final AccountUserRepository accountUserRepository;

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository, AccountTypeRepository accountTypeRepository, AccountUserRepository accountUserRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
        this.accountTypeRepository = accountTypeRepository;
        this.accountUserRepository = accountUserRepository;
    }


    @Override
    public List<AccountTransactionDTO> getAllTransactions() {
        List<AccountTransactionDTO> accountTransactionDTOS = new ArrayList<>();
        try{

            for(AccountTransaction accountransaction : accountTransactionRepository.findAll()){
                accountTransactionDTOS.add(new AccountTransactionDTO(accountransaction));
            }

        }
        catch(Exception e){
            throw new RuntimeException("Unable to read from database.", e);
        }
        return accountTransactionDTOS;
    }

    @Override
    public AccountTransactionDTO create(AccountTransactionDTO accountTransactionDTO) {
        try{
            AccountUser accountUser = accountUserRepository.getOne(accountTransactionDTO.getUserid());
            AccountTyoe accountTyoe = accountTypeRepository.getOne(accountTransactionDTO.getAccountypeid());
            return new AccountTransactionDTO(
                    accountTransactionRepository.save(
                            new AccountTransaction(
                                    accountUser,
                                    accountTyoe,
                                    accountTransactionDTO.getAmount(),
                                    LocalDate.now()
                            )
                    )
            );
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to save to db", e);
        }

    }
}
