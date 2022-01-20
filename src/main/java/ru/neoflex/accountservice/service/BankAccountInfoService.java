package ru.neoflex.accountservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.neoflex.accountservice.entity.Address;
import ru.neoflex.accountservice.entity.BankAccount;
import ru.neoflex.accountservice.entity.BankAccountInfo;
import ru.neoflex.accountservice.model.enums.AccountType;
import ru.neoflex.accountservice.repository.AddressRepo;
import ru.neoflex.accountservice.repository.BankAccountInfoRepo;
import ru.neoflex.accountservice.repository.BankAccountRepo;
import ru.neoflex.accountservice.utils.DateConverter;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
@Slf4j
public class BankAccountInfoService {
    private final AddressService addressService;
    private final BankAccountService bankAccountService;
    private final BankAccountInfoRepo bankAccountInfoRepo;
    private final BankAccountRepo bankAccountRepo;
    private final AddressRepo addressRepo;
    private final AccountTypeService accountTypeService;

    public BankAccountInfoService(AddressService addressService, BankAccountService bankAccountService, BankAccountInfoRepo bankAccountInfoRepo, BankAccountRepo bankAccountRepo, AddressRepo addressRepo, AccountTypeService accountTypeService) {
        this.addressService = addressService;
        this.bankAccountService = bankAccountService;
        this.bankAccountInfoRepo = bankAccountInfoRepo;
        this.bankAccountRepo = bankAccountRepo;
        this.addressRepo = addressRepo;
        this.accountTypeService = accountTypeService;
    }

    @Scheduled(cron = "*/120 * * * * *")
    public void generateBankAccount() {
        int count = 10;
        List<Address> addressList = addressService.getAddresses(count);
        List<BankAccount> bankAccountList = bankAccountService.generateAccounts(count);
        List<AccountType> accountTypeList = accountTypeService.getAccountTypes(count);

        for (int i = 0; i < count; i++) {
            BankAccountInfo bankAccountInfo = new BankAccountInfo();
            bankAccountInfo.setUuid(UUID.randomUUID());
            bankAccountInfo.setBankAccount(bankAccountList.get(i));
            bankAccountInfo.setAddress(addressList.get(i));
            bankAccountInfo.setAccountType(accountTypeList.get(i));
            addressRepo.save(addressList.get(i));
            bankAccountRepo.save(bankAccountList.get(i));
            bankAccountInfoRepo.save(bankAccountInfo);
            log.info(String.format("BankAccountInfo with id %s was saved.", bankAccountInfo.getUuid().toString()));
        }
    }

    public BankAccountInfo getBankAccountInfoById(UUID uuid) {
        log.info(String.format("BankAccountInfo with id %s was returned.", uuid.toString()));
        return bankAccountInfoRepo.getById(uuid);
    }

    public List<BankAccountInfo> getBankAccountInfos() {
        log.info("BankAccountInfos list was returned.");
        return bankAccountInfoRepo.findAll();
    }

    public List<BankAccountInfo> getBankAccountByType(String type) {
        AccountType accountType = AccountType.valueOf(type.toUpperCase(Locale.ROOT));
        log.info(String.format("BankAccountInfos with type of %s were returned."), accountType.getTitle());
        return bankAccountInfoRepo.getAccountsByType(accountType);
    }

    public List<BankAccountInfo> getByPeriod(String startDate, String endDate) {
        Date startingDate = DateConverter.stringDayMonthYearToDate(startDate);
        Date endingDate = DateConverter.stringDayMonthYearToDate(endDate);
        log.info(String.format("BankAccountInfos created in period between %s and %s were returned."), startingDate, endingDate);
        return bankAccountInfoRepo.getByPeriod(startingDate, endingDate);
    }
}
