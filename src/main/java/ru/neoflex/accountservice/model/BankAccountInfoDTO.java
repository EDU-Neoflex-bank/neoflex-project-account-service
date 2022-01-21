package ru.neoflex.accountservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import ru.neoflex.accountservice.model.enums.AccountType;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountInfoDTO {
    private BankAccountDTO bankAccountDTO;
    private AddressDTO addressDTO;
    private AccountType accountType;
}