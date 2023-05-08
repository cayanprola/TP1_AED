import java.lang.reflect.Array;
import java.util.*;

public class Jaccard extends Distancias {
    public static double calculate(String header1, String header2, ArrayList<HashMap<String, List<String>>> list) {
        List<String> map1 = list.get(0).get(header1);
        List<String> map2 = list.get(1).get(header2);

        Set<String> intersection = new HashSet<>(map1);
        intersection.retainAll(map2);

        System.out.println(map1);
        System.out.println(map2);

        Set<String> union = new HashSet<>(map1);
        union.addAll(map2);

        return (double) intersection.size() / union.size();
    }
}