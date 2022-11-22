import java.util.ArrayList;

public interface StudyGroupService {
    public StudyGroup generateStudyGroup(String teacherPath, String studentPath);
    
    abstract ArrayList<String> getNames(String path);
}
