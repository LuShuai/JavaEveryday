package someTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class test2 {
    public static void main(String[] args) {
        try {
            BufferedReader
                br =
                new BufferedReader(new InputStreamReader(new FileInputStream("data/Patient.txt"), "GBK"));
            String str;
            String s[][] = new String[11][9];
            int row = 0;
            while ((str = br.readLine()) != null) {
                if (Character.isDigit(str.charAt(0))) {
                    //date line
                    String[] line = str.split("\\s+");
                    for (int col = 0; col < line.length; col++) {
                        s[row][col] = line[col];
                        //System.out.println(s[row][col]);
                    }
                    ++row;
                }
            }
            br.close();
            System.out.println(s[1][7]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
