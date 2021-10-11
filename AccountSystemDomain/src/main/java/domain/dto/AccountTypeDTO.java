package domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import domain.persistance.AccountTyoe;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value= "AccountType", description = "DataTransfer object that represents the AccountType")
public class AccountTypeDTO implements Serializable {

    private String nmonic;
    private String description;
    private long id;

    public AccountTypeDTO() {
    }

    public AccountTypeDTO(String nmonic, String description, long id) {
        this.nmonic = nmonic;
        this.description = description;
        this.id = id;
    }

    public AccountTypeDTO(AccountTyoe accountTyoe) {
        this.nmonic = accountTyoe.getNmonic();
        this.description = accountTyoe.getAccountDesc();
        this.id = accountTyoe.getAccountTypeID();
    }

    @ApiModelProperty(
            position = 1,
            value = "Account type Mnemonic",
            name = "Mnemonic",
            dataType = "java.lang.String",
            example = "Miles",
            required = true
    )
    public String getNmonic() {
        return nmonic;
    }

    @ApiModelProperty(
            position = 2,
            value = "Account type description",
            name = "description",
            dataType = "java.lang.String",
            example = "Miles",
            required = true
    )
    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    @ApiModelProperty(
            position = 3,
            value = "Account type ID",
            name = "ID",
            dataType = "java.lang.Long",
            example = "5",
            required = true
    )
    public void setId(long id) {
        this.id = id;
    }

    public void setNmonic(String nmonic) {
        this.nmonic = nmonic;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public AccountTyoe getAccountType()
    {
        return new AccountTyoe(this.getNmonic(),this.getDescription());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDTO that = (AccountTypeDTO) o;
        return id == that.id && Objects.equals(nmonic, that.nmonic) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nmonic, description, id);
    }

    @Override
    public String toString() {
        return "AccountTypeDTO{" +
                "nmonic='" + nmonic + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
