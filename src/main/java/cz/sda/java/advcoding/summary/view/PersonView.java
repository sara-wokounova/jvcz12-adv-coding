package cz.sda.java.advcoding.summary.view;

import cz.sda.java.advcoding.summary.view.menuoptions.ApplicationMenu;
import cz.sda.java.advcoding.summary.view.menuoptions.PersonMenuOptions;
import org.beryx.textio.TextIO;

public class PersonView implements ApplicationMenu {

    private final TextIO textIO;

    public PersonView(TextIO textIO) {
        this.textIO = textIO;
    }

    @Override
    public void showMenu() {
        PersonMenuOptions selectedOption = null;
        textIO.getTextTerminal().println("%n----------------------%sMainMenu%----------------------%n");
        while (selectedOption != PersonMenuOptions.BACK) {
            selectedOption = textIO.newEnumInputReader(PersonMenuOptions.class)
                    .withAllValuesNumbered()
                    .withDefaultValue(PersonMenuOptions.BACK)
                    .read("Choose an option");
            switch (selectedOption) {
                case ADD_PERSON -> textIO.getTextTerminal().println("Adding a person");
                case UPDATE_PERSON -> textIO.getTextTerminal().println("Editing a person");
                case REMOVE_PERSON -> textIO.getTextTerminal().println("Deleting a person");
                case LIST_PERSONS -> textIO.getTextTerminal().println("Listing persons");
                case BACK -> textIO.getTextTerminal().println("Going back");
            }

        }
    }
}
