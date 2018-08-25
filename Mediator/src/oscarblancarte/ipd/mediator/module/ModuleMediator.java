package oscarblancarte.ipd.mediator.module;

import java.util.HashMap;
import java.util.Map;

public class ModuleMediator {

    private static ModuleMediator mediator;

    private static final Map<String, AbstractModule> modules = new HashMap<>();

    private ModuleMediator() {
    }

    public static synchronized ModuleMediator getInstance() {
        if (mediator == null) {
            mediator = new ModuleMediator();
        }
        return mediator;
    }

    public void registModule(AbstractModule module) {
        modules.put(module.getModulName(), module);
    }

    public Object mediate(ModuleMessage mediateEvent) {
        if (!modules.containsKey(mediateEvent.getTarget())) {
            throw new RuntimeException("The module '"
                    + mediateEvent.getTarget() + "' it's not registered");
        }
        System.out.println("Mediate source > '" + mediateEvent.getSource()
                + "', target > '" + mediateEvent.getTarget() 
                + "', messagetType > '"+mediateEvent.getMessageType()+"'");
        AbstractModule module = modules.get(mediateEvent.getTarget());
        return module.notifyMessage(mediateEvent);
    }
}
