package com.covidstats.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidstats.demo.dto.StatisticsDto;
import com.covidstats.demo.exception.RecordNotFoundException;
import com.covidstats.demo.model.Countries;
import com.covidstats.demo.model.Statistics;
import com.covidstats.demo.repository.StatisticsRepository;

@Service
public class StatisticsService {

	@Autowired
	StatisticsRepository statsRepository;

	@Autowired
	CountriesService countriesService;

	public List<Statistics> getAllStatistics() {
		List<Statistics> statList = statsRepository.findAll();

		if (statList.size() > 0) {
			return statList;
		} else {
			return new ArrayList<Statistics>();
		}
	}

	public Statistics createOrUpdateStatistics(StatisticsDto data) throws RecordNotFoundException {
		Optional<Statistics> statistics = statsRepository.findById(data.getStatisticsId());

		if (statistics.isPresent()) {
			Statistics updateStats = statistics.get();
			updateStats.setActiveCase(data.getActiveCase());
			updateStats.setConfirmed(data.getConfirmed());
			updateStats.setRecovered(data.getRecovered());
			updateStats.setDeath(data.getDeath());
			updateStats = statsRepository.save(updateStats);

			return updateStats;
		} else {
			Countries country = countriesService.getCountryById(data.getCountryId());

			Statistics newStats = new Statistics();
			newStats.setCountry(country);
			newStats.setActiveCase(data.getActiveCase());
			newStats.setConfirmed(data.getConfirmed());
			newStats.setRecovered(data.getRecovered());
			newStats.setDeath(data.getDeath());
			newStats = statsRepository.save(newStats);

			return newStats;
		}
	}

	public void deleteStatisticsRecord(Long id) throws RecordNotFoundException {
		Optional<Statistics> statistics = statsRepository.findById(id);

		if (statistics.isPresent()) {
			statsRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No statistics record exist for given id");
		}
	}

}
