package issuesystem.client.command;

import issuesystem.client.context.SessionContext;
import issuesystem.dto.DataTransferObject;
import issuesystem.dto.User;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FindUserCommand implements CommandInterface<Void>{

    private static FindUserCommand INSTANCE = new FindUserCommand();

    public static FindUserCommand getInstance(){
        return INSTANCE;
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Void onObject) {
        String input = scanner.nextLine();
        DataTransferObject<String> dto = new DataTransferObject<>(DataTransferObject.FUBL, input);

        try {
            SessionContext.getOut().writeObject(dto);
            SessionContext.getOut().flush();
            DataTransferObject<User> response = (DataTransferObject<User>)SessionContext.getIn().readObject();
            System.out.println("The User you were looking for is: " +response.getObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
