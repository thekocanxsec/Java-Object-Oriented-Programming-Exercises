import java.util.List;

public class Task3 {
}

interface Product{
    String displayDetails();
}

abstract class InventoryItem implements Product{
    private String productName;
    private double price;

    private int quantity;

    public InventoryItem(String productName, double price, int quantity){
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

class ElectronicsProduct extends InventoryItem{
    private String brand;

    public ElectronicsProduct(String productName, double price, int quantity, String brand){
        super(productName, price,quantity);
        this.brand = brand;
    }

    @Override
    public String displayDetails(){
        return "Electronics Product";
    }
}

class ClothingProduct extends InventoryItem{
    private String size;

    public ClothingProduct(String productName, double price, int quantity, String size){
        super(productName, price, quantity);
        this.size = size;
    }

    @Override
    public String displayDetails(){
        return "Clothing Product";
    }
}

class InventoryManager{

    public List<InventoryItem> updateInventory(List<InventoryItem> items){
        for(InventoryItem item : items){
            if(item instanceof ElectronicsProduct){
                ElectronicsProduct electronicsProduct = (ElectronicsProduct) item;
                electronicsProduct.setPrice(electronicsProduct.getPrice() * 0.9);
            }
            else if(item instanceof ClothingProduct){
                ClothingProduct clothingProduct = (ClothingProduct) item;
                clothingProduct.setPrice(clothingProduct.getPrice() * 0.8);
            }
        }
        return items;
    }
}