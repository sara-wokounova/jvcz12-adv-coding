package cz.sda.java.advcoding.ex12;

import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Set;

public record Car(@NonNull String name, @NonNull String model, BigDecimal price, int yearOfManufacture, @NonNull Set<Manufacturer> manufacturers, @NonNull EngineType engineType) {
}
