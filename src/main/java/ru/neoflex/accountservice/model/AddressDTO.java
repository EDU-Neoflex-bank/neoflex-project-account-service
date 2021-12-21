package ru.neoflex.accountservice.model;

import java.util.Objects;

public class AddressDTO {
    private String street;
    private int houseNumber;
    private String flat;
    private int postIndex;
    private String city;
    private String state;
    private String country;

    public AddressDTO(String street, int houseNumber, String flat, int postIndex, String city, String state, String country) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.flat = flat;
        this.postIndex = postIndex;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public int getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(int postIndex) {
        this.postIndex = postIndex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressDTO)) return false;
        AddressDTO addressDTO = (AddressDTO) o;
        return getHouseNumber() == addressDTO.getHouseNumber() && getPostIndex() == addressDTO.getPostIndex() && getStreet().equals(addressDTO.getStreet()) && getFlat().equals(addressDTO.getFlat()) && getCity().equals(addressDTO.getCity()) && getState().equals(addressDTO.getState()) && getCountry().equals(addressDTO.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreet(), getHouseNumber(), getFlat(), getPostIndex(), getCity(), getState(), getCountry());
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", flat='" + flat + '\'' +
                ", postIndex=" + postIndex +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
