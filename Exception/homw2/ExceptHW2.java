import java.io.Console;
import java.util.logging.Logger;
import java.lang.Exception;

public class ExceptHW2 {
    /*Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
    2. Если необходимо, исправьте данный код (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
    
    Дан следующий код, исправьте его там, где требуется (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
    
    Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
    */
    
    public static void main(String[] args) {
        
        Logger logger = Logger.getAnonymousLogger();
        logger.info(returnFloat().toString());
        task2(1);
        task2(11);
    }

    public static Float returnFloat() {
        System.out.println("Input any float number: ");
        while (true) {
            try {
                Float number = Float.parseFloat(System.console().readLine());
                return number;
            } catch (Exception e) {
                System.out.println("Input a float number:");
            }
        }

    }
    

    public static void task2(int n) {
        try {
            Integer[] intArray = new Integer[n];
            int d = 0;

            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching OutOfBound: " + e);
        } catch (NullPointerException e) {
            System.out.println("Catching Null: ");
        } catch (Exception e) {
            System.out.println("Catching other staff: " + e);
        }
    }
    
    
}
