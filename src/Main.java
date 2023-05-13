import java.util.*;

public class Main<K, V> extends HashMap<K, V> {
    public static void main(String[] args) throws Exception {
        ArrayList<HashMap<String, List<String>>> myList = new ArrayList<>();

        String header1 = "", header2 = "";
        for (String s : args) {
            System.out.println(s);
        }
        header1 = args[2].split("=")[1];
        header2 = args[3].split("=")[1];
        Leitor l = new Leitor();
        l.lerFile(myList, args[0].split("=")[1], args[1].split("=")[1]);
        String metric = args[4].split("=")[1];
        selectMetric(metric, header1, header2, myList);
    }

    public static void selectMetric(String metric, String header1, String header2, ArrayList<HashMap<String, List<String>>> myList) {
        switch (metric) {
            case "levenshtein":
                Levenshtein levenshtein = new Levenshtein();
                levenshtein.calculate(header1, header2, myList);
                break;
            case "hamming":
                Hamming hamming = new Hamming();
                hamming.calculate(header1, header2, myList);
                break;
            case "jaccard":
                Jaccard jaccard = new Jaccard();
                jaccard.calculate(header1, header2, myList);
                break;
            case "cosine":
                Cosine cosine = new Cosine();
                cosine.calculate(header1, header2, myList);
                break;
            case "damerau-levenshtein":
                Damerau_Levenshtein dm = new Damerau_Levenshtein();
                break;
        }
    }
}