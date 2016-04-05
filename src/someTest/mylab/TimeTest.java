package someTest.mylab;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by shuailu on 1/28/16.
 */
public class TimeTest {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String myTimeZone = "America/Los_Angeles";
    private static final String UTC = "UTC";

    public static void main(String[] args) throws ParseException {

        // ZonedDateTime = LocalDateTime + TimeZone
        LocalDateTime localDateTime = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
        System.out.println("Source time without zone: " + localDateTime
            .format(formatter));   //to convert localDatetime to milliSec here you need to specify time zone

        ZonedDateTime zonedDateTimeMyZone = ZonedDateTime.of(localDateTime, ZoneId.of(myTimeZone));
        ZonedDateTime zonedDateTimeUTC = ZonedDateTime.of(localDateTime, ZoneId.of(UTC));
        System.out.println("Time difference in hour: " +
                           (getTimeInstantInMilliSec(zonedDateTimeUTC) - getTimeInstantInMilliSec(zonedDateTimeMyZone))
                           / (1000 * 3600));

        Date newDate = Date.from(zonedDateTimeUTC.toInstant());
        System.out.println("new date: " + newDate);



        // Backward compatibility: LocalDateTime to Date (java 7- manner)
        System.out.println("\nBackward compatibility test:");
        Date dateMyZone = Date.from(zonedDateTimeMyZone.toInstant());
        Date dateUTC = Date.from(zonedDateTimeUTC.toInstant());

        System.out.println("Time difference in hour: " +
                           (getTimeInstantInMilliSec(dateUTC, UTC) - getTimeInstantInMilliSec(dateMyZone, myTimeZone))
                           / (1000 * 3600));


        // Test upgrade Date to LocalDateTime (java 8)
        System.out.println("\nDate to LocalDateTime:");
        LocalDateTime localDateTimeMyZone =  Instant.ofEpochMilli(dateMyZone.getTime()).atZone(ZoneId.of(myTimeZone)).toLocalDateTime();
        LocalDateTime localDateTimeUTC =  Instant.ofEpochMilli(dateMyZone.getTime()).atZone(ZoneId.of(UTC)).toLocalDateTime();

        System.out.println(localDateTimeMyZone.format(formatter));
        System.out.println(localDateTimeUTC.format(formatter));




        //Date get Time
        Date date = dateFormatter.parse("1970-01-01 00:00:00");
        System.out.println(date.getTime());

        Instant instant = Instant.ofEpochMilli(date.getTime()); // + TimeZone.getDefault().getRawOffset());
        LocalDateTime localDateTime1 = instant.atZone(ZoneId.of(UTC)).toLocalDateTime();
        System.out.println(localDateTime1);

        date = new Date(0L);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(dateFormat.format(date.getTime()));
    }

    private static long getTimeInstantInMilliSec(ZonedDateTime zonedDateTime) {
        long milliSec = zonedDateTime.toInstant().toEpochMilli();
        System.out.println(String.format("It is %s, time instant: %d, time zone: %s", zonedDateTime.format(formatter),
                                         milliSec, zonedDateTime.getZone()));
        return milliSec;

    }


    private static long getTimeInstantInMilliSec(Date date, String timeZone) {
        long milliSec = date.toInstant().toEpochMilli();
        System.out.println(String.format("It is %s, time instant: %d, \"time zone\": %s", dateFormatter.format(date),
                                         milliSec, timeZone));
        return milliSec;
    }
}
