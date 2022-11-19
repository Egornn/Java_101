package HW1;


import java.util.List;
import java.util.logging.Logger;


public class hw1main {
   public static void main(String[] args) {
    
   
    HotDrinkHeir drink1 = new HotDrinkHeir("Coffee", "$", 80, 0.5d);
    HotDrinkHeir drink2 = new HotDrinkHeir("Tea", "$", 100, 0.3d);
    HotDrinkHeir drink3 = new HotDrinkHeir("Hot Chocolate", "$", 90, 0.4d);

    HotDrinkHeir[] ass1 = { drink1, drink2, drink3 };
    HotDrinkHeir[] ass2 = { drink2, drink3 };
    
    HotDirrinkVendor machine1 = new HotDirrinkVendor(ass1);
    HotDirrinkVendor machine2 = new HotDirrinkVendor(ass2);



    Logger logger = Logger.getAnonymousLogger();
    logger.info(String.valueOf(machine1.getProduct("Coffee", 0.5d, 80)));
    
    // logger.info(String.valueOf(machine2.getProduct("Coffee", 0.5d, 80)));
}
    
    
//1. Создать наследника реализованного класса ГорячийНапиток с дополнительным полем int температура.
// 2. Создать класс ГорячихНапитковАвтомат реализующий интерфейс ТорговыйАвтомат и реализовать перегруженный метод getProduct(int name, int volume, int temperature) выдающий продукт соответствующий имени, объему и температуре
// 3. В main проинициализировать несколько ГорячихНапитков и ГорячихНапитковАвтомат и воспроизвести логику заложенную в программе
// 4. Все вышеуказанное создать согласно принципам ООП пройдённым на семинаре

}
