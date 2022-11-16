import java.lang.reflect.Parameter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.Configuration.Parameters;

import org.w3c.dom.TypeInfo;

public class Notebook {
    private String id;
    private String model;
    private int screenSize;
    private String processor;
    private int memory;
    private int hardDriveStorgate;
    private String operatingSystem;
    private Date dateProduction;
    private String color;
    private Map<Integer, Object> specs = new HashMap<>();
    private static Map<Integer, Object> filter = new HashMap<>();

    
    public Notebook(String id) {
        this.id = id;
        this.specs.put(1, id);

    }

    public void setModel(String model) {
        this.model = model;
        this.specs.put(1, model);
    }
    
    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
        this.specs.put(2, screenSize);
    }

    public void setProcessor(String processor) {
        this.processor = processor;
        this.specs.put(3, processor);
    }
    
    public void setMemory(int memory) {
        this.memory = memory;
        this.specs.put(4, memory);

    }
      
    public void setHardDriveStorgate(int hardDriveStorgate) {
        this.hardDriveStorgate = hardDriveStorgate;
        this.specs.put(5, hardDriveStorgate);
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
        this.specs.put(6, operatingSystem);
    }
    
    public void setMemory(Date dateProduction) {
        this.dateProduction = dateProduction;
        this.specs.put(7, dateProduction);

    }

    public void setColor(String color) {
        this.color = color;
        this.specs.put(8, color);
    }
    
    public static String infoOnFilter() {
        return "For the filter write number and the minimum value for the parameter." 
            +"1 - model, 2 - screen, 3 - core, 4 - memory, 5 - HDD, 6 - OS, 7 - Date, 8 - Color";

    }

    public  static void filterBy(int criteria, Object min) {
        filter.put(criteria, min);
    }
    
    public void removeFilter() {
        filter = new HashMap<>();
    }


    public static Map<String, Map<Integer, Object>> getNotebooks(ArrayList<Notebook> noteboos) {
        Map<String, Map<Integer, Object>> results = new HashMap<>();
        boolean good = true;
        for (Notebook specifiaction : noteboos) {
            for (int i = 0; i < specifiaction.specs.size(); i++) {
                good = true;
                for (int j : filter.keySet()) {
                    if (specifiaction.specs.get(j) instanceof Integer) {
                        if ((Integer) specifiaction.specs.getOrDefault(j,0) < (Integer) filter.getOrDefault(j,0)) {
                            good = false;
                        }
                    }
                }
                if (good) {
                    results.put(specifiaction.id, specifiaction.specs);
                }
            }
        }
        return results;
    }
    
}
