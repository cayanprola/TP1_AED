import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.*;

public class Damerau_LevenshteinTest {

    @Test
    public void testCalcDistance() {
        assertEquals(1, Damerau_Levenshtein.calcDistance("cat", "cot"));
        assertEquals(3, Damerau_Levenshtein.calcDistance("kitten", "sitting"));
        assertEquals(3, Damerau_Levenshtein.calcDistance("Saturday", "Sunday"));
    }

    @Test
    public void testCalculate() {
        String header1 = "list1";
        String header2 = "list2";
        ArrayList<HashMap<String, List<String>>> myList = new ArrayList<>();
        HashMap<String, List<String>> map1 = new HashMap<>();
        map1.put(header1, List.of("cat", "kitten", "Saturday"));
        HashMap<String, List<String>> map2 = new HashMap<>();
        map2.put(header2, List.of("cot", "sitting", "Sunday"));
        myList.add(map1);
        myList.add(map2);

        Damerau_Levenshtein.calculate(header1, header2, myList);
    }
}
