package ru.neoflex.accountservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.accountservice.model.BankAccountInfoDTO;
import ru.neoflex.accountservice.service.BankAccountInfoService;

import java.util.List;
import java.util.UUID;

@Api(tags = {"Getting BankAccountInfo"})
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BankAccountInfoDTOController {

    private final BankAccountInfoService bankAccountInfoService;

    @GetMapping("/account-info")
    @ApiOperation(value = "Get BankAccountInfo by uuid", notes = "This method returns BankAccountInfo by uuid")
    public BankAccountInfoDTO getAccountInfo(
            @RequestParam("uuid")
            @ApiParam(
                    name = "uuid",
                    type = "String",
                    value = "BankAccountInfo uuid",
                    required = true)
                    UUID uuid
    ) {
        return bankAccountInfoService.getBankAccountInfoById(uuid);
    }

    @GetMapping("/account-infos")
    @ApiOperation(value = "Get BankAccountInfo list")
    public List<BankAccountInfoDTO> getAccountInfos() {
        return bankAccountInfoService.getBankAccountInfos();
    }

    @GetMapping("/account-infos-by-type")
    @ApiOperation(value = "Get BankAccountInfo by type")
    public List<BankAccountInfoDTO> getAccountByType(
            @RequestParam("type")
            @ApiParam(
                    name = "type",
                    type = "String",
                    value = "BankAccountInfo types: 'SAVINGS', 'MONEYMARKET', 'CHECKING', 'IRA' or 'CD'",
                    required = true)
                    String type
    ) {
        return bankAccountInfoService.getBankAccountByType(type);
    }

    @GetMapping("/account-infos-by-period")
    @ApiOperation(value = "Get BankAccountInfo by period in dd-MM-yyyy format")
    public List<BankAccountInfoDTO> getAccountsByPeriod(
            @RequestParam
            @ApiParam(
                    name = "startDate",
                    type = "String",
                    value = "BankAccountInfo start period date",
                    required = true)
                    String startDate,
            @RequestParam
            @ApiParam(
                    name = "endDate",
                    type = "String",
                    value = "BankAccountInfo end period date",
                    required = true)
                    String endDate
    ) {
        return bankAccountInfoService.getByPeriod(startDate, endDate);
    }
}