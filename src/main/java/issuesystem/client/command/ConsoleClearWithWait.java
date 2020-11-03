package issuesystem.client.command;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleClearWithWait implements CommandInterface<Void>{

    public ConsoleClearWithWait() {
    }
    private static class Singleton {
        private static final ConsoleClearWithWait INSTANCE= new ConsoleClearWithWait();
    }

    public static ConsoleClearWithWait getInstance(){return Singleton.INSTANCE;}


    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(Void onObject) {
        System.out.println("Press enter to continue ...");

        scanner.nextLine();
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("fail");
        }
    }
}
