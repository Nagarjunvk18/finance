package com.forexservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.forexservice.dto.ExchangeRateDTO;
import com.forexservice.exception.ExchangeRateNotFoundException;

@Service
public interface ExchangeRateService {

	ExchangeRateDTO save(ExchangeRateDTO rate);

	ExchangeRateDTO update(long id, ExchangeRateDTO rate) throws ExchangeRateNotFoundException;

	List<ExchangeRateDTO> findAll();

	ExchangeRateDTO delete(long id) throws ExchangeRateNotFoundException;

}
