import java.util.logging.Logger;
    

public class main3 {
    public static void main(String[] args) {

    Logger logger = Logger.getAnonymousLogger();
    StudyGroup myNewGroup =new StudyGroup();
    myNewGroup= myNewGroup.generateStudyGroup("C:/Users/Егор/Documents/Java/OOP/hw2/teacher.txt","C:/Users/Егор/Documents/Java/OOP/hw2/students.txt");
    logger.info(myNewGroup.toString());

}
}