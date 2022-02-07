package ru.neoflex.accountservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.neoflex.accountservice.model.enums.AccountType;
import ru.neoflex.accountservice.utils.RandomDateGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "account_info")
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@EqualsAndHashCode
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

    public BankAccountInfo() {
        createDate = RandomDateGenerator.getRandomDate();
    }
}
