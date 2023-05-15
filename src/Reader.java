import java.io.*;
import java.lang.reflect.AccessibleObject;
import java.util.*;

public class Leitor<K, V> extends HashMap<K, V> {
    public void lerFile(ArrayList<HashMap<String, List<String>>> arrMap, String filename1, String filename2) {

        HashMap<Integer, String> data1 = new HashMap<>();
        HashMap<Integer, String> data2 = new HashMap<>();

        try {
            File file1 = new File(filename1);
            File file2 = new File(filename2);

            arrMap.add(this.parseFile(file1));
            arrMap.add(this.parseFile(file2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, List<String>> parseFile(File filename) throws FileNotFoundException {
        HashMap<String, List<String>> map = new HashMap<>();
        boolean start = true;
        int headersAmount = 0;
        ArrayList<String> headers = new ArrayList<>();

        Scanner myReader = new Scanner(filename);
        while (myReader.hasNextLine()) {
            String[] values = myReader.nextLine().split(",", headersAmount);
            int cont = 0;

            for (String value : values) {
                if (start) {
                    map.put(value, new ArrayList<>());
                    headersAmount = map.keySet().size();
                    headers.add(value);
                } else {
                    String key = headers.get(cont);
                    List<String> map_values = map.get(key);
                    map_values.add(value);
                    map.put(key, map_values);
                }

                cont++;
            }

            start = false;
        }
        myReader.close();

        return map;
    }
}
