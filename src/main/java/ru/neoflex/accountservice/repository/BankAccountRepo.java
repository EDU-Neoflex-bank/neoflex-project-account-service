package ru.neoflex.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.accountservice.entity.BankAccount;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public interface BankAccountRepo extends JpaRepository<BankAccount, UUID> {

}
