package oscarblancarte.ipd.interprete.sql.nonterminal;

import oscarblancarte.ipd.interprete.sql.*;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public interface StatementExpression extends AbstractSQLExpression {

    @Override
    public Object interpret(Context context)throws InterpreteException;
}