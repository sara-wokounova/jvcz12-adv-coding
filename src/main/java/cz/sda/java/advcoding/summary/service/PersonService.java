package cz.sda.java.advcoding.summary.service;

import cz.sda.java.advcoding.summary.model.Company;
import cz.sda.java.advcoding.summary.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private final List<Person> persons = new ArrayList<>();

    public void createPerson(String name, String phoneNumber, String email, Company company) {
        persons.add(Person.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .email(email)
                .company(company)
                .build());
    }

    public List<Person> getPersons() {
        return List.copyOf(persons);
    }

    public Person getPerson(Integer seqNo) {
        return persons.get(seqNo);
    }

    public void removePerson(int personIndex) {
        if (personIndex < 0 || personIndex >= persons.size()) {
            throw new IllegalArgumentException("Invalid person index");
        }
        persons.remove(personIndex);
    }

    public void updatePerson(Integer personIndex, String name, String phoneNumber, String emailAddress, Company company) {
        if (personIndex < 0 || personIndex >= persons.size()) {
            throw new IllegalArgumentException("Invalid person index");
        }
        persons.set(personIndex, Person.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .email(emailAddress)
                .company(company)
                .build());
    }
}
