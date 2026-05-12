package io.student.countries.service;

import io.student.countries.domain.CountryResponse;
import io.student.countries.domain.CountryUpdateDto;
import io.student.countries.domain.CreateCountryRequest;

import java.util.List;

public interface CountryService {
    List<CountryResponse> allCountries();

    CountryResponse addCountry(CreateCountryRequest country);

    CountryResponse updateCountryName(String countryCode, CountryUpdateDto updateDto);
}
