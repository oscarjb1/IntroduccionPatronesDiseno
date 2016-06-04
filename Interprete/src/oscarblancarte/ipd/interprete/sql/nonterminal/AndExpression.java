package oscarblancarte.ipd.interprete.sql.nonterminal;

import oscarblancarte.ipd.interprete.sql.*;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class AndExpression implements StatementExpression {

    private final StatementExpression leftStatement;
    private final StatementExpression rightStatement;

    public AndExpression(StatementExpression leftStatement,
            StatementExpression rightStatement) {
        this.leftStatement = leftStatement;
        this.rightStatement = rightStatement;
    }

    @Override
    public Object interpret(Context context)throws InterpreteException {
        Boolean leftReslt = (Boolean) leftStatement.interpret(context);
        Boolean rightReslt = (Boolean) rightStatement.interpret(context);
        return leftReslt && rightReslt;
    }

    @Override
    public String toString() {
        return "( " + leftStatement.toString()
                + " AND " + rightStatement.toString() + " )";
    }
}
