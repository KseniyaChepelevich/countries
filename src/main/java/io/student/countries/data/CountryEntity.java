package io.student.countries.data;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "country_name", nullable = false)
    private String name;

    @Column(name = "iso_code", nullable = false, unique = true, length = 2)
    private String countryCode;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryEntity that)) return false;
        return id.equals(that.id) && name.equals(that.name) && countryCode.equals(that.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countryCode);
    }
}
