import java.util.Locale;
import java.util.ResourceBundle;

/**
 * MissingReosurceException if resource no found or missing key
 */
public class Cp14_I18N {
    public static void main(String[] args) {
        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");
        printProperties(us);
        System.out.println();
        printProperties(france);
    }

    public static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("Cp14_I18N", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
    }
}