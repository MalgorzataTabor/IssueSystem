package issuesystem.menu;

import issuesystem.client.command.ConsoleJustClear;

import issuesystem.client.context.ApplicationContext;

import java.io.IOException;

public class ClientMain {
    public static void main(String[] args) throws IOException {

        ConsoleJustClear.getInstance().execute(null);
        ApplicationContext.setMenu(DefaultMenu.getInstance());
        while (true) {
            ApplicationContext.getMenu().printMenu();
        }

       /* Scanner scanner = new Scanner(System.in);

        while(true){

            MainMenuParams[] menuParams = MainMenuParams.values();

            for (int i = 0; i <menuParams.length ; i++) {
                System.out.println(menuParams[i].getCommandNumber() + " " +menuParams[i].getCommandDescription());

            }

            int i = scanner.nextInt();


            MainMenuParams mainMenuParams = Arrays.asList(menuParams).stream()
                    .filter(p->p.getCommandNumber() == i)
                    .findFirst()
                    .get();

            System.out.println("");
            System.out.println(mainMenuParams.getCommandNumber() + " " + mainMenuParams.getCommandDescription());
            System.out.println("");
        }*/

    }
}
