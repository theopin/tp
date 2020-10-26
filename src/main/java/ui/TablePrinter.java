package ui;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import exception.CommandException;

import java.util.ArrayList;
import java.util.HashMap;


public class TablePrinter {
    String [][] rawTable;
    ArrayList<String[]> finalTable;
    int maxWidth = 30;
    boolean leftJustifiedRows = true;

    public TablePrinter() throws CommandException {
        makeRawTable(CheatSheetList.getList());
    }

    public TablePrinter(ArrayList<CheatSheet> cheatSheetToBePrinted) throws CommandException {
        makeRawTable(cheatSheetToBePrinted);
    }

    /*
     * Table to print in console in 2-dimensional array. Each sub-array is a row.
     */
    private void makeRawTable(ArrayList<CheatSheet> cheatSheetsToBePrinted) throws CommandException {
        rawTable = new String[cheatSheetsToBePrinted.size() + 1][4];
        rawTable[0][0] = "INDEX";
        rawTable[0][1] = "NAME";
        rawTable[0][2] = "SUBJECT";
        rawTable[0][3] = "DETAILS";
        for (int i = 1; i <= cheatSheetsToBePrinted.size(); i++) {
            CheatSheet cs = cheatSheetsToBePrinted.get(i-1);
            rawTable[i][0] = String.valueOf(i);
            rawTable[i][1] = cs.getName().trim();
            try {
                rawTable[i][2] = cs.getSubject().trim();
            } catch (NullPointerException n) {
                rawTable[i][2] = "";
            }
            rawTable[i][3] = cs.getDetails().trim();
        }
    }

    /*
     * Create new table array with wrapped rows
     */
    private void makeTableWithWrapping() {
        finalTable = new ArrayList<>();
        int test = 0;
        for (String[] row : rawTable) {
            // If any cell data is more than max width, then it will need extra row.
            boolean needExtraRow = false;
            // Count of extra split row.
            int splitRow = 0;
            do {
                needExtraRow = false;
                String[] newRow = new String[row.length];
                for (int i = 0; i < row.length; i++) {
                    // If data is less than max width, use that as it is.
                    if (row[i].length() < maxWidth) {
                        newRow[i] = splitRow == 0 ? row[i] : "";
                    } else if ((row[i].length() > (splitRow * maxWidth))) {
                        // If data is more than max width, then crop data at maxwidth.
                        // Remaining cropped data will be part of next row.
                        int end = Math.min(row[i].length(), ((splitRow * maxWidth) + maxWidth));
                        newRow[i] = row[i].substring((splitRow * maxWidth), end);
                        needExtraRow = true;
                    } else {
                        newRow[i] = "";
                    }
                }
                finalTable.add(newRow);
                if (needExtraRow) {
                    splitRow++;
                }
            } while (needExtraRow);
        }
    }

    /*
     * Calculate appropriate Length of each column by looking at width of data in
     * each column.
     *
     * Map columnLengths is <column_number, column_length>
     */
    public HashMap<Integer, Integer> calculateLengthOfEachCol() {
        HashMap<Integer, Integer> columnLengths = new HashMap<>();
        for (String[] row : finalTable) {
            for (int i = 0; i < row.length; i++) {
                columnLengths.putIfAbsent(i, 0);
                if (columnLengths.get(i) < row[i].length()) {
                    columnLengths.put(i, row[i].length());
                }
            }
        }
        return columnLengths;
    }

    public StringBuilder prepareStringFormatForEachRow(HashMap<Integer, Integer> columnLengths) {
        final StringBuilder stringFormat = new StringBuilder("");
        String flag = leftJustifiedRows ? "-" : "";
        for (HashMap.Entry<Integer, Integer> e : columnLengths.entrySet()) {
            stringFormat.append("| %").append(flag).append(e.getValue()).append("s ");
        }
        stringFormat.append("|\n");
        //System.out.println("stringFormat = " + stringFormat.toString());
        return stringFormat;
    }

    public StringBuilder prepareLine(HashMap<Integer, Integer> columnLengths) {
        StringBuilder line = new StringBuilder();
        for (Integer value : columnLengths.values()) {
            line.append("+");
            line.append("-".repeat(value + 2));
        }

        line.append("+\n");
        //System.out.println("Line = " + line);
        return line;
    }

    public void printFinalTable(StringBuilder stringFormat, StringBuilder line) {
        System.out.print(line);
        System.out.printf(stringFormat.toString(), rawTable[0][0], rawTable[0][1], rawTable[0][2], rawTable[0][3]);
        System.out.print(line);
        for (int i = 1; i < finalTable.size(); i++) {
            System.out.printf(stringFormat.toString(), finalTable.get(i)[0], finalTable.get(i)[1], finalTable.get(i)[2], finalTable.get(i)[3]);
        }
        System.out.println(line);
    }

    public void execute() throws CommandException {
        makeTableWithWrapping();
        HashMap<Integer, Integer> columnLengths = calculateLengthOfEachCol();
        StringBuilder stringFormat = prepareStringFormatForEachRow(columnLengths);
        StringBuilder line = prepareLine(columnLengths);
        printFinalTable(stringFormat, line);
    }
}
