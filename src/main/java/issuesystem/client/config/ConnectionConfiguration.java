package issuesystem.client.config;

public class ConnectionConfiguration {
    private static String address = "localhost";
    private static int port = 1234;


    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        ConnectionConfiguration.address = address;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        ConnectionConfiguration.port = port;
    }
}
