import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.*;

public class JaccardTest {

    @Test
    public void testCalculate() {
        String header1 = "header1";
        String header2 = "header2";

        ArrayList<HashMap<String, List<String>>> myList = new ArrayList<>();

        HashMap<String, List<String>> map1 = new HashMap<>();
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        map1.put(header1, list1);

        HashMap<String, List<String>> map2 = new HashMap<>();
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("c");
        list2.add("d");
        map2.put(header2, list2);

        myList.add(map1);
        myList.add(map2);

        Jaccard.calculate(header1, header2, myList);

        //Expected intersection of {"a", "c"} and union of {"a", "b", "c", "d"} leads to 2/4 = 0.5 Jaccard similarity
        List<String> expectedIntersection = new ArrayList<>();
        expectedIntersection.add("a");
        expectedIntersection.add("c");

        List<String> expectedUnion = new ArrayList<>();
        expectedUnion.add("a");
        expectedUnion.add("b");
        expectedUnion.add("c");
        expectedUnion.add("d");

        // Check the intersection
        Set<String> intersection = new HashSet<>(map1.get(header1));
        intersection.retainAll(map2.get(header2));
        assertEquals(expectedIntersection, new ArrayList<>(intersection));

        // Check the union
        Set<String> union = new HashSet<>(map1.get(header1));
        union.addAll(map2.get(header2));
        assertEquals(expectedUnion, new ArrayList<>(union));

        // Check the Jaccard similarity
        double expectedSimilarity = 0.5;
        double actualSimilarity = (double) intersection.size() / union.size();
        assertEquals(expectedSimilarity, actualSimilarity, 0.001);
    }
}
