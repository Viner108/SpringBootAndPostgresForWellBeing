package com.mkyong.repository;

import com.mkyong.model.UserHealth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserHealthRepository extends JpaRepository<UserHealth, Long>{
    @Query("SELECT b FROM UserHealth b WHERE b.userId = :userId")
    List<UserHealth> findByUserId(@Param("userId") Long userId);
    @Query("SELECT b FROM UserHealth b WHERE b.date BETWEEN :date1 AND :date2")
    List<UserHealth> findByDate(@Param("date1") LocalDate date1,@Param("date2") LocalDate date2);
}
