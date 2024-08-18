package cz.sda.java.advcoding.summary.model;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public record Company(String name, String id, String address, List<Person> employees) {

    public static class CompanyBuilder {
        CompanyBuilder() {
            employees = new ArrayList<>();
        }
    }
}
