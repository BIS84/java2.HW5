package HW5;

import java.io.*;

public class AppData {

    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String getAppData(AppData name) {

        String str = "";
        for (int i = 0; i < header.length; i++) {
            if(i < header.length - 1) {
                str = str + header[i] + ";";
            } else {
                str = str + header[i] + "\n";
            }
        }
        for (int i = 0; i < data.length; i++) {
            if(data[i].length != header.length) {
                try {
                    throw new NumberOfColumnsException("NOCE");
                } catch (NumberOfColumnsException e) {
                    System.out.println("Количество данных в строке " + (i + 1) + " не соответствует числу столбцов.");
                }
            }
            for (int j = 0; j < data[i].length; j++){
                if(j < data[i].length - 1) {
                    str = str + data[i][j] + ";";
                } else {
                    str = str + data[i][j] + "\n";
                }
            }
        }
        return str;
    }

    public void fileWriter(AppData appData) throws IOException {

        FileOutputStream fos = null;
        try { fos = new FileOutputStream("./table.csv");
            byte[] buffer = appData.getAppData(appData).getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
