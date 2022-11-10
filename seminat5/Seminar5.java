import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Seminar5 {

    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        Map<Integer, String> db = new HashMap<>();
        db.put(123456, "Ivanov");
        db.put(321456, "Vasiliev");
        db.put(234561, "Petrova");
        db.put(234432, "Ivanov");
        db.put(654321, "Petrova");
        db.put(345678, "Ivanov");

        logger.info(String
                .valueOf(db.keySet().stream().filter(n -> db.get(n).equals("Ivanov")).collect(Collectors.toList())));

        for (Integer key : db.keySet()) {
            if (db.get(key).equals("Ivanov")) {
                logger.info(String.valueOf(key) + " " + db.get(key));
            }
        }


        logger.info(String.valueOf(romanToInteger("MXXI")));
        
        logger.info(integertoRoman(2022));
    }

    public static boolean isIsomorf(String first, String second) {
        Map<Character, Character> stringMap = new HashMap<>();
        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();
        if (firstChars.length != secondChars.length) {
            return false;
        }
        for (int i = 0; i < first.length(); i++) {
            if (!stringMap.containsKey(firstChars[i])) {
                if (stringMap.values().contains(secondChars[i])) {
                    return false;
                }
                stringMap.put(firstChars[i], secondChars[i]);
            } else if (!(stringMap.get(firstChars[i]) == secondChars[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRight(String exp) {
        char[] charsExp = exp.toCharArray();
        Stack<Character> stack = new Stack<>();
        List<Character> openContainer = new ArrayList<>();
        openContainer.add('(');
        openContainer.add('[');
        openContainer.add('{');
        openContainer.add('<');
        List<Character> closeContainer = new ArrayList<>();
        closeContainer.add(')');
        closeContainer.add(']');
        closeContainer.add('}');
        closeContainer.add('>');
        for (char item : charsExp) {
            if (openContainer.contains(item)) {
                stack.push(item);
            } else if (closeContainer.contains(item)) {
                if (stack.isEmpty() || !openContainer.get(closeContainer.indexOf(item)).equals(stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static Integer romanToInteger(String roman) {
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        char[] romanNumber = roman.toCharArray();
        int number = 0;
        for (int i = 0; i < romanNumber.length - 1; i++) {
            if (dict.get(romanNumber[i]) >= dict.get(romanNumber[i + 1])) {
                number += dict.get(romanNumber[i]);
            } else {
                number -= dict.get(romanNumber[i]);
            }
        }
        number += dict.get(romanNumber[romanNumber.length - 1]);
        return number;
    }
    
    public static String integertoRoman(int arabic) {
        Map<Integer,String> dict = new HashMap<>();
        dict.put( 1000, "M");
        dict.put( 500, "D");
        dict.put( 100, "C");
        dict.put( 50, "L");
        dict.put(10, "X");
        dict.put( 5,"V");
        dict.put(1, "I");
        dict.put( 900, "CM");
        dict.put( 400, "CD");
        dict.put(90, "XC");
        dict.put( 40,"XL");
        dict.put( 9,"IX");
        dict.put( 4,"IV");
        StringBuilder romanNumber = new StringBuilder();
        while (arabic > 0) {
            while (arabic / 1000 >= 1) {
                romanNumber.append(dict.get(1000));
                arabic -= 1000;
            }
            while (arabic / 100 >= 1) {
                if (dict.containsKey(arabic - arabic % 100)) {
                    romanNumber.append(dict.get(arabic - arabic % 100));
                    arabic = arabic % 100;
                }
                if (arabic >= 500) {
                    romanNumber.append(dict.get(500));
                    arabic = arabic - 500;
                }
                else {
                    if (arabic >= 100){
                        romanNumber.append(dict.get(100));
                        arabic -=100;
                    }
                }
            }
            while (arabic / 10 >= 1) {
                if (dict.containsKey(arabic - arabic % 10)) {
                    romanNumber.append(dict.get(arabic - arabic % 10));
                    arabic = arabic % 10;
                }
                if (arabic >= 50) {
                    romanNumber.append(dict.get(50));
                    arabic -=50;
                }
                else {
                    if (arabic >= 10){
                        romanNumber.append(dict.get(10));
                        arabic -=10;
                    }
                }
            }
            while (arabic> 0) {
                if (dict.containsKey(arabic)) {
                    romanNumber.append(dict.get(arabic));
                    arabic = 0;
                }
                if (arabic >= 5) {
                    romanNumber.append(dict.get(5));
                    arabic -=5;
                }
                else {
                    if (arabic >= 1){
                        romanNumber.append(dict.get(1));
                        arabic -=1;
                    }
                }
            }
        }
        return romanNumber.toString();
        }
}