package cz.sda.java.advcoding.summary;

import cz.sda.java.advcoding.summary.service.PersonService;
import cz.sda.java.advcoding.summary.view.MainView;
import cz.sda.java.advcoding.summary.view.PersonView;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

class Main {

    public static void main(String[] args) {
        TextIO textIO = TextIoFactory.getTextIO();
        PersonService personService = new PersonService();
        PersonView personView = new PersonView(textIO, personService);
        MainView mainView = new MainView(textIO, personView);
        mainView.showMenu();
        textIO.dispose();
    }
}
