package Downcasting;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
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

    public String getProductName(){
        return this.productName;
    }

    public double getPrice(){
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
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
}

class ElectronicsProduct extends InventoryItem{
    private String brand;

    public ElectronicsProduct(String productName, double price, int quantity, String brand){
        super(productName,price,quantity);
        this.brand = brand;
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
                electronicsProduct.setPrice(electronicsProduct.getPrice() * 0.90);
            }
            else if(item instanceof ClothingProduct){
                ClothingProduct clothingProduct = (ClothingProduct) item;
                clothingProduct.setPrice(clothingProduct.getPrice() * 0.8);
            }

        }
        return items;
    }
}

class MainRun{
    static void main(String[] args) {
        List<InventoryItem> items = new ArrayList<>();
        items.add(new ElectronicsProduct("Laptop", 1000.0, 5, "Dell"));
        items.add(new ClothingProduct("T-Shirt", 50.0, 20, "M"));

        InventoryManager manager = new InventoryManager();
        List<InventoryItem> updatedItems = manager.updateInventory(items);

        for (InventoryItem item : updatedItems) {
            System.out.println(item.getProductName() + " - New Price: " + item.getPrice() + " (" + item.displayDetails() + ")");
        }
    }
}