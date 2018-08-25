package oscarblancarte.ipd.mediator.module.impl;

import oscarblancarte.ipd.mediator.module.*;

public class PurchaseModule extends AbstractModule {

    public static final String MODULE_NAME = "Chopping";
    public static final String OPERATION_PURCHASE_REQUEST = "PurchaseRequest";

    @Override
    public String getModulName() {
        return MODULE_NAME;
    }

    @Override
    public Object notifyMessage(ModuleMessage message) {
        switch (message.getMessageType()) {
            case OPERATION_PURCHASE_REQUEST:
                return purchaseRequest(message);
            default:
                throw new RuntimeException("Operation not supported '"
                        + message.getMessageType() + "'");
        }
    }

    private Void purchaseRequest(ModuleMessage message){
        return null;
    }
}
