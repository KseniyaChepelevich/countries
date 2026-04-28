package io.student.countries.controller;

import io.student.countries.data.CountryEntity;
import io.student.countries.domain.Country;
import io.student.countries.domain.CountryUpdateDto;
import io.student.countries.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping("/all")
    public List<Country> all (){
        return countryService.allCountries();
    }

    @PostMapping("/add")
    public Country add (@RequestBody Country country){
        return countryService.addCountry(country);
    }

    @PatchMapping("/{code}")
    public Country update (@PathVariable String code, @RequestBody CountryUpdateDto updateDto) {
        return countryService.updateCountryName(code, updateDto);
    }
}
