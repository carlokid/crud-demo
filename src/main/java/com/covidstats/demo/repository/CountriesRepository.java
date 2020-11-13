package com.covidstats.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covidstats.demo.model.Countries;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, Long> {

}
