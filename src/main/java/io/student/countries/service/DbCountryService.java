package io.student.countries.service;

import io.student.countries.data.CountryEntity;
import io.student.countries.data.CountryRepository;
import io.student.countries.domain.CountryResponse;
import io.student.countries.domain.CountryUpdateDto;
import io.student.countries.domain.CreateCountryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbCountryService implements CountryService {
    private final CountryRepository countryRepository;

    public DbCountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<CountryResponse> allCountries() {
        return countryRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .toList();

    }

    private CountryResponse mapToDomain(CountryEntity entity) {
        return new CountryResponse(entity.getId(), entity.getName(), entity.getCountryCode());
    }

    @Override
    public CountryResponse addCountry(CreateCountryRequest country) {
        CountryEntity entity = new CountryEntity();
        entity.setName(country.name());
        entity.setCountryCode(country.countryCode());
        CountryEntity saved = countryRepository.save(entity);
        return mapToDomain(saved);
    }

    public CountryEntity findByCountryCode(String countryCode) {
        return countryRepository.findByCountryCode(countryCode)
                .orElseThrow(() -> new RuntimeException("Страна с кодом " + countryCode + " не найдена"));
    }

    @Override
    public CountryResponse updateCountryName(String countryCode, CountryUpdateDto updateDto) {
        CountryEntity country = findByCountryCode(countryCode);
        country.setName(updateDto.name());
        CountryEntity saved = countryRepository.save(country);
        return mapToDomain(saved);
    }
}
