package issuesystem.menu.params;

import issuesystem.client.command.*;
import issuesystem.client.context.ApplicationContext;
import issuesystem.client.context.SessionContext;
import issuesystem.dto.DataTransferObject;

import java.io.IOException;
import java.util.Scanner;


public enum UserMenuParams implements MenuParamInterface {


    ADD_USER(1, "Add user", p -> {
        CreateUserCommand createUserCommand = new CreateUserCommand();
        createUserCommand.execute(null);
        ConsoleClearWithWait.getInstance().execute(null);
    }),

    SHOW_USERS(2, "Show all users", p -> {
        GetUserListFromServer getUserListFromServer = new GetUserListFromServer();
        getUserListFromServer.execute(null);
        ConsoleClearWithWait.getInstance().execute(null);

    }),

    FIND_USER(3, "Find User ", p -> {
        ConsoleJustClear.getInstance().execute(null);
        System.out.println("Enter searched user login: ");
        FindUserCommand.getInstance().execute(null);
        DataTransferObject dto = null;

        try {
            dto = (DataTransferObject) SessionContext.getIn().readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(dto.getObject());
        ConsoleClearWithWait.getInstance().execute(null);
    }),

    DEL_USER(4, "Delete user by id", p -> {
        DeleteUserById getUserListFromServer = new DeleteUserById();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the user id to delete:");
        Integer id = scanner.nextInt();
        getUserListFromServer.execute(id);
        ConsoleClearWithWait.getInstance().execute(null);

    }),

    EXIT_TO_MAIN_MENU(0, "Exit to main menu", p -> {
        ApplicationContext.setMenuParams(MainMenuParams.values());
    });


    private int commandNumber;
    private String commandDescription;
    private CommandInterface commandInterface;


    UserMenuParams(int commandNumber, String commandDescription, CommandInterface commandInterface) {
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
