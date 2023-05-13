import java.lang.reflect.Array;
import java.util.*;

public class Jaccard extends Distancias {
    public static void calculate(String header1, String header2, ArrayList<HashMap<String, List<String>>> myList) {
        List<String> map1 = myList.get(0).get(header1);
        List<String> map2 = myList.get(1).get(header2);

        Set<String> intersection = new HashSet<>(map1);
        intersection.retainAll(map2);

        System.out.println(map1);
        System.out.println(map2);

        Set<String> union = new HashSet<>(map1);
        union.addAll(map2);
        System.out.println((double) intersection.size() / union.size());
    }
}