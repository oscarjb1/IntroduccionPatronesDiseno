package oscarblancarte.ipd.mediator.module.impl;

import oscarblancarte.ipd.mediator.module.*;

public class NotifyModule extends AbstractModule {

    public static final String MODULE_NAME = "Notification";
    public static final String OPERATION_NOTIFY = "Notify";

    @Override
    public String getModulName() {
        return MODULE_NAME;
    }

    @Override
    public Void notifyMessage(ModuleMessage message) {
        switch (message.getMessageType()) {
            case OPERATION_NOTIFY:
                return notify(message);
            default:
                throw new RuntimeException("Operation not supported '"
                        + message.getMessageType() + "'");
        }
    }

    private Void notify(ModuleMessage message) {
        System.out.println("Notification sent");
        return null;
    }

}
