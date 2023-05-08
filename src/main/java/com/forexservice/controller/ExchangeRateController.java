package com.forexservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.forexservice.dto.ExchangeRateDTO;
import com.forexservice.exception.ExchangeRateNotFoundException;
import com.forexservice.service.ExchangeRateService;

@RestController
@RequestMapping("/exchange")
public class ExchangeRateController {

	@Autowired
	private ExchangeRateService exchangeRateService;

	@PostMapping
	public ResponseEntity<ExchangeRateDTO> save(@RequestBody ExchangeRateDTO rate) {
		ExchangeRateDTO savedRate = exchangeRateService.save(rate);
		return new ResponseEntity<>(savedRate, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ExchangeRateDTO> update(@PathVariable long id, @RequestBody ExchangeRateDTO rate)
			throws ExchangeRateNotFoundException {
		ExchangeRateDTO updatedRate = exchangeRateService.update(id, rate);
		return new ResponseEntity<>(updatedRate, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ExchangeRateDTO>> findAll() {
		List<ExchangeRateDTO> rates = exchangeRateService.findAll();
		return new ResponseEntity<>(rates, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ExchangeRateDTO> delete(@PathVariable long id) throws ExchangeRateNotFoundException {
		ExchangeRateDTO deletedRate = exchangeRateService.delete(id);
		return new ResponseEntity<>(deletedRate, HttpStatus.OK);
	}

}
