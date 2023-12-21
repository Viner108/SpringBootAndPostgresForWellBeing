package com.mkyong.model;


import jakarta.persistence.*;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity

@Table(name = "user_health")
public class UserHealth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;
    private String pressure;

    private String headAche;
    private LocalDate date;

    public UserHealth() {
    }

    public UserHealth(Long name) {
        this.id = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHeadAche() {
        return headAche;
    }

    public void setHeadAche(String headAche) {
        this.headAche = headAche;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long name) {
        this.id = name;
    }
}
