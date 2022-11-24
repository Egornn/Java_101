package hw2;
import java.util.ArrayList;

public interface StudyGroupService {
    public StudyGroup generateStudyGroup(String teacherPath, String studentPath);
    
    ArrayList<String> getNames(String path);
    
    public void removeStudentByName (String name);
}
