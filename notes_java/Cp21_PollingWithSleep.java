public class Cp21_PollingWithSleep {

    private static long counter = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (long i = -999999999L; i < 999999999L; i++)
                Cp21_PollingWithSleep.counter++;
        }).start();
        while (Cp21_PollingWithSleep.counter < 30000) {
            System.out.println("Not reached yet: " + Cp21_PollingWithSleep.counter);
            Thread.sleep(100); // .1 SECOND
        }
        System.out.println("Reached!: " + Cp21_PollingWithSleep.counter);
    }
}
