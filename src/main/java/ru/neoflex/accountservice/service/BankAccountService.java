package ru.neoflex.accountservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.neoflex.accountservice.entity.BankAccount;
import ru.neoflex.accountservice.mapper.BankAccountMapper;
import ru.neoflex.accountservice.model.BankAccountDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {
    private final RequestService requestService;
    private final BankAccountMapper bankAccountMapper;

    public BankAccountService(RequestService requestService, BankAccountMapper bankAccountMapper) {
        this.requestService = requestService;
        this.bankAccountMapper = bankAccountMapper;
    }

    public List<BankAccount> getBankAccounts(int count) {
        String json = requestService.getJSON("http://localhost:8080/api/accounts/", count);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<BankAccountDTO> bankAccountDTOS = new ArrayList<>();
        List<BankAccount> bankAccounts = new ArrayList<>();

        try {
            bankAccountDTOS = objectMapper.readValue(json, new TypeReference<List<BankAccountDTO>>() {});
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        for (BankAccountDTO bankAccountDTO : bankAccountDTOS) {
            bankAccounts.add(bankAccountMapper.toBankAccount(bankAccountDTO));
        }

        return bankAccounts;
    }
}
