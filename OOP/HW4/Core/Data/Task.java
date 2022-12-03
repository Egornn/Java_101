package HW4.Core.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Task {
    private String taskName;
    private Integer id;
    private String dateAdded;
    private String timeAdded;
    private String deadline;
    private String authorName;
    private String priority;
    private static Integer totalId = 0;

    private Task(String taskName, Integer id, String dateAdded, String timeAdded, String deadline, String authorName,  String priority) {
        this.taskName = taskName;
        this.id = id;
        this.dateAdded = dateAdded;
        this.timeAdded = timeAdded;
        this.deadline = deadline;
        this.authorName = authorName;
        this.priority = priority;
        totalId++;
    }
    private Task() {
        this.id = totalId++;
        this.timeAdded = LocalTime.now().toString();
        this.dateAdded = LocalDate.now().toString();
        this.authorName = "Anonymous author";
    }
    private Task(String author) {
        this.id = totalId++;
        this.timeAdded = LocalTime.now().toString();
        this.dateAdded = LocalDate.now().toString();
        this.authorName = author;
    }

    private Task(String author, String deadline) {
        this.id = totalId++;
        this.timeAdded = LocalTime.now().toString();
        this.dateAdded = LocalDate.now().toString();
        this.authorName = author;
        this.deadline = deadline;
    }

    private setDeadline(String deadline){
        this.deadline=deadline;
    }

    private Integer getID() {
        return this.id;
    }
    
    private boolean checkID(Integer id) {
        return this.id == id;
    }
    
    @Override
    public String toString() {
        StringBuilder taskstring = new StringBuilder();
        taskstring.append(this.priority);
        taskstring.append(String.format("ID= %s, ", this.id.toString()));
        taskstring.append(String.format("Task Name= %s, ", this.taskName));
        taskstring.append(String.format("Date Added= %s, ", this.dateAdded.toString()));
        taskstring.append(String.format("Time Added= %s, ", this.timeAdded.toString()));
        taskstring.append(String.format("Author= %s, ", this.authorName));
        taskstring.append(String.format("Deadline= %s, ", this.deadline.toString()));
        
        return taskstring.toString(); 
    }
}
