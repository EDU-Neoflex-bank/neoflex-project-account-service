package ru.neoflex.accountservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Получение BankAccountInfo"})
@RestController
@RequestMapping("/api")
public class BankAccountInfoController {

    @PostMapping("/account-info")
    @ApiOperation(value = "Получить какую-то строку")
    public String getAccountInfo(@RequestBody() @ApiParam(value = "Bla-bla-bla value: описание", example = "example: пример значения") String string) {
        return string;
    }
}