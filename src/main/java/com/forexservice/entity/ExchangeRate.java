package com.forexservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exchange_rates")
public class ExchangeRate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "exchange_source_rate")
	private double exchangeSourceRate;

	@Column(name = "exchange_target_rate")
	private double exchangeTargetRate;

	@Column(name = "exchange_fee")
	private double exchangeFee;

	@Column(name = "exchange_time")
	private LocalDate exchangeTime;

}
