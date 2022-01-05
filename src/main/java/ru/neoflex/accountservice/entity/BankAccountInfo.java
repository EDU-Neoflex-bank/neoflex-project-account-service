package ru.neoflex.accountservice.entity;

import ru.neoflex.accountservice.model.enums.AccountType;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "account_info")
public class BankAccountInfo {
    @Id
    @Column(name = "bank_account_id")
    private UUID uuid;

    @OneToOne
    @JoinColumn(name = "bank_account")
    private BankAccount bankAccount;

    @OneToOne
    @JoinColumn(name = "bank_account_address")
    private Address address;

    @JoinColumn(name = "bank_account_type")
    @Enumerated(STRING)
    private AccountType accountType;

    public BankAccountInfo(BankAccount bankAccount, Address address, AccountType accountType) {
        uuid = UUID.randomUUID();
        this.accountType = accountType;
        this.address = address;
        this.bankAccount = bankAccount;
    }

    public BankAccountInfo() {}

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
