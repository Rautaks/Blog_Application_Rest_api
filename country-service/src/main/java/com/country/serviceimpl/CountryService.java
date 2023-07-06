package com.country.serviceimpl;



import java.util.List;


import com.country.Dto.CountryDto;
import com.country.Repository.Entity.Country;



public interface CountryService {
	
	/**
	 * This method is use to save the data in database
	 * 
	 * @param countryDto
	 * @return "Successfully Saved"
	 */
	String saveCountryInToDB(CountryDto countryDto);
	


	/**
	 * This method is use to get the country list from database
	 * 
	 * @return CountryDto List of countries
	 */  
	
	List<CountryDto> getAllcountry();
	
	

	CountryDto getCountryById(Integer id);

	/**
	 * 
	 * @param entity
	 * @param countryId
	 * @return
	 */
	
	Country updateCountry(Country entity, int countryId);
	
	
     String deleteCountry(Integer id);
	
	

}
