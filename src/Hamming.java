public class Hamming extends Distancias{
    public static double hammingSimilarity(String s1, String s2) {
        if (s1.length() != s2.length()) {
            throw new IllegalArgumentException("Strings must have the same length");
        }

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }

        return 1 - (double) count / s1.length();
    }

}
