package cz.sda.java.advcoding.summary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Person {
    String name;
    String phoneNumber;
    String email;
    Company company;
}
