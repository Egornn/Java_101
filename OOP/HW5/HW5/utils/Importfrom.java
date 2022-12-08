package HW5.utils;

import HW5.model.*;
import HW5.model.contact.Contact;
import HW5.model.contact.Phone;
import HW5.model.contact.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import HW5.model.phonebook.Phonebook;
import HW5.model.service.ContactServiceImpl;
import HW5.model.service.PhonebookService;

public class Importfrom {
    public static Phonebook importFromFile(String phonebookName, String path, String format) {
        try {
			List<String> allLines = Files.readAllLines(Paths.get(path));
            if (allLines.size() == 0) {
                return new Phonebook("Empty");
            }
            ArrayList<Contact> listContacts = new ArrayList<>();

            switch (format) {
                case "No Format":
                    for (String message : allLines) {
                        List<String> line = (Arrays.stream(message.split(" ")).toList());
                        User user1 = new User(line.get(0), line.get(1));
                        
                        ArrayList<Phone> phones1 = new ArrayList<>();

                        for (int i = 3; i < line.size(); i++) {

                            phones1.add(new Phone(line.get(i).replace(",", "")));

                        }
                        user1.setCompany(line.get(2));
                        Contact cont1 = new ContactServiceImpl().createContact(user1, phones1);
                        listContacts.add(cont1);

                    }
                    return new PhonebookService().createPhonebook(phonebookName, listContacts);

                case "International Format":
                    for (String message : allLines) {
                        if (!message.equals("")) {
                            message = message.replace("  ", " ");
                            List<String> line = (Arrays.stream(message.split(" ")).toList());
                            User user1 = new User(line.get(0), line.get(1));
                            ArrayList<Phone> phones1 = new ArrayList<>();

                            for (int i = 3; i < line.size(); i++) {

                                phones1.add(new Phone(line.get(i).replace(",", "").replace("+7-", "8")));
                            }
                            user1.setCompany(line.get(2));
                            Contact cont1 = new ContactServiceImpl().createContact(user1, phones1);
                            listContacts.add(cont1);

                        }
                    }


                    return new PhonebookService().createPhonebook(phonebookName, listContacts);

                default:
                    return new Phonebook("Bad format");

            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Contact> cont = new ArrayList<>();
        return new PhonebookService().createPhonebook(phonebookName,cont);
    }
    
}
