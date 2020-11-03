package issuesystem.client.command;

import issuesystem.client.context.SessionContext;
import issuesystem.dto.DataTransferObject;

import java.io.IOException;

public class DeleteUserById implements CommandInterface<Integer>{
    @Override
    public void execute(Integer onObject) {
        DataTransferObject<Integer> dto =
        new DataTransferObject<>(DataTransferObject.DELU, onObject);

        try {
            SessionContext.getOut().writeObject(dto);
            SessionContext.getOut().flush();

            DataTransferObject<Integer> response =
                    (DataTransferObject<Integer>) SessionContext.getIn().readObject();
            System.out.println("Answer from the server: " + response.getObject());
            if(response.getObject()<0){
                System.out.println("User could not be removed");
            }else{

                System.out.println("User has been deleted");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
