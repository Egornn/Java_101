import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class first {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        Product item1 = new Product("Chips", 20);
        Product item2 = new Product("Juice", 15);
        Product item3 = new Product("Nuts", 40);
        ArrayList<Product> assort = new ArrayList<>(Arrays.asList( new Product [] {item1,item2,item3}));
        VendingMachine vendor1 = new VendingMachine();
        vendor1.initProducts(assort);
        logger.info(vendor1.checkAssortment().toString());
        logger.info(vendor1.getProduct("Nuts").toString());
        logger.info(vendor1.checkAssortment().toString());
        
    }
}
