import java.io.*;
import java.util.*;

public class Leitor<K, V> extends HashMap<K, V> {
    public static void lerFile(ArrayList<String[]> arr1, ArrayList<String[]> arr2, ArrayList<HashMap<?, ?>> arrMap) throws Exception {

        String line = "";
        String splitBy = ",";

        ArrayList<HashMap<?, ?>> myList = new ArrayList<HashMap<?, ?>>();
        HashMap<Integer, String> data1 = new HashMap<Integer, String>();
        HashMap<Integer, String> data2 = new HashMap<Integer, String>();

        //ler string do expedia com oq esta entre aspas, e nao usar somente split por virgula


        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader booking = new BufferedReader(new FileReader("./files/rooms/booking.csv"));
            BufferedReader expedia = new BufferedReader(new FileReader("./files/rooms/expedia.csv"));

            while ((line = booking.readLine()) != null)   //returns a Boolean value
            {
                arr1.add(line.split(splitBy));
            }
            while ((line = expedia.readLine()) != null)   //returns a Boolean value
            {
                arr2.add(line.split(splitBy));    // use comma as separator
            }
            for (int x = 0; x < arr1.size(); x++) {
                data1.put(x, Arrays.toString(arr1.get(x)));
            }
            for (int x = 0; x < arr1.size(); x++) {
                System.out.println(data1.get(x));
            }
            for (int x = 0; x < arr2.size(); x++) {
                data2.put(x, Arrays.toString(arr2.get(x)));
            }
            for (int x = 0; x < arr2.size(); x++) {
                System.out.println(data2.get(x));
            }
            
            myList.add(data1);
            myList.add(data2);

            booking.close();
            expedia.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
