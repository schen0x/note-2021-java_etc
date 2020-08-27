import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Cp19_SerializationWithObjectStreamAnimal implements Serializable {
    static final long serialVersionUID = 1L;
    private String name;
    private transient int age;
    private Integer ageInteger;
    private transient char type;
    private transient Cp19_SerializationWithObjectStreamAnimalNestedAttr attr;
    // its constructor will not be called.

    // will not be called in the deserialization process
    public Cp19_SerializationWithObjectStreamAnimal() {
        this.name = "noname";
        this.type = 'N';
    }

    public Cp19_SerializationWithObjectStreamAnimal(String name, int age, Integer ageInteger, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.ageInteger = ageInteger;
        this.attr = Cp19_SerializationWithObjectStreamAnimalNestedAttr.getInstance();
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.ageInteger + " " + this.type + " " + this.attr + "\n";
    }
}

class Cp19_SerializationWithObjectStreamAnimalNestedAttr implements Serializable {
    private static final long serialVersionUID = 1L;
    String s = "nestedAttr";

    // private construct does not effect the result;
    public Cp19_SerializationWithObjectStreamAnimalNestedAttr() {
        System.out.println("constructing");
        this.s = "nestedAttr";
    }

    public static Cp19_SerializationWithObjectStreamAnimalNestedAttr getInstance() {
        return new Cp19_SerializationWithObjectStreamAnimalNestedAttr();
    }

    @Override
    public String toString() {
        return this.s;
    }
}

public class Cp19_SerializationWithObjectStream {
    public static List<Cp19_SerializationWithObjectStreamAnimal> getCp19_SerializationWithObjectStreamAnimals(
            File dataFile) throws IOException, ClassNotFoundException {
        List<Cp19_SerializationWithObjectStreamAnimal> animals = new ArrayList<Cp19_SerializationWithObjectStreamAnimal>();
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                Object object = in.readObject();
                if (object instanceof Cp19_SerializationWithObjectStreamAnimal)
                    animals.add((Cp19_SerializationWithObjectStreamAnimal) object);
            }
        } catch (EOFException e) {
            // File end reached
            // Since -1 cannot be on Object, this is the proper technique
        }
        return animals;
    }

    public static void createCp19_SerializationWithObjectStreamAnimalsFile(
            List<Cp19_SerializationWithObjectStreamAnimal> animals, File dataFile) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (Cp19_SerializationWithObjectStreamAnimal animal : animals)
                out.writeObject(animal);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Cp19_SerializationWithObjectStreamAnimal> animals = new ArrayList<Cp19_SerializationWithObjectStreamAnimal>();
        animals.add(new Cp19_SerializationWithObjectStreamAnimal("Tommy Tiger", 5, 5, 'T'));
        animals.add(new Cp19_SerializationWithObjectStreamAnimal("Peter Penguin", 8, 8, 'P'));
        File dataFile = new File("Cp19_SerializationWithObjectStreamAnimal.data");
        createCp19_SerializationWithObjectStreamAnimalsFile(animals, dataFile);
        System.out.println("----------------");
        System.out.println(getCp19_SerializationWithObjectStreamAnimals(dataFile));
    }
}