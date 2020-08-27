/**
 * null char print nothing, 
 * null String print literal "null", 
 * however,
 * call on nullArrary.length throws the exception
 * call on nullString.length() throws the exception
 */
public class Cp0_NullPointerExceptions {
    public static void main(String[] args) {
        char[] cl = new char[2];
        System.out.println("cl[0]: " + cl[0]); //blank line

        System.out.println("-----------------");
        String[][] sl = new String[2][];
        System.out.println("sl[0]: " + sl[0]); // literal null
        System.out.println(sl.length);
        // ! System.out.println(sl[0][0]); // exception thrown
        sl[0] = new String[] { "'0'", "1", null};
        System.out.println("sl[0][2]: " + sl[0][2]);
        System.out.println(sl[0][2].length());
    }
}