package za.ac.nwu.accountsys.logic.flow;

import domain.dto.AccountTransactionDTO;

import java.util.List;

public interface FetchAccountTransFlow {
    List<AccountTransactionDTO> getAllTransactions();
}
