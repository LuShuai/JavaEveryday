package someTest.filelineiterator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by shuailu on 5/29/16.
 */
public class FileIterableWithCache implements Iterable<String> {

    BufferedReader br;
    String nextLine;

    public FileIterableWithCache(String filePath) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(filePath));
        loadNextLine();
    }

    private void loadNextLine() {
        try {
            nextLine = br.readLine();
        } catch (IOException e) {
            nextLine = null;
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return nextLine != null;
            }

            @Override
            public String next() {
                String res = nextLine;
                loadNextLine();
                return res;
            }
        };
    }

    public static void main(String[] args) {
        try {
            FileIterableWithCache fileIterableWithCache = new FileIterableWithCache(
                "/Users/shuailu/Projects/shuai/JavaEveryday/src/someTest/filelineiterator/data.txt");

            int counter = 0;
            for (String line : fileIterableWithCache) {
                System.out.println(line);
                counter++;
            }
            System.out.println(counter + " lines in total");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
