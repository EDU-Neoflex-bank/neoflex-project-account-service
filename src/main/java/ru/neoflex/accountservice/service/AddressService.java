package ru.neoflex.accountservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.neoflex.accountservice.entity.Address;
import ru.neoflex.accountservice.mapper.AddressMapper;
import ru.neoflex.accountservice.model.AddressDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class AddressService {

    private final AddressMapper addressMapper;

    private final ObjectMapper objectMapper;

    private final RestTemplate restTemplate;

    public List<Address> getAddresses(int count) {
        String json = restTemplate.getForObject("http://localhost:8081/api/addresses/{count}", String.class, count);
        List<Address> addresses = new ArrayList<>();
        List<AddressDTO> addressDTOS = new ArrayList<>();

        try {
            addressDTOS = objectMapper.readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        addressDTOS.parallelStream()
                .map(addressMapper::toAddress)
                .collect(Collectors.toCollection(() -> addresses));

        log.info("Addresses list was returned successfully.");
        return addresses;
    }
}
