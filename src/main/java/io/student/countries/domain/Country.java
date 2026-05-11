package io.student.countries.domain;

import java.util.UUID;

public record Country(UUID id, String name, String countryCode) {
}
