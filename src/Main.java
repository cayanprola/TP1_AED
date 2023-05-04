import java.io.*;
import java.util.*;

public class Main<K,V> extends HashMap<K, V>{
    public static void main(String[] args) throws Exception {
        ArrayList<HashMap<?, ?>> myList = new ArrayList<HashMap<?, ?>>();

        ArrayList<String> arr1 = new ArrayList<String>();
        ArrayList<String> arr2 = new ArrayList<String>();
        Leitor l = new Leitor();
        l.lerFile(arr1, arr2, myList);
    }
}