import java.io.File;
import java.lang.System.Logger;
import java.util.logging.*;

public class Lect2 {
    public static void main(String [] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            sb.append("+");
        }

    

    String str1 = "Abcbc";
    String str2 = "def";
    System.out.println(str1.concat(str2));
    System.out.println(String.valueOf(123));
    System.out.println(String.join("\'", str1, str2));
    System.out.println(str1.charAt(1));
    System.out.println(str1.indexOf("bc"));
    System.out.println(str1.lastIndexOf("bc"));
    System.out.println(str1.startsWith("ab"));
    System.out.println(str1.endsWith("bc"));
    System.out.println(str1.replace("bc", "fd"));
    System.out.println(("     "+str1).trim());
    System.out.println(str1.substring(1, 3));
    System.out.println(str1.toUpperCase());
    System.out.println(str1.toLowerCase());
    System.out.println(str1.compareTo(str2));
    System.out.println(str1.equals("abCbc"));
    System.out.println(str1.equalsIgnoreCase("abCbc"));
    System.out.println(str1.regionMatches(true, 0, "labcbc", 1, 4));
    
    String[] name = { "E", "g", "o", "r" };
    String sk = "Egor";
    System.out.println(sk.toLowerCase());
    System.out.println(String.join("", name));

    String projectPath = System.getProperty("user.dir"); 
    String pathFile = projectPath.concat("/name.txt");
    File txt = new File(pathFile);
    System.out.println(txt.getAbsolutePath());
    try {
        String projectPathf = System.getProperty("user.dir f"); 
        String pathFilef = projectPathf.concat("/name.txt");
        File txtf = new File(pathFilef);
        System.out.println(txtf.getAbsolutePath());
        
    } catch (Exception e) {
        System.out.println("catch");
    }
    finally {
        System.out.println("finally");
    }
    
    System.out.println(txt.isHidden());
    System.out.println(txt.length());
    System.out.println(txt.lastModified());
    System.out.println(txt.list());
    System.out.println(txt.listFiles());
    System.out.println(txt.mkdir());
    System.out.println(txt.renameTo(txt));
    
    //Logger logger = Logger.getLogger(Lect2.class.getName());
    //Logger log = Logger.getLogger(Lect2.class.getName());






    
}
}
