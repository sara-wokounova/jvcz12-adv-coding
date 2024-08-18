package cz.sda.java.advcoding.summary.model;

import lombok.Builder;

@Builder
public record Person(String  name, String phoneNumber, String email, Company company) {
}
