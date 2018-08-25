package oscarblancarte.ipd.interprete.sql;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class Context {
    
    private SimpleDateFormat dateFormat;
    private HSSFWorkbook workboook;
    private HSSFSheet sheets;
    private String[] columns;
    private final String dbPath;
    private Iterator<Row> tableIterator;
    private final List<Row> resultRows = new ArrayList<>();
    private Row currentRow;
    private List<Object[]> result;
    private int resultColumnCount;

    public Context(String dbPath) {
        this.dbPath = dbPath;
        initiateFileRead();
    }
    
    public void createResultArray(int columns){
        this.resultColumnCount = columns;
        result = new ArrayList<>();
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }
    
    public List<Object[]> getResultArray(){
        return result;
    }
    
    public Object[] createRow(){
        Object[] row = new Object[resultColumnCount];
        result.add(row);
        return row;
    }
    
    public List<Row> getResultRow(){
        return resultRows;
    }

    

    private void initiateFileRead() {
        try {
            workboook = new HSSFWorkbook(Context.class.getClassLoader()
                    .getResourceAsStream(dbPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createRowIterator() {
        tableIterator = sheets.iterator();
        tableIterator.next();
    }

    public Row getCurrentRow() {
        return currentRow;
    }

    public boolean nextRow() {
        if (tableIterator.hasNext()) {
            currentRow = tableIterator.next();
            return true;
        }
        return false;
    }

    public Iterator<Row> getRowIterator() {
        return tableIterator;
    }

    public void addCurrentRowToResults() {
        resultRows.add(currentRow);
    }

    public void destroy() {
        try {
            workboook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean tableExist(String table) {
        return loadTable(table);
    }

    private boolean loadTable(String table) {

        if (columns != null) {
            return true;
        }

        sheets = workboook.getSheet(table);
        if (sheets == null) {
            return false;
        }
        for (Row row : sheets) {
            int lastRow = row.getLastCellNum();
            columns = new String[lastRow];
            int index = 0;
            for (Cell cell : row) {
                columns[index++] = cell.getStringCellValue();
            }
            System.out.println("Table > '" + table + "' Colums > '" 
                    + Arrays.toString(columns) + "'");
            break;
        }
        return true;
    }

    public boolean tableColumn(String column) {
        for (String col : columns) {
            if (col.equalsIgnoreCase(column)) {
                return true;
            }
        }
        return false;
    }

    public int columnIndex( String column) {
        for (int c = 0; c < columns.length; c++) {
            if (columns[c].equalsIgnoreCase(column)) {
                return c;
            }
        }
        throw new RuntimeException("Column '" + column + "' not exist");
    }
}
