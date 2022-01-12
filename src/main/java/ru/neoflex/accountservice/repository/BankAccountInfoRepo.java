package ru.neoflex.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.neoflex.accountservice.entity.BankAccountInfo;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
public interface BankAccountInfoRepo extends JpaRepository<BankAccountInfo, UUID> {

//    через jpquery написать в параметры @Query() запрос из базы
    @Query()
    List<BankAccountInfo> getByPeriod(Date startDate, Date endDate);
}
