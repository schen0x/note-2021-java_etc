import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test8 {
    private static List<Double> generateArray(int n) {
        List<Double> outList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Double e = Math.random();
            outList.add(e);
        }
        Collections.sort(outList);
        return outList;
    }

    public static void main(String[] args) {
        int n = 8000000;
        List<Double> outList = generateArray(n);
        List<Double> len = new ArrayList<>();
        for (int i = 0; i < outList.size(); i++) {
            if (i == 0) {
                len.add(outList.get(0));
            } else {
                len.add(outList.get(i) - outList.get(i - 1));
            }
        }
        len.add(1 - outList.get(outList.size() - 1));

        // process
        double theAvg =(1 / (double)(n + 1));
        long count = len.stream().filter(d -> d > theAvg).count();
        System.out.println(count);
        double result = (double)count/ (double)n;
        System.out.println(result);
    }
}
