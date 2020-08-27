import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "rawtypes"})
public class Cp16_GenericCollectionTrivia {
    public static void main(String[] args) {
        List<Integer> listGeneric = new ArrayList<>();
        List lPointer = listGeneric;
        lPointer.add("99");
        lPointer.add("100");
        System.out.println(lPointer); 
        Collections.sort(listGeneric);
        System.out.println(listGeneric);

        listGeneric.add(Integer.valueOf(101));
        System.out.println(listGeneric);
        //! Collections.sort(listGeneric); //ClassCastException

        System.out.println("--------------------");

        List<? extends Integer> listA = new ArrayList<>();
        //! listA.add(Integer.valueOf(1));
        listA.add(null); //though possible to add null.
        listA.clear();

        List<? super IOException> listB = new ArrayList<>();
        //! listB.add(new Exception());
        listB.add(new EOFException()); 
    }
}