package com.forexservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forexservice.entity.ExchangeRate;

@Repository
public interface ExchangeRateDAO extends JpaRepository<ExchangeRate, Long> {

}
