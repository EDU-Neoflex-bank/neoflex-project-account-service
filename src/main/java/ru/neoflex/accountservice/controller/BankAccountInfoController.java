package ru.neoflex.accountservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.accountservice.entity.BankAccountInfo;
import ru.neoflex.accountservice.service.BankAccountInfoService;

import java.util.UUID;

@Api(tags = {"Получение BankAccountInfo"})
@RestController
@RequestMapping("/api")
public class BankAccountInfoController {

    private final BankAccountInfoService bankAccountInfoService;

    public BankAccountInfoController(BankAccountInfoService bankAccountInfoService) {
        this.bankAccountInfoService = bankAccountInfoService;
    }

    @PostMapping("/account-info")
    @ApiOperation(value = "Получить какую-то строку")
    public BankAccountInfo getAccountInfo(@RequestBody() @ApiParam(value = "Bla-bla-bla value: описание", example = "example: пример значения") UUID uuid) {
        return bankAccountInfoService.getBankAccountInfoById(uuid);
    }

//    @PostMapping("/account-info")
//    @ApiOperation(value = "Получить какую-то строку")
//    public String getAccountInfo(@RequestBody() @ApiParam(value = "Bla-bla-bla value: описание", example = "example: пример значения") String string) {
//        return string;
//    }
}

/*
 Получение bankaccountinfo по id

 Получение всех bankaccountinfo

 Получение bankaccountinfo по типу

 Получение bankaccount по id (сделать в отдельном контроллере BankAccountController)

 Получение bankaccountinfo за какой-то промежуток времени




 @Slf4j
 найти зависимость

 подключить lombok

 */