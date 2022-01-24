package ru.neoflex.accountservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "account_address")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Address address = (Address) o;
        return uuid != null && Objects.equals(uuid, address.uuid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}