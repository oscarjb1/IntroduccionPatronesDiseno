package oscarblancarte.ipd.state.states;

import oscarblancarte.ipd.state.Server;

public class StartServerState extends AbstractServerState {
    
    public StartServerState(Server server){
        server.getMessageProcess().start();
    }
    
    @Override
    public void handleMessage(Server server, String message) {
        boolean isSaturated = 
                server.getMessageProcess().queueMessage(message);
        if(!isSaturated){
            server.setState(new SaturatedServerState(server));
        }
    }
}
