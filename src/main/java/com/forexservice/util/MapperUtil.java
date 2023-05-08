package com.forexservice.util;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.forexservice.dto.ExchangeRateDTO;
import com.forexservice.entity.ExchangeRate;

public class MapperUtil {
	private static final ModelMapper MAPPER = new ModelMapper();

	public static ExchangeRateDTO toDTO(ExchangeRate exchangeRate) {
		return MAPPER.map(exchangeRate, ExchangeRateDTO.class);
	}

	public static ExchangeRate toEntity(ExchangeRateDTO exchangeRateDTO) {
		return MAPPER.map(exchangeRateDTO, ExchangeRate.class);
	}

	public static List<ExchangeRateDTO> mapToExchangeDtoList(List<ExchangeRateDTO> exchangeList) {
		return MAPPER.map(exchangeList, new TypeToken<List<ExchangeRateDTO>>() {
		}.getType());
	}

	
}
