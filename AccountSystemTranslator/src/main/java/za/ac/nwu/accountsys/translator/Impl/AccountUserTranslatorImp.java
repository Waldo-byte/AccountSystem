package za.ac.nwu.accountsys.translator.Impl;

import domain.dto.AccountBalanceDTO;
import domain.dto.AccountTypeDTO;
import domain.dto.AccountUsersDTO;
import domain.persistance.AccountTransaction;
import domain.persistance.AccountTyoe;
import domain.persistance.AccountUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import za.ac.nwu.accountsys.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.accountsys.repo.persistence.AccountTypeRepository;
import za.ac.nwu.accountsys.repo.persistence.AccountUserRepository;
import za.ac.nwu.accountsys.translator.AccountUserTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan("za.ac.nwu.accountsys.repo.persistence")
public class AccountUserTranslatorImp implements AccountUserTranslator {

    private final AccountUserRepository accountUserRepository;
    private final AccountTypeRepository accountTypeRepository;
    private final AccountTransactionRepository accountTransactionRepository;

    @Autowired
    public AccountUserTranslatorImp(AccountUserRepository accountUserRepository, AccountTypeRepository accountTypeRepository, AccountTransactionRepository accountTransactionRepository) {
        this.accountUserRepository = accountUserRepository;
        this.accountTypeRepository = accountTypeRepository;
        this.accountTransactionRepository = accountTransactionRepository;
    }


    @Override
    public List<AccountUsersDTO> getAll() {
        List<AccountUsersDTO> accountUsersDTOS = new ArrayList<>();
        try{

            for(AccountUser accountUser : accountUserRepository.findAll()){
                accountUsersDTOS.add(new AccountUsersDTO(accountUser));
            }

        }
        catch(Exception e){
            throw new RuntimeException("Unable to read from database.", e);
        }
        return accountUsersDTOS;
    }

    @Override
    public AccountUsersDTO create(AccountUsersDTO accountUsersDTO) {
        try{
            AccountUser temporary_user = accountUsersDTO.getAccountUser();
            AccountUser accountUser = accountUserRepository.save(temporary_user);
            return new AccountUsersDTO(accountUser);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to save to db", e);
        }

    }

    @Override
    public List<AccountBalanceDTO> getMemberBalances(long userID){
        try{
            List<AccountBalanceDTO> accountBalanceDTOS = new ArrayList<>();

            AccountUser accountUser = accountUserRepository.getOne(userID);
            List<AccountTransaction> accountTransactions = accountTransactionRepository.getMemberBalances(accountUser);

            for(AccountTransaction accountTransaction : accountTransactions){
                boolean balance = false;
                for(int i = 0; i < accountBalanceDTOS.size(); i++){
                    AccountBalanceDTO tempBalance = accountBalanceDTOS.get(i);
                    if(tempBalance.getAccountid() == accountTransaction.getAccountTyoe().getAccountTypeID())
                    {
                        balance = true;
                        tempBalance.setBalance(tempBalance.getBalance() + (long) accountTransaction.getAmount());
                        accountBalanceDTOS.set(i, tempBalance);
                    }
                }
                if(!balance)
                {
                    accountBalanceDTOS.add(new AccountBalanceDTO(accountTransaction.getAccountTyoe().getAccountTypeID(),(long) accountTransaction.getAmount()));
                }

            }
            return accountBalanceDTOS;

        }
        catch(Exception e){
            throw new RuntimeException("Could not retrieve database");

        }

    }

}
