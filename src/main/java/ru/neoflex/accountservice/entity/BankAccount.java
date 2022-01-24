package ru.neoflex.accountservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;
import ru.neoflex.accountservice.model.enums.Sex;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "account")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
    @Column(name = "account_id")
    private UUID uuid;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "account_number")
    private long accountNumber;

    @Column(name = "sex")
    @Enumerated(STRING)
    private Sex sex;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BankAccount that = (BankAccount) o;
        return uuid != null && Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
