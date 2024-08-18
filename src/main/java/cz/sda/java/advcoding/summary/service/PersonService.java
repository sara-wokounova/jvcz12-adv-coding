package cz.sda.java.advcoding.summary.service;

import cz.sda.java.advcoding.summary.model.Company;
import cz.sda.java.advcoding.summary.model.Person;

import java.util.ArrayList;
import java.util.List;

class PersonService {

    private List<Person> persons = new ArrayList<>();

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
}
