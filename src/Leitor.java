import java.io.*;
import java.util.*;

public class Leitor<K,V> extends HashMap<K,V> {
    public static void lerFile(ArrayList<String> arr1, ArrayList<String> arr2, ArrayList<HashMap<?, ?>> arrMap) throws Exception {

        ArrayList<HashMap<?, ?>> myList = new ArrayList<HashMap<?, ?>>();

        HashMap<String, String> data1 = new HashMap<String, String>();
        HashMap<String, String> data2 = new HashMap<String, String>();
        HashMap<String, Integer> dataIndex1 = new HashMap<String, Integer>();
        HashMap<String, Integer> dataIndex2 = new HashMap<String, Integer>();


        Scanner scFile1 = new Scanner(new File("./files/rooms/booking.csv"));
        Scanner scFile2 = new Scanner(new File("./files/rooms/expedia.csv"));


        scFile1.useDelimiter(",");
        scFile2.useDelimiter(",");

        int i = 0;
        while (scFile1.hasNextInt()) {
            dataIndex1.put("index", scFile1.nextInt());
//            data1.put("name", scFile1.next());
            i++;
            arr1.add(scFile1.next());
        }
        for (String x : arr1) {
//            System.out.println(x);
        }
        scFile1.close();
        while (scFile2.hasNextInt()) {
            int j = 0;
            dataIndex2.put("index", scFile2.nextInt());
//            data2.put("name", scFile2.next());

            j++;
            arr2.add(scFile2.next());
        }
        for (String x : arr2) {
//            System.out.println(x);
        }
        scFile2.close();

        myList.add(data1);
        myList.add(dataIndex1);
        myList.add(data2);
        myList.add(dataIndex2);

        for(i = 0; i < arr1.size(); i++) {
            System.out.println(dataIndex1.get("index"));
        }
    }


}
