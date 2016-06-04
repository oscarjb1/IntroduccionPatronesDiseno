package oscarblancarte.ipd.command.impl;

import java.io.OutputStream;

public abstract class AsyncCommand extends BaseCommand {

    public void execute(final String[] args, final OutputStream out) {
        new Thread(new Runnable() {
            public void run() {
                executeOnBackground(args, out);
            }
        }).start();
    }

    public abstract void executeOnBackground(String[] args, OutputStream out);
}
