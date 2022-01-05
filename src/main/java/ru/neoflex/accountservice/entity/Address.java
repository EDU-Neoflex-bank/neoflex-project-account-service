package ru.neoflex.accountservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "account_address")
public class Address {

    @Id
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "bank_account_id")
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

    public Address(UUID uuid, String city, String streetName, String streetAddress, String buildingNumber, String zipCode, String postCode, String country) {
        this.uuid = uuid;
        this.city = city;
        this.streetName = streetName;
        this.streetAddress = streetAddress;
        this.buildingNumber = buildingNumber;
        this.zipCode = zipCode;
        this.postCode = postCode;
        this.country = country;
    }

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreetName(), address.getStreetName()) && Objects.equals(getStreetAddress(), address.getStreetAddress()) && Objects.equals(getBuildingNumber(), address.getBuildingNumber()) && Objects.equals(getZipCode(), address.getZipCode()) && Objects.equals(getPostCode(), address.getPostCode()) && Objects.equals(getCountry(), address.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreetName(), getStreetAddress(), getBuildingNumber(), getZipCode(), getPostCode(), getCountry());
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", postcode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}