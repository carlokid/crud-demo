package com.covidstats.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CONTINENT")
public class Continent {

	@Id
	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "continentCode", cascade = CascadeType.ALL)
	private Set<Countries> countries;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Countries> getCountries() {
		return countries;
	}

	public void setCountries(Set<Countries> countries) {
		this.countries = countries;
	}

}