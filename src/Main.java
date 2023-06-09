import java.util.*;

public class Main<K, V> extends HashMap<K, V> {
    public static void main(String[] args) throws Exception {
        ArrayList<HashMap<String, List<String>>> myList = new ArrayList<>();

        //Change our variables to the arguments values
        String header1, header2;
        header1 = args[3].split("=")[1];
        header2 = args[4].split("=")[1];

        //Read the files based on the arguments
        Reader read = new Reader();
        read.readFile(myList, args[1].split("=")[1], args[2].split("=")[1]);
        //Saves the metric based on the last argumetn
        String metric = args[5].split("=")[1];
        selectMetric(metric, header1, header2, myList);
    }

    public static void selectMetric(String metric, String header1, String header2, ArrayList<HashMap<String, List<String>>> myList) {
        //Uses the saved metric to switch to the needed operation
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
                Damerau_Levenshtein damerauLevenshtein = new Damerau_Levenshtein();
                damerauLevenshtein.calculate(header1, header2, myList);
                break;
            default:
                System.out.println("Check your arguments.");
                System.exit(1);
                break;
        }
    }
}