import java.util.*;

public class Main<K, V> extends HashMap<K, V> {
    public static void main(String[] args) throws Exception {
        ArrayList<HashMap<Integer, String>> myList = new ArrayList<>();
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String > arr2 = new ArrayList<>();

        Leitor l = new Leitor();
        l.lerFile(arr1, arr2, myList);
        Levenshtein lev = new Levenshtein();
        Jaccard jac = new Jaccard();
        /*for(int i = 0; i < myList.get(0).size(); i++) {
            System.out.println(lev.calculate(myList, 0, 1, i));
        }*/
        System.out.println(jac.calculate(myList));

    }
}