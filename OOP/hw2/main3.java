import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Logger;

import org.w3c.dom.TypeInfo;

import util.*;
import hw2.*;
import hw2.Human;
import hw2.StudyGroup;

public class Main3 {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        StudyGroup myNewGroup = new StudyGroup();
        myNewGroup = myNewGroup.generateStudyGroup("C:/Users/Егор/Documents/Java/OOP/hw2/teacher.txt",
                "C:/Users/Егор/Documents/Java/OOP/hw2/students.txt");
        logger.info(myNewGroup.toString());

        int i = 0;
        for (Object object : myNewGroup) {
            Human someHuman = (Human) object;
            logger.info(someHuman.toString());
        }

        while (myNewGroup.hasNext()) {

            if (i++ == 3) {
                myNewGroup.remove();
            }
            logger.info("While " + myNewGroup.next().toString());
        }
        logger.info(myNewGroup.toString());

        removeStudent(myNewGroup, "Ivan Ivanov");

        logger.info(myNewGroup.toString());


        StudyGroup myNewGroup2 =         myNewGroup = myNewGroup.generateStudyGroup("C:/Users/Егор/Documents/Java/OOP/hw2/teacher2.txt",
        "C:/Users/Егор/Documents/Java/OOP/hw2/students2.txt");
        StudyGroup myNewGroup3=         myNewGroup = myNewGroup.generateStudyGroup("C:/Users/Егор/Documents/Java/OOP/hw2/teacher3.txt",
                "C:/Users/Егор/Documents/Java/OOP/hw2/students3.txt");
        
        
                // New staff Homework
        ArrayList <StudyGroup> firstGroup =new  ArrayList<>(Arrays.asList(myNewGroup,myNewGroup2,myNewGroup3));
        ArrayList <StudyGroup> secondGroup =new  ArrayList<>(Arrays.asList(myNewGroup,myNewGroup3));
        ArrayList <StudyGroup> thirdGroup =new  ArrayList<>(Arrays.asList(myNewGroup3));
        Stream firstStream = new Stream(firstGroup);
        Stream secondStream = new Stream(secondGroup);
        Stream thirdStream = new Stream(thirdGroup);
        
        Stream [] toSort = {firstStream, secondStream, thirdStream};
        logger.info("\n\nUnsorted \n");
        
        logger.info(Stream.arrayTostring(toSort));
        sortStream(toSort);
        
        
        logger.info("\n\nSorted \n");
        logger.info(Stream.arrayTostring(toSort));

    }

    public static void removeStudent(StudyGroup myNewGroup, String name) {
        myNewGroup.removeStudentByName(name);

    }

    public static Stream[] sortStream(Stream[] streamsToSort) {
        StreamService streamList = new StreamService(streamsToSort);
        streamList.sortStreams();
    
        return streamList.streamNames;

    }
}

// - Создать класс Поток содержащий в себе список УчебныхГрупп и реализующий интерфейс Iterable
// - Создать класс StreamComparator, реализующий сравнение количества групп входящих в Поток
// - Создать класс ПотокСервис, добавив в него метод сортировки списка потоков, используя созданный StreamComparator
// - Модифицировать класс Контроллер, добавив в него созданный сервис
// - Модифицировать класс Контроллер, добавив в него метод сортирующий список потоков, путем вызова созданного сервиса
