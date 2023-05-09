import java.util.*;

public class Hamming extends Distancias {
    public static void hammingSimilarity(String header1, String header2, ArrayList<HashMap<String, List<String>>> list) {
        for (String s1 : list.get(0).get(header1)) {
           for (String s2 : list.get(1).get(header2)) {
               System.out.println(s1 + " : " + s2);
//                if (s1.length() != s2.length()) {
//                    throw new IllegalArgumentException("Strings must have equal length");
//                }
            }
        }
        int count = 0;
        for (int i = 0; i < list.get(0).get(header1).size() ; i++){
            if (list.get(0).get(header1).toString().charAt(i) != list.get(1).get(header2).toString().charAt(i)) {
                count++;
            }
        }
        System.out.println(1 - (double) count / list.get(0).get(header1).size());
    }

}
