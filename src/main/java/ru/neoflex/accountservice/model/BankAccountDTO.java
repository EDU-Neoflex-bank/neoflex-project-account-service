package ru.neoflex.accountservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.neoflex.accountservice.model.enums.Sex;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BankAccountDTO {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("middleName")
    private String middleName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("accountNumber")
    private long accountNumber;

    @JsonProperty("sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    public BankAccountDTO(String firstName, String middleName, String lastName, long accountNumber, Sex sex) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.sex = sex;
    }

    public BankAccountDTO() {
    }

    public Optional<String> getFirstName() {
        return Optional.ofNullable(firstName);
    }

    public Optional<String> getMiddleName() {
        return Optional.ofNullable(middleName);
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

    public Optional<Long> getAccountNumber() {
        return Optional.ofNullable(accountNumber);
    }

    public Optional<Sex> getSex() {
        return Optional.ofNullable(sex);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccountDTO)) return false;
        BankAccountDTO that = (BankAccountDTO) o;
        return getAccountNumber() == that.getAccountNumber() && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getMiddleName(), that.getMiddleName()) && Objects.equals(getLastName(), that.getLastName()) && getSex() == that.getSex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getMiddleName(), getLastName(), getAccountNumber(), getSex());
    }

    @Override
    public String toString() {
        return "BankAccountDTO{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountNumber=" + accountNumber +
                ", sex=" + sex +
                '}';
    }
}