package oscarblancarte.ipd.interprete.sql.nonterminal;

import oscarblancarte.ipd.interprete.sql.*;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class OrExpression implements StatementExpression{
    private StatementExpression leftStatement;
    private StatementExpression rightStatement;

    public OrExpression(StatementExpression leftStatement, 
            StatementExpression rightStatement) {
        this.leftStatement = leftStatement;
        this.rightStatement = rightStatement;
    }

    @Override
    public Object interpret(Context context)throws InterpreteException {
        Boolean leftReslt = (Boolean) leftStatement.interpret(context);
        Boolean rightReslt = (Boolean) rightStatement.interpret(context);
        return leftReslt || rightReslt;
    }

    @Override
    public String toString() {
        return "( "+leftStatement.toString()
                + " OR " + rightStatement.toString() + " )";
    }
}
