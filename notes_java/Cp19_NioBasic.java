import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cp19_NioBasic {
    @SuppressWarnings("unused")
    private void run() throws URISyntaxException {
        Path path1 = Paths.get("/abc/alligator/swim.txt");
        Path path2 = Paths.get(new URI("file:///alligator/swim.txt"));
        System.out.println(path1);
        // System.out.println(path2);
        System.out.println(path1.getName(0));
        System.out.println(path1.getParent().getParent().getParent());
        System.out.println(path1.getParent().getParent().getParent().getRoot());
        System.out.println("------------");
        System.out.println(path1.getRoot());
        Path path3 = Paths.get("/");
        System.out.println(path3.getRoot());
        Path path4 = Paths.get("swim.txt");
        System.out.println(path4.getRoot()); //relative no root
        System.out.println(path4.getParent()); //relative no root
    }
    public static void main(String[] args) throws URISyntaxException {
        Cp19_NioBasic x = new Cp19_NioBasic();
        x.run();
    }
}