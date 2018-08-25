package oscarblancarte.ipd.interprete.sql.nonterminal;

import java.util.Date;
import org.apache.poi.ss.usermodel.*;
import oscarblancarte.ipd.interprete.sql.*;
import oscarblancarte.ipd.interprete.sql.terminal.*;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class BooleanExpression implements StatementExpression {

    private final LiteralExpression leftExpression;
    private final LiteralExpression booleanOperator;
    private final LiteralExpression rightExpression;

    public BooleanExpression(LiteralExpression leftExp, 
            LiteralExpression operator, LiteralExpression rightExp) {
        this.leftExpression = leftExp;
        this.booleanOperator = operator;
        this.rightExpression = rightExp;
    }

    @Override
    public Boolean interpret(Context context) 
            throws InterpreteException {
        Row currentRow = context.getCurrentRow();

        String left = leftExpression.interpret(context).toString();
        String opr = booleanOperator.interpret(context).toString();
        Object right = rightExpression.interpret(context);

        int columnIndex = context.columnIndex(left);
        Cell cell = currentRow.getCell(columnIndex);

        if (rightExpression instanceof NumericExpression) {
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            double cellValue = cell.getNumericCellValue();
            double rightVal = ((Number) right).doubleValue();
            if (opr.equals("=")) {
                return cellValue == rightVal;
            } else if (opr.equals("<>") || opr.equals("!=")) {
                return cellValue != rightVal;
            } else if (opr.equals(">")) {
                return cellValue > rightVal;
            } else if (opr.equals(">=")) {
                return cellValue >= rightVal;
            } else if (opr.equals("<")) {
                return cellValue < rightVal;
            } else if (opr.equals("<=")) {
                return cellValue <= rightVal;
            } else {
                throw new RuntimeException(
                        "Unexpected operator '" + opr + "'");
            }
        } else if (rightExpression instanceof DateExpression) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
            String cellValue = cell.getStringCellValue();
            long cellDateLong = 0;
            long expressionDateLong = ((Date) right).getTime();
            try {
                Date date = context.getDateFormat().parse(cellValue);
                cellDateLong = date.getTime();
            } catch (Exception e) {
                throw new InterpreteException(
                        "Invalid date > " + cellValue);
            }
            if (opr.equals("=")) {
                return cellDateLong == expressionDateLong;
            } else if (opr.equals("<>") || opr.equals("!=")) {
                return cellDateLong != expressionDateLong;
            } else if (opr.equals(">")) {
                return cellDateLong > expressionDateLong;
            } else if (opr.equals(">=")) {
                return cellDateLong >= expressionDateLong;
            } else if (opr.equals("<")) {
                return cellDateLong < expressionDateLong;
            } else if (opr.equals("<=")) {
                return cellDateLong <= expressionDateLong;
            } else {
                throw new RuntimeException(
                        "Unexpected operator '" + opr + "'");
            }
        } else if (rightExpression instanceof LiteralExpression
                || rightExpression instanceof TextExpression) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
            String cellValue = cell.getStringCellValue();
            String rightVal = right.toString();
            if (opr.equals("=")) {
                return cellValue.equals(rightVal);
            } else if (opr.equals("<>") || opr.equals("!=")) {
                return !cellValue.equalsIgnoreCase(rightVal);
            } else if (opr.equals(">")) {
                int result = cellValue.toString().
                        compareToIgnoreCase(rightVal.toString());
                return result > 0;
            } else if (opr.equals(">=")) {
                int result = cellValue.toString().
                        compareToIgnoreCase(rightVal.toString());
                return result >= 0;
            } else if (opr.equals("<")) {
                int result = cellValue.toString().
                        compareToIgnoreCase(rightVal.toString());
                return result < 0;
            } else if (opr.equals("<=")) {
                int result = cellValue.toString().
                        compareToIgnoreCase(rightVal.toString());
                return result <= 0;
            } else {
                throw new RuntimeException(
                        "Unexpected operator '" + opr + "'");
            }
        } else {
            throw new RuntimeException("Type of cell not supported " 
                    + right.getClass().getSimpleName());
        }
    }

    @Override
    public String toString() {
        return leftExpression.toString() + " "
                + booleanOperator.toString() + " "
                + rightExpression.toString();
    }
}