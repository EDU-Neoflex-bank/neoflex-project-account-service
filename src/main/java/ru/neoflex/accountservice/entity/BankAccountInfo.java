package ru.neoflex.accountservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import ru.neoflex.accountservice.model.enums.AccountType;
import ru.neoflex.accountservice.utils.RandomDateGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "account_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Getter
@ToString
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
        createDate = RandomDateGenerator.getRandomDate();
    }

    public BankAccountInfo() {
        createDate = RandomDateGenerator.getRandomDate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BankAccountInfo that = (BankAccountInfo) o;
        return uuid != null && Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
