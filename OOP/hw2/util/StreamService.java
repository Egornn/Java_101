package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import hw2.*;
import util.*;

public class StreamService extends StreamComparator{
    // - Создать класс ПотокСервис, добавив в него метод сортировки списка потоков, используя созданный StreamComparator
    public Stream[] streamNames;

    public StreamService(Stream[] stream) {
        this.streamNames = stream;
    }

    public void sortStreams() {

        int minInd = 0;
        for (int i = 0; i < this.streamNames.length - 1; i++) {
            for (int j = i + 1; j < this.streamNames.length; j++) {
                if (compareStreams(this.streamNames[(minInd)], this.streamNames[(j)])) {
                    minInd = j;
                }
            }
            var temp = this.streamNames[(minInd)];
            this.streamNames[minInd] = this.streamNames[i];
            this.streamNames[i] = temp;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder streams = new StringBuilder();

        for (Stream stream : streamNames) {
            streams.append(stream.toString());
        }
        return streams.toString();
    }
}
