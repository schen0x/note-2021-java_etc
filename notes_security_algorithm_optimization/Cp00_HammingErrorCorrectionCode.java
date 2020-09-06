import java.util.Random;

public class Cp00_HammingErrorCorrectionCode {
    public static void main(String[] args) {
        int[] block =new Random().ints(0,2).limit(16).toArray();
        int out = 0;
        // Hamming code(16, 11), or ([2**n (- 1), 2**n - n - 1 ])
        // XOR of every position where "1" is presented.
        for(int i =0; i<16; i++)
            if(block[i] == 1) out = out^i;
        
        // The error correction bits;
        System.out.println(Integer.toBinaryString(out));
    }
}