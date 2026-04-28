package io.student.countries.service;

import io.student.countries.data.CountryEntity;
import io.student.countries.domain.Country;
import io.student.countries.domain.CountryUpdateDto;

import java.util.List;

public interface CountryService {
    List<Country> allCountries();

   Country addCountry(Country country);

    Country updateCountryName(String countryCode, CountryUpdateDto updateDto);
}
