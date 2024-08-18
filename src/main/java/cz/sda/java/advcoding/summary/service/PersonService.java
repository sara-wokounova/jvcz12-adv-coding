package cz.sda.java.advcoding.summary.service;

import cz.sda.java.advcoding.summary.model.Person;

public class PersonService extends BaseService<Person> {

    @Override
    public void update(int index, Person newPerson) {
        var oldPerson = getAt(index);
        var updatedPerson = Person.builder()
                .name(newPerson.getName())
                .phoneNumber(newPerson.getPhoneNumber())
                .email(newPerson.getEmail())
                .company(oldPerson.getCompany())
                .build();
        super.update(index, updatedPerson);
    }
}
