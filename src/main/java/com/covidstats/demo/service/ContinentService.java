package com.covidstats.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidstats.demo.exception.RecordNotFoundException;
import com.covidstats.demo.model.Continent;
import com.covidstats.demo.repository.ContinentRepository;

@Service
public class ContinentService {

	@Autowired
	ContinentRepository repository;

	public List<Continent> getAllContinents() {
		List<Continent> continentList = repository.findAll();

		if (continentList.size() > 0) {
			return continentList;
		} else {
			return new ArrayList<Continent>();
		}
	}

	public Continent getContinentById(String code) throws RecordNotFoundException {
		Optional<Continent> continent = repository.findById(code);

		if (continent.isPresent()) {
			return continent.get();
		} else {
			throw new RecordNotFoundException("No continent record exist for given continent code");
		}
	}

}