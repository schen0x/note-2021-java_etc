import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cp19_Skip {
    public static void main(String[] args) throws IOException {
        Path data = Paths.get("Cp19_SkipDataTempFile.txt");
        // write a tempfile
        try (Writer w = Files.newBufferedWriter(data, Charset.forName("UTF-8"));) {
            w.write("ABCDEFG");
        }
        // reading
        try (Reader r = Files.newBufferedReader(data, Charset.forName("UTF-8"))) {
            System.out.println(r.skip(99));
            int ch = r.read(); // -1
            System.out.println(ch + " char:" + (char) ch);
        }
        // delete the tempfile
        File datafile = new File("Cp19_SkipDataTempFile.txt");
        datafile.delete();
    }

}