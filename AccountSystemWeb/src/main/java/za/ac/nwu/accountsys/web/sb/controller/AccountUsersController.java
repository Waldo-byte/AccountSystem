package za.ac.nwu.accountsys.web.sb.controller;

import domain.dto.AccountTypeDTO;
import domain.dto.AccountUsersDTO;
import domain.persistance.AccountUser;
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
import za.ac.nwu.accountsys.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.accountsys.logic.flow.CreateAccountUserFlow;
import za.ac.nwu.accountsys.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.accountsys.logic.flow.FetchAccountUserFlow;

import java.util.List;

@RestController
@RequestMapping("account-user")
@ComponentScan(value = "za.ac.nwu.accountsys.logic.flow")
public class AccountUsersController {

    private final FetchAccountUserFlow fetchAccountUserFlow;
    private final CreateAccountUserFlow createAccountUserFlow;

    @Autowired
    public AccountUsersController(FetchAccountUserFlow fetchAccountUserFlow, CreateAccountUserFlow createAccountUserFlow) {
        this.fetchAccountUserFlow = fetchAccountUserFlow;
        this.createAccountUserFlow = createAccountUserFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all configured account users", notes = "Returns account users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returned users", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<AccountUsersDTO>>> getAll(){
        List<AccountUsersDTO> accountUsers = fetchAccountUserFlow.getAll();
        GeneralResponse<List<AccountUsersDTO>> response = new GeneralResponse<>(true,accountUsers);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Create new account user", notes = "create new user in db")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Created Successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountUsersDTO>> create(
            @ApiParam(
                    value = "request body to create user",
                    required = true)
            @RequestBody AccountUsersDTO accountUser){
        AccountUsersDTO accountUserResponse = createAccountUserFlow.create(accountUser);
        GeneralResponse<AccountUsersDTO> response = new GeneralResponse<>(true, accountUserResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
