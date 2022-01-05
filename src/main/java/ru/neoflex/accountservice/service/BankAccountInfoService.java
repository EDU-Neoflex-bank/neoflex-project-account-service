package ru.neoflex.accountservice.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.neoflex.accountservice.entity.Address;
import ru.neoflex.accountservice.entity.BankAccount;
import ru.neoflex.accountservice.entity.BankAccountInfo;
import ru.neoflex.accountservice.model.enums.AccountType;
import ru.neoflex.accountservice.repository.BankAccountInfoRepo;

import java.util.List;
import java.util.UUID;

@Service
public class BankAccountInfoService {

    private final AddressService addressService;
    private final BankAccountService bankAccountService;
    private final BankAccountInfoRepo bankAccountInfoRepo;
    private final AccountTypeService accountTypeService;

    public BankAccountInfoService(AddressService addressService, BankAccountService bankAccountService, BankAccountInfoRepo bankAccountInfoRepo, AccountTypeService accountTypeService) {
        this.addressService = addressService;
        this.bankAccountService = bankAccountService;
        this.bankAccountInfoRepo = bankAccountInfoRepo;
        this.accountTypeService = accountTypeService;
    }

    @Scheduled(cron = "*/20 * * * * *")
    public void generateBankAccount() {
        int count = 10;
        List<Address> addressList = addressService.getAddresses(count);
        List<BankAccount> bankAccountList = bankAccountService.getBankAccounts(count);
        List<AccountType> accountTypeList = accountTypeService.getAccountTypes(count);

        for (int i = 0; i < count; i++) {
            BankAccountInfo bankAccountInfo = new BankAccountInfo();
            bankAccountInfo.setUuid(UUID.randomUUID());
            bankAccountInfo.setBankAccount(bankAccountList.get(i));
            bankAccountInfo.setAddress(addressList.get(i));
            bankAccountInfo.setAccountType(accountTypeList.get(i));

            System.out.println(bankAccountInfo);
//            TODO: Create and set up tables in DB
//            bankAccountInfoRepo.save(bankAccountInfo);
//            bankAccountInfoRepo.findAll().forEach(System.out::println);
        }
    }
}
