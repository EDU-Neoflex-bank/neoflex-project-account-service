package ru.neoflex.accountservice.mapper;

import org.springframework.stereotype.Service;
import ru.neoflex.accountservice.entity.Address;
import ru.neoflex.accountservice.model.AddressDTO;

import java.util.UUID;

@Service
public class AddressMapper {

    public Address toAddress(AddressDTO addressDTO) {
        return Address.builder()
                .uuid(UUID.randomUUID())
                .city(addressDTO.getCity())
                .streetName(addressDTO.getStreetName())
                .streetAddress(addressDTO.getStreetAddress())
                .buildingNumber(addressDTO.getBuildingNumber())
                .zipCode(addressDTO.getZipCode())
                .postCode(addressDTO.getPostCode())
                .country(addressDTO.getCountry())
                .build();
    }
}
