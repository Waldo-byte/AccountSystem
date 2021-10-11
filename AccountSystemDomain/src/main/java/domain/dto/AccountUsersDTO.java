package domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import domain.persistance.AccountTyoe;
import domain.persistance.AccountUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value= "AccountUsers", description = "DataTransfer object that represents the AccountUsers")
public class AccountUsersDTO implements Serializable {

    private String name;
    private String surname;
    private long id;

    public AccountUsersDTO() {
    }

    public AccountUsersDTO(String name, String surname, long id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public AccountUsersDTO(AccountUser accountUser) {
        this.name = accountUser.getName();
        this.surname = accountUser.getSurname();
        this.id= accountUser.getUserid();
    }


    @ApiModelProperty(
            position = 1,
            value = "User Name",
            name = "name",
            dataType = "java.lang.String",
            example = "David",
            required = true
    )
    public String getName() {
        return name;
    }

    @ApiModelProperty(
            position = 2,
            value = "User Surname",
            name = "surname",
            dataType = "java.lang.String",
            example = "Stevens",
            required = true
    )
    public String getSurname() {
        return surname;
    }

    @ApiModelProperty(
            position = 3,
            value = "User ID",
            name = "user_id",
            dataType = "java.lang.Long",
            example = "3",
            required = true
    )
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @JsonIgnore
    public AccountUser getAccountUser()
    {
        return new AccountUser(this.getName(),this.getSurname());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountUsersDTO that = (AccountUsersDTO) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, id);
    }

    @Override
    public String toString() {
        return "AccountUsersDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }
}
