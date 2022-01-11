package ru.neoflex.accountservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.neoflex.accountservice.entity.Address;
import ru.neoflex.accountservice.mapper.AddressMapper;
import ru.neoflex.accountservice.model.AddressDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private final RequestService requestService;
    private final AddressMapper addressMapper;

    public AddressService(RequestService requestService, AddressMapper addressMapper) {
        this.requestService = requestService;
        this.addressMapper = addressMapper;
    }

    public List<Address> getAddresses(int count) {
        String json = requestService.getJSON("http://localhost:8081/api/addresses", count);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<AddressDTO> addressDTOS = new ArrayList<>();
        List<Address> addresses = new ArrayList<>();

        try {
            addressDTOS = objectMapper.readValue(json, new TypeReference<List<AddressDTO>>() {});
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        for (AddressDTO addressDTO : addressDTOS) {
            addresses.add(addressMapper.toAddress(addressDTO));
        }

        return addresses;
    }
}
