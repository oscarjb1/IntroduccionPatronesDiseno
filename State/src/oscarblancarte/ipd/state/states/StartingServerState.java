package oscarblancarte.ipd.state.states;

import oscarblancarte.ipd.state.Server;

public class StartingServerState extends AbstractServerState {

    public StartingServerState(final Server server) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("Server Starting");
                    Thread.sleep(1000 * 10);
                    if (server.getMessageProcess().countMessage() 
                            >= server.getMaxRequest()) {
                        server.setState(
                                new SaturatedServerState(server));
                    } else {
                        server.setState(
                                new StartServerState(server));
                    }
                    System.out.println("Server Start");
                } catch (Exception e) {
                }
            }
        }
        ).start();
    }

    @Override
    public void handleMessage(Server server, String message) {
        server.getMessageProcess().queueMessage(message);
    }

}
