import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.event.InternalFrameEvent;

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String an = "F ";
        System.out.println(an);

        short age = 10;
        int salary = 12345;
        System.out.println(age);
        System.out.println(salary);

        float f = 123.45f;
        double d = 123.45d;
        System.out.println(f);
        System.out.println(d);

        char c = 262;
        System.out.println(c);

        int a = 12;
        double doa = a;
        System.out.println(doa);

        boolean x = true && false;
        System.out.println(x);

        boolean y = true ^ true;
        System.out.println(y);

        var ife = 123;
        System.out.println(ife);

        var varrr = 123.456;
        System.out.println(varrr);
        System.out.println(getType(varrr));

        int inta = 123_324;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(inta);

        Character.toUpperCase(c);
        System.out.println(c);

        String ss = "qwer";
        System.out.println(ss.charAt(1));

        a = 123;
        System.out.println(++a);

        int test = 0;
        test = test++ - ++test;
        System.out.println(test);

        boolean fn = 123 > 2;
        boolean ne = 123 != 4;
        System.out.println(fn);
        System.out.println(ne);
        
        int bit = 8;
        bit = bit << 1;
        System.out.println(bit);
        bit = 18;
        bit = bit >> 1;
        System.out.println(bit);

        int a1 = 6;
        int b1 = 2;
        System.out.println(a1 | b1);
        
        int a2 = 5;
        int b2 = 2;
        System.out.println(a2 & b2);

        
        int a3 = 7;
        int b3 = 2;
        System.out.println(a3 ^ b3);

        boolean st1 = true;
        boolean st2 = true;
        System.out.println(st2 & st1);
        System.out.println(st2 && st1);
        
        int[] array1 = new int[10];
        array1[5] = 56;
        System.out.println(array1[4]);
        System.out.println(array1[5]);

        int[] array2 = new int[] { 1, 23, 4, 5 };
        System.out.println(array2[2]);
        System.out.println(array1.length);

        int[][] array3 = new int[3][5];
        for (int i = 0; i < array3.length; i++) {
            for (int j = 0; j < array3[1].length; j++) {
                array3[i][j] = i + j;
            }
        }
        System.out.println(array3[2][4]);

        // Scanner iScanner = new Scanner(System.in);
        // System.out.printf("name:");
        // String name = iScanner.nextLine();
        // System.out.printf("Привет, %s!\n", name);
        // iScanner.close();

        // Scanner iScanner2 = new Scanner(System.in);
        // System.out.printf("number:");
        // boolean flag = iScanner2.hasNextInt();
        // System.out.println(flag);
        // int consoleNum = iScanner2.nextInt();
        // System.out.printf("Привет, %s!\n", consoleNum);
        // iScanner2.close();

        String str1 = "qwe";
        int num2 = 2;
        String q = str1 + num2;
        System.out.println(q);

        a = 1;
        int b = 2;
        int a_b = a + b;
        String resr = String.format("%d + %d = %d \n", a, b, a_b);
        System.out.println(resr);
        float refe = a_b;
        System.out.printf("%.2f\n",refe);
        
        System.out.println(sumtwo(a, b));
        
        int mini = a < b ? a : b;
        System.out.println(mini);

        int caseSwitch = 4;
        String text = "";
        switch (caseSwitch) {
            case 1:
                System.out.println("A");
                break;
            case 2:
                System.out.println(text);
                break;
            case 3:
            case 4:
                System.out.println(" Last");
                break;
            default:
                System.out.println("Error");
                break;
        }

        int valuer = 321;
        int count = 0;
        while (valuer != 0) {
            valuer /= 10;
            count++;
        }
        System.out.println(count);
        valuer=1234;
        do {
            valuer/=10;
            count++;
        } while (valuer!=0);
        System.out.println(count);

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }
        
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                break;
            }
            System.out.println(i);
        }
        
        int[] array4 = new int[] { 1, 2, 3, 4, 5, 32, 4, 4 };
        for (int item : array4) {
            System.out.println(item);
        }








    }

    static String getType(Object o) {
        return o.getClass().getSimpleName();
    }

    static public int sumtwo(int a, int b) {
        return a + b;
    }
}
