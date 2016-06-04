package oscarblancarte.ipd.decorator.impl.message;

/**
 *
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public interface IMessage {
    
    public IMessage processMessage();
    public String getContent();
    public void setContent(String content);
}