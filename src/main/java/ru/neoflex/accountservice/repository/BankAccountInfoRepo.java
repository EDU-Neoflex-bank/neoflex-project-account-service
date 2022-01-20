package ru.neoflex.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.neoflex.accountservice.entity.BankAccountInfo;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
public interface BankAccountInfoRepo extends JpaRepository<BankAccountInfo, UUID> {

    @Query( "select ba " +
            "from BankAccountInfo ba " +
            "where ba.accountType = ?1")
    List<BankAccountInfo> getAccountsByType(String accountType);

    @Query("select bi " +
            "from BankAccountInfo bi " +
            "where  :startDate <= bi.createDate AND " +
            "       bi.createDate <= :endDate"
    )
    List<BankAccountInfo> getByPeriod(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
