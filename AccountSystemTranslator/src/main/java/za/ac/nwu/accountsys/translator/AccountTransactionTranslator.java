package za.ac.nwu.accountsys.translator;

import domain.dto.AccountTransactionDTO;
import domain.dto.AccountTypeDTO;
import domain.persistance.AccountTransaction;

import java.util.List;

public interface AccountTransactionTranslator {
    List<AccountTransactionDTO> getAllTransactions();

    AccountTransactionDTO create(AccountTransactionDTO accountTransaction);
}
