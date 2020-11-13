package com.covidstats.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covidstats.demo.model.Continent;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, String> {

}
