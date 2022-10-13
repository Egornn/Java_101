package Seminar1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.math.*;
import javax.swing.text.Position;



class sem1 {
    public static void main(String[] args) {

        System.out.println("Hello, world!");
        Date time = new Date();
        System.out.println(time);
        System.out.println(LocalDateTime.now());

        int[] array1 = new int[] { 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1 };

        Random rnd = new Random();
        int[] array2 = new int[10];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = rnd.nextInt(0, 2);
        }

        ArrayList<Integer> List1 = new ArrayList<>();
        List1.add(21);
        System.out.println(List1.get(0));

        int[][] twoD = new int[2][4];
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.deepToString(twoD));
        int counter = 0;
        int maximum = 0;
        for (int i : array1) {
            if (i == 1)
                counter++;
            else {
                if (counter > maximum)
                    maximum = counter;
                counter = 0;
            }
        }
        System.out.println(maximum);

        int[] nums = new int[] { 3, 2, 3, 3, 22, 3, 2, 3, 3 };

        int val = 3;
        int posit = nums.length - 1;
        System.out.println(rnd.nextDouble(0.1, 4.3));

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[posit] == val)
                posit--;
            else {
                for (int j = posit; j >= 0; j--) {
                    if (nums[j] == val) {
                        int temp = nums[j];
                        nums[j] = nums[posit];
                        nums[posit] = temp;
                        posit--;
                        break;
                    } else
                        continue;
                }
            }
        }
        System.out.println(Arrays.toString(nums));

        String someString = "Random rrr String";
        System.out.println(someString.charAt(4));
        someString = someString.replace("r", "some")
                .replace("R", "some");
        System.out.println(someString);
        String toReverse = "Welcome to Java coding";
        System.out.println(ReverseString(toReverse));
        String[] testSample = new String[] { "Ab", "Abs", "Absd", "Absko" };
        System.out.println(MaxCommonPrefix(testSample));
        System.out.println(longestCommonPrefix(testSample));
    }

    static public String ReverseString(String sentence) {
        String[] words = sentence.split(" ");
        String output = "";
        for (String word : words) {
            output = " "+word + output;
        }
        return output.trim();
    }


    static public String MaxCommonPrefix(String[] stringList) {
        String common = "";
        boolean flag = true;

        while (flag && common.length() < stringList[0].length()) {
            common += stringList[0].charAt(common.length());
            for (String str : stringList) {
                if (!str.startsWith(common))
                    flag = false;
            }
        }
        if (flag)
            return common;
        else
            return common.substring(0, common.length()-2);

    }
    
    static public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (var str : strs)
            // Возвращает целочисленное значение, указывающее начальную 
            // позицию строки в объекте String. 
            // Если строка не найдена, возвращается -1.
            while (str.indexOf(prefix) != 0) {
                // Начальная позиция подстроки не равна 0, 
                // затем подстрока сокращается, а затем сравнивается.
                prefix = prefix.substring(0, prefix.length() - 1); 
                if (prefix.isEmpty())
                    return "";
            }
        return prefix;
    }
    


}


