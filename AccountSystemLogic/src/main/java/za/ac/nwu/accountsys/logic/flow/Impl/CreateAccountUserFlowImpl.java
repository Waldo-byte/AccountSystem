package za.ac.nwu.accountsys.logic.flow.Impl;


import domain.dto.AccountUsersDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import za.ac.nwu.accountsys.logic.flow.CreateAccountUserFlow;
import za.ac.nwu.accountsys.translator.AccountUserTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
@ComponentScan(value = "za.ac.nwu.accountsys.translator")
public class CreateAccountUserFlowImpl implements CreateAccountUserFlow {

    private final AccountUserTranslator accountUserTranslator;

    public CreateAccountUserFlowImpl(AccountUserTranslator accountUserTranslator) {
        this.accountUserTranslator = accountUserTranslator;
    }

    @Override
    public AccountUsersDTO create(AccountUsersDTO accountUser) {
        return accountUserTranslator.create(accountUser);
    }
}
