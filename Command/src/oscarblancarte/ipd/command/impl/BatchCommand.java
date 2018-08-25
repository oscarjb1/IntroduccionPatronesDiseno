package oscarblancarte.ipd.command.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Arrays;
import oscarblancarte.ipd.command.CommandManager;
import oscarblancarte.ipd.command.CommandUtil;
import oscarblancarte.ipd.command.ICommand;

public class BatchCommand extends BaseCommand {

    public static final String COMMAND_NAME = "batch";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {

        if (args == null || args.length < 1) {
            write(out, "Insufficient arguments");
            return;
        }

        CommandManager manager = CommandManager.getIntance();
        String[] lines = readLinesFromFile(args[0]);
        for (String line : lines) {
            String[] argsCommand = CommandUtil.tokenizerArgs(line);
            ICommand command = manager.getCommand(argsCommand[0]);
            String[] reduce = Arrays.copyOfRange(argsCommand, 1, argsCommand.length);
            command.execute(reduce, out);
            write(out, "\n");
        }
        write(out, "Batch executed");
    }

    private String[] readLinesFromFile(String filePath) throws RuntimeException {
        File file = new File(filePath);
        FileInputStream stream = null;
        try {
            if (!file.exists()) {
                throw new RuntimeException("File not Found");
            }

            stream = new FileInputStream(file);
            byte[] byteArray = new byte[stream.available()];
            stream.read(byteArray);

            String commands = new String(byteArray);
            String[] lines = commands.split("\n");
            return lines;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                stream.close();
            } catch (Exception e2) {
            }
        }
    }

}
