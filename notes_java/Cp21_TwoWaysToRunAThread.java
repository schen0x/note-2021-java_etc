public class Cp21_TwoWaysToRunAThread {
    private class Cp21_TwoWaysToRunAThreadRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("runnable running");
        }
    }

    private class Cp21_TwoWaysToRunAThreadExtended extends Thread {

        @Override
        public void run() {
            System.out.println("thread class also implements runnable interface");
        }
    }

    public static void main(String[] args) {
        Cp21_TwoWaysToRunAThread x = new Cp21_TwoWaysToRunAThread();

        for (int i = 0; i < 10; i++) {
            new Thread(x.new Cp21_TwoWaysToRunAThreadRunnable()).start();

            x.new Cp21_TwoWaysToRunAThreadExtended().start();
        }
        

    }
}