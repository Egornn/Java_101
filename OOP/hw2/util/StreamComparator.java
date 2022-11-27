package util;

import hw2.Stream;


public class StreamComparator {
    // - Создать класс StreamComparator, реализующий сравнение количества групп входящих в Поток

    
    public static boolean compareStreams(Stream firstStream, Stream secondStream) {

        return (firstStream.listOfGroups.size() > secondStream.listOfGroups.size());

    }
    
    
}
