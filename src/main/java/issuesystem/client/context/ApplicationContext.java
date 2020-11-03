package issuesystem.client.context;

import issuesystem.menu.AbstractMenu;
import issuesystem.menu.params.MenuParamInterface;

public class ApplicationContext{

    private static AbstractMenu menu;

    public static AbstractMenu getMenu() {
        return menu;
    }

    public static void setMenu(AbstractMenu menu) {
        ApplicationContext.menu = menu;
    }

    public static <T extends MenuParamInterface> void setMenuParams(T[] params) {
        menu.setMenuParams(params);
    }


}
