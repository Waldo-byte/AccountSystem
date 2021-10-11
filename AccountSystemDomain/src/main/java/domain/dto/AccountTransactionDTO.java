package domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import domain.persistance.AccountTransaction;
import domain.persistance.AccountTyoe;
import domain.persistance.AccountUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value= "AccountTransactions", description = "DataTransfer object that represents the Account Transfers")
public class AccountTransactionDTO implements Serializable {
    private long userid;
    private long accountypeid;
    private double amount;


    public AccountTransactionDTO() {
    }

    public AccountTransactionDTO(long userid, long accountypeid, double amount) {
        this.userid = userid;
        this.accountypeid = accountypeid;
        this.amount = amount;
    }

    public AccountTransactionDTO(AccountTransaction accountTransaction) {
        this.userid = accountTransaction.getAccountUser().getUserid();
        this.accountypeid = accountTransaction.getAccountTyoe().getAccountTypeID();
        this.amount = accountTransaction.getAmount();
    }

    @ApiModelProperty(
            position = 1,
            value = "User ID",
            name = "Userid",
            dataType = "java.lang.String",
            example = "1",
            required = true
    )

    public long getUserid() {
        return userid;
    }

    @ApiModelProperty(
            position = 2,
            value = "account Typeid",
            name = "typeID",
            dataType = "java.lang.String",
            example = "3",
            required = true
    )
    public long getAccountypeid() {
        return accountypeid;
    }

    @ApiModelProperty(
            position = 3,
            value = "Get Amount",
            name = "Amount",
            dataType = "java.lang.String",
            example = "3200",
            required = true
    )
    public double getAmount() {
        return amount;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public void setAccountypeid(long accountypeid) {
        this.accountypeid = accountypeid;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

//    @JsonIgnore
//    public AccountTransaction getAccountTransaction() {
//        return new AccountTransaction(this.getUserid(),this.getAccountypeid(),this.getAmount(), LocalDate.now());
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDTO that = (AccountTransactionDTO) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(userid, that.userid) && Objects.equals(accountypeid, that.accountypeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, accountypeid, amount);
    }

    @Override
    public String toString() {
        return "AccountTransactionDTO{" +
                "userid=" + userid +
                ", accountypeid=" + accountypeid +
                ", amount=" + amount +
                '}';
    }
}
