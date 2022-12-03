
import java.util.List;

import HW4.*;

public class ExportCSV extends Task {
    public void exportStacktoCSV(TaskStack stack, String path) {
        List<String[]> list = new ArrayList<>();
        String[] oneTask = new String[7];
        String [] header= {"status", "id", "TaskName", "dateAdded", "timeAdded","Deadline", "Author"};
        list.add(header);
        for (Task task : stack) {
            oneTask[0]= task.priority;
            oneTask[1] = tasks.id;
            oneTask[2] = tasks.taskName;
            oneTask[3] = tasks.dateAdded.toString();
            oneTask[4] = tasks.timeAdded.toString();
            oneTask[5] = tasks.deadline.toString();
            oneTask[6] = tasks.authorName; 
        }
        list.add(oneTask);
        CSVWriter writer = new CSVWriter(new FileWriter(path));
        writer.write(list);
        
        
    }
}
