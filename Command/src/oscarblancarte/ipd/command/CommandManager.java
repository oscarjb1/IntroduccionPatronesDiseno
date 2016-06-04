package oscarblancarte.ipd.command;

import java.util.HashMap;
import oscarblancarte.ipd.command.impl.BatchCommand;
import oscarblancarte.ipd.command.impl.DateTimeCommand;
import oscarblancarte.ipd.command.impl.DirCommand;
import oscarblancarte.ipd.command.impl.EchoCommand;
import oscarblancarte.ipd.command.impl.ErrorCommand;
import oscarblancarte.ipd.command.impl.ExitCommand;
import oscarblancarte.ipd.command.impl.FileCommand;
import oscarblancarte.ipd.command.impl.MemoryCommand;
import oscarblancarte.ipd.command.impl.NotFoundCommand;
import oscarblancarte.ipd.command.impl.WaitAndSayHello;

public class CommandManager {

    private static CommandManager commandManager;

    private static final HashMap<String, Class<? extends ICommand>> COMMANDS = new HashMap<String, Class<? extends ICommand>>();

    private CommandManager() {
        registCommand(EchoCommand.COMMAN_NAME, EchoCommand.class);
        registCommand(DirCommand.COMMAND_NAME, DirCommand.class);
        registCommand(DateTimeCommand.COMMAND_NAME, DateTimeCommand.class);
        registCommand(MemoryCommand.COMMAN_NAME, MemoryCommand.class);
        registCommand(FileCommand.COMMAND_NAME, FileCommand.class);
        registCommand(ExitCommand.COMMAND_NAME, ExitCommand.class);
        registCommand(BatchCommand.COMMAND_NAME, BatchCommand.class);
        registCommand(WaitAndSayHello.COMMAND_NAME, WaitAndSayHello.class);
    }

    public static synchronized CommandManager getIntance() {
        if (commandManager == null) {
            commandManager = new CommandManager();
        }

        return commandManager;
    }

    public ICommand getCommand(String commandName) {

        if (COMMANDS.containsKey(commandName.toUpperCase())) {
            try {
                return COMMANDS.get(commandName.toUpperCase()).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                return new ErrorCommand();
            }
        } else {
            return new NotFoundCommand();
        }
    }

    public void registCommand(String commandName, Class<? extends ICommand> command) {
        COMMANDS.put(commandName.toUpperCase(), command);
    }
}