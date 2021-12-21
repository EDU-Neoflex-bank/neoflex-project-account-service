package ru.neoflex.accountservice.entity;

import ru.neoflex.accountservice.model.AddressDTO;
import ru.neoflex.accountservice.model.BankAccountDTO;
import ru.neoflex.accountservice.model.enums.AccountType;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "account_info")
public class BankAccountInfo {
    @Id
    @Column(name = "accountinfo_id")
    private UUID uuid;

//    @Column(name = "account_id")
//    FIXME: Как взять BankAccount из базы по account_id
//    private BankAccountDTO bankAccountDTO;

//    @Column(name = "address_id")
//    FIXME: Как взять Address из базы по address_id
//    private AddressDTO addressDTO;

    @Column(name = "account_type")
    @Enumerated(STRING)
    private AccountType accountType;



//    TODO:
//    Поместить сюда BankAccount
//    Адреc
//    B тип


//    Как через Spring JPA наладить связи между сущностями (аннотации one-to-one, one-to-many, many-to-many)
}
