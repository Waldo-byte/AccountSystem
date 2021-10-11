package domain.persistance;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "accountTransaction")
public class AccountTransaction implements Serializable {

    private long atrans_id;
    private AccountUser accountUser;
    private AccountTyoe accountTyoe;
    private double amount;
    private LocalDate date;

    public AccountTransaction() {
    }

    public AccountTransaction(long atrans_id, AccountUser accountUser, AccountTyoe accountTyoe, double amount, LocalDate date) {
        this.atrans_id = atrans_id;
        this.accountUser = accountUser;
        this.accountTyoe = accountTyoe;
        this.amount = amount;
        this.date = date;
    }

    public AccountTransaction(AccountUser accountUser, AccountTyoe accountTyoe, double amount, LocalDate date) {
        this.accountUser = accountUser;
        this.accountTyoe = accountTyoe;
        this.amount = amount;
        this.date = date;
    }

    public AccountTransaction(AccountUser accountUser, AccountTyoe accountTyoe, double amount) {
        this.accountUser = accountUser;
        this.accountTyoe = accountTyoe;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TRANSACTION")
    public long getAtrans_id() {
        return atrans_id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERID")
    public AccountUser getAccountUser() {
        return accountUser;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNTTYPE_ID")
    public AccountTyoe getAccountTyoe() {
        return accountTyoe;
    }

    @Column(name = "AMOUNT")
    public double getAmount() {
        return amount;
    }

    @Column(name = "CREATION_DATE")
    public LocalDate getDate() {
        return date;
    }

    public void setAtrans_id(long atrans_id) {
        this.atrans_id = atrans_id;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }

    public void setAccountTyoe(AccountTyoe accountTyoe) {
        this.accountTyoe = accountTyoe;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return atrans_id == that.atrans_id && Double.compare(that.amount, amount) == 0 && Objects.equals(accountUser, that.accountUser) && Objects.equals(accountTyoe, that.accountTyoe) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atrans_id, accountUser, accountTyoe, amount, date);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "atrans_id=" + atrans_id +
                ", accountUser=" + accountUser +
                ", accountTyoe=" + accountTyoe +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
