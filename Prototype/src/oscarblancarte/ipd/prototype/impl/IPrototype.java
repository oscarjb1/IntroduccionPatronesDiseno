package oscarblancarte.ipd.prototype.impl;
/**
 * @author oscar javier blancarte iturralde
 * @see http://www.oscarblancarteblog.com
 */
public interface IPrototype<T extends IPrototype> extends Cloneable{
    public T clone();
    public T deepClone();
}