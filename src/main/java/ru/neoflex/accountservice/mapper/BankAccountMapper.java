package ru.neoflex.accountservice.mapper;

import org.springframework.stereotype.Service;
import ru.neoflex.accountservice.entity.BankAccount;
import ru.neoflex.accountservice.model.BankAccountDTO;

import java.util.UUID;

@Service
public class BankAccountMapper {

    public BankAccount toBankAccount(BankAccountDTO bankAccountDTO) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setUuid(UUID.randomUUID());
        bankAccount.setAccountNumber(bankAccountDTO.getAccountNumber().get());
        bankAccount.setFirstName(bankAccountDTO.getFirstName().get());
        bankAccount.setMiddleName(bankAccountDTO.getMiddleName().get());
        bankAccount.setLastName(bankAccountDTO.getLastName().get());
        bankAccount.setSex(bankAccountDTO.getSex().get());

        return bankAccount;
    }
}
