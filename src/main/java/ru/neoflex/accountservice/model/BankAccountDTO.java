package ru.neoflex.accountservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.neoflex.accountservice.model.enums.Sex;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class BankAccountDTO {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("middleName")
    private String middleName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("accountNumber")
    private long accountNumber;

    @JsonProperty("sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    public Optional<String> getFirstName() {
        return Optional.ofNullable(firstName);
    }

    public Optional<String> getMiddleName() {
        return Optional.ofNullable(middleName);
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

    public Optional<Long> getAccountNumber() {
        return Optional.ofNullable(accountNumber);
    }

    public Optional<Sex> getSex() {
        return Optional.ofNullable(sex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccountDTO)) return false;
        BankAccountDTO that = (BankAccountDTO) o;
        return getAccountNumber() == that.getAccountNumber() && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getMiddleName(), that.getMiddleName()) && Objects.equals(getLastName(), that.getLastName()) && getSex() == that.getSex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getMiddleName(), getLastName(), getAccountNumber(), getSex());
    }
}