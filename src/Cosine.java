import java.util.*;

public class Cosine extends Metrics {

    //We need to convert strings to number vectors so we can calculate them
    public static HashMap<String, Integer> convertListToVector(List<String> list) {
        HashMap<String, Integer> vector = new HashMap<String, Integer>();
        for (String s : list) {
            Integer count = vector.get(s);
            if (count == null) {
                vector.put(s, 1);
            } else {
                vector.put(s, count + 1);
            }
        }
        return vector;
    }

    //Calculate the magnitude between each vector so we can apply the formula
    public static double calculateMagnitude(HashMap<String, Integer> vector) {
        double magnitude = 0.0;
        for (Integer value : vector.values()) {
            magnitude += value * value;
        }
        magnitude = Math.sqrt(magnitude);
        return magnitude;
    }

    public static void calculate(String header1, String header2, ArrayList<HashMap<String, List<String>>> myList) {

        // Get the lists of strings for the two headers
        List<String> map1 = myList.get(0).get(header1);
        List<String> map2 = myList.get(1).get(header2);

        if (map1 == null || map2 == null) {
            throw new IllegalArgumentException("Header not found in one of the maps.");
        }

        // Convert the lists to vectors
        HashMap<String, Integer> vector1 = convertListToVector(map1);
        HashMap<String, Integer> vector2 = convertListToVector(map2);

        // Calculate the dot product
        double dotProduct = 0.0;
        for (Map.Entry<String, Integer> entry : vector1.entrySet()) {
            String key = entry.getKey();
            Integer value1 = entry.getValue();
            Integer value2 = vector2.get(key);
            if (value2 != null) {
                dotProduct += value1 * value2;
            }
        }

        // Calculate the magnitude of both vectors
        double magnitude1 = calculateMagnitude(vector1);
        double magnitude2 = calculateMagnitude(vector2);

        // Calculate the cosine similarity
        double cosineSimilarity = dotProduct / (magnitude1 * magnitude2);

        System.out.println("Str1= " + map1);
        System.out.println("Str2= " + map2);
        System.out.println("Cosine Similarity: " + cosineSimilarity);
    }
}

