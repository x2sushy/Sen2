package game.command;

public class ExitCommand implements Command{
    /**
     * Executes the exit command, terminating the game.
     * @return empty string
     */
    @Override
    public String execute() {
        System.exit(0);
        return "";
    }
}
