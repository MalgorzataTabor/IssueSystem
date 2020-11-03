package issuesystem.client.command;

import issuesystem.client.context.SessionContext;
import issuesystem.dto.DataTransferObject;
import issuesystem.dto.User;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CreateUserCommand implements CommandInterface<User> {


    @Override
    public void execute(User onObject) {
        try {
        User builder = getUser();
        DataTransferObject<User> dto = new DataTransferObject<>(DataTransferObject.ADU, builder);

            SessionContext.getOut().writeObject(dto);
            SessionContext.getOut().flush();
            Object o = SessionContext.getIn().readObject();
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private User getUser() {
        User.UserBuilder builder = User.builder();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Add new User: \n");
        System.out.print("name: ");
        builder.name(scanner.nextLine());


        System.out.print("surname: ");
        builder.surname(scanner.nextLine());

        System.out.print("login: ");
        builder.login(scanner.nextLine());

        System.out.print("miasto: ");
        builder.city(scanner.nextLine());

        System.out.print("address: ");
        builder.address(scanner.nextLine());

        System.out.print("password: ");
        builder.password(scanner.nextLine());

        System.out.print("age: ");
        builder.age(scanner.nextInt());

        return builder.insertDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now())
                .passwordExpireDate(LocalDateTime.now().plusDays(30))
                .build();
    }

}
