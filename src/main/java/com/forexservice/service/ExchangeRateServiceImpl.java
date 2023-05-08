package com.forexservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forexservice.dao.ExchangeRateDAO;
import com.forexservice.dto.ExchangeRateDTO;
import com.forexservice.entity.ExchangeRate;
import com.forexservice.exception.ExchangeRateNotFoundException;
import com.forexservice.util.MapperUtil;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

	@Autowired
	private ExchangeRateDAO exchangeRateDAO;

	@Override
	public ExchangeRateDTO save(ExchangeRateDTO rate) {
		ExchangeRate exchangeRate = exchangeRateDAO.save(MapperUtil.toEntity(rate));
		return MapperUtil.toDTO(exchangeRate);
	}

	@Override
	public ExchangeRateDTO update(long id, ExchangeRateDTO rate) throws ExchangeRateNotFoundException {
		ExchangeRate existingExchangeRate = exchangeRateDAO.findById(id)
				.orElseThrow(() -> new ExchangeRateNotFoundException("Exchange Rate not found with ID: " + id));
		existingExchangeRate.setExchangeFee(rate.getExchangeFee());
		existingExchangeRate.setExchangeSourceRate(rate.getExchangeSourceRate());
		existingExchangeRate.setExchangeTargetRate(rate.getExchangeTargetRate());
		existingExchangeRate.setExchangeTime(rate.getExchangeTime());
		ExchangeRate updatedExchangeRate = exchangeRateDAO.save(existingExchangeRate);
		return MapperUtil.toDTO(updatedExchangeRate);
	}

	@Override
	public List<ExchangeRateDTO> findAll() {
		List<ExchangeRate> exchangeRates = exchangeRateDAO.findAll();
		return exchangeRates.stream().map(MapperUtil::toDTO).collect(Collectors.toList());
	}

	@Override
	public ExchangeRateDTO delete(long id) throws ExchangeRateNotFoundException {
		ExchangeRate exchangeRate = exchangeRateDAO.findById(id)
				.orElseThrow(() -> new ExchangeRateNotFoundException("Exchange Rate not found with ID: " + id));
		exchangeRateDAO.deleteById(id);
		return MapperUtil.toDTO(exchangeRate);
	}

}
