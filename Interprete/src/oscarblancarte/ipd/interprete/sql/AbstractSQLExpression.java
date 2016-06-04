package oscarblancarte.ipd.interprete.sql;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public interface AbstractSQLExpression {
    public Object interpret(Context context) throws InterpreteException;
}
