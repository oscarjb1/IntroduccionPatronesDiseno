package oscarblancarte.ipd.command.impl;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeCommand extends BaseCommand {

    public static final String COMMAND_NAME = "date";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {

        SimpleDateFormat dateFormater = null;
        if (args == null) {
            dateFormater = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        } else {
            try {
                dateFormater = new SimpleDateFormat(args[0]);
            } catch (Exception e) {
                write(out, "invalid format");
                return;
            }

        }
        String date = dateFormater.format(new Date());
        write(out, date);
    }
}