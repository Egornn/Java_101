import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class Task4 {

    public static void main(String[] args) {

        LinkedList<String> cars = new LinkedList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        logger.info(String.valueOf(cars));
        logger.info(String.valueOf(ReverseLinkedList(cars)));

        CustomQueue testQueue = new CustomQueue();

        testQueue.enqueue("Volvo");
        testQueue.enqueue("BMW");
        logger.info(String.valueOf(testQueue.first()));
        logger.info(String.valueOf(testQueue.dequeue()));
        logger.info(String.valueOf(testQueue.first()));

        String infixEquation = "4+3*5-4/5-2+4";
        logger.info(InfixToPostix(infixEquation));
        
        Calculator();

    }

    public static LinkedList<String> ReverseLinkedList(LinkedList<String> normalList) {
        LinkedList<String> reverseLinkedList = new LinkedList<>();
        int size = normalList.size();
        for (int i = 0; i < normalList.size(); i++) {
            reverseLinkedList.add(normalList.get(size - i - 1));
        }
        return reverseLinkedList;
    }

    //  Не уверен, что до конца понял задание, но чтобы был смысл вытащить прошлый результат, сделал цепной калькулятор. 2+3 =5 -> 5*3 = 15 -> 15-4=11...
    public static void Calculator() {
        Scanner sc = new Scanner(System.in);
        logger.info("Input the first number");
        Double numberOne = sc.nextDouble();
        logger.info("Input the operator");
        String operator = sc.next();
        logger.info("Input the second number");
        Double numberTwo = sc.nextDouble();
        listOfResults.add(0d);
        numberOne = Calc(numberOne, numberTwo, operator);
        logger.info("Running total = " + String.valueOf(numberOne));
        while (true) {
            logger.info("Input the next operator ('reverse' to reverse to the previous result)");
            operator = String.valueOf(sc.next());
            if (operator.equals("reverse")) {
                logger.info(
                        String.valueOf("Reversed to the previous result = " + String.valueOf(listOfResults.getLast())));
                listOfResults.removeLast();
            } else {
                logger.info("Input the next number");
                numberTwo = sc.nextDouble();
                listOfResults.add(numberOne);
                numberOne = Calc(numberOne, numberTwo, operator);
                logger.info("Running total = " + String.valueOf(numberOne));
            }

        }

    }

    public static Logger logger = Logger.getAnonymousLogger();
    public static LinkedList<Double> listOfResults = new LinkedList<>();

    public static Double Calc(Double a, Double b, String oper) {
        switch (oper) {
            case "+": {
                logger.info(String.valueOf(a + b));

                return a + b;
            }
            case "-": {
                logger.info(String.valueOf(a - b));
                return a - b;
            }
            case "*": {
                logger.info(String.valueOf(a * b));
                return a * b;
            }
            case "/":
                if (b == 0) {
                    System.out.println("Division by zero");
                    return 0d;
                } else {
                    logger.info(String.valueOf(a / b));
                    return a / b;
                }
            case "**":
                return (Double) Math.pow(a, b);
        }
        return 0d;
    }

    public static String InfixToPostix(String infixEquation) {
        String[] operators = { "+", "-", "*", "/", "(", ")" };
        for (String operator : operators) {
            infixEquation = infixEquation.replace(operator, " " + operator + " ");

        }
        String[] infixEquationList = infixEquation.split(" ");
        LinkedList<String> infixEquationLinked = new LinkedList<>();
        for (String element : infixEquationList) {
            infixEquationLinked.add(element);
        }
        String postfixEquation = InfixToPostfixList(infixEquationLinked).getFirst();
        return (postfixEquation);
    }

    public static LinkedList<String> InfixToPostfixList(LinkedList<String> infixLinkedList) {
        if (infixLinkedList.size() <= 1) {
            return infixLinkedList;
        }
        for (int i = 0; i < infixLinkedList.size(); i++) {
            if (String.valueOf(infixLinkedList.get(i)).equals("(")) {
                LinkedList<String> sublistInBrackets = new LinkedList<>();

                int indexSublistInBrackets = i + 1;
                int startingNode = indexSublistInBrackets;
                //3+(4*(5+5)*3) -> start= 2, index=5 -> beacket into 2, remove 3,4,5,6 -> 5-2+1=index-start+1

                for (int indexBrackets = 0; indexBrackets < infixLinkedList.size(); indexBrackets++) {
                    if (infixLinkedList.get(indexBrackets).equals("(")) {
                        int indexOpenBracket = indexBrackets;
                        int diffOpenCloseBrackets = 1;
                        int indexCloseBracket = indexOpenBracket;
                        while (diffOpenCloseBrackets > 0) {
                            indexCloseBracket += 1;
                            if (infixLinkedList.get(indexCloseBracket).equals("(")) {
                                diffOpenCloseBrackets += 1;
                            }
                            if (infixLinkedList.get(indexCloseBracket).equals("(")) {
                                diffOpenCloseBrackets -= 1;
                            }
                        }
                        LinkedList<String> newValue = new LinkedList<>();
                        for (int j = indexOpenBracket + 1; j < indexCloseBracket; j++) {
                            newValue.add(infixLinkedList.get(j));
                        }
                        infixLinkedList.set(indexOpenBracket, InfixToPostfixList(newValue).get(0));
                        for (int j = indexOpenBracket + 1; j < indexCloseBracket; j++) {
                            infixLinkedList.remove(j);
                        }
                    }

                }

                // while (!infixLinkedList.get(indexSublistInBrackets).equals(")")) {
                //     if (infixLinkedList.get(indexSublistInBrackets).equals("(")) {
                //         sublistInBrackets.add(InfixToPostfixList(infixLinkedList)
                //                 .subList(indexSublistInBrackets + 1, infixLinkedList.size()).get(0));

                //     } else {
                //         sublistInBrackets.add(infixLinkedList.get(indexSublistInBrackets));

                //     }

                //     indexSublistInBrackets += 1;
                // }
                infixLinkedList.set(i, InfixToPostfixList(sublistInBrackets).get(0));
                for (int j = 0; j < indexSublistInBrackets - startingNode + 1; j++) {
                    infixLinkedList.remove(i + 1);
                }
            }

            for (int ind = 0; ind < infixLinkedList.size(); ind++) {
                if (String.valueOf(infixLinkedList.get(ind)).equals("*")
                        || String.valueOf(infixLinkedList.get(ind)).equals("/")) {
                    infixLinkedList.set(ind,
                            infixLinkedList.get(ind - 1) + infixLinkedList.get(ind + 1) + infixLinkedList.get(ind));
                    infixLinkedList.remove(ind + 1);
                    infixLinkedList.remove(ind - 1);
                    ind = ind - 2;
                }

            }
            for (int indx = 0; indx < infixLinkedList.size(); indx++) {
                if (String.valueOf(infixLinkedList.get(indx)).equals("+")
                        || String.valueOf(infixLinkedList.get(indx)).equals("-")) {
                    infixLinkedList.set(indx,
                            infixLinkedList.get(indx - 1) + infixLinkedList.get(indx + 1) + infixLinkedList.get(indx));
                    infixLinkedList.remove(indx + 1);
                    infixLinkedList.remove(indx - 1);
                    indx = indx - 2;
                }

            }

        }
        return infixLinkedList;
    }

    //Задача с семинара по переводу чисел в Римские
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
    
    //Реализуйте очередь с помощью LinkedList со следующими методами:enqueue() - помещает элемент в конец очереди, dequeue() - 
    //возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя

    /**
     * CustomQueue
     */
