package ru.neoflex.accountservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.neoflex.accountservice.entity.Address;
import ru.neoflex.accountservice.entity.BankAccount;
import ru.neoflex.accountservice.entity.BankAccountInfo;
import ru.neoflex.accountservice.mapper.BankAccountInfoMapper;
import ru.neoflex.accountservice.model.BankAccountInfoDTO;
import ru.neoflex.accountservice.model.enums.AccountType;
import ru.neoflex.accountservice.repository.AddressRepo;
import ru.neoflex.accountservice.repository.BankAccountInfoRepo;
import ru.neoflex.accountservice.repository.BankAccountRepo;
import ru.neoflex.accountservice.utils.DateConverter;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class BankAccountInfoService {

    private final AddressService addressService;

    private final BankAccountService bankAccountService;

    private final BankAccountInfoRepo bankAccountInfoRepo;

    private final BankAccountRepo bankAccountRepo;

    private final AddressRepo addressRepo;

    private final AccountTypeService accountTypeService;

    @Scheduled(cron = "${getting-accounts-crone-timer}")
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
            log.info("BankAccountInfo with id {} was saved.", bankAccountInfo.getUuid().toString());
        }
    }

    public BankAccountInfoDTO getBankAccountInfoById(UUID uuid) {
        log.info("BankAccountInfo with id {} was returned.", uuid.toString());
        return BankAccountInfoMapper.toBankAccountInfoDTO(bankAccountInfoRepo.getById(uuid));
    }

    public List<BankAccountInfoDTO> getBankAccountInfos() {
        log.info("BankAccountInfos list was returned.");
        return bankAccountInfoRepo.findAll()
                .stream()
                .map(BankAccountInfoMapper::toBankAccountInfoDTO)
                .collect(Collectors.toList());
    }

    public List<BankAccountInfoDTO> getBankAccountByType(String type) {
        AccountType accountType = AccountType.valueOf(type.toUpperCase(Locale.ROOT));
        log.info("BankAccountInfos with type of {} were returned.", accountType.getTitle());
        return bankAccountInfoRepo.getAccountsByType(accountType)
                .stream()
                .map(BankAccountInfoMapper::toBankAccountInfoDTO)
                .collect(Collectors.toList());
    }

    public List<BankAccountInfoDTO> getByPeriod(String startDate, String endDate) {
        Date startingDate = DateConverter.stringDayMonthYearToDate(startDate);
        Date endingDate = DateConverter.stringDayMonthYearToDate(endDate);
        log.info("BankAccountInfos created in period between {} and {} were returned.", startingDate, endingDate);
        return bankAccountInfoRepo.getByPeriod(startingDate, endingDate)
                .stream()
                .map(BankAccountInfoMapper::toBankAccountInfoDTO)
                .collect(Collectors.toList());
    }
}
