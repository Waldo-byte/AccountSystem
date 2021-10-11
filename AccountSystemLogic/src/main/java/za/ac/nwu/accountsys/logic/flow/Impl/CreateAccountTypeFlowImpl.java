package za.ac.nwu.accountsys.logic.flow.Impl;


import domain.dto.AccountTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import za.ac.nwu.accountsys.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.accountsys.translator.AccountTypeTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
@ComponentScan(value = "za.ac.nwu.accountsys.translator")
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDTO create(AccountTypeDTO accountType) {
        return accountTypeTranslator.create(accountType);
    }
}
