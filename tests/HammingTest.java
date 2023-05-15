import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HammingTest {

    @Test
    public void testCalcDistance() {
        int distance = Hamming.calcDistance("abc", "abc");
        assertEquals(0, distance);

        distance = Hamming.calcDistance("abc", "abd");
        assertEquals(1, distance);

        distance = Hamming.calcDistance("abc", "abcd");
        assertEquals(-1, distance);
    }

    @Test
    public void testCalculate() {
        ArrayList<HashMap<String, List<String>>> list = new ArrayList<>();

        HashMap<String, List<String>> map1 = new HashMap<>();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("abc");
        list1.add("def");
        map1.put("header1", list1);
        list.add(map1);

        HashMap<String, List<String>> map2 = new HashMap<>();
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("abc");
        list2.add("xyz");
        map2.put("header2", list2);
        list.add(map2);

        Hamming.calculate("header1", "header2", list);
    }
}

