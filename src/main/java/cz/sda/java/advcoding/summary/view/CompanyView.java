package cz.sda.java.advcoding.summary.view;

import cz.sda.java.advcoding.summary.model.Company;
import cz.sda.java.advcoding.summary.model.Person;
import cz.sda.java.advcoding.summary.service.CompanyService;
import cz.sda.java.advcoding.summary.service.PersonService;
import cz.sda.java.advcoding.summary.view.menuoptions.ApplicationMenu;
import cz.sda.java.advcoding.summary.view.menuoptions.CompanyMenuOptions;
import org.beryx.textio.TextIO;

import java.util.List;

public class CompanyView implements ApplicationMenu {

    private final TextIO textIO;
    private final CompanyService companyService;
    private final PersonService personService;

    public CompanyView(TextIO textIO, CompanyService companyService, PersonService personService) {
        this.textIO = textIO;
        this.companyService = companyService;
        this.personService = personService;
    }

    @Override
    public void showMenu() {
        CompanyMenuOptions selectedOption = null;
        textIO.getTextTerminal().println("\n----------------------\nCompany Menu\n----------------------\n");
        while (selectedOption != CompanyMenuOptions.BACK) {
            selectedOption = textIO.newEnumInputReader(CompanyMenuOptions.class)
                    .withAllValuesNumbered()
                    .withDefaultValue(CompanyMenuOptions.BACK)
                    .read("Choose an option");
            switch (selectedOption) {
                case ADD_COMPANY-> addCompany();
                case UPDATE_COMPANY -> updateCompany();
                case REMOVE_COMPANY-> removeCompany();
                case LIST_COMPANIES -> listCompanies();
                case ADD_PERSON -> addEmployee();
                case REMOVE_PERSON -> removeEmployee();
                case BACK -> textIO.getTextTerminal().println("Going back");
            }

        }
    }

    private void removeEmployee() {
        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println("Removing an employee");
        listCompanies();
        Integer companyIndex = textIO.newIntInputReader()
                .withMinVal(0)
                .withMaxVal(companyService.getAll().size() - 1)
                .read("Enter the number of the company to remove an employee from");
        Company company = companyService.getAt(companyIndex);
        textIO.getTextTerminal().println("Removing an employee from company: " + company.name());
        List<Person> employees = company.employees();
        printEmployeesOfCompany(employees);
        Integer employeeIndex = textIO.newIntInputReader()
                .withMinVal(0)
                .withMaxVal(employees.size() - 1)
                .read("Enter the number of the employee to remove");
        Person employee = employees.get(employeeIndex);
        companyService.removeEmployee(company, employee);
    }

    private void printEmployeesOfCompany(List<Person> employees) {
        for (int i = 0; i < employees.size(); i++) {
            textIO.getTextTerminal().printf("[%d] %s%n", i, employees.get(i).getName());
        }
    }

    private void addEmployee() {
        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println("Adding an employee");
        listCompanies();
        Integer companyIndex = textIO.newIntInputReader()
                .withMinVal(0)
                .withMaxVal(companyService.getAll().size() - 1)
                .read("Enter the number of the company to add an employee to");
        Company company = companyService.getAt(companyIndex);
        textIO.getTextTerminal().println("Adding an employee to company: " + company.name());
        var persons = personService.getAll();
        textIO.getTextTerminal().println("List of all persons in system");
        for (int i = 0; i < persons.size(); i++) {
            textIO.getTextTerminal().printf("[%d] %s%n", i, persons.get(i).getName());
        }
        Integer personIndex = textIO.newIntInputReader()
                .withMinVal(0)
                .withMaxVal(persons.size() - 1)
                .read("Enter the number of the person to add to company");
        companyService.addEmployee(company, persons.get(personIndex));
    }

    private void updateCompany() {
        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println("Updating a company");
        listCompanies();
        Integer companyIndex = textIO.newIntInputReader()
                .withMinVal(0)
                .withMaxVal(companyService.getAll().size() - 1)
                .read("Enter the number of the person to update");
        Company company = companyService.getAt(companyIndex);
        textIO.getTextTerminal().println("Updating company: " + company.name());
        textIO.getTextTerminal().print("Current details: ");
        writeCompanyToTerminal(companyIndex, company);
        String name = textIO.newStringInputReader()
                .withDefaultValue(company.name())
                .withInputTrimming(true)
                .read("Enter name");
        String id = textIO.newStringInputReader()
                .withDefaultValue(company.id())
                .withInputTrimming(true)
                .read("Enter company identification number");
        String address = textIO.newStringInputReader()
                .withDefaultValue(company.address())
                .withInputTrimming(true)
                .read("Enter company address");
        companyService.update(companyIndex, Company.builder()
                .name(name)
                .id(id)
                .address(address)
                .build());
    }

    private void removeCompany() {
        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println("Removing a company");
        listCompanies();
        Integer companyIndex = textIO.newIntInputReader()
                .withMinVal(0)
                .withMaxVal(companyService.getAll().size() - 1)
                .read("Enter the number of the company to remove");
        try {
            companyService.remove(companyIndex);
        } catch (IllegalArgumentException e) {
            textIO.getTextTerminal().println("Entered company does not exist");
        }

    }

    private void listCompanies() {
        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println("List of all companies in system");
        List<Company> companies = companyService.getAll();
        for (int i = 0; i< companies.size(); i++) {
            this.writeCompanyToTerminal(i, companies.get(i));
        }
        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println();
    }

    private void writeCompanyToTerminal(Integer seqNo, Company company) {
        if (company == null) {
            return;
        }
        String companyName;
        textIO.getTextTerminal().printf("[%d] %s (employee count: %d): %s, %s%n", seqNo, company.name(), company.employees().size(), company.id(), company.address());
    }

    private void addCompany() {
        textIO.getTextTerminal().println("Adding a company");
        String name = textIO.newStringInputReader()
                .withInputTrimming(true)
                .read("Enter name");
        // TODo constraint on ID - ask what id can be
        String id = textIO.newStringInputReader()
                .withInputTrimming(true)
                .read("Enter company identification number");
        String address = textIO.newStringInputReader()
                .withInputTrimming(true)
                .read("Enter company address");
        companyService.createPerson(Company.builder()
                .name(name)
                .id(id)
                .address(address)
                .build());
    }
}
