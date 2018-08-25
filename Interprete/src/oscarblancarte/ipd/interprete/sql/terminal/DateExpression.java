package oscarblancarte.ipd.interprete.sql.terminal;

import java.text.SimpleDateFormat;
import oscarblancarte.ipd.interprete.sql.Context;
import oscarblancarte.ipd.interprete.sql.InterpreteException;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class DateExpression extends LiteralExpression {

    public DateExpression(String literal) {
        super(literal);
    }

    @Override
    public Object interpret(Context context) throws InterpreteException {
        try {
            SimpleDateFormat dateFormat = context.getDateFormat();
            return dateFormat.parse(literal);
        } catch (Exception e) {
            throw new InterpreteException("Invalid date format '"+literal+"'");
        }
    }

    @Override
    public String toString() {
        return "'"+literal+"'";
    }
}
