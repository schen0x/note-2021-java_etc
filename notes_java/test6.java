import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Set;

@SuppressWarnings("unused")
public class test6 {
    public static void main(String[] args) {
        Map<String,Integer> m = new HashMap<>();
        m.put("C", 3);
        m.put("D", 3);
        m.put("A", 2);

        //! String r = m.stream()
        //TODO why the result is always sorted.
        Set<Entry<String, Integer>> entrySet = m.entrySet();
        String r = m.entrySet().stream()
            .map(Entry::getKey)
            .collect(Collectors.joining());
            System.out.println(r);


        ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC"));
        LocalDateTime ldt = LocalDateTime.from(zdt);
        System.out.println(ldt);
        System.out.println(zdt);
    }
    
}