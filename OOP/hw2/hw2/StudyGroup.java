package hw2;
import util.StudyGroupIterator;
import java.util.ArrayList;
import java.util.Iterator;

import util.StudyGroupIterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudyGroup extends StudyGroupIterator implements StudyGroupService, Iterable{
    private ArrayList<Student> students  =new ArrayList<>();
    private Teacher lecturer = new Teacher();

    public StudyGroup() {
        ArrayList<Student> emp = new ArrayList<>();
        emp.add(new Student());
        this.lecturer =new Teacher();
        this.students = emp;
    }
    
    protected StudyGroup(String teacher, ArrayList<String> students) {
        Student studentOd = new Student();
        for (String studentName : students) {
            studentOd = new Student(studentName);
            this.students.add(studentOd);
        }
        if (this.students.size() == 0) {
            this.students.add(studentOd);
        }
        this.lecturer = new Teacher(teacher);

    }
    @Override
    public void removeStudentByName(String removed) {
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).name.equals(removed)) {
                this.students.remove(i--);
            }
            
        }
        
    }
    @Override
    public StudyGroup generateStudyGroup(String teacherPath, String studentPath) {
        String teacherName = getNames(teacherPath).get(0);
        
        ArrayList<String> studentArrayList = getNames(studentPath);
        System.out.println(studentArrayList.get(0));
        return new StudyGroup(teacherName, studentArrayList);
    }
    @Override
    public ArrayList<String> getNames(String path) {
        ArrayList<String> names = new ArrayList<>();
        BufferedReader reader;
        try{
        reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        while (line != null) {
            names.add(line);
            line = reader.readLine();
        }
        reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (names.size() == 0) {
            names.add("");
        }
        return names;
    }
    @Override
    public String toString() {
        StringBuilder toStirngBuilder = new StringBuilder();
        toStirngBuilder.append(String.format("Teacher is %S. ", this.lecturer));
        toStirngBuilder.append(String.format("Students are "));
        for (int i = 0; i < this.students.size() - 1; i++) {
            toStirngBuilder.append(String.format("%s, ", this.students.get(i)));
        }
        if (this.students.size() == 0) {
            toStirngBuilder.append("not presented.");
            return toStirngBuilder.toString();
        }
        toStirngBuilder.append(String.format("%s.", this.students.get(this.students.size() - 1)));
        return toStirngBuilder.toString();

    }
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return (super.humanInd <= this.students.size());
    }

    @Override
    public Human next() {
        // TODO Auto-generated method stub
        
        if (super.humanInd == this.students.size()) {
            super.humanInd++;
            return lecturer;
        }    
        
        return this.students.get(super.humanInd++);
    }
   

    @Override
    public Iterator<Human> iterator() {
        ArrayList<Human> human = new ArrayList<>();
        human.addAll(this.students);
        human.add(lecturer);
        Iterator<Human> iter = human.iterator();
        // TODO Auto-generated method stub
        return iter;

    }
   
    @Override
        public void remove() {
            // TODO Auto-generated method stub
            if (super.humanInd < this.students.size()) {
                this.students.remove((int) super.humanInd);
            }
            else if (super.humanInd == this.students.size()){
                this.lecturer = new Teacher();
            }
        }
   
}
