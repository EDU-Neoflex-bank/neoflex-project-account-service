package ru.neoflex.accountservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.neoflex.accountservice.model.enums.AccountType;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BankAccountInfoDTO {

    private BankAccountDTO bankAccountDTO;
    private AddressDTO addressDTO;
    private AccountType accountType;

    /**
     * @param bankAccountDTO
     * @param addressDTO
     */
    public BankAccountInfoDTO(BankAccountDTO bankAccountDTO, AddressDTO addressDTO, AccountType accountType) {
        this.bankAccountDTO = bankAccountDTO;
        this.addressDTO = addressDTO;
        this.accountType = accountType;
    }

    /**
     * @return
     */
    public BankAccountDTO getBankAccount() {
        return bankAccountDTO;
    }

    /**
     * @param bankAccountDTO
     */
    public void setBankAccount(BankAccountDTO bankAccountDTO) {
        this.bankAccountDTO = bankAccountDTO;
    }

    /**
     * @return
     */
    public AddressDTO getAddress() {
        return addressDTO;
    }

    /**
     * @param addressDTO
     */
    public void setAddress(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    /**
     * @return
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * @param accountType
     */
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccountInfoDTO)) return false;
        BankAccountInfoDTO that = (BankAccountInfoDTO) o;
        return getBankAccount().equals(that.getBankAccount()) && getAddress().equals(that.getAddress()) && getAccountType() == that.getAccountType();
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getBankAccount(), getAddress(), getAccountType());
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "BankAccountInfo{" +
                "bankAccount=" + bankAccountDTO +
                ", address=" + addressDTO +
                ", accountType=" + accountType +
                '}';
    }
}
