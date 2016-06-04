package oscarblancarte.ipd.chainofresponsability.validator;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class ValidationException extends Exception {

    public ValidationException(String message) throws ValidationException {
        super(message);
    }
}