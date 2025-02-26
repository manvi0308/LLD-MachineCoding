package StateDesignPattern.VendingMachine.Code;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private final Map<Product, Integer> productIntegerMap;
    public Inventory(){
        productIntegerMap = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product, int quantity){
        productIntegerMap.put(product, quantity);
    }

    public void removeProduct(Product product){
        productIntegerMap.remove(product);
    }

    public void updateQuantity(Product product, int quantity){
        productIntegerMap.put(product, quantity);
    }

    public int getQuantity(Product product){
        return productIntegerMap.get(product);
    }

    public boolean isAvaialable(Product product){
        return productIntegerMap.containsKey(product) && productIntegerMap.get(product) > 0;
    }
}
