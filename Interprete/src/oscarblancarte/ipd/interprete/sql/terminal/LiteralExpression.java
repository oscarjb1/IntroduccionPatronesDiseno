package oscarblancarte.ipd.interprete.sql.terminal;

import oscarblancarte.ipd.interprete.sql.Context;
import oscarblancarte.ipd.interprete.sql.InterpreteException;
import oscarblancarte.ipd.interprete.sql.AbstractSQLExpression;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class LiteralExpression implements AbstractSQLExpression {

    protected String literal;

    public LiteralExpression(String literal) {
        this.literal = literal;
    }

    @Override
    public Object interpret(Context context) throws InterpreteException {
        return literal;
    }

    @Override
    public String toString() {
        return literal;
    }
}
