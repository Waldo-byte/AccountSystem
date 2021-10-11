package domain.persistance;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "accountType")
public class AccountTyoe implements Serializable {

    private static final long serialVersionUID = 3833725316797154577L;

    private long accountTypeID;
    private String nmonic;
    private String accountDesc;
    private LocalDate creationDate;
    private Set<AccountTransaction> accountTransactionSet;

    public AccountTyoe() {
    }

    public AccountTyoe(long accountTypeID, String currency, String accountDesc, LocalDate creationDate) {
        this.accountTypeID = accountTypeID;
        this.nmonic = currency;
        this.accountDesc = accountDesc;
        this.creationDate = creationDate;
    }

    public AccountTyoe(String nmonic, String accountDesc, LocalDate creationDate) {
        this.nmonic = nmonic;
        this.accountDesc = accountDesc;
        this.creationDate = creationDate;
    }

    public AccountTyoe(String nmonic, String accountDesc) {
        this.nmonic = nmonic;
        this.accountDesc = accountDesc;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TYPE")
    public long getAccountTypeID() {
        return accountTypeID;
    }

    @Column(name = "NMONIC")
    public String getNmonic() {
        return nmonic;
    }

    @Column(name = "DESCRIPTION")
    public String getAccountDesc() {
        return accountDesc;
    }

    @Column(name = "DATE_CREATED")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountTyoe", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactionSet() {
        return accountTransactionSet;
    }

    public void setAccountTypeID(long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public void setNmonic(String nmonic) {
        this.nmonic = nmonic;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTyoe that = (AccountTyoe) o;
        return accountTypeID == that.accountTypeID && Objects.equals(nmonic, that.nmonic) && Objects.equals(accountDesc, that.accountDesc) && Objects.equals(creationDate, that.creationDate) && Objects.equals(accountTransactionSet, that.accountTransactionSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeID, nmonic, accountDesc, creationDate, accountTransactionSet);
    }

    public void setAccountTransactionSet(Set<AccountTransaction> accountTransactionSet) {
        this.accountTransactionSet = accountTransactionSet;
    }

    @Override
    public String toString() {
        return "AccountTyoe{" +
                "accountTypeID=" + accountTypeID +
                ", nmonic='" + nmonic + '\'' +
                ", accountDesc='" + accountDesc + '\'' +
                ", creationDate=" + creationDate +
                ", accountTransactionSet=" + accountTransactionSet +
                '}';
    }
}
