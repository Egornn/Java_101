import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Telephones {
    public static Map<String, ArrayList<String> > telephoneList = new HashMap<>();

    public static void add(String name, String phone) {
        if (telephoneList.containsKey(name)) {
            if (!telephoneList.get(name).contains(phone)) {
                telephoneList.get(name).add(phone);
            }
        } else {
            ArrayList<String> newPhone = new ArrayList<>();
            newPhone.add(phone);
            telephoneList.put(name, newPhone);
        }
    
    }
    public static String getPhone(String name) {
        if (telephoneList.containsKey(name)) {
            return telephoneList.get(name).toString();
        } 
        return "No such person";
    }
    

    
    public static void main(String[] args) {
        System.out.println();
    }
    
}
