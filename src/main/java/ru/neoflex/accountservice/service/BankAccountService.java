package ru.neoflex.accountservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.neoflex.accountservice.entity.BankAccount;
import ru.neoflex.accountservice.mapper.BankAccountMapper;
import ru.neoflex.accountservice.model.BankAccountDTO;
import ru.neoflex.accountservice.repository.BankAccountRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class BankAccountService {
    private final RequestService requestService;
    private final BankAccountMapper bankAccountMapper;
    private final BankAccountRepo bankAccountRepo;

    public BankAccountService(RequestService requestService, BankAccountMapper bankAccountMapper, BankAccountRepo bankAccountRepo) {
        this.requestService = requestService;
        this.bankAccountMapper = bankAccountMapper;
        this.bankAccountRepo = bankAccountRepo;
    }

    public List<BankAccount> generateAccounts(int count) {
        String json = requestService.getJSON("http://localhost:8080/api/accounts", count);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<BankAccountDTO> bankAccountDTOS = new ArrayList<>();
        List<BankAccount> bankAccounts = new ArrayList<>();

        try {
            bankAccountDTOS = objectMapper.readValue(json, new TypeReference<List<BankAccountDTO>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        for (BankAccountDTO bankAccountDTO : bankAccountDTOS) {
            bankAccounts.add(bankAccountMapper.toBankAccount(bankAccountDTO));
        }

        return bankAccounts;
    }

    public BankAccount getBankAccountById(UUID uuid) {
        log.info(String.format("BankAccount with id %s was returned."), uuid);
        return bankAccountRepo.getById(uuid);
    }

    public List<BankAccount> getBankAccountsList() {
        log.info("BankAccounts list was returned.");
        return bankAccountRepo.findAll();
    }
}
