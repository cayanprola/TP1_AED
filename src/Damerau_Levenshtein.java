import java.util.*;

public class Damerau_Levenshtein extends Metrics {
    public static int calcDistance(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        //Two-dimensional integer array d that stores the Damerau-Levenshtein distance between all substrings of s1 and s2
        int[][] d = new int[len1 + 1][len2 + 1];

        //Fill the first row and first column of the table with the corresponding edit distances
        for (int i = 0; i <= len1; i++) {
            d[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            d[0][j] = j;
        }
        //Fill in the rest of the table by computing the minimum edit distance among three possible operations
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // Determine the cost of the substitution operation based on whether the characters at the corresponding positions match or not
                int cost = s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1;

                // Choose the operation with the minimum cost among insertion, deletion, and substitution
                d[i][j] = Math.min(d[i - 1][j] + 1, Math.min(d[i][j - 1] + 1, d[i - 1][j - 1] + cost));

                // Check if a transposition operation is possible and update the table accordingly
                if (i > 1 && j > 1 && s1.charAt(i - 1) == s2.charAt(j - 2) && s1.charAt(i - 2) == s2.charAt(j - 1)) {
                    d[i][j] = Math.min(d[i][j], d[i - 2][j - 2] + cost);
                }
            }
        }
        //Return the edit distance between the two input strings.
        return d[len1][len2];
    }

    public static void calculate(String header1, String header2, ArrayList<HashMap<String, List<String>>> myList) {
        List<String> map1 = myList.get(0).get(header1);
        List<String> map2 = myList.get(1).get(header2);

        //Initialize variables to hold the total distance and total count of pairs
        int distanceSum = 0;
        int totalCount = 0;

        //Iterate over all pairs of strings from the two input lists and compute their similarity score
        for (String s1 : map1) {
            for (String s2 : map2) {
                //Compute the Damerau-Levenshtein distance between the current pair of strings
                int distance = calcDistance(s1, s2);
                distanceSum += distance;
                totalCount++;

                //Prints the result
                System.out.println(s1 + ":" + s2 + "; similarity: " + (-1.0 + (distanceSum / (double) totalCount)));
            }
        }
    }
}
