package issuesystem.menu.params;

import issuesystem.client.command.CommandInterface;
import issuesystem.client.command.ConsoleClearWithWait;
import issuesystem.client.command.OpenConnectionCommand;
import issuesystem.client.context.ApplicationContext;
import issuesystem.client.context.SessionContext;

public enum ConnectionMenuParams implements MenuParamInterface {

    OPEN_CONNECTION(1, "Open connection", p -> {

        OpenConnectionCommand openConnectionCommand = new OpenConnectionCommand();
        openConnectionCommand.execute(null);
        if (SessionContext.isIsSessionOpen()) {
            System.out.println("Session is OPEN ");
        } else {
            System.out.println("Can't open session");
        }
        ConsoleClearWithWait.getInstance().execute(null);
    }),

    EXIT_TO_MAIN_MENU(0, "Exit to main manu ", p -> {

        ApplicationContext.setMenuParams(MainMenuParams.values());
    });

    private int commandNumber;
    private String commandDescription;
    private CommandInterface commandInterface;

    ConnectionMenuParams(int commandNumber, String commandDescription, CommandInterface commandInterface) {
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
