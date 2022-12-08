package HW5.model.service;

import HW5.model.contact.Contact;
import HW5.model.phonebook.Phonebook;
import java.util.ArrayList;

public class PhonebookService {
	public Phonebook createPhonebook(String name, ArrayList<Contact> contacts){
		Phonebook phonebook = new Phonebook(name);
		for (Contact i : contacts){
			if (!isExist(phonebook.getContacts(), i)) {
				phonebook.addContact(i);
			}
		}
		return phonebook;
	}

	public boolean isExist(ArrayList<Contact> contacts, Contact contact){
		return (contacts.contains(contact));
	}
}
