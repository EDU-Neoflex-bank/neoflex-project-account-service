package ru.neoflex.accountservice.entity;

import ru.neoflex.accountservice.model.enums.AccountType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "account_info")
public class BankAccountInfo {
    @Id
    @Column(name = "account_info_id")
    private UUID uuid;

    @OneToOne
    @JoinColumn(name = "account_id")
    private BankAccount bankAccount;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @JoinColumn(name = "account_type")
    @Enumerated(STRING)
    private AccountType accountType;

    @Column(name = "create_date")
    private Date createDate;

    public BankAccountInfo(BankAccount bankAccount, Address address, AccountType accountType) {
        uuid = UUID.randomUUID();
        this.accountType = accountType;
        this.address = address;
        this.bankAccount = bankAccount;
        createDate = new Date();
    }

    public BankAccountInfo() {
        createDate = new Date();
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public UUID getUuid() {
        return uuid;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public Address getAddress() {
        return address;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccountInfo)) return false;
        BankAccountInfo that = (BankAccountInfo) o;
        return Objects.equals(getUuid(), that.getUuid()) && Objects.equals(getBankAccount(), that.getBankAccount()) && Objects.equals(getAddress(), that.getAddress()) && getAccountType() == that.getAccountType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getBankAccount(), getAddress(), getAccountType());
    }

    @Override
    public String toString() {
        return "BankAccountInfo{" +
                "uuid=" + uuid +
                ", bankAccount=" + bankAccount +
                ", address=" + address +
                ", accountType=" + accountType +
                '}';
    }
}
