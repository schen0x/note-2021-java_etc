public class Cp0_NullStringBuilder {
        static char c;
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb); // nothing

        System.out.println(c); 
    } 
}
