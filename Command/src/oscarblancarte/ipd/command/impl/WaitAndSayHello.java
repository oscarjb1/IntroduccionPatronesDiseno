package oscarblancarte.ipd.command.impl;

import java.io.OutputStream;

public class WaitAndSayHello extends AsyncCommand {

    public static final String COMMAND_NAME = "waithello";

    @Override
    public void executeOnBackground(String[] args, OutputStream out) {
        if (args == null || args.length < 1) {
            write(out, "Insufficient parameters");
            return;
        }

        Long time = null;
        try {
            time = Long.parseLong(args[0]);
        } catch (Exception e) {
            write(out, "Invalid time");
            return;
        }

        try {
            Thread.sleep(time.longValue());
            write(out, "Hello!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

}
