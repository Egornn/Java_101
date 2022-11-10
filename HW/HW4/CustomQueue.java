import java.util.LinkedList;
import java.util.logging.Logger;

public class CustomQueue {
    public static LinkedList<String> queue = new LinkedList<>();
    public static void main(String[] args) {
        
    }
    
    public static void enqueue(String element) {
        queue.add(element);
    }

    public static String dequeue() {
        String firstInQueue = queue.getFirst();
        queue.removeFirst();
        return firstInQueue;
    }
// LinkedList<String> queue
    public static String first() {
        return queue.getFirst();
    }

}

