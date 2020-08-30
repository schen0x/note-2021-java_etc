public class test3 {
    private int i = 5;

    class test3_inner{
        private int i = new test3().i + 5;
    }

    public static void main(String[] args) {
        System.out.println(new test3().new test3_inner().i);
    }
    
}