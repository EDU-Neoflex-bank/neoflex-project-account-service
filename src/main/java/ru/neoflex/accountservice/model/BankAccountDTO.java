package ru.neoflex.accountservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.neoflex.accountservice.model.enums.Sex;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
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
}