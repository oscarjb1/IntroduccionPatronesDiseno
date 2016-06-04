package oscarblancarte.ipd.interprete.sql.nonterminal;

import oscarblancarte.ipd.interprete.sql.*;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class WhereExpression implements AbstractSQLExpression {

    private StatementExpression statement;

    public WhereExpression(StatementExpression statement) {
        this.statement = statement;
    }

    @Override
    public Void interpret(Context context) throws InterpreteException {
        context.createRowIterator();
        while (context.nextRow()) {
            if (statement == null) {
                context.addCurrentRowToResults();
            } else {
                Boolean result = (Boolean) statement.interpret(context);
                if (result) {
                    context.addCurrentRowToResults();
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if (statement != null) {
            return "\nWHERE " + statement.toString();
        } else {
            return "";
        }
    }
}
