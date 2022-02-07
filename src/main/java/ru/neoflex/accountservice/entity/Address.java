package ru.neoflex.accountservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "account_address")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "city")
    private String city;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "building_number")
    private String buildingNumber;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "post_code")
    private String postCode;

    @Column(name = "country")
    private String country;
}