package za.ac.nwu.accountsys.logic.flow.Impl;

import domain.dto.AccountTransactionDTO;
import domain.dto.AccountTypeDTO;
import domain.persistance.AccountTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import za.ac.nwu.accountsys.logic.flow.CreateAccountTransFlow;
import za.ac.nwu.accountsys.translator.AccountTransactionTranslator;
import za.ac.nwu.accountsys.translator.Impl.AccountTransactionTranslatorImpl;

import javax.transaction.Transactional;

@Transactional
@Component
@ComponentScan(value = "za.ac.nwu.accountsys.translator")
public class CreateAccountTransFlowImpl implements CreateAccountTransFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;

    @Autowired
    public CreateAccountTransFlowImpl(AccountTransactionTranslator accountTransactionTranslator) {
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public AccountTransactionDTO create(AccountTransactionDTO accountTransaction) {
        return accountTransactionTranslator.create(accountTransaction);
    }
}
