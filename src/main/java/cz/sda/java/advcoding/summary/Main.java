package cz.sda.java.advcoding.summary;

import cz.sda.java.advcoding.summary.service.CompanyService;
import cz.sda.java.advcoding.summary.service.PersonService;
import cz.sda.java.advcoding.summary.view.CompanyView;
import cz.sda.java.advcoding.summary.view.MainView;
import cz.sda.java.advcoding.summary.view.PersonView;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

class Main {

    public static void main(String[] args) {
        TextIO textIO = TextIoFactory.getTextIO();
        PersonService personService = new PersonService();
        CompanyService companyService = new CompanyService();
        PersonView personView = new PersonView(textIO, personService);
        CompanyView companyView = new CompanyView(textIO, companyService, personService);
        MainView mainView = new MainView(textIO, personView, companyView);
        mainView.showMenu();
        textIO.dispose();
    }
}
