package com.covidstats.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidstats.demo.exception.RecordNotFoundException;
import com.covidstats.demo.model.Countries;
import com.covidstats.demo.repository.CountriesRepository;

@Service
public class CountriesService {

	@Autowired
	CountriesRepository repository;

	public List<Countries> getAllCountries() {
		List<Countries> countryList = repository.findAll();
		
		if (countryList.size() > 0) {
			return countryList;
		} else {
			return new ArrayList<Countries>();
		}
	}

	public Countries getCountryById(Long id) throws RecordNotFoundException {
		Optional<Countries> country = repository.findById(id);

		if (country.isPresent()) {
			return country.get();
		} else {
			throw new RecordNotFoundException("No country record exist for given country id");
		}
	}

}