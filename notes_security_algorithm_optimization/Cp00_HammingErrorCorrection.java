import java.util.Random;

public class Cp0_HammingErrorCorrectionCode {
    public static void main(String[] args) {
        int[] block =new Random().ints(0,2).limit(16).toArray();
        int out = 0;
        for(int i =0; i<16; i++)
            if(block[i] == 1) out = out^i;
    } 
}