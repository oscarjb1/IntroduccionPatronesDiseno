package oscarblancarte.ipd.command.impl;

import java.io.OutputStream;
import oscarblancarte.ipd.command.ICommand;

public class ExitCommand implements ICommand {

    public static final String COMMAND_NAME = "exit";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        System.exit(0);
    }

}