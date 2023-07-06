 package com.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.country.Dto.CountryDto;
import com.country.Repository.Entity.Country;
import com.country.serviceimpl.CountryService;




@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	//Create country
	
	@PostMapping("/add-country")
	public String saveCountryInTODB(@RequestBody CountryDto countryDto) {
		String saveCountryInToDB = countryService.saveCountryInToDB(countryDto);
		return saveCountryInToDB;
	}
	
	
	//get all country
	@GetMapping("/country")
	public List<CountryDto> getAllCountries() {
		return countryService.getAllcountry();
	}	
	
	//get country By Id
	@GetMapping("/country/{id}")
	public ResponseEntity<CountryDto> getCountryById(@PathVariable(value = "id") int id) {
	    
	    CountryDto dto = countryService.getCountryById(id);
	    
	    if(dto == null)
	    {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }else
	    {
	    	return new ResponseEntity<>(dto, HttpStatus.OK);
	    }
	    
	}
	
	//UPDATE country by id
	@PutMapping("/country/{id}")
	public ResponseEntity<Country> updateCountry(@RequestBody Country entity,
			@PathVariable(value = "id") int countryId) {
		Country country = countryService.updateCountry(entity, countryId);
		return new ResponseEntity<>(country, HttpStatus.ACCEPTED);

	}
	
	//delete country
	@DeleteMapping("/{id}")
	public String deleteCountry(@PathVariable(value = "id") int id) {
		String str = countryService.deleteCountry(id);
		return str;
		
	}
	
	

}













