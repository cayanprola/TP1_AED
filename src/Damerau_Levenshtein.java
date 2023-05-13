import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Damerau_Levenshtein extends Distancias {
    public static int damerauLevenshteinDistance(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] d = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            d[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            d[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int cost = s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1;

                d[i][j] = Math.min(d[i - 1][j] + 1, Math.min(d[i][j - 1] + 1, d[i - 1][j - 1] + cost));

                if (i > 1 && j > 1 && s1.charAt(i - 1) == s2.charAt(j - 2) && s1.charAt(i - 2) == s2.charAt(j - 1)) {
                    d[i][j] = Math.min(d[i][j], d[i - 2][j - 2] + cost);
                }
            }
        }

        return d[len1][len2];
    }

    public static void calculate(String header1, String header2, ArrayList<HashMap<String, List<String>>> myList) {
        List<String> map1 = myList.get(0).get(header1);
        List<String> map2 = myList.get(1).get(header2);
        int distanceSum = 0;
        int totalCount = 0;

        for (String s1 : map1) {
            for (String s2 : map2) {
                int distance = damerauLevenshteinDistance(s1, s2);
                distanceSum += distance;
                totalCount++;

                System.out.println(s1 + ":" + s2 + " similarity: " + (-1.0 + (distanceSum / (double) totalCount)));
            }
        }
    }
}
