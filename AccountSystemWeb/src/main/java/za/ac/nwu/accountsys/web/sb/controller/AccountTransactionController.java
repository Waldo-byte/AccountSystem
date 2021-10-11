package za.ac.nwu.accountsys.web.sb.controller;

import domain.dto.AccountTransactionDTO;
import domain.dto.AccountTypeDTO;
import domain.service.GeneralResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.accountsys.logic.flow.CreateAccountTransFlow;
import za.ac.nwu.accountsys.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.accountsys.logic.flow.FetchAccountTransFlow;
import za.ac.nwu.accountsys.logic.flow.FetchAccountTypeFlow;

import java.util.List;

@RestController
@RequestMapping("account-transactions")
@ComponentScan(value = "za.ac.nwu.accountsys.logic.flow")
public class AccountTransactionController {
    private final FetchAccountTransFlow fetchAccountTransactionFlow;
    private final CreateAccountTransFlow createAccountTransactionFlow;

    @Autowired
    public AccountTransactionController(FetchAccountTransFlow fetchAccountTransactionFlow, CreateAccountTransFlow createAccountTransactionFlow) {
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
        this.createAccountTransactionFlow = createAccountTransactionFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all configured account types", notes = "Returns account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns account types", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<AccountTransactionDTO>>> getAll(){
        List<AccountTransactionDTO> accountTransactionDTOS = fetchAccountTransactionFlow.getAllTransactions();
        GeneralResponse<List<AccountTransactionDTO>> response = new GeneralResponse<>(true,accountTransactionDTOS);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Create new account type", notes = "create new account type in db")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Created Successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTransactionDTO>> create(
            @ApiParam(
                    value = "request body to create new transaction",
                    required = true)
            @RequestBody AccountTransactionDTO accountTransaction){
        AccountTransactionDTO accountTransactionResponse= createAccountTransactionFlow.create(accountTransaction);
        GeneralResponse<AccountTransactionDTO> response = new GeneralResponse<>(true, accountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
