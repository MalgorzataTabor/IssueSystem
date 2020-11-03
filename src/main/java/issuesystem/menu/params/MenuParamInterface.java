package issuesystem.menu.params;


import issuesystem.client.command.CommandInterface;

public interface MenuParamInterface {

    int getCommandNumber();

    String getCommandDescription();

    CommandInterface getCommandInterface();

}
