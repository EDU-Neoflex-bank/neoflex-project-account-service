package ru.neoflex.accountservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.accountservice.entity.BankAccount;
import ru.neoflex.accountservice.service.BankAccountService;

import java.util.UUID;

@Api(tags = {"Getting BankAccounts"})
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @GetMapping("/account")
    @ApiOperation(value = "Get BankAccount by uuid", notes = "This method returns BankAccount by uuid")
    public BankAccount getAccountInfo(
            @RequestParam("uuid")
            @ApiParam(
                    name = "uuid",
                    type = "String",
                    value = "BankAccount uuid",
                    example = "54a2ad70-6686-413f-9701-86cdd9d0e2fb",
                    required = true)
                    UUID uuid) {
        return bankAccountService.getBankAccountById(uuid);
    }
}
