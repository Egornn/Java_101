import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import  java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.nio.charset.Charset;


public class Task5 {
    public static void main(String[] args) {
        
        Logger logger = Logger.getAnonymousLogger();
        
        Telephones dictionaryTelephones = new Telephones();
        dictionaryTelephones.add("Ivanov", "8912313");
        dictionaryTelephones.add("Petrov", "8943422");
        dictionaryTelephones.add("Ivanov", "8942334");
        logger.info(dictionaryTelephones.getPhone("Ivanov"));
        logger.info(dictionaryTelephones.getPhone("Petrov"));
        logger.info(dictionaryTelephones.getPhone("Simirov"));

        ArrayList <String> names = new ArrayList<>();
        names.add("Ivan ivanov");
        names.add("Kristin Belova");
        names.add("Anna Musina");
        names.add("Anna Kurtova");
        names.add("Ivan Urin");
        names.add("Petr Lukov");
        names.add("Pavel Chernov");
        names.add("Petr Chernishov");
        names.add("Svetlana Petrova");
        names.add("Maria Fedorova");
        names.add("Svetlana Petrova");
        names.add("Maria Fedorova");
        names.add("Marina Svetlova");
        names.add("Maria Savina");
        names.add("Maria Rukova");
        names.add("Marina Lugova");
        names.add("Anna Vladimirova");
        names.add("Ivan Mechnikov");
        names.add("Maria Savina");
        names.add("Petr Perin");
        names.add("Ivan Ezhov");

        logger.info(FindDuplicates(names).toString());

        Integer[] arrayToSort = { 6, 4, 2, 4, 6, 3, 5, -5, 23, 4, 5, 46, 75, 7, 1, 53, 2 };
              
        logger.info(arrayToString(arrayToSort));
        sort(arrayToSort);
        logger.info(arrayToString(arrayToSort));

        logger.info(String.valueOf(generateBoard(8)));
        
    }
    
    public static String FindDuplicates(ArrayList<String> names) {

        Map<String, Integer> namesFrequeMap = new HashMap<>();
        for (String nameString : names) {
            namesFrequeMap.putIfAbsent(nameString.split(" ")[0], 0);
            namesFrequeMap.put(nameString.split(" ")[0], namesFrequeMap.get(nameString.split(" ")[0]) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedHashMap<String, Integer> sortedFMap = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> entry : namesFrequeMap.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        for (int num : list) {
            for (Entry<String, Integer> entry : namesFrequeMap.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedFMap.put(entry.getKey(), num);
                }
            }
        }
        var<String> allNames = sortedFMap.keySet().toArray();
        for (int i = allNames.length - 1; i >= 0; i--) {
            if (sortedFMap.containsKey(allNames[i])) {

                System.out.println(sortedFMap.get(allNames[i]));
                if (sortedFMap.get(allNames[i]) == 1) {
                    sortedFMap.remove(allNames[i]);
                }
            }
        }
        LinkedHashMap<String, Integer> inversedFMap = new LinkedHashMap<>();
        for (int i = sortedFMap.size() - 1; i >= 0; i--) {
            inversedFMap.put(sortedFMap.keySet().toArray()[i].toString(),
                    Integer.parseInt(sortedFMap.values().toArray()[i].toString()));
        }
        return inversedFMap.toString();
    }
    
    

    



    public static void sort(Integer arr[]){
            int size = arr.length;
     
            for (int i = size / 2 - 1; i >= 0; i--)
                heapify(arr, size, i);
     
            for (int i = size - 1; i > 0; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                heapify(arr, i, 0);
            }
        }
     
        public static void heapify(Integer arr[], int size, int i) {
            int largest = i;
            int l = 2 * i + 1;
            int r = 2 * i + 2;

            if (l < size && arr[l] > arr[largest]) {
                largest = l;
            }

            if (r < size && arr[r] > arr[largest]) {
                largest = r;
            }
            if (largest != i) {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;
                heapify(arr, size, largest);
            }
        }

        
        public static String arrayToString(Integer[] array) {
            StringBuilder stringArray = new StringBuilder();
            for (int i = 0; i < array.length - 1; i++) {
                stringArray.append(array[i]);
                stringArray.append(", ");

            }
            stringArray.append(array[array.length - 1]);
            return stringArray.toString();

        }

        public static String generateBoard(int size) {
        ArrayList <Integer> queensPos  =  new ArrayList<>() ;
        for (int i = 0; i < size; i++) {
            queensPos.add(i+1);
        }
        Boolean consistent = false;
        while (!consistent) {
            Collections.shuffle(queensPos);
            consistent = checkValid(queensPos);

        }
        Map<Character, Integer> boardCoordinates = new LinkedHashMap<>();
        

        for (int i = 0; i < size; i++) {
            boardCoordinates.put((char) (i + 65), queensPos.get(i));
        }
        
        String nQueens = new String();
        nQueens = boardCoordinates.toString();
        nQueens = nQueens.replace('{', ' ');
        nQueens = nQueens.replaceAll("=", "");
        nQueens = nQueens.replace(',', ' ');
        nQueens = nQueens.replace('}', ' ');
        nQueens=nQueens.trim();  
        return "Queens coorinates are "+nQueens; 
        
    }
    
    public static Boolean checkValid(ArrayList<Integer> queensPos) {
        for (int i = 0; i < queensPos.size()-1; i++) {
            for (int j = i + 1; j < queensPos.size(); j++) {
                if (Math.abs(queensPos.get(i) - queensPos.get(j)) == (j - i)) {
                    return false;
                }
            }
        }
        return true;
        
    }
        
}
 