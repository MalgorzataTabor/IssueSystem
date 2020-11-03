package issuesystem.client.command;

import java.io.IOException;

public class ConsoleJustClear implements CommandInterface<Void>{
    public ConsoleJustClear() {
    }
    private static class Singleton{
        private static final ConsoleJustClear INSTANCE = new ConsoleJustClear();
    }

    public static ConsoleJustClear getInstance(){return Singleton.INSTANCE;}

    @Override
    public void execute(Void onObject) {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        } catch (Exception e) {

        }
    }
}
