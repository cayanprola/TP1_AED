import java.util.*;

public class Hamming extends Metrics {
    public static int calcDistance(String s1, String s2) {
        //Compare the length of both strings
        if (s1.length() != s2.length()) {
            return -1;
        }
        //Calculate the number of different chars both strings have and return it
        int distance = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    public static void calculate(String header1, String header2, ArrayList<HashMap<String, List<String>>> list) {
        for (String str1 : list.get(0).get(header1)) {
            for (String str2 : list.get(1).get(header2)) {

                //Use the method distance to calculate the distance of both maps and save it
                int distance = calcDistance(str1.toLowerCase(), str2.toLowerCase());
                if (distance <= -1)
                    continue;
                //Get the max length between both strings to do the formula
                int maxLength = Math.max(str1.length(), str2.length());

                //Prints the result
                System.out.println(str1 + " : " + str2 + "; similarity = " + (double) (maxLength - distance) / maxLength);
            }
        }
    }
}
