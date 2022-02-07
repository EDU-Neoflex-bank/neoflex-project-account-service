package ru.neoflex.accountservice.mapper;

import org.springframework.stereotype.Service;
import ru.neoflex.accountservice.entity.BankAccount;
import ru.neoflex.accountservice.model.BankAccountDTO;

import java.util.UUID;

@Service
public class BankAccountMapper {

    public BankAccount toBankAccount(BankAccountDTO bankAccountDTO) {
        return BankAccount.builder()
                .uuid(UUID.randomUUID())
                .accountNumber(bankAccountDTO.getAccountNumber())
                .firstName(bankAccountDTO.getFirstName())
                .middleName(bankAccountDTO.getMiddleName())
                .lastName(bankAccountDTO.getLastName())
                .sex(bankAccountDTO.getSex())
                .build();
    }
}
