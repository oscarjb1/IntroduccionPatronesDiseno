package oscarblancarte.ipd.command.impl;

import java.io.OutputStream;

public class NotFoundCommand extends BaseCommand {

    private static final String COMMAND_NAME = "NOT FOUND";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        write(out, "Commando no encontrado");
    }
}
