import java.util.ArrayList;
import java.util.List;

class Task3 {
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

    public void setProductName(String productName){
        this.productName = productName;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String getProductName(){
        return this.productName;
    }

    public double getPrice(){
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }


}

class ElectronicsProduct extends InventoryItem{
    private String brand;

    public ElectronicsProduct(String productName, double price, int quantity, String brand){
        super(productName,price,quantity);
        this.brand = brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getBrand(){
        return this.brand;
    }


    @Override
    public String displayDetails(){
        return "ElectronicsProduct";
    }

}

class ClothingProduct extends InventoryItem{
    private String size;

    public ClothingProduct(String productName, double price, int quantity, String size){
        super(productName,price,quantity);
        this.size = size;
    }

    public void setSize(String size){
        this.size = size;
    }

    public String getSize(){
        return this.size;
    }

    @Override
    public String displayDetails(){
        return "ClothingProduct";
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

class MainRun3 {
    public static void main(String[] args) {
        List<InventoryItem> items = new ArrayList<>();

        ElectronicsProduct laptop = new ElectronicsProduct("Laptop", 1000.0, 5, "Dell");
        ClothingProduct tShirt = new ClothingProduct("T-Shirt", 50.0, 20, "M");

        items.add(laptop);
        items.add(tShirt);

        System.out.println("--- Before Update ---");
        for (InventoryItem item : items) {
            System.out.println(item.getProductName() + " [" + item.displayDetails() + "] - Price: " + item.getPrice());
        }

        InventoryManager manager = new InventoryManager();
        List<InventoryItem> updatedItems = manager.updateInventory(items);

        System.out.println("\n--- After Update (10% off electronics, 20% off clothing) ---");
        for (InventoryItem item : updatedItems) {
            System.out.println(item.getProductName() + " - Discounted Price: " + item.getPrice());
        }
    }
}