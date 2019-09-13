package command;

import java.util.ArrayList;

/**
 * @author yejh
 * @create 2019-07_28 23:19
 */
public class MacroCommand implements Command {
    private ArrayList<Command> commands = new ArrayList<>();

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public void removeCommand(Command command) {
        this.commands.remove(command);
    }
}
