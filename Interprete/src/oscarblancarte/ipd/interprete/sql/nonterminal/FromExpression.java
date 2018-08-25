package oscarblancarte.ipd.interprete.sql.nonterminal;

import oscarblancarte.ipd.interprete.sql.*;;
import oscarblancarte.ipd.interprete.sql.terminal.*;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class FromExpression implements AbstractSQLExpression {
    
    private LiteralExpression table;
    
    public FromExpression(LiteralExpression from){
        this.table = from;
    }

    @Override
    public Object interpret(Context context) 
            throws InterpreteException{
        String tableName = 
                table.interpret(context).toString();
        if(!context.tableExist(tableName)){
            throw new InterpreteException(
                    "The table '"+tableName+"' not exist");
        }
        return null;
    }

    @Override
    public String toString() {
        return "FROM " + table.toString();
    }
}
