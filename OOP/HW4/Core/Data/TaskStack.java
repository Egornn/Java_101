package HW4.Core.Data;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Box.Filler;

public class TaskStack extends Task implements StackControl {
    private ArrayList<Task> stackCompleted = new ArrayList<>();
    private ArrayList<Task> stack = new ArrayList<>();
    private static String[] priorities = { "Unspecified", "Low", "Medium", "High" };

    public TaskStack() {

    }

    private void changeProirity(Task task, Integer newP) {
        task.priority = priorities[i];
    }

    @Override
    public void addTask(String taskName, String author, Date deadline, Integer prioritiy) {

        this.stack.add(Task(taskName, Task.totalId++, LocalDate.now().toString(), LocalTime.now().toString(), deadline,
                author, priorities[priority]));

    }

    @Override
    public void addTask(Task task) {
        this.stack.add(task);
    }
    
    @Override
    public void changePriority(Integer id, Integer newPiority) {
        for (Task task : this.stack) {
            if (task.id = id) {
                task.priority = priorities[i];
            }
            
        }
        

        
    }

    @Override
    public void completeTask(Integer id) {
        for (Task task : this.stack) {
            if (task.id = id) {
                this.stackCompleted.add(task);
                this.stack.remove(task);
                task.priority = task.priority + " Completed";          
            }
            
        }
    }
    

    @Override
    public String toString() {
        StringBuilder fullStack = new StringBuilder();
        for (Task task : this.stack) {
            fullStack.append(task.toString);
        }
        for (Task completed : this.stackCompleted) {
            fullStack.append(String.format("%s", completed.toString()));
        }
        return fullStack.toString();
        
    }


}
