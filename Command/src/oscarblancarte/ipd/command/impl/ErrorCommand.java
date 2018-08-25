package oscarblancarte.ipd.command.impl;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

public class ErrorCommand extends BaseCommand {

    private static final String COMMAND_NAME = "ERROR";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        String message = "Invocation error";
        write(out, message);
    }

}