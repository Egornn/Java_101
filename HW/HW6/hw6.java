
import java.util.ArrayList;
import java.util.logging.Logger;

public class hw6 {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();

        Notebook book1 = new Notebook("ID1");
        Notebook book2 = new Notebook("ID2");
        Notebook book3 = new Notebook("ID3");

        book1.setColor("red");
        book1.setHardDriveStorgate(1000);
        book1.setMemory(4096);
        book1.setModel("Intel 5");
        book1.setOperatingSystem("Windows XP");
        book1.setProcessor("Intel 8");
        book1.setScreenSize(19);

        book2.setColor("black");
        book2.setHardDriveStorgate(2000);
        book2.setMemory(8192);
        book2.setModel("Intel 5");
        book2.setOperatingSystem("Windows XP");
        book2.setProcessor("Intel 9");
        book2.setScreenSize(20);
        
        book3.setColor("red");
        book3.setHardDriveStorgate(1500);
        book3.setMemory(16384);
        book3.setModel("Intel 5");
        book3.setOperatingSystem("MacOs");
        book3.setProcessor("Apple A1");
        book3.setScreenSize(21);

        logger.info(Notebook.infoOnFilter());
        Notebook.filterBy(2, 20);
        Notebook.filterBy(5, 500);
        ArrayList <Notebook>  setOfBooks  = new ArrayList<>();
        setOfBooks.add(book1);
        setOfBooks.add(book2);
        setOfBooks.add(book3);
        
        var result = Notebook.getNotebooks(setOfBooks);
        logger.info(String.valueOf(result));
    }
}
