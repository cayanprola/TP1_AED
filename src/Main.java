import java.util.*;

public class Main<K, V> extends HashMap<K, V> {
    public static void main(String[] args) throws Exception {
        ArrayList<HashMap<String, List<String>>> myList = new ArrayList<>();

        Leitor l = new Leitor();
        l.lerFile(myList);
        Levenshtein lev = new Levenshtein();
        Jaccard jac = new Jaccard();
        Hamming ham = new Hamming();
        ham.hammingSimilarity("location", "Location", myList);
//        lev.calculate(myList, "country", "country");
// System.out.println(jac.calculate("Booking.com", "Expedia", myList));

    }
}