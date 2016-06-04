package oscarblancarte.ipd.interprete.sql.nonterminal;

import oscarblancarte.ipd.interprete.sql.AbstractSQLExpression;
import java.util.List;
import oscarblancarte.ipd.interprete.sql.Context;
import oscarblancarte.ipd.interprete.sql.InterpreteException;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class SelectExpression implements AbstractSQLExpression{

    private final TargetExpression target;
    private final FromExpression from;
    private final WhereExpression where;
    
    public SelectExpression(TargetExpression columns,
            FromExpression table,WhereExpression where){
        this.target = columns;
        this.from = table;
        this.where = where;
    }
    
    public SelectExpression(TargetExpression columns,
            FromExpression table){
        this.target = columns;
        this.from = table;
        this.where = new WhereExpression(null);
    }
    
    @Override
    public List<Object[]> interpret(Context context) 
            throws InterpreteException{
        from.interpret(context);
        where.interpret(context);
        target.interpret(context);
        return context.getResultArray();
    }

    @Override
    public String toString() {
        return "SELECT " + target.toString() + " " + 
                from.toString() + " " +  where.toString();
    }
}
