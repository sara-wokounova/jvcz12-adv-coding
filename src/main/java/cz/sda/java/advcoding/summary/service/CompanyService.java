package cz.sda.java.advcoding.summary.service;

import cz.sda.java.advcoding.summary.model.Company;
import cz.sda.java.advcoding.summary.model.Person;

import java.util.ArrayList;
import java.util.List;

public class CompanyService extends BaseService<Company> {

    public void addEmployee(Company company, Person employee) {
        if (employee.getCompany() != null) {
            employee.getCompany().employees().remove(employee);
        }
        company.employees().add(employee);
        employee.setCompany(company);
    }

    public void removeEmployee(Company company, Person employee) {
        company.employees().remove(employee);
        employee.setCompany(null);
    }

}
