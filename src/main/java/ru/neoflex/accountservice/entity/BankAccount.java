package ru.neoflex.accountservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.neoflex.accountservice.model.enums.Sex;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "account")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BankAccount {
    @Id
    @Column(name = "account_id")
    private UUID uuid;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "account_number")
    private long accountNumber;

    @Column(name = "sex")
    @Enumerated(STRING)
    private Sex sex;

    public BankAccount(UUID uuid, String firstName, String middleName, String lastName, long accountNumber, Sex sex) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.sex = sex;
    }

    public BankAccount() {}

    @Override
    public String toString() {
        return "BankAccount{" +
                "uuid=" + uuid +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountNumber=" + accountNumber +
                ", sex=" + sex +
                '}';
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
