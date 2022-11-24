import java.util.Iterator;
import java.util.logging.Logger;

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

        removeStudent(myNewGroup,"Ivan Ivanov");

        logger.info(myNewGroup.toString());

    }
    
    public static void removeStudent(StudyGroup myNewGroup, String name) {
        myNewGroup.removeStudentByName(name);

    }
}

// - Создать класс УчебнаяГруппаИтератор, заставив его реализовать интерфейс Iterator
// - Реализовать его контракты (включая удаление)
/*- Модифицировать класс УчебнаяГруппа, заставив его реализовать интерфейс Iterable
- Реализовать метод iterator() возвращающий экземпляр созданного нами итератора
- Модифицировать класс УчебнаяГруппаСервис, добавив в него метод удаления студента по ФИО
- Модифицировать класс Контроллер, добавив в него метод удаления студента и вызывать в нем созданный метод из УчебнаяГруппаСервис
 */
