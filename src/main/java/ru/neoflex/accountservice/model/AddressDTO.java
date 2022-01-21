package ru.neoflex.accountservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Enumerated;
import java.util.Objects;

import static javax.persistence.EnumType.STRING;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressDTO)) return false;
        AddressDTO that = (AddressDTO) o;
        return Objects.equals(getCity(), that.getCity()) && Objects.equals(getStreetName(), that.getStreetName()) && Objects.equals(getStreetAddress(), that.getStreetAddress()) && Objects.equals(getBuildingNumber(), that.getBuildingNumber()) && Objects.equals(getZipCode(), that.getZipCode()) && Objects.equals(getPostCode(), that.getPostCode()) && Objects.equals(getCountry(), that.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreetName(), getStreetAddress(), getBuildingNumber(), getZipCode(), getPostCode(), getCountry());
    }
}
