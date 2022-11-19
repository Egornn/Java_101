package HW1;



public class HotDrinkHeir extends HotDrink  {
    
    public int temperature;
    

    
    public HotDrinkHeir(String name, String currency, int temp, Double size) {
        super.size = size;
        super.name = name;
        super.currency = currency;
        this.temperature = temp;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Product %s at %s celsius with volume %s", super.name,  this.temperature, super.size);
    }
}
