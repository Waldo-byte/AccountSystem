package za.ac.nwu.accountsys.translator;

import domain.dto.AccountUsersDTO;

import java.util.List;

public interface AccountUserTranslator {
    List<AccountUsersDTO> getAll();

    AccountUsersDTO create(AccountUsersDTO accountUsersDTO);
}
