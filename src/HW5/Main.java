package HW5;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String[] header1 = {"number", "value", "measurementError"};
        int[][] data1 = {{1, 102, 1}, {2, 125, 3}, {3, 156, 2}, {4, 256, 1}};

        AppData table = new AppData(header1, data1);

        table.fileWriter(table);

        table.fileReader();
    }
}
