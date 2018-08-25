package oscarblancarte.ipd.mediator.module.impl;

import oscarblancarte.ipd.mediator.module.*;
import oscarblancarte.ipd.mediator.module.impl.dto.*;

public class ECommerceModule extends AbstractModule {

    public static final String MODULE_NAME = "ECommerce";

    public static final String OPERATION_COMPLETE_ORDER = "CompleteOrder";

    @Override
    public String getModulName() {
        return MODULE_NAME;
    }

    @Override
    public Object notifyMessage(ModuleMessage message) {
        switch (message.getMessageType()) {
            case OPERATION_COMPLETE_ORDER:
                return compleOrder(message);
            default:
                throw new RuntimeException("Operation not supported '" + 
                        message.getMessageType() + "'");
        }
    }
    
    private String compleOrder(ModuleMessage message){
        SaleOrder saleOrder = (SaleOrder)message.getPayload();
        System.out.println("Order completed successfully > " );
        
        ModuleMessage crmMessage = new ModuleMessage(MODULE_NAME, 
                NotifyModule.MODULE_NAME, NotifyModule.OPERATION_NOTIFY, 
                saleOrder);
        mediator.mediate(crmMessage);
        return saleOrder.getId();
    }
    
    public String createSale(Sale sale){
        ModuleMessage crmMessage = new ModuleMessage(MODULE_NAME, 
                CRMModule.MODULE_NAME, CRMModule.OPERATION_CREATE_ORDER, sale);
        return mediator.mediate(crmMessage).toString();
    }

}
