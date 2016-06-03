package someTest.mylab;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shuailu on 5/31/16.
 */
public class TimeFormatTest {

    public static void main(String[] args) throws ParseException {

        DateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd HHmmss z");
        String timeString = "20160524 160559 PST8PDT";
        Date date = dateFormatter.parse(timeString);

    }

}
