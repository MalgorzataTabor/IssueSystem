package issuesystem.client.command;

import issuesystem.client.config.ConnectionConfiguration;
import issuesystem.client.context.SessionContext;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class OpenConnectionCommand implements CommandInterface<String>{
    @Override
    public void execute(String onObject) {
        try {
            Socket channel = new Socket(ConnectionConfiguration.getAddress(), ConnectionConfiguration.getPort());

            ObjectOutputStream out = new ObjectOutputStream(channel.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(channel.getInputStream());

            SessionContext.setSocket(channel);
            SessionContext.setOut(out);
            SessionContext.setIn(in);
            SessionContext.setIsSessionOpen(true);
        } catch (IOException e) {
            e.printStackTrace();
            SessionContext.setIsSessionOpen(false);
        }

    }
}
