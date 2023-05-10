import java.util.*;

public class Hamming extends Distancias {
    public static int distance(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return -1;
        }
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

                int distance = distance(str1.toLowerCase(), str2.toLowerCase());
                if (distance <= -1)
                    continue;
                int maxLength = Math.max(str1.length(), str2.length());
                System.out.println(str1 + " : " + str2 + " " +(double) (maxLength - distance) / maxLength);
            }
        }
    }
}
