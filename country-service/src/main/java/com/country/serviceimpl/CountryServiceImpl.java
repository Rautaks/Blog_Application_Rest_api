package com.country.serviceimpl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.country.Dto.CountryDto;
import com.country.Repository.CountryRepo;
import com.country.Repository.Entity.Country;


@Repository
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepo countryRepo;
	
	@Override
	public String saveCountryInToDB(CountryDto countryDto) {

		Country countryEntity = new Country();

		countryEntity.setCountryname(countryDto.getCountryName());
		countryEntity.setCoutrycapital(countryDto.getCountryCapital());

		countryRepo.save(countryEntity);

		return "Successfully Saved";
	}

	@Override
	public List<CountryDto> getAllcountry() {
		
		List<Country> countryList = countryRepo.findAll();

		List<CountryDto> list = new ArrayList<>();

		for (Country country : countryList) {

			CountryDto countryDto = new CountryDto();
			countryDto.setId(country.getId());
			countryDto.setCountryName(country.getCountryname());
			countryDto.setCountryCapital(country.getCoutrycapital());

			list.add(countryDto);
			
		}
		return list;
	}

	@Override
	public CountryDto getCountryById(Integer id) {
		
		CountryDto countryDto  = new CountryDto();
		try {
		Country country =  countryRepo.findById(id).get();
		
		if(country !=null)
		{
			countryDto.setId(country.getId());
			countryDto.setCountryName(country.getCountryname());
			countryDto.setCountryCapital(country.getCoutrycapital());
			
		}
		}catch(Exception e)
		{
			System.out.println("Country not found in db:"+ e.getMessage());
			return null;
		}
		return countryDto;
	}


	@Override
	public Country updateCountry(Country entity, int countryId) {
		
		Country country = countryRepo.findById(countryId).get();
		
		country.setId(countryId);
		country.setCountryname(entity.getCountryname());
		country.setCoutrycapital(entity.getCoutrycapital());
		
		return countryRepo.save(country);
	}
	
	@Override
	public String deleteCountry(Integer id) {
		
		countryRepo.deleteById(id);
		
		return "DELETE SUCCESSFULLY";
		
	}

	
}











