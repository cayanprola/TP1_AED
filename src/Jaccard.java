import java.util.*;

public class Jaccard extends Distancias {
    public static double calculate(ArrayList<HashMap<Integer, String>> list) {
        // Convert the input list to a set of hash maps
        HashSet<HashMap<Integer, String>> setHash = new HashSet<>(list);

        // Calculate the size of the intersection and union of the set
        int intersectionSize = 0;
        for (HashMap<Integer, String> map : setHash) {
            // Access the values of the hash map using the get() method
            if (map.get(0) != null && map.get(1) != null) {
                intersectionSize++;
            }
        }
        int unionSize = setHash.size() * 2 - intersectionSize;

        // Calculate the Jaccard similarity and return the result
        double similarity = (double) intersectionSize / unionSize;
        return similarity;
    }

}