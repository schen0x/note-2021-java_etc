import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * remember to avoid double when doing math related to money
 */
public class Cp14_I18NNumberAndCurrency {
    private void run() {
        Locale localeJP = new Locale("ja");
        Locale.setDefault(localeJP);

        // NumberFormat.getInstance();
        NumberFormat generalInstance = NumberFormat.getInstance(localeJP);
        NumberFormat numberInstance = NumberFormat.getNumberInstance(localeJP);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(localeJP);
        NumberFormat percentInstance = NumberFormat.getPercentInstance(localeJP);
        NumberFormat integerInstance = NumberFormat.getIntegerInstance(localeJP);
        System.out.println(generalInstance);

        // format() number -> string
        int attendeesPerYear = 3_200_000;
        int attendeesPerMonth = attendeesPerYear / 12;

        System.out.println(attendeesPerMonth);
        System.out.println(numberInstance.format(attendeesPerMonth));
        System.out.println(currencyInstance.format(attendeesPerMonth));
        System.out.println(percentInstance.format(attendeesPerMonth));
        System.out.println(integerInstance.format(attendeesPerMonth));

        NumberFormat g = NumberFormat.getIntegerInstance(Locale.GERMANY);
        System.out.println(g.format(attendeesPerMonth));

        // parsing(), string -> number
        System.out.println("---parsing---");
        String s = "40.35";
        try {
            System.out.println(numberInstance.parse(s));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Cp14_I18NNumberAndCurrency x = new Cp14_I18NNumberAndCurrency();
        x.run();
    }
}