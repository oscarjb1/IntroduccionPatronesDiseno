package oscarblancarte.ipd.decorator.impl.message;

/**
 *
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class TextMessage implements IMessage {

    private String content;

    public TextMessage() {
    }

    public TextMessage(String message) {
        this.content = message;
    }

    public String getMessage() {
        return content;
    }

    public void setMessage(String message) {
        this.content = message;
    }

    @Override
    public IMessage processMessage() {
        return this;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }
}