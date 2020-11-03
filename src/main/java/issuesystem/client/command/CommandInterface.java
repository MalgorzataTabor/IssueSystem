package issuesystem.client.command;

public interface CommandInterface <T> {
    void execute(T onObject);
}
