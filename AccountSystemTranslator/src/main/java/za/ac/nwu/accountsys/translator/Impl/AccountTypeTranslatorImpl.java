package za.ac.nwu.accountsys.translator.Impl;

import domain.dto.AccountTypeDTO;
import domain.persistance.AccountTyoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import za.ac.nwu.accountsys.repo.persistence.AccountTypeRepository;
import za.ac.nwu.accountsys.translator.AccountTypeTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan("za.ac.nwu.accountsys.repo.persistence")
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDTO> getAllAccountTypes() {
        List<AccountTypeDTO> accountTypeDTOS = new ArrayList<>();
        try{

            for(AccountTyoe accountTyoe : accountTypeRepository.findAll()){
                accountTypeDTOS.add(new AccountTypeDTO(accountTyoe));
            }

        }
        catch(Exception e){
            throw new RuntimeException("Unable to read from database.", e);
        }
        return accountTypeDTOS;
    }

    @Override
    public AccountTypeDTO create(AccountTypeDTO accountTypeDTO) {
        try{
            AccountTyoe temporary_at = accountTypeDTO.getAccountType();
            temporary_at.setCreationDate(LocalDate.now());
            AccountTyoe accountTyoe = accountTypeRepository.save(temporary_at);
            return new AccountTypeDTO(accountTyoe);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to save to db", e);
        }

    }
}
