package cz.sda.java.advcoding.summary.view;

import cz.sda.java.advcoding.summary.view.menuoptions.ApplicationMenu;
import cz.sda.java.advcoding.summary.view.menuoptions.MainMenuOptions;
import org.beryx.textio.TextIO;

public class MainView implements ApplicationMenu {

    private final TextIO textIO;
    private final PersonView personView;

    public MainView(TextIO textIO, PersonView personView) {
        this.textIO = textIO;
        this.personView = personView;
    }

    @Override
    public void showMenu() {
        MainMenuOptions selectedOption = null;
        textIO.getTextTerminal().println("%n----------------------%sMainMenu%----------------------%n");
        while (selectedOption != MainMenuOptions.EXIT) {
            selectedOption = textIO.newEnumInputReader(MainMenuOptions.class)
                    .withAllValuesNumbered()
                    .withDefaultValue(MainMenuOptions.EXIT)
                    .read("Choose an option");
            switch (selectedOption) {
                case PERSON -> personView.showMenu();
                case EXIT -> textIO.getTextTerminal().println("Exiting");
            }
        }
    }
}
