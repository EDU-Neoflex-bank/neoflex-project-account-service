package ru.neoflex.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.neoflex.accountservice.model.enums.AccountType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountInfoDTO {

    private BankAccountDTO bankAccountDTO;

    private AddressDTO addressDTO;

    private AccountType accountType;
}