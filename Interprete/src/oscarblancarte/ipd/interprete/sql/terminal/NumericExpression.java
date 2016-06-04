package oscarblancarte.ipd.interprete.sql.terminal;

import oscarblancarte.ipd.interprete.sql.Context;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class NumericExpression extends LiteralExpression{
    
    private final Number number;
    
    public NumericExpression(Number num){
        super(null);
        this.number = num;
    }

    @Override
    public Object interpret(Context context) {
        return number;
    }

    @Override
    public String toString() {
        return number.toString();
    }
    
}
