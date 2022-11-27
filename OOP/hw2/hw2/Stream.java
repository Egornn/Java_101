package hw2;
import hw2.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Stream implements Iterable{
    public ArrayList<StudyGroup> listOfGroups = new ArrayList<>();
    
    public Stream(ArrayList<StudyGroup> groups) {
        for (StudyGroup study : groups) {
            this.listOfGroups.add(study);
        }
    }

    @Override
    public Iterator iterator() {
        // - Создать класс Поток содержащий в себе список УчебныхГрупп и реализующий интерфейс Iterable
        Iterator<StudyGroup> iter = this.listOfGroups.iterator();
        return iter;
    }
    
    @Override
    public String toString() {

        StringBuilder text = new StringBuilder();
        for (StudyGroup studyGroup : this.listOfGroups) {
            text.append(studyGroup.toString() + " ");
            
        }
        return text.toString();
    }

    public static String arrayTostring(Stream[] array) {
        
        StringBuilder text = new StringBuilder();
        text.append("Stream is [");
        int i = 0;
        for (Stream stream : array) {
            text.append(i+++" "+stream.toString() + " ");
        }

        text.append("].");
        return text.toString();

    }
}
