package ru.neoflex.accountservice.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.neoflex.accountservice.entity.BankAccount;
import ru.neoflex.accountservice.mapper.BankAccountMapper;
import ru.neoflex.accountservice.model.enums.Sex;
import ru.neoflex.accountservice.repository.BankAccountRepo;

import java.util.UUID;

@Service
public class BankAccountInfoService {

    private final ObjectMapper objectMapper;
    private final BankAccountRepo bankAccountRepo;
    private final BankAccountMapper bankAccountMapper;

    public BankAccountInfoService(ObjectMapper objectMapper, BankAccountRepo bankAccountRepo, BankAccountMapper bankAccountMapper) {
        this.objectMapper = objectMapper;
        this.bankAccountRepo = bankAccountRepo;
        this.bankAccountMapper = bankAccountMapper;
    }

    @Scheduled(cron = "*/2 * * * * *")
    public void generateBankAccount() {

//        System.out.println("test");

//        bankAccountRepo.save(bankAccountMapper.toBankAccount());
        bankAccountRepo.save(new BankAccount(UUID.randomUUID(), "Иван", "Иванович", "Иванов", 1239762374628734L, Sex.MALE));
        bankAccountRepo.findAll().forEach(System.out::println);

        System.out.println("------------------------------------------------");

//        рест запрост
//        передать строку в objectMapper
//        преобразовать строку в список объектов


        /*
        Сделать запрос при помощи REST template
        его надо будет заинжектить как и в генераторе (все инъекции делать через конструктор!!)

        метод будет возвращать строку с JSON, которую надо распарсить с помощью Jackson.
        После этого будет получен список аккаунтов, к ним добавить по одному типу и адресу
        и через сеттеры добавить эту инфу в пустой объект в новый объект BankAccountInfo.

        После этого записать в базу.
         */
    }

    /*
    В цикле для каждого BankAccountInfo добавить типа аккаунта
     */

//  Вызвать AddressService getAddress

    /*
    Метод сохранения в базу. Потом.
     */


//    Узнать по поводу домашек - кто должен проверять

//    Прочитать про внедрение зависимостей, про шедулер и

/*
* 1. ОТправить запрос на генератор
* 2. получить json
* 3. Преобразовать строку в список объектов BankAccount -> передать его в метод createBankAccountsInfo(). Он вернет список BankAccountInfo
* 4. ОТправить запрос на адрес генетор
* 2. получить json
* 3. Преобразовать строку в список объектов Address
* 4. Создать BankAccountInfo
*
* */


    /*
    * createBankAccountsInfo()
    *   */
}


/*

 */
