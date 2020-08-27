import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * remember to avoid double when doing math related to money
 */
public class Cp14_DateAndTimeFormat {
    private void run() {
        LocalDate date = LocalDate.of(2020, 8, 19);
        // LocalTime time = LocalTime.of(12, 70, 30); //! DateTimeException
        LocalTime time = LocalTime.of(12, 0, 30);
        LocalDateTime ldt = LocalDateTime.of(date, time);

        // formatting
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        // customizing
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(ldt.format(formatter));
        System.out.println(formatter.format(ldt));

        DateTimeFormatter ofStrFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm:ss");
        System.out.println(ofStrFormatter.format(ldt));

        // Default formatter:
        // LocalDate.parse(): DateTimeFormatter.ISO_LOCAL_DATE, e.g. "2007-12-03", not null.
        // LocalTime.parse(): DateTimeFormatter.ISO_LOCAL_DATE, e.g. "10:15:30", not null.
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate dt = LocalDate.parse("01 02 2015", f); 
        LocalTime t = LocalTime.parse("11:22");
        System.out.println(dt); // 2015–01–02
        System.out.println(t); // 11:22

    }

    public static void main(String[] args) {
        Cp14_DateAndTimeFormat x = new Cp14_DateAndTimeFormat();
        x.run();
    }
}