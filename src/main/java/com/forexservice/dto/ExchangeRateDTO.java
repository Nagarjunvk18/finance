package com.forexservice.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateDTO {

	private Long id;
	private double exchangeSourceRate;
	private double exchangeTargetRate;
	private double exchangeFee;
	private LocalDate exchangeTime;

}
