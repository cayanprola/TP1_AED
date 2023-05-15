import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;

public class TestLevenshtein {
    @Test
    public void testCalculate() {
        Levenshtein levenshtein = new Levenshtein();

        ArrayList<HashMap<String, List<String>>> list = new ArrayList<HashMap<String, List<String>>>();
        HashMap<String, List<String>> map1 = new HashMap<String, List<String>>();
        HashMap<String, List<String>> map2 = new HashMap<String, List<String>>();
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        list1.add("cat");
        list1.add("dog");
        list2.add("bat");
        list2.add("rat");
        map1.put("header1", list1);
        map2.put("header2", list2);
        list.add(map1);
        list.add(map2);

        levenshtein.calculate("header1", "header2", list);
        // check that the output is correct for the given inputs
        // expected output:
        // cat:bat similarity: 0.25
        // cat:rat similarity: 0.2
        // dog:bat similarity: 0.2
        // dog:rat similarity: 0.16666666666666666
    }

    @Test
    public void testCalcDistance() {
        Levenshtein levenshtein = new Levenshtein();

        int distance1 = levenshtein.calcDistance("kitten", "sitting");
        // expected distance: 3
        assertEquals(3, distance1);

        int distance2 = levenshtein.calcDistance("book", "back");
        // expected distance: 2
        assertEquals(2, distance2);

        int distance3 = levenshtein.calcDistance("black", "slack");
        // expected distance: 1
        assertEquals(1, distance3);
    }
}
