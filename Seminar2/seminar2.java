import java.util.Scanner;
import java.util.logging.Logger;;

public class seminar2 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getAnonymousLogger();
       
        int lengthString = 12;
        String c1 = "Fifth";
        String c2 = "Popularity";
        logger.info(NumLength(c1, c2, lengthString));
        String toZip = "aaabbbabbaabbb";
        logger.info(ZipString(toZip));
        String palindrome = "asdfghgfdsa";
        String notPalindrome = "asdfg";
        logger.info(Boolean.toString(IsPalindrome(palindrome)));
        logger.info(Boolean.toString(IsPalindrome(notPalindrome)));
        logger.info(Boolean.toString(CheckIfPalindrome(palindrome)));
        logger.info(Boolean.toString(CheckIfPalindrome(notPalindrome)));
    
    }

    public static String NumLength(String string1, String string2, int len) {

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < string1.length() || i < string2.length(); i++) {
            if (i < string1.length()) {
                answer.append(string1.charAt(i));
            }
            if (i < string2.length()) {
                answer.append(string2.charAt(i));
            }
        }
        return answer.substring(0, len);
    }
    
    public static String ZipString(String fullSize) {
        if (fullSize.length() <= 1)
            return fullSize;
        StringBuilder zipped = new StringBuilder();
        Integer counter = 1;
        Character current = fullSize.charAt(0);
        System.out.println(fullSize);
        for (int i = 1; i < fullSize.length(); i++) {
            if (fullSize.charAt(i) == current) {
                counter++;
            } else {
                zipped = zipped.append(counter.toString()).append(current.toString());
                counter = 1;
                current = fullSize.charAt(i);
            }
        }
        zipped = zipped.append(counter.toString()).append(current.toString());
        return zipped.toString();
    }

    public static boolean IsPalindrome(String strToCheck) {
        for (int i = 0; i < strToCheck.length() / 2; i++) {
            if (strToCheck.charAt(i) != strToCheck.charAt(strToCheck.length() - 1 - i)) {
                return false;
            }

        }
        return true;

    }

    public static boolean CheckIfPalindrome(String strToCheck) {
        StringBuilder strReverse = new StringBuilder(strToCheck).reverse();
        StringBuilder str = new StringBuilder(strToCheck);
        return str.toString().equals(strReverse.toString());
        
    }

}
