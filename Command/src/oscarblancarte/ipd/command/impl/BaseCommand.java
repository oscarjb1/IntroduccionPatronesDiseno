package oscarblancarte.ipd.command.impl;

import java.io.OutputStream;
import oscarblancarte.ipd.command.ICommand;

public abstract class BaseCommand implements ICommand {

    @Override
    public abstract String getCommandName();

    @Override
    public abstract void execute(String[] args, OutputStream out);

    public void write(OutputStream out, String message) {
        try {
            out.write(message.getBytes());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}