package ru.neoflex.accountservice.entity;

import ru.neoflex.accountservice.model.enums.AccountType;

import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;
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
        createDate = getRandomDate();
    }

    public BankAccountInfo() {
        createDate = getRandomDate();
    }

    public static Date getRandomDate() {
        GregorianCalendar gc = new GregorianCalendar();
        int startYear = 2000;
        int endYear = 2022;

        int year = startYear + (int) Math.round(Math.random() * (endYear - startYear));
        int dayOfYear = 1 + (int) Math.round(Math.random() * (gc.getActualMaximum(gc.DAY_OF_YEAR) - 1));
        gc.set(gc.YEAR, year);
        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return gc.getTime();
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccountInfo)) return false;
        BankAccountInfo that = (BankAccountInfo) o;
        return Objects.equals(getUuid(), that.getUuid()) && Objects.equals(getBankAccount(), that.getBankAccount()) && Objects.equals(getAddress(), that.getAddress()) && getAccountType() == that.getAccountType() && Objects.equals(getCreateDate(), that.getCreateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getBankAccount(), getAddress(), getAccountType(), getCreateDate());
    }

    @Override
    public String toString() {
        return "BankAccountInfo{" +
                "uuid=" + uuid +
                ", bankAccount=" + bankAccount +
                ", address=" + address +
                ", accountType=" + accountType +
                ", createDate=" + createDate +
                '}';
    }
}
