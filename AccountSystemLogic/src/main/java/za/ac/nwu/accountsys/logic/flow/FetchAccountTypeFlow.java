package za.ac.nwu.accountsys.logic.flow;

import domain.dto.AccountTypeDTO;

import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDTO> getAllAccountTypes();

}
