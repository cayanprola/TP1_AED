import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CosineTest {

    private ArrayList<HashMap<String, List<String>>> myList;

    @Before
    public void setUp() throws Exception {
        myList = new ArrayList<HashMap<String, List<String>>>();
        HashMap<String, List<String>> map1 = new HashMap<String, List<String>>();
        map1.put("header1", Arrays.asList("apple", "banana", "orange", "pear", "grape"));
        myList.add(map1);
        HashMap<String, List<String>> map2 = new HashMap<String, List<String>>();
        map2.put("header2", Arrays.asList("apple", "banana", "orange", "pear", "grape", "kiwi"));
        myList.add(map2);
    }

    @Test
    public void testCalculate() {
        try {
            Cosine.calculate("header1", "header2", myList);
            assertTrue(true);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testCalculateWithInvalidHeader() {
        try {
            Cosine.calculate("header1", "header3", myList);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testCalculateWithNullInput() {
        try {
            Cosine.calculate(null, null, null);
            fail("Expected NullPointerException not thrown");
        } catch (NullPointerException e) {
            assertNotNull(e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testConvertListToVector() {
        List<String> list = Arrays.asList("apple", "banana", "orange", "pear", "grape");
        HashMap<String, Integer> vector = Cosine.convertListToVector(list);
        assertEquals(5, vector.size());
        assertEquals(1, (int) vector.get("apple"));
        assertEquals(1, (int) vector.get("banana"));
        assertEquals(1, (int) vector.get("orange"));
        assertEquals(1, (int) vector.get("pear"));
        assertEquals(1, (int) vector.get("grape"));
    }

    @Test
    public void testCalculateMagnitude() {
        HashMap<String, Integer> vector = new HashMap<String, Integer>();
        vector.put("apple", 2);
        vector.put("banana", 3);
        vector.put("orange", 1);
        double magnitude = Cosine.calculateMagnitude(vector);
        assertEquals(Math.sqrt(14), magnitude, 0.0001);
    }

}
