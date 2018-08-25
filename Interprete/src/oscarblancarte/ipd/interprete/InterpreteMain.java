package oscarblancarte.ipd.interprete;

import java.text.SimpleDateFormat;
import java.util.*;
import oscarblancarte.ipd.interprete.sql.*;
import oscarblancarte.ipd.interprete.sql.nonterminal.*;
import oscarblancarte.ipd.interprete.sql.terminal.*;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class InterpreteMain {

    public static void main(String[] args) {
        //Abstract Syntactic Tree
        SelectExpression select = getById();
        System.out.println(select.toString());
        Context context = new Context("META-INF/Employee.xls");
        context.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
        try {
            List<Object[]> output = select.interpret(context);
            for (Object[] object : output) {
                System.out.println(Arrays.toString(object));
            }
        } catch (InterpreteException e) {
            e.printStackTrace();
        } finally {
            context.destroy();
        }
    }

    public static SelectExpression getById() {
        SelectExpression select = new SelectExpression(
                new TargetExpression(
                        new LiteralExpression("FIRST_NAME"),
                        new LiteralExpression("LAST_NAME")
                ),
                new FromExpression(
                        new LiteralExpression("EMPLOYEES")),
                new WhereExpression(
                        new BooleanExpression(
                                new LiteralExpression("ID"),
                                new LiteralExpression("="),
                                new NumericExpression(10)
                        )
                )
        );
        return select;
    }

    public static SelectExpression findByDate() {
        SelectExpression select = new SelectExpression(
                new TargetExpression(
                        new LiteralExpression("ID"),
                        new LiteralExpression("BORN_DATE"),
                        new LiteralExpression("DEPARTMENT"),
                        new LiteralExpression("FIRST_NAME"),
                        new LiteralExpression("LAST_NAME")
                ),
                new FromExpression(
                        new LiteralExpression("EMPLOYEES")),
                new WhereExpression(
                        new BooleanExpression(
                                new LiteralExpression("BORN_DATE"),
                                new LiteralExpression(">"),
                                new DateExpression("01/01/1990")
                        )
                )
        );
        return select;
    }

    public static SelectExpression findByTwoID() {
        SelectExpression select = new SelectExpression(
                new TargetExpression(
                        
                        new LiteralExpression("FIRST_NAME"),
                        new LiteralExpression("DEPARTMENT"),
                        new LiteralExpression("ID")
                ),
                new FromExpression(
                        new LiteralExpression("EMPLOYEES")),
                new WhereExpression(
                        new OrExpression(
                                new BooleanExpression(
                                        new LiteralExpression("ID"),
                                        new LiteralExpression("="),
                                        new NumericExpression(5)
                                ),
                                new BooleanExpression(
                                        new LiteralExpression("ID"),
                                        new LiteralExpression("="),
                                        new NumericExpression(14)
                                )
                        )
                )
        );
        return select;
    }

    public static SelectExpression complexQuery() {
        SelectExpression select = new SelectExpression(
        new TargetExpression(
            new LiteralExpression("FIRST_NAME"),
            new LiteralExpression("LAST_NAME")
        ),
        new FromExpression(
            new LiteralExpression("EMPLOYEES")),
        new WhereExpression(
            new AndExpression(
                new BooleanExpression(
                    new LiteralExpression("STATUS"),
                    new LiteralExpression("="),
                    new TextExpression("Active")
                ),
                new AndExpression(
                    new BooleanExpression(
                        new LiteralExpression("BORN_DATE"),
                        new LiteralExpression("<="),
                        new DateExpression("01/01/1981")
                    ),
                    new OrExpression(
                        new BooleanExpression(
                            new LiteralExpression("DEPARTMENT"),
                            new LiteralExpression("="),
                            new TextExpression("IT")
                        ),
                        new BooleanExpression(
                            new LiteralExpression("DEPARTMENT"),
                            new LiteralExpression("="),
                            new TextExpression("Accounting")
                        )
                    )
                )
            )
        )
        );
        return select;
    }
}
