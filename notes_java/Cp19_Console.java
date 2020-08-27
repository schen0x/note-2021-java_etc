import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cp19_Console {
    private static void oldSchool() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();
        System.out.println("you wrote in old school: " + userInput);
    }

    private static void basic() {
        Console console = System.console();
        if (console != null) {
            String userInput = console.readLine();
            console.writer().println("You entered the following: " + userInput);
            console.format("fmt %s %d --", "str", 123);
        }
    }

    public static void main(String[] args) throws IOException {
        oldSchool();
        basic();
    }
}