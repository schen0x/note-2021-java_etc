import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Cp19_SimpleCopyFile {
    private static void copySimple(File source, File destination) throws IOException {
        try (InputStream in = new FileInputStream(source); OutputStream out = new FileOutputStream(destination)) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        }
    }

    private static void copyBuffered(File source, File destination) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(source));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File source = new File("Zoo.class");
        File destination = new File("ZooCopy.class");
        copySimple(source, destination);
        copyBuffered(source, destination);
    }
}