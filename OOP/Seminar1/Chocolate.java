public class Chocolate extends ProductGen implements VendingInterface{
    
    private String color;
    // private String name;
    
    
    public Chocolate(String name, double price, String currency, String color) {
        this.color = color;
        super.name = name;
        super.price = price;
        super.currency = currency;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return super.getName();
    }

    @Override
    public double getPrice() {
        // TODO Auto-generated method stub
        return super.getPrice();
    }

    @Override
    public String sellItem() {
        // TODO Auto-generated method stub
        return "We sold one "+this.color+" chocolate bar "+super.name +" at a price "+super.currency+super.price;
    }




}
