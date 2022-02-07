package ru.neoflex.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.accountservice.entity.Address;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public interface AddressRepo extends JpaRepository<Address, UUID> {
}