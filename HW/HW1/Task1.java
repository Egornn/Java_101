import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.event.SwingPropertyChangeSupport;

import java.util.*;

public class Task1 {

    public static void main(String[] args) {
        //FindFactorial(args);
        // TriangleNumber(5);
        // PrimeRange(1, 1000);
        // float a = 4.43f;
        // float b = 2.57f;
        // System.out.println(Calc(a, b, "+"));
        // System.out.println(Calc(a, b, "/"));
        // System.out.println(Calc(a, b, "**"));
        String equation = "1? + ?? = 33";
        System.out.println( equation+" -> "+ FillTheGaps(equation));
    }

    public static float Calc(float a, float b, String oper) {
        switch (oper) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    System.out.println("Division by zero");
                    return 0f;
                }
                else
                    return a / b;
            case "**":
                return (float) Math.pow(a, b);
        }
        return 0f;
    }


    public static void TriangleNumber(int n) {
        System.out.println((n) * (n + 1)/2);               
    }

    public static void FindFactorial(String[] args) {
        Map<Integer, Integer> fact = new HashMap<Integer, Integer>();
        Scanner iScanner = new Scanner(System.in);
        int n = iScanner.nextInt();
        iScanner.close();
        System.out.println(factorial(n, fact));
    }
    
    public static int ObjectToInt(Object num) {
        int answer = ((Number) num).intValue();
        return answer;
    }
    

    
    public static int factorial(int n, Map fact) {
        if (n == 1 || n == 0) {
            fact.put(1, 1);
            return ObjectToInt(fact.get(1));
        }
        return n * factorial(n - 1, fact);
    }
        
    public static void PrimeRange(int low, int up) {
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = low; i < up + 1; i++) {
            long upperDiv = Math.round((Math.sqrt(i)));
            boolean flag = true;
            for (int j = 2; j < upperDiv + 1; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                output.add(i);

            flag = true;

        }
        if (output.get(0) == 1)
            output.remove(0);

        System.out.println(output.toString());
    }
    
    public static String FillTheGaps(String eq) {
        int numOfQue = eq.split("\\?").length - 1;
        System.out.println(numOfQue);
        String answer = CheckOneQue(eq, numOfQue);        

        return answer;

    }
    
    public static String CheckOneQue(String eq, int num) {
        String sol = "No solution";
        if (num == 1) {
            for (int i = 0; i < 10; i++) {
                String temp=eq.replaceFirst("\\?", String.valueOf(i));
                String[] words = temp.split("[+=]");
                for (int j = 0; j < words.length; j++) {
                    words[j] = words[j].trim();
                }
                if (Integer.parseInt(words[0]) + Integer.parseInt(words[1]) == Integer.parseInt(words[2]))
                    return temp;
            }
            return "No solution";
        }
        else {

            for (int i = 0; i < 10; i++) {
                String recursive = CheckOneQue(eq.replaceFirst("\\?", String.valueOf(i)), num - 1);
                if (sol != recursive)
                    return recursive;
            }
            
        }
        return "None";
    }
}
