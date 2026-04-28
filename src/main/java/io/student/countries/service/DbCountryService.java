package io.student.countries.service;

import io.student.countries.data.CountryEntity;
import io.student.countries.data.CountryRepository;
import io.student.countries.domain.Country;
import io.student.countries.domain.CountryUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbCountryService implements CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public DbCountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> allCountries() {
        return countryRepository.findAll()
                .stream()
                .map(countryEntity -> {
                    return new Country(
                            countryEntity.getId(),
                            countryEntity.getCountryCode(),
                            countryEntity.getName()
                    );
                }).toList();

    }

    private Country mapToDomain(CountryEntity entity) {
        return new Country(entity.getId(), entity.getName(), entity.getCountryCode());
    }

    @Override
    public Country addCountry(Country country) {
        CountryEntity entity = new CountryEntity();
        entity.setName(country.name());
        entity.setCountryCode(country.country_code());
        CountryEntity saved = countryRepository.save(entity);
        return mapToDomain(saved);
    }

    public CountryEntity findByCountryCode(String countryCode) {
        return countryRepository.findByCountryCode(countryCode)
                .orElseThrow(() -> new RuntimeException("Страна с кодом " + countryCode + " не найдена"));
    }

    @Override
    public Country updateCountryName(String countryCode, CountryUpdateDto updateDto) {
        CountryEntity country = findByCountryCode(countryCode);
        country.setName(updateDto.name());
        CountryEntity saved = countryRepository.save(country);
        return mapToDomain(saved);
    }
}
