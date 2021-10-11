package za.ac.nwu.accountsys.logic.flow;

import domain.dto.AccountUsersDTO;

public interface CreateAccountUserFlow {
    AccountUsersDTO create(AccountUsersDTO accountUser);
}
