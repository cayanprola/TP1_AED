import java.util.ArrayList;
import java.util.HashMap;

public class Levenshtein extends Distancias {
    //ration = (s1.length()+s2.length()−distance(s1, s2))/(s1.length()+s2.length())
    //Returns the distance between each index from both maps
    public static double distance(ArrayList<HashMap<?, ?>> arrMap, int indexMap1, int indexMap2, int indexData) {
       return arrMap.get(indexMap1).get(indexData).toString().length() - arrMap.get(indexMap2).get(indexData).toString().length();

    }
    //Calculates the Levenshtein similarity between two maps
    public static double calculate(ArrayList<HashMap<?, ?>> arrMap, int indexMap1, int indexMap2, int indexData) {
        return arrMap.get(indexMap1).get(indexData).toString().length() + arrMap.get(indexMap2).get(indexData).toString().length() - distance(arrMap, indexMap1, indexMap2, indexData) / arrMap.get(indexMap1).get(indexData).toString().length() + arrMap.get(indexMap2).get(indexData).toString().length();

    }
}
