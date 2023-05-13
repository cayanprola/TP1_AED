import java.util.*;

public class Cosine extends Distancias {

    public static double getCosineSimilarity(String str1, String str2) {
        Map<String, Integer> map1 = getTermFrequencyMap(str1);
        Map<String, Integer> map2 = getTermFrequencyMap(str2);

        Set<String> union = new HashSet<>(map1.keySet());
        union.addAll(map2.keySet());

        double dotProduct = 0.0;
        double mag1 = 0.0;
        double mag2 = 0.0;

        for (String term : union) {
            int count1 = map1.containsKey(term) ? map1.get(term) : 0;
            int count2 = map2.containsKey(term) ? map2.get(term) : 0;

            dotProduct += count1 * count2;
            mag1 += count1 * count1;
            mag2 += count2 * count2;
        }

        if (mag1 == 0.0 || mag2 == 0.0) {
            return 0.0;
        } else {
            return dotProduct / (Math.sqrt(mag1) * Math.sqrt(mag2));
        }
    }

    public static String getTextFromMap(String header, ArrayList<HashMap<String, List<String>>> list) {
        for (HashMap<String, List<String>> map : list) {
            if (map.containsKey(header)) {
                List<String> textList = map.get(header);
                StringBuilder sb = new StringBuilder();
                for (String text : textList) {
                    sb.append(text).append(" ");
                }
                return sb.toString().trim();
            }
        }
        return "";
    }

    private static Map<String, Integer> getTermFrequencyMap(String str) {
        Map<String, Integer> map = new HashMap<>();

        String[] terms = str.toLowerCase().split("\\W+");

        for (String term : terms) {
            if (map.containsKey(term)) {
                map.put(term, map.get(term) + 1);
            } else {
                map.put(term, 1);
            }
        }
        return map;
    }

    public static void calculate(String header1, String header2, ArrayList<HashMap<String, List<String>>> list) {
        String str1 = getTextFromMap(header1, list);
        String str2 = getTextFromMap(header2, list);
        System.out.println(str1);
        System.out.println("--");
        System.out.println(str2);

        double similarity = getCosineSimilarity(str1, str2);
        System.out.println("Cosine similarity: " + similarity);
    }
}

    /*This method takes two arrays of double values as input and returns a double value between 0 and 1, which represents their cosine similarity.
     The method first checks if the two arrays have the same length, as the cosine similarity can only be calculated between vectors of equal length. If the lengths are different, an IllegalArgumentException is thrown.

The method then iterates over the elements in the two arrays and computes the dot product of the two vectors, as well as their individual norms.
 The dot product is the sum of the products of the corresponding elements in the two arrays, and the norm of a vector is the square root of the sum of the squares of its elements.

Finally, the method computes the denominator of the cosine similarity formula, which is the product of the norms of the two vectors.
 If the denominator is zero, the method returns 0, as the cosine similarity between two zero vectors is undefined.
 Otherwise, the method returns the dot product divided by the denominator, which gives a value between 0 and 1,
  where 1 represents two identical vectors and 0 represents two completely different vectors.*/

