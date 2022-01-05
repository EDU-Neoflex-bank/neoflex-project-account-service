package ru.neoflex.accountservice.mapper;

import org.springframework.stereotype.Service;
import ru.neoflex.accountservice.entity.Address;
import ru.neoflex.accountservice.model.AddressDTO;

import java.util.UUID;

@Service
public class AddressMapper {

    public Address toAddress(AddressDTO addressDTO){
        Address address = new Address();
        address.setUuid(UUID.randomUUID());
        address.setCity(addressDTO.getCity());
        address.setStreetName(addressDTO.getStreetName());
        address.setStreetAddress(addressDTO.getStreetAddress());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        address.setZipCode(addressDTO.getZipCode());
        address.setPostCode(addressDTO.getPostCode());
        address.setCountry(addressDTO.getCountry());

        return address;
    }
}
