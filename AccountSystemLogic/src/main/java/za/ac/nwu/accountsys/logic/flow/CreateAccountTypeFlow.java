package za.ac.nwu.accountsys.logic.flow;

import domain.dto.AccountTypeDTO;

public interface CreateAccountTypeFlow {
    AccountTypeDTO create(AccountTypeDTO accountType);
}
