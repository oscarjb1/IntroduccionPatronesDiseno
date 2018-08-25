package oscarblancarte.ipd.command.impl;

import java.io.File;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

public class DirCommand extends BaseCommand {

    public static final String COMMAND_NAME = "dir";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        if (args == null || args.length < 2) {
            write(out, COMMAND_NAME + " insufficient arguments");
        }

        String operation = args[0];
        if ("-D".equals(operation.toUpperCase())) {
            write(out, deleteDir(args[1]));
        } else if ("-N".equals(operation.toUpperCase())) {
            write(out, newDir(args[1]));
        } else {
            write(out, "Invalid argument {-d | -n}");
        }
    }

    private String deleteDir(String url) {

        try {
            File file = new File(url);
            if (!file.exists()) {
                return "File not found";
            }

            if (!file.canWrite()) {
                return "Insufficient privileges";
            }

            file.delete();
            return "";
        } catch (Exception e) {
            return "ERROR: " + e.getMessage();
        }

    }

    private String newDir(String url) {
        try {
            File file = new File(url);
            if (file.exists()) {
                return "File not found";
            }

            file.mkdirs();
            return "";
        } catch (Exception e) {
            return "ERROR: " + e.getMessage();
        }
    }

}