package ru.neoflex.accountservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.neoflex.accountservice.entity.BankAccount;
import ru.neoflex.accountservice.mapper.BankAccountMapper;
import ru.neoflex.accountservice.model.BankAccountDTO;
import ru.neoflex.accountservice.repository.BankAccountRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class BankAccountService {

    private final BankAccountMapper bankAccountMapper;

    private final BankAccountRepo bankAccountRepo;

    private final ObjectMapper objectMapper;

    private final RestTemplate restTemplate;

    public List<BankAccount> generateAccounts(int count) {
        String json = restTemplate.getForObject("http://localhost:8080/api/accounts/{count}", String.class, count);
        List<BankAccountDTO> bankAccountDTOS = new ArrayList<>();
        List<BankAccount> bankAccounts = new ArrayList<>();

        try {
            bankAccountDTOS = objectMapper.readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        bankAccountDTOS.parallelStream()
                .map(bankAccountMapper::toBankAccount)
                .collect(Collectors.toCollection(() -> bankAccounts));

        return bankAccounts;
    }

    public BankAccount getBankAccountById(UUID uuid) {
        log.info("BankAccount with id {} was returned.", uuid);
        return bankAccountRepo.getById(uuid);
    }
}
