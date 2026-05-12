package io.student.countries.domain;

import java.util.UUID;

public record CountryResponse(UUID id, String name, String countryCode) {
}


