package ru.neoflex.accountservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Enumerated;

import static javax.persistence.EnumType.STRING;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class AddressDTO {

    @JsonProperty(value = "city")
    private String city;

    @JsonProperty(value = "street_name")
    private String streetName;

    @JsonProperty(value = "street_address")
    private String streetAddress;

    @JsonProperty(value = "building_number")
    private String buildingNumber;

    @JsonProperty(value = "zip_code")
    private String zipCode;

    @JsonProperty(value = "postcode")
    private String postCode;

    @JsonProperty(value = "country")
    @Enumerated(STRING)
    private String country;
}
