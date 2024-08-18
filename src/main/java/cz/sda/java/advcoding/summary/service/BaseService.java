package cz.sda.java.advcoding.summary.service;

import cz.sda.java.advcoding.summary.model.Company;
import cz.sda.java.advcoding.summary.model.Person;

import java.util.ArrayList;
import java.util.List;

class BaseService<T> {
    private final List<T> repository = new ArrayList<T>();

    public void createPerson(T entity) {
        repository.add(entity);
    }

    public List<T> getAll() {
        return List.copyOf(repository);
    }

    public T getAt(int seqNo) {
        return repository.get(seqNo);
    }

    public T remove(int index) {
        if (index < 0 || index >= repository.size()) {
            throw new IllegalArgumentException("Invalid entity index");
        }
        return repository.remove(index);
    }

    public void update(int index, T newEntity) {
        if (index < 0 || index >= repository.size()) {
            throw new IllegalArgumentException("Invalid entity index");
        }
        repository.set(index, newEntity);
    }
}
