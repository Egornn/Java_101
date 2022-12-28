import java.io.Console;
import java.util.logging.Logger;
import java.lang.Exception;


public class Task3hw2 {
    
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) throws Exception {
        System.out.println(a + b);
    }
    
}
