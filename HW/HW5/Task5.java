import java.util.ArrayList;
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
        var <String> allNames = sortedFMap.keySet().toArray();
        for (int i = allNames.length - 1; i >=0; i--) {
            if (sortedFMap.containsKey(allNames[i])) {
                
                System.out.println(sortedFMap.get(allNames[i]));
                if (sortedFMap.get(allNames[i]) == 1) {
                    sortedFMap.remove(allNames[i]);
                }
            }
        }
        LinkedHashMap<String, Integer> inversedFMap = new LinkedHashMap<>();
        for (int i = sortedFMap.size() - 1; i >= 0; i--) {
            inversedFMap.put(sortedFMap.keySet().toArray()[i].toString(), Integer.parseInt(sortedFMap.values().toArray()[i].toString()));
        }
        return inversedFMap.toString();
    }
}
