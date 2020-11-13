package com.covidstats.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covidstats.demo.model.Statistics;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

}
