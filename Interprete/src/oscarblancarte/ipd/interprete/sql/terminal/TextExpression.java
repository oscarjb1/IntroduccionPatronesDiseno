package oscarblancarte.ipd.interprete.sql.terminal;

import oscarblancarte.ipd.interprete.sql.Context;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class TextExpression extends LiteralExpression {

    public TextExpression(String literal) {
        super(literal);
    }
    
    @Override
    public String interpret(Context context) {
        return literal;
    }

    @Override
    public String toString() {
        return "'"+literal+"'";
    }
}
