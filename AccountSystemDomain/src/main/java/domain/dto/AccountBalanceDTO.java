package domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@ApiModel(value= "AccountBalance", description = "DataTransfer object that represents the Account balance")
public class AccountBalanceDTO {

    private long accountid;
    private long balance;

    public AccountBalanceDTO(long accountid, long balance) {
        this.accountid = accountid;
        this.balance = balance;
    }

    @ApiModelProperty(
            position = 1,
            value = "Account ID",
            name = "Accountid",
            dataType = "java.lang.Long",
            example = "1",
            required = true
    )
    public long getAccountid() {
        return accountid;
    }


    @ApiModelProperty(
            position = 2,
            value = "Balance",
            name = "Balance",
            dataType = "java.lang.Long",
            example = "1",
            required = true
    )
    public long getBalance() {
        return balance;
    }

    public void setAccountid(long accountid) {
        this.accountid = accountid;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountBalanceDTO that = (AccountBalanceDTO) o;
        return accountid == that.accountid && balance == that.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountid, balance);
    }

    @Override
    public String toString() {
        return "AccountBalanceDTO{" +
                "accountid=" + accountid +
                ", balance=" + balance +
                '}';
    }
}
