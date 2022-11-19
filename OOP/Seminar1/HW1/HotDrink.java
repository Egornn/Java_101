package HW1;


public class HotDrink {
    protected String name;
    protected Double size;
    protected static String currency;
    
    static {
        currency = "$";
    }

    public HotDrink(double size, String currency) {
        this.size = size;
        this.name = name;
        this.currency = currency;

    }
    
    public HotDrink() {
        this.name = "Default";
        this.size = 1d;
        this.currency = "$";
    }
}
