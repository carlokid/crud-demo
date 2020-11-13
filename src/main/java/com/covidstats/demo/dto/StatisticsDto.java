package com.covidstats.demo.dto;

public class StatisticsDto {

	private Long statisticsId;
	private Long countryId;
	private Long activeCase;
	private Long confirmed;
	private Long recovered;
	private Long death;

	public Long getStatisticsId() {
		return statisticsId;
	}

	public void setStatisticsId(Long statisticsId) {
		this.statisticsId = statisticsId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getActiveCase() {
		return activeCase;
	}

	public void setActiveCase(Long activeCase) {
		this.activeCase = activeCase;
	}

	public Long getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Long confirmed) {
		this.confirmed = confirmed;
	}

	public Long getRecovered() {
		return recovered;
	}

	public void setRecovered(Long recovered) {
		this.recovered = recovered;
	}

	public Long getDeath() {
		return death;
	}

	public void setDeath(Long death) {
		this.death = death;
	}

}
