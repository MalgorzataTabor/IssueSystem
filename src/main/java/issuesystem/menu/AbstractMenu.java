package issuesystem.menu;


import issuesystem.menu.params.MenuParamInterface;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public abstract class AbstractMenu<T extends MenuParamInterface> {


    protected List<T> menuParams;

    public AbstractMenu(T[] mainMenuParams) { this.menuParams = Arrays.asList(mainMenuParams); }

    public void setMenuParams(T[] menuParams) {
        this.menuParams = Arrays.asList(menuParams);
    }

    public abstract void printMenu() throws IOException;


}
