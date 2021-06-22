import java.io.*;
import java.util.Locale;

public class Database {
    private String[] colNames;
    private int numRows;
    private String[][] data;

    public String[] getColNames() {
        return colNames;
    }

    public void setColNames(String[] colNames) {
        this.colNames = colNames;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public Database(String contents) {
/* TODO 
This constructor should take the contents of a CSV file and initialize the memember variables of the Database class.
*/
        String[] csvFileLines = contents.split("\n");
        String csvHeaderLine = csvFileLines[0];
        this.setColNames(csvHeaderLine.split(","));

        this.setNumRows(csvFileLines.length - 1);
        String[][] data = new String[this.getNumRows()][this.getColNames().length];

        for(int i = 1; i < csvFileLines.length; i++) {
            String curr_line = csvFileLines[i];
            String[] curr_line_values = curr_line.split(",");
            for(int j = 0; j < curr_line_values.length; j++) {
                data[i-1][j] = curr_line_values[j];
            }
        }

        this.setData(data);
    }

    public String getValue(String columnName,int row){
    /* TODO */
//This method should return the data contained on row "row" and the column matching  @columname
        int colIdx = 0;
        for(int i = 0; i < this.getColNames().length; i++) {
            if(this.getColNames()[i].equals(columnName)){
                colIdx = i;
            }
        }
        return this.getData()[row][colIdx];
    }

}


