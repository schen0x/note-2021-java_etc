import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Cp19_Mark {
    private void run() throws IOException {
        String str = "ABCD";
        InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        System.out.print((char) is.read()); // A
        if (is.markSupported()) {
            is.mark(1);
            // It might still rember, although "The stream is not required to remember any
            // data at all
            // if more than readlimit bytes are read from the stream before
            // reset is called."
            System.out.print((char) is.read()); // B
            System.out.print((char) is.read()); // C
            is.reset();
            // The general contract of reset is:
            // If the method markSupported returns true, then:
            //     If the method mark has not been called since the stream was created, or the
            // number of bytes read from the stream since mark was last called is larger
            // than the argument to mark at that last call, then an IOException might be
            // thrown.
            //     If such an IOException is not thrown, then the stream is reset to a state
            // such that all the bytes read since the most recent call to mark (or since the
            // start of the file, if mark has not been called) will be resupplied to
            // subsequent callers of the read method, followed by any bytes that otherwise
            // would have been the next input data as of the time of the call to reset.
            //
            // If the method markSupported returns false, then:
            //     The call to reset may throw an IOException.
            //     If an IOException is not thrown, then the stream is reset to a fixed state
            // that depends on the particular type of the input stream and how it was
            // created. The bytes that will be supplied to subsequent callers of the read
            // method depend on the particular type of the input stream.
            //
            // The method reset for class InputStream does nothing except throw an
            // IOException.
        }
        System.out.println("----------------------");
        byte[] byteArrayAsOutput = new byte[2];
        System.out.print(is.read(byteArrayAsOutput));  // 2
        System.out.print((char) byteArrayAsOutput[0]); // B
        System.out.print((char) byteArrayAsOutput[1]); // C
        System.out.print((char) is.read()); // D
        System.out.println("----------");
        char c = 78;
        System.out.println(c);
    }

    public static void main(String[] args) throws IOException {
        Cp19_Mark x = new Cp19_Mark();
        x.run();
    }

}