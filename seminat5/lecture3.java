import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class lecture3 {

    public static void main(String[] args) {

        Logger logger = Logger.getAnonymousLogger();

        var startTime = System.nanoTime();

        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        logger.info(String.valueOf(ll));
        Queue<Integer> queue = new LinkedList<Integer>();
        logger.info(String.valueOf(System.nanoTime() - startTime));
        QueueHandler();
    }

    public static void QueueHandler() {
        Logger logger = Logger.getAnonymousLogger();
        Scanner scanner = new Scanner(System.in);
        List<String> dataList = new ArrayList<>();
        while (true) {
            String nextline = scanner.nextLine();
            String[] newLine = nextline.split("~");
            switch (newLine[0]) {
                case "add":
                    dataList.add(String.valueOf(newLine[0]));
                    
                    break;

                case "print":
                    for (int index = 0; index < Integer.parseInt(newLine[1]); index++) {
                        dataList.add(String.valueOf(newLine[0]));
                    }
                    logger.info(String.valueOf(dataList));
                    break;
                case "remove":
                logger.info(String.valueOf(dataList.remove(Integer.parseInt(newLine[1]) - 1)));
                logger.info(String.valueOf(dataList));
                break;       
            }

        }
    }
}