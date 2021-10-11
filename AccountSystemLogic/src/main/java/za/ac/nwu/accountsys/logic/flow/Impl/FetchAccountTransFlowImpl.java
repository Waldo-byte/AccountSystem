package za.ac.nwu.accountsys.logic.flow.Impl;

import domain.dto.AccountTransactionDTO;
import domain.dto.AccountTypeDTO;
import domain.dto.AccountUsersDTO;
import domain.persistance.AccountTransaction;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import za.ac.nwu.accountsys.logic.flow.FetchAccountTransFlow;
import za.ac.nwu.accountsys.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.accountsys.translator.AccountTransactionTranslator;
import za.ac.nwu.accountsys.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
@ComponentScan(value = "za.ac.nwu.accountsys.translator")
public class FetchAccountTransFlowImpl implements FetchAccountTransFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;

    public FetchAccountTransFlowImpl(AccountTransactionTranslator accountTransactionTranslator) {
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public List<AccountTransactionDTO> getAllTransactions() {
        return accountTransactionTranslator.getAllTransactions();
    }

}
