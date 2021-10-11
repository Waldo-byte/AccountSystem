package za.ac.nwu.accountsys.translator.Impl;

import domain.dto.AccountTypeDTO;
import domain.dto.AccountUsersDTO;
import domain.persistance.AccountTyoe;
import domain.persistance.AccountUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
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

    @Autowired
    public AccountUserTranslatorImp(AccountUserRepository accountUserRepository) {
        this.accountUserRepository = accountUserRepository;
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
}
