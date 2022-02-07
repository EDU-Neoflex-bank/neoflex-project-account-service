package ru.neoflex.accountservice.mapper;

import org.springframework.stereotype.Service;
import ru.neoflex.accountservice.entity.BankAccountInfo;
import ru.neoflex.accountservice.model.BankAccountInfoDTO;

@Service
public class BankAccountInfoMapper {

    public static BankAccountInfoDTO toBankAccountInfoDTO(BankAccountInfo bankAccountInfo) {
        return BankAccountInfoDTO.builder()
                .bankAccount(bankAccountInfo.getBankAccount())
                .address(bankAccountInfo.getAddress())
                .accountType(bankAccountInfo.getAccountType())
                .createDate(bankAccountInfo.getCreateDate())
                .build();
    }
}
