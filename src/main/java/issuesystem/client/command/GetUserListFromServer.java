package issuesystem.client.command;

import issuesystem.client.context.SessionContext;
import issuesystem.dto.DataTransferObject;
import issuesystem.dto.User;

import java.io.IOException;
import java.util.List;

public class GetUserListFromServer implements CommandInterface<Void>{
    @Override
    public void execute(Void onObject) {
        DataTransferObject<List<User>> dto = new DataTransferObject<>(DataTransferObject.GETUL, null);

        try {
            SessionContext.getOut().writeObject(dto);
            SessionContext.getOut().flush();
            DataTransferObject<List<User>> response = (DataTransferObject<List<User>>) SessionContext.getIn().readObject();
            System.out.println(response.getObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
