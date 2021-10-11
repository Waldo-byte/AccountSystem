package za.ac.nwu.accountsys.logic.flow;

import domain.dto.AccountUsersDTO;

import java.util.List;

public interface FetchAccountUserFlow {
    List<AccountUsersDTO> getAll();
}
