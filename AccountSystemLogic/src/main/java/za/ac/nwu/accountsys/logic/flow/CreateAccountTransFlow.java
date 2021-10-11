package za.ac.nwu.accountsys.logic.flow;

import domain.dto.AccountTransactionDTO;


public interface CreateAccountTransFlow {
    AccountTransactionDTO create(AccountTransactionDTO accountTrans);
}
