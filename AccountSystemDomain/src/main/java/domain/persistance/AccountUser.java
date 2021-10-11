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
@Table(name = "accountUser")
public class AccountUser {

    private long userid;
    private String name;
    private String surname;
    private Set<AccountTransaction> accountTransactionSet;

    public AccountUser() {
    }

    public AccountUser(long userid, String name, String surname, Set<AccountTransaction> accountTransactionSet) {
        this.userid = userid;
        this.name = name;
        this.surname = surname;
        this.accountTransactionSet = accountTransactionSet;
    }

    public AccountUser(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USERID")
    public long getUserid() {
        return userid;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountUser", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactionSet() {
        return accountTransactionSet;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAccountTransactionSet(Set<AccountTransaction> accountTransactionSet) {
        this.accountTransactionSet = accountTransactionSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountUser that = (AccountUser) o;
        return userid == that.userid && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(accountTransactionSet, that.accountTransactionSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, name, surname, accountTransactionSet);
    }


    @Override
    public String toString() {
        return "AccountUser{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accountTransactionSet=" + accountTransactionSet +
                '}';
    }
}
