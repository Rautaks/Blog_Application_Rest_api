package com.country.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.country.Repository.Entity.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {
	

}
