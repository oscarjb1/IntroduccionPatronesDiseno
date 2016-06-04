package oscarblancarte.ipd.mediator.module;

public abstract class AbstractModule {

    protected ModuleMediator mediator;

    public abstract String getModulName();

    public void activate() {
        mediator = ModuleMediator.getInstance();
        mediator.registModule(this);
    }

    public abstract Object notifyMessage(ModuleMessage message);
}