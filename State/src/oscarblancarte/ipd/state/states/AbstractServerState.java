package oscarblancarte.ipd.state.states;

import oscarblancarte.ipd.state.Server;

public abstract class AbstractServerState {

    public AbstractServerState() {
    }

    public abstract void handleMessage(
            Server server, String message);

}
