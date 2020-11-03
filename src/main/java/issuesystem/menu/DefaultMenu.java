package issuesystem.menu;

import issuesystem.client.command.ConsoleJustClear;
import issuesystem.menu.params.MainMenuParams;
import issuesystem.menu.params.MenuParamInterface;

import java.util.Scanner;

public class DefaultMenu extends AbstractMenu<MenuParamInterface> {


    public DefaultMenu(MenuParamInterface[] mainMenuParams) {
        super(mainMenuParams);
    }

    private static class Singleton {
        private static final DefaultMenu INSTANCE = new DefaultMenu(MainMenuParams.values());
    }

    public static DefaultMenu getInstance() {
        return Singleton.INSTANCE;
    }


    @Override
    public void printMenu()  {
        for (MenuParamInterface menuParam : this.menuParams) {
            System.out.println(menuParam.getCommandNumber() + " . " + menuParam.getCommandDescription());

        }
        System.out.println("Give the command number: ");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        MenuParamInterface foundMenuParam = this.menuParams.stream()
                .filter(p-> p.getCommandNumber() == i)
                .findFirst()
                .get();
        ConsoleJustClear.getInstance().execute(null);
        foundMenuParam.getCommandInterface().execute(null);
    }
}
