package issuesystem.client.context;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SessionContext {
    private static Socket socket;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;

    private static boolean isSessionOpen;

    public static Socket getSocket() {
        return socket;
    }

    public static ObjectOutputStream getOut() {
        return out;
    }

    public static ObjectInputStream getIn() {
        return in;
    }

    public static boolean isIsSessionOpen() {
        return isSessionOpen;
    }

    public static void setSocket(Socket socket) {
        SessionContext.socket = socket;
    }

    public static void setOut(ObjectOutputStream out) {
        SessionContext.out = out;
    }

    public static void setIn(ObjectInputStream in) {
        SessionContext.in = in;
    }

    public static void setIsSessionOpen(boolean isSessionOpen) {
        SessionContext.isSessionOpen = isSessionOpen;
    }
}
