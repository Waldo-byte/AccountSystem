package za.ac.nwu.accountsys.translator;

import domain.dto.AccountTypeDTO;

import java.util.List;

public interface AccountTypeTranslator {
    List<AccountTypeDTO> getAllAccountTypes();

    AccountTypeDTO create(AccountTypeDTO accountType);
}
