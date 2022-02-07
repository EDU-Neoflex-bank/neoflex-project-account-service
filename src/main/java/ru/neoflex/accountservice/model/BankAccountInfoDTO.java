package ru.neoflex.accountservice.model;

import lombok.Builder;
import lombok.Data;
import ru.neoflex.accountservice.entity.Address;
import ru.neoflex.accountservice.entity.BankAccount;
import ru.neoflex.accountservice.model.enums.AccountType;

import java.util.Date;

@Data
@Builder
public class BankAccountInfoDTO {

    private BankAccount bankAccount;

    private Address address;

    private AccountType accountType;

    private Date createDate;
}