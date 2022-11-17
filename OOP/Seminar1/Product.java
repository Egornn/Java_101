public class Product {
    
    protected double price;
    protected String name;
    protected static String currency;
    
    static {
        currency = "$";
    }

    


    public Product(String name, double price) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return this.name + " - " + price;
    }
}

