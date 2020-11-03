package issuesystem.menu.params;

import issuesystem.client.command.CommandInterface;
import issuesystem.client.config.ConnectionConfiguration;
import issuesystem.client.context.ApplicationContext;


public enum MainMenuParams implements MenuParamInterface {


    CONFIGURATION_MENU(1, "Konfiguracja", p -> ApplicationContext.setMenuParams(ConfigMenuParams.values())),
    USER_MENU(2, "Zarządzanie użytkownikami", p -> ApplicationContext.setMenuParams(UserMenuParams.values())),
    ISSUES_MENU(3, "Zarządzanie zagadnieniami", p -> ApplicationContext.setMenuParams(ConfigMenuParams.values())),
    CONNECTION_MENU(4, "Zarządzanie połączeniami", p -> ApplicationContext.setMenuParams(ConnectionMenuParams.values())),
    EXIT_MENU(5, "Wyjście z programu", p -> {
        System.exit(-1);
    });

    private int commandNumber;
    private String commandDescription;
    private CommandInterface commandInterface;
   // private CommandInterface commandInterface;

    MainMenuParams(int commandNumber, String commandDescription, CommandInterface commandInterface) {
        this.commandNumber = commandNumber;
        this.commandDescription = commandDescription;
        this.commandInterface = commandInterface;
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public String getCommandDescription() {
        return commandDescription;
    }

    @Override
    public CommandInterface getCommandInterface() {
        return commandInterface;
    }
}
