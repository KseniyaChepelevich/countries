package io.student.countries.controller;

import io.student.countries.domain.CountryResponse;
import io.student.countries.domain.CountryUpdateDto;
import io.student.countries.domain.CreateCountryRequest;
import io.student.countries.service.CountryService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("api/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping("/all")
    public List<CountryResponse> all() {
        return countryService.allCountries();
    }

    @PostMapping("/add")
    public CountryResponse add(@RequestBody CreateCountryRequest country) {
        return countryService.addCountry(country);
    }

    @PatchMapping("/{code}")
    public CountryResponse update(@PathVariable String code, @RequestBody CountryUpdateDto updateDto) {
        return countryService.updateCountryName(code, updateDto);
    }
}
