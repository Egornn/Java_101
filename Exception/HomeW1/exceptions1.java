import java.util.Arrays;
import java.util.logging.Logger;
import java.lang.Exception;

public class exceptions1 {
    


        
        
         public static void main(String[] args) {
            // Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
            Logger logger = Logger.getAnonymousLogger();
 
            logger.info(methodOne(1, 0));
            logger.info(methodTwo(12, "myCuteUwU0"));
            logger.info(methodThree(123, null));

            // Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
            int intArray[] = new int[3];
            taskTwo(intArray);
            intArray = new int[10];
            taskTwo(intArray);
            // ?? In theory intArray could be a very poorly named String array

            //Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
            //и возвращающий новый массив, каждый элемент которого равен разности элементов 
            //двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.

            int[] one = { 1, 2, 3, 0 };
            int[] two = { 2, 3, 0, 8 };
            int[] three = { 2, 3, 4, 5, 6, 6 };
            logger.info(Arrays.toString(pairedSub(one, two)));
            logger.info(Arrays.toString(pairedSub(one, three)));

            // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
            //и возвращающий новый массив, каждый элемент которого равен частному элементов 
            //двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо 
            //как-то оповестить пользователя. Важно: При выполнении метода единственное исключение,
            // которое пользователь может увидеть - RuntimeException, т.е. ваше
            
            logger.info(Arrays.toString(pairedDiv(one, two)));
            logger.info(Arrays.toString(pairedDiv(one, three)));

            // 5*
        // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
        //и возвращающий новый массив, каждый элемент которого равен сумме элементов двух входящих массивов в той же ячейке. 
        //Если длины массивов не равны, необходимо как-то оповестить пользователя.
            logger.info(Arrays.toString(pairedSum(one, two)));
            logger.info(Arrays.toString(pairedSum(one, three)));

            // 6*
        // Реализуйте метод, принимающий в качестве аргументов двумерный массив. 
        //Метод должен проверить что длина строк и столбцов с одинаковым индексом одинакова, 
        //детализировать какие строки со столбцами не требуется. Как бы вы реализовали подобный метод.
        int[][] twoDimOne = new int[3][4];
        int[][] twoDimTwo = new int[4][2];
        twoDimOne[1][2] = 1;
        twoDimTwo[0][1] = 2;
        
        logger.info(isSame(twoDimOne, twoDimTwo).toString(false));
         
        
        }

        public static int[] pairedSub(int[] first, int[] second) {
            if (first.length != second.length) {
                int[] error = new int[1];

                error[0] = -1;
                System.out.println("different length");
                return error;
            }
            int[] sum = new int[first.length];
            for (int i = 0; i < sum.length; i++) {
                sum[i] = first[i] - second[i];

            }
            return sum;

        }
        
        public static int[] pairedSum(int[] first, int[] second) {
            if (first.length != second.length) {
                int[] error = new int[1];

                error[0] = -1;
                System.out.println("different length");
                return error;
            }
            int[] sum = new int[first.length];
            for (int i = 0; i < sum.length; i++) {
                sum[i] = first[i] + second[i];

            }
            return sum;

        }

        public static Boolean isSame(int[][] first, int[][] second) {
            var transposedFirst = transpose(first);
            var transposedSecond = transpose(second);
            var minimal = Integer.min(first.length,
                    Integer.min(second.length, Integer.min(first[0].length,second[0].length)));
            for (int i = 0; i < minimal; i++) {
                if (first[i].length != second[i].length || transposedFirst[i].length != transposedSecond[i].length) {
                    return false;
                }

            }
            return true;
        }
            
        public static int[] pairedDiv(int[] first, int[] second) {
            try {
                int size = Integer.max(first.length, second.length);
                int[] sum = new int[size];
                for (int i = 0; i < sum.length; i++) {
                    sum[i] = first[i] / second[i];

                }
                return sum;

            } catch (Exception e) {
                System.out.println(e.getMessage());
                int[] error = new int[1];
                error[0] = -1;
                return error;
            }
        }
            
            

            public static String methodOne(Integer a, Integer b) {
                try {
                    Float result = a.floatValue() / b.floatValue();
                    return result.toString();
                } catch (Exception e) {
                    return e.getMessage();

                }
            }

            public static String methodTwo(Integer a, String b) {
                try {
                    Float result = a.floatValue() / Integer.parseInt(b);
                    return result.toString();
                } catch (Exception e) {
                    return e.getMessage();

                }
            }

            
            public static String methodThree(Integer a, String b) {
                try {
                    Float result = a.floatValue() / Integer.parseInt(b);
                    return result.toString() ; 
                } catch (Exception e) {
                    return e.getMessage();
        
                }
            }

            public static void taskTwo(int[] intArray) {
                try {
                    int d = 0;
                    double catchedReel = intArray[8] / d;
                    System.out.println("CatchedReel = " + catchedReel);
                } catch (Exception e) {
                    System.out.println("catched exception: " + e);
                }

            }
        
            public static int[][] transpose(int[][] matrix) {
                int[][] transposed = new int[matrix[0].length][matrix.length];
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        transposed[j][i] = matrix[i][j];
                    }

                }
                return transposed;
            }
}
