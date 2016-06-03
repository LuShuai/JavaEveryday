package someTest.filelineiterator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by shuailu on 5/26/16.
 */
public class FileLineIterable implements Iterable<String>{

    private BufferedReader br;

    public FileLineIterable(String filePath) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(filePath));
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                try {
                    br.mark(1);
                    if (br.readLine() != null) {
                        br.reset();
                        return true;
                    }
                    return false;
                } catch (IOException e) {
                    return false;
                }
            }

            @Override
            public String next() {
                try {
                    return br.readLine();
                } catch (IOException e) {
                    return null;
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        try {
            FileLineIterable fileLineIterable = new FileLineIterable("/Users/shuailu/Projects/shuai/JavaEveryday/src/someTest/filelineiterator/data.txt");

            for (String line : fileLineIterable) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
