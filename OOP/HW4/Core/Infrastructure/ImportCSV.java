import java.util.Stack;

import HW4.*;

public class ImportCSV {
    public void readCSV(Stack<E> stack, String path) {
        BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII);
        String line = br.readLine();

        while (line != null) {
            String[] attributes = line.split(",");
            
            Task newTask = Task(Integer.parseInt(attributes[1]), attributes[2], attributes[3], attributes[4], attributes[5],
                    attributes[6], attributes[0]);
            stack.addTask(newTask);
            if (attributes[0].contains("Completed")) {
                
                stack.completeTask(Integer.parseInt(attributes[1]));
            }
        }

    }
   
    
}
