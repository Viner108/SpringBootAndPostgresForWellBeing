package com.mkyong.repository;
import com.mkyong.model.Book;
import com.mkyong.model.UserHealth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserHealthRepository extends JpaRepository<UserHealth, Long>{
    @Query("SELECT b FROM UserHealth b WHERE b.userId = :userId")
    List<UserHealth> findByUserId(@Param("userId") Long userId);
}
