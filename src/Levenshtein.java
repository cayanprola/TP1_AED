import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Levenshtein extends Distancias {
    public void calculate(ArrayList<HashMap<String, List<String>>> arrMap, String header1, String header2) {
        for (String str1 : arrMap.get(0).get(header1)) {
            for (String str2 : arrMap.get(1).get(header2)) {
                double distance = this.computeLevenshteinDistance(str1, str2);
                double similarity = (str1.length() + str2.length() - distance) / (str1.length() + str2.length());
                // double similarity = 1 - ((double) distance / Math.max(str1.length(), str2.length()));

                System.out.println(str1 + ":" + str2 + " distance: " + similarity);
            }
        }
    }

    public int computeLevenshteinDistance(String s1, String s2) {
        int[][] distance = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            distance[i][0] = i;
        }

        for (int j = 0; j <= s2.length(); j++) {
            distance[0][j] = j;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                distance[i][j] = Math.min(Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1),
                        distance[i - 1][j - 1] + cost);
            }
        }

        return distance[s1.length()][s2.length()];

    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }

}
