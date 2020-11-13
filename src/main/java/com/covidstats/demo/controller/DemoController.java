package com.covidstats.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covidstats.demo.dto.StatisticsDto;
import com.covidstats.demo.exception.RecordNotFoundException;
import com.covidstats.demo.model.Continent;
import com.covidstats.demo.model.Countries;
import com.covidstats.demo.model.Statistics;
import com.covidstats.demo.service.ContinentService;
import com.covidstats.demo.service.CountriesService;
import com.covidstats.demo.service.StatisticsService;

@RestController
@RequestMapping("/covid-stats")
public class DemoController {

	@Autowired
	ContinentService continentService;

	@Autowired
	CountriesService countyService;

	@Autowired
	StatisticsService statisticsService;

	@GetMapping("/continents")
	public ResponseEntity<List<Continent>> getAllContinents() {
		List<Continent> list = continentService.getAllContinents();

		return new ResponseEntity<List<Continent>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/continents/{code}")
	public ResponseEntity<Continent> getContinentById(@PathVariable("code") String code)
			throws RecordNotFoundException {
		Continent entity = continentService.getContinentById(code);

		return new ResponseEntity<Continent>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/countries")
	public ResponseEntity<List<Countries>> getAllCountries() {
		List<Countries> list = countyService.getAllCountries();

		return new ResponseEntity<List<Countries>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/countries/{id}")
	public ResponseEntity<Countries> getCountryById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Countries entity = countyService.getCountryById(id);

		return new ResponseEntity<Countries>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/statistics")
	public ResponseEntity<List<Statistics>> getAllStatistics() {
		List<Statistics> list = statisticsService.getAllStatistics();

		return new ResponseEntity<List<Statistics>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/statistics/createOrUpdate")
	public ResponseEntity<Statistics> createOrUpdateStatistics(@RequestBody StatisticsDto data)
			throws RecordNotFoundException {
		Statistics updated = statisticsService.createOrUpdateStatistics(data);
		return new ResponseEntity<Statistics>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/statistics/delete/{id}")
	public HttpStatus deleteStatisticsById(@PathVariable("id") Long id) throws RecordNotFoundException {
		statisticsService.deleteStatisticsRecord(id);
		return HttpStatus.FORBIDDEN;
	}

}