package oscarblancarte.ipd.decorator.impl.decorators;

import oscarblancarte.ipd.decorator.impl.message.IMessage;

/**
 *
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class SOAPEnvelopMessage extends MessageDecorator {

    public SOAPEnvelopMessage(IMessage message) {
        super(message);
    }

    @Override
    public IMessage processMessage() {
        message.processMessage();
        message =  envelopMessage();
        return message;
    }

    private IMessage envelopMessage() {
        String soap = "<soapenv:Envelope xmlns:soapenv="
                + "\n\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "\nxmlns:ser=\"http://service.dishweb.cl.com/\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + message.getContent()
                + "\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";
        message.setContent(soap);
        return message;
    }

}