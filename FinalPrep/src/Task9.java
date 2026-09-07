import java.util.*;

class Task9 {
}

class Item1{
    private int barcode;
    private String name;

    public Item1(String name, int barcode){
        this.name = name;
        this.barcode = barcode;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBarcode(int barcode){
        this.barcode = barcode;
    }

    public String getName(){
        return this.name;
    }

    public int getBarcode(){
        return this.barcode;
    }


}

class Honey extends Item1{
    public Honey(String name, int barcode){
        super(name,barcode);
    }

}

class Milk extends Item1{
    public Milk(String name, int barcode){
        super(name,barcode);
    }

}

class Order<T extends Item1>{
    private List<T> items;

    public Order(List<T> items){
        this.items = items;
    }

    public void setItems(List<T> items){
        this.items = items;
    }

    public List<T> getItems(){
        return this.items;
    }

    public Optional<List<T>> filterByName(String name){
        List<T> filteredList = new ArrayList<>();

        for(T item : items){
            if(item.getName().equalsIgnoreCase(name)){
                filteredList.add(item);
            }
        }
        return filteredList.isEmpty() ? Optional.empty() : Optional.of(filteredList);
    }

    public T getByBarcode(int barcode){
        for(T code : items){
            if(code.getBarcode() == barcode){
                return code;
            }
        }
        return null;
    }
}




class MainRun9 {
    public static void main(String[] args) {
        List<Item1> itemList = new ArrayList<>();
        itemList.add(new Milk("Organic Milk", 101));
        itemList.add(new Honey("Wildflower Honey", 102));
        itemList.add(new Milk("Organic Milk", 103));

        Order<Item1> order = new Order<>(itemList);

        // Test filterByName
        Optional<List<Item1>> filtered = order.filterByName("Organic Milk");
        System.out.println("Filtered items count: " + (filtered.isPresent() ? filtered.get().size() : 0));

        // Test getByBarcode
        Item1 found = order.getByBarcode(102);
        System.out.println("Found by barcode: " + (found != null ? found.getName() : "Not found"));
    }
}
