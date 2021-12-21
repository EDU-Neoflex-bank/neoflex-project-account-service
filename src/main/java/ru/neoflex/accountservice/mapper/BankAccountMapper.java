package ru.neoflex.accountservice.mapper;

import org.springframework.stereotype.Service;
import ru.neoflex.accountservice.entity.BankAccount;
import ru.neoflex.accountservice.model.BankAccountDTO;

@Service
public class BankAccountMapper {

    public BankAccount toBankAccount(BankAccountDTO bankAccountDTO){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setUuid(bankAccountDTO.getUuid());
        bankAccount.setAccountNumber(bankAccountDTO.getAccountNumber());
        bankAccount.setFirstName(bankAccountDTO.getFirstName());
        bankAccount.setMiddleName(bankAccountDTO.getMiddleName());
        bankAccount.setLastName(bankAccountDTO.getLastName());
        bankAccount.setSex(bankAccountDTO.getSex());

        return bankAccount;
    }
}
