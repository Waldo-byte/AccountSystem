package za.ac.nwu.accountsys.logic.flow.Impl;

import domain.dto.AccountTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import za.ac.nwu.accountsys.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.accountsys.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
@ComponentScan(value = "za.ac.nwu.accountsys.translator")
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDTO> getAllAccountTypes() {
        return accountTypeTranslator.getAllAccountTypes();
    }
}
