package cz.sda.java.advcoding.summary.model;

import lombok.Builder;

import java.util.List;

@Builder
public record Company(String name, String id, String address, List<Person> employees) {
}
