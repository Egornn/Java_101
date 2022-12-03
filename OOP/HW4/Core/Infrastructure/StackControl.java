package HW4.Core.Infrastructure;

import HW4.Core.Data;

public interface StackControl {
    public void addTask(String taskName,String author, Date deadline, Integer prioritiy);
    public void changePriority (Integer id, Integer newPiority);

    public void addTask(Task task);
    public void completeTask(Integer id);
    
}
