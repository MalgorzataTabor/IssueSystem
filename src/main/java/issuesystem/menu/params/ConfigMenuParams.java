package issuesystem.menu.params;

import issuesystem.client.command.CommandInterface;
import issuesystem.client.command.ConsoleClearWithWait;
import issuesystem.client.command.ConsoleJustClear;
import issuesystem.client.config.ConnectionConfiguration;
import issuesystem.client.context.ApplicationContext;


import java.util.Scanner;

public enum ConfigMenuParams implements MenuParamInterface {


    SET_ADDRESS(1, "Ustaw adres", p -> {
        System.out.println("Podaj adres serwera");
        Scanner scan = new Scanner(System.in);
        String serverAddress = scan.nextLine();
        ConnectionConfiguration.setAddress(serverAddress);
        ConsoleJustClear.getInstance().execute(null);
    }),
    SET_PORT(2, "Konfiguruj port", p -> {
        System.out.println("Podaj port serwera");
        Scanner scan = new Scanner(System.in);
        int serverPort = scan.nextInt();
        ConnectionConfiguration.setPort(serverPort);
        ConsoleJustClear.getInstance().execute(null);
    }),
    SHOW_CONFIGURATION(3, "Pokarz nową konfigurację", p -> {
        System.out.println("twoja konfiguracja serwera to");
        System.out.println("Address: " + ConnectionConfiguration.getAddress());
        System.out.println("Port: " + ConnectionConfiguration.getPort());
        ConsoleClearWithWait.getInstance().execute(null);


    }),
    EXIT(4, "Wyjdź do menu głównego", p -> {
        System.out.println("To jet komenda wyjścia z menu głównego");

        ApplicationContext.setMenuParams(MainMenuParams.values());
    });

    private int commandNumber;
    private String commandDescription;
    private CommandInterface commandInterface;

    ConfigMenuParams(int commandNumber, String commandDescription, CommandInterface commandInterface) {
        this.commandNumber = commandNumber;
        this.commandDescription = commandDescription;
        this.commandInterface = commandInterface;
    }

    @Override
    public int getCommandNumber() {
        return commandNumber;
    }

    @Override
    public String getCommandDescription() {
        return commandDescription;
    }

    @Override
    public CommandInterface getCommandInterface() {
        return commandInterface;
    }
}
