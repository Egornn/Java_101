package HW5;

import HW5.utils.*;
import HW5.model.contact.Contact;
import HW5.model.contact.Phone;
import HW5.model.contact.User;
import HW5.model.phonebook.Phonebook;
import HW5.model.service.ContactServiceImpl;
import HW5.model.service.PhonebookService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
	
	public static void startApp() {
		String message = "Alexey Aleksandrov 8493 853394";
		String message2 = "Boris Blade 843493 8573394";
		List<String> line = (Arrays.stream(message.split(" ")).toList());
		User user1 = new User(line.get(0), line.get(1));
		ArrayList<Phone> phones1 = new ArrayList<>();
		for (int i = 2; i < line.size(); i++) {
			phones1.add(new Phone(line.get(i)));
		}
		List<String> line2 = (Arrays.stream(message2.split(" ")).toList());
		User user2 = new User(line2.get(0), line2.get(1));
		ArrayList<Phone> phones2 = new ArrayList<>();
		for (int i = 2; i < line2.size(); i++) {
			phones2.add(new Phone(line2.get(i)));
		}
		user1.setCompany("YOLO");
		user2.setCompany("AmoguS");
		Contact cont1 = new ContactServiceImpl().createContact(user1, phones1);
		Contact cont2 = new ContactServiceImpl().createContact(user2, phones2);

		ArrayList<Contact> listContacts = new ArrayList<>();
		listContacts.add(cont1);
		listContacts.add(cont2);

		Phonebook pb1 = new PhonebookService().createPhonebook("pb1", listContacts);

		ExportToF.ExportToFile(pb1, "C:/Users/Егор/Documents/Java/OOP/HW5/HW5/export.txt", "No Format");
		ExportToF.ExportToFile(pb1, "C:/Users/Егор/Documents/Java/OOP/HW5/HW5/InternationalExport.txt",
				"International Format");
		Phonebook pb2 = Importfrom.importFromFile("first", "C:/Users/Егор/Documents/Java/OOP/HW5/HW5/export.txt",
				"No Format");
		Phonebook pb3 = Importfrom.importFromFile("first", "C:/Users/Егор/Documents/Java/OOP/HW5/HW5/InternationalExport.txt",
				"International Format");
		ExportToF.ExportToFile(pb2, "C:/Users/Егор/Documents/Java/OOP/HW5/HW5/RE-export.txt", "No Format");
		System.out.println(pb3.toString());
		ExportToF.ExportToFile(pb3, "C:/Users/Егор/Documents/Java/OOP/HW5/HW5/RE-InternationalExport.txt",
						"International Format");
			}
	
}