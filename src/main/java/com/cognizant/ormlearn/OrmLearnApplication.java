package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	private static void testGetAllCountries() {

		LOGGER.info("Start handson 1 of day 1 - session 1 and 2");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End handson 1 of day 1 - session 1 and 2");

	}

	private static void getAllCountriesTest(String code) throws CountryNotFoundException {

		LOGGER.info("Start handson 6 of day 1 - session 1 and 2");

		Country country = countryService.findCountryByCode(code);

		LOGGER.debug("Country:{}", country);

		LOGGER.info("End handson 6 of day 1 - session 1 and 2");

	}

	public static void testAddCountry() {
		LOGGER.info("Start handson 7 of day 1 - session 1 and 2");

		Country country = new Country("cs", "cognizant");
		countryService.addCountry(country);

		LOGGER.info("End handson 7 of day 1 - session 1 and 2");
	}

	private static void updateCountryTest(String code, String name) throws CountryNotFoundException {

		LOGGER.info("Start handson 8 of day 1 - session 1 and 2");

		countryService.updateCountry(code, name);

		LOGGER.info("End handson 8 of day 1 - session 1 and 2");

	}
	private static void deleteCountryTest(String code) {

		LOGGER.info("Start handson 9 of day 1 - session 1 and 2");

		countryService.deleteCountry(code);

		LOGGER.info("End handson 9 of day 1 - session 1 and 2");

	}

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");
		testGetAllCountries();
		getAllCountriesTest("IN");
		testAddCountry();
		getAllCountriesTest("cs");
		updateCountryTest("cs","cognizant pro");
		deleteCountryTest("cs");

	}

}
