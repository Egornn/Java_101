package HW1;

import java.util.ArrayList;

public class HotDirrinkVendor implements HotdrinkMachine {
    private ArrayList<HotDrinkHeir> products = new ArrayList<>();
    
    public HotDirrinkVendor(HotDrinkHeir[] products) {
        for (HotDrinkHeir hotDrinkHeirProd : products) {
            this.products.add(hotDrinkHeirProd);
        }
    }

    @Override
    public HotDrinkHeir getProduct(String name, Double volume, int temperature) {
        for (int i = 0; i < products.size(); i++) {
            
            if (products.get(i).size.equals(volume) && products.get(i).name.equals(name) && products.get(i).temperature==(temperature)) {
                return products.get(i);
            }
        }
        return new HotDrinkHeir("Nothing",  ""  , 0 , 0d);
    }
}
