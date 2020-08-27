import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;

@SuppressWarnings("unused")
public class Cp19_nioFiles {
    private void run1() throws IOException {
        Path path1 = Paths.get("nioNewTest", "123");
        Path path2 = Files.createDirectories(path1);
        Path path3 = Files.createDirectories(path1);
        System.out.println(path2);
        System.out.println(Files.createDirectories(Paths.get("nioNewTest", "123")));
        System.out.println(path3);
        Files.move(path1, path2);
    }

    private void run2() {
        Path path1 = Paths.get("nioNewTest", "123");
        Files.isSymbolicLink(path1);
        System.out.println(Files.isDirectory(Paths.get("/walrus.txt")));
        System.out.println(Files.isExecutable(Paths.get("/walrus.txt")));
        System.out.println(Files.isReadable(Paths.get("/walrus.txt")));
    }

    private void run3() throws IOException {
        Path path1 = Paths.get("nioNewTest", "123");
        System.out.println(Files.isHidden(path1));
        UserPrincipal up = Files.getOwner(Paths.get("Cp19_nioFiles.java"));
        System.out.println(up);
        try {
            UserPrincipal owner = FileSystems.getDefault().getUserPrincipalLookupService()
                    .lookupPrincipalByName("root");
            System.out.println(owner);
            Files.setOwner(Paths.get("Cp19_nioFiles.java"), owner);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Cp19_nioFiles x = new Cp19_nioFiles();
        // x.run1();
        // x.run2();
        x.run3();
    }
}