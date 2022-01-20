package ru.neoflex.accountservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.neoflex.accountservice.model.enums.AccountType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class AccountTypeService {

    public List<AccountType> getAccountTypes(int count) {
        List<AccountType> accountTypeList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            accountTypeList.add(AccountType.values()[new Random().nextInt(AccountType.values().length)]);
        }

        log.info("Accounts list was returned successfully.");
        return accountTypeList;
    }
}
