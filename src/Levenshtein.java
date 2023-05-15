import java.util.*;

public class Levenshtein extends Metrics {


    public int calcDistance(String s1, String s2) {
        //Create a 2D array to store the Levenshtein distance between each pair of characters
        int[][] distance = new int[s1.length() + 1][s2.length() + 1];

        //Fill the first row and first column of the table with the corresponding edit distances
        for (int i = 0; i <= s1.length(); i++) {
            distance[i][0] = i;
        }

        for (int j = 0; j <= s2.length(); j++) {
            distance[0][j] = j;
        }

        //Loop through the remaining cells of the array
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                //Determine the cost of changing the i character of s1 to the j character of s2
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                //Change the current cell with the minimum of the three neighboring cells plus the cost
                distance[i][j] = Math.min(Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1),
                        distance[i - 1][j - 1] + cost);
            }
        }
        return distance[s1.length()][s2.length()];
    }
    public void calculate(String header1, String header2, ArrayList<HashMap<String, List<String>>> list) {
        //Iterates both group of strings
        for (String str1 : list.get(0).get(header1)) {
            for (String str2 : list.get(1).get(header2)) {
                //Gets the distance
                double distance = this.calcDistance(str1, str2);
                //Calculate the similarity and print it
                double similarity = (str1.length() + str2.length() - distance) / (str1.length() + str2.length());
                System.out.println(str1 + ":" + str2 + " similarity: " + similarity);
            }
        }
    }
}
