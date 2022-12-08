package HW5.model.service;

import HW5.model.contact.Contact;
import HW5.model.contact.Phone;
import HW5.model.contact.User;
import java.util.ArrayList;

public interface ContactService <T extends User, E extends Phone>  {

	public boolean isCorrect(T user, ArrayList<E> phones);
	public Contact createContact(T user, ArrayList<E> phones);

}
