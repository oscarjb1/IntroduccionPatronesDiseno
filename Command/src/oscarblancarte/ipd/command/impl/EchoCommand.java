package oscarblancarte.ipd.command.impl;

import java.io.OutputStream;
import java.util.Arrays;

public class EchoCommand extends BaseCommand {

    public static final String COMMAN_NAME = "echo";

    @Override
    public void execute(String[] args, OutputStream out) {
        String message = getCommandName() + " " + Arrays.toString(args);
        write(out, message);
    }

    @Override
    public String getCommandName() {
        return COMMAN_NAME;
    }
}