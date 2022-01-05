package ru.neoflex.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.accountservice.entity.BankAccountInfo;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public interface BankAccountInfoRepo extends JpaRepository<BankAccountInfo, UUID> {

}
