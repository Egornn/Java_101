package HW5.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

import HW5.model.*;
import HW5.model.contact.Contact;
import HW5.model.phonebook.Phonebook;

public class ExportToF {

    public static void ExportToFile(Phonebook book, String path, String format) {
        try {
            File myObj = new File(path);
            myObj.delete();
        } finally {
            StringFormating(book, path, format);

        }
    }

    private static void StringFormating(Phonebook book, String path, String format) {
        try {
            FileWriter myWriter = new FileWriter(path);
        
            var contacts = book.getContacts();
            switch (format) {
                case "No Format":
                    try {
                        for (int i = 0; i < contacts.size(); i++) {
                            String line = contacts.get(i).toString();
                            line = line.replace("[", "");
                            line = line.replace("]", "");
                            if (i == contacts.size()-1) {
                                myWriter.write(line);
                            }
                            else {
                                myWriter.write(line + "\n");
                            }
                        }
                        myWriter.close();
                    } catch (Exception e) {
                        System.out.println("Export error");
                        ;
                    }
                    break;
                    case "International Format":
                    try {
                        for (int i = 0; i < contacts.size(); i++) {
                            String line = contacts.get(i).toString();
                            
                            line = line.replace("[", "");
                            line = line.replace("]", "");
                            String[] everything = line.split(" ");
                            
                            StringBuilder convertedLine = new StringBuilder();
                            convertedLine.append(everything[0] + " " + everything[1]+" "+ everything[2]+" ");
                            for (int j = 3; j < everything.length; j++) {
                                String phone = " +7-" + everything[j].substring(1);
                                convertedLine.append(phone);
                            }
                            if (i == contacts.size() - 1) {
                                myWriter.write(convertedLine.toString());
                            }
                            else {
                                myWriter.write(convertedLine.toString() + "\n\n");
                        }
                        }
                        myWriter.close();
                    } catch (Exception e) {
                        System.out.println("Export error");
                        
                    }
                    break;
                    
                default:
                    break;
            }
        } 
         catch (Exception e) {
        // TODO: handle exception
        System.out.println("error");    
        }
    }
}

