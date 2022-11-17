import java.lang.reflect.Array;
import java.util.ArrayList;

public class VendingMachine {
    
   

    private ArrayList<Product> assortment = new ArrayList<>();
    


    public void addProduct(Product item) {
        this.assortment.add(item);
    }

    


    public void initProducts(ArrayList<Product> items) {
        for (Product item : items) {
            addProduct(item);
        }

    }

    public Product getProduct(String name) {
        for (int i = 0; i < this.assortment.size(); i++) {
            String currentName = this.assortment.get(i).getName();
            if (currentName.equals(name)) {
                Product boughProduct = this.assortment.get(i);
                this.assortment.remove(i);
                return boughProduct;
            }
        }

        return new Product("Empty", 0);
    }

    public ArrayList checkAssortment() {
        return this.assortment;

    }
    
    
    
}

//Реализуйте класс Товар, содержащий данные о товаре, и 
//ТорговыйАвтомат, содержащий в себе методы initProducts (List <Product>) 
//сохраняющий в себе список исходных продуктов и getProduct(String name)