import java.io.*;
import java.util.*;

public class Leitor<K, V> extends HashMap<K, V> {
    public static void lerFile(ArrayList<String> arr1, ArrayList<String> arr2, ArrayList<HashMap<Integer, String>> arrMap) {

        String line;
        String splitBy = ",";
        HashMap<Integer, String> data1 = new HashMap<>();
        HashMap<Integer, String> data2 = new HashMap<>();

        try {
            //parsing a CSV file into BufferedReader
            BufferedReader booking = new BufferedReader(new FileReader("./files/rooms/booking.csv"));
            BufferedReader expedia = new BufferedReader(new FileReader("./files/rooms/expedia.csv"));

            //BufferedReader name1 = new BufferedReader(new FileReader("./files/names/names1.csv"));
            //BufferedReader name2 = new BufferedReader(new FileReader("./files/names/names2.csv"));

            while ((line = booking.readLine()) != null) {
                arr1.add(Arrays.toString(line.split(splitBy)));
            }
            while ((line = expedia.readLine()) != null) {
                arr2.add(Arrays.toString(line.split(splitBy)));    // use comma as separator
            }
            for (int x = 0; x < arr1.size(); x++) {
                data1.put(x, arr1.get(x));
            }
            for (int x = 0; x < arr2.size(); x++) {
                data2.put(x, arr2.get(x));
            }
            /*for (int x = 0; x < arr1.size(); x++) {
                System.out.println(data1.get(x));
            }*/
            /*for (int x = 0; x < arr2.size(); x++) {
                System.out.println(data2.get(x));
            }*/

            arrMap.add(data1);
            arrMap.add(data2);

            booking.close();
            expedia.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
