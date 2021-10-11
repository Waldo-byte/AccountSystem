package za.ac.nwu.accountsys.logic.flow.Impl;

import domain.dto.AccountUsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import za.ac.nwu.accountsys.logic.flow.FetchAccountUserFlow;
import za.ac.nwu.accountsys.translator.AccountUserTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
@ComponentScan(value = "za.ac.nwu.accountsys.translator")
public class FetchAccountUserFlowImpl implements FetchAccountUserFlow {

    private final AccountUserTranslator accountUserTranslator;

    @Autowired
    public FetchAccountUserFlowImpl(AccountUserTranslator accountUserTranslator) {
        this.accountUserTranslator = accountUserTranslator;
    }

    @Override
    public List<AccountUsersDTO> getAll() {
        return accountUserTranslator.getAll();
    }
}
