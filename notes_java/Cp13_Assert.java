public class Cp13_Assert {
    public static void run() { //
        int i = 1;
        int j = 1;
        //! assert i < 0;
        assert j < 0: "natural number only";
        System.out.println(i);
    }

    public static void main(String[] args) {
        run();
    }
}