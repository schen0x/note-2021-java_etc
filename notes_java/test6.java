import java.io.IOException;

class test6 {
    public static void main(String[] args) {
        int i = 1;
        try {
            i = 3;
        }catch (SecurityException | IndexOutOfBoundsException e){
        } finally {
            System.out.println(i);
        }
        System.out.println(i);

        Integer in = null;
        System.out.println((Number) in);
    }
}
