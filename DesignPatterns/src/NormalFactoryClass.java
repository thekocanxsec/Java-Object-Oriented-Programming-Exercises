class NormalFactoryClass {
}


interface Coffee{
    void brew();
}

class Esspreso implements Coffee{
    @Override
    public void brew(){
        System.out.println("Brewing a strong, bitter Espresso!");
    }
}

class Latte implements Coffee{
    @Override
    public void brew(){
        System.out.println("Brewing a light Latte!");
    }
}

class CoffeeFactory{
    public Coffee orderCoffee(String type){
        if(type == null){
            return null;
        }else if(type.equalsIgnoreCase("Esspreso")){
            return new Esspreso();
        } else if (type.equalsIgnoreCase("Latte")){
            return new Latte();
        }

        throw new IllegalArgumentException("No such coffee of type: " + type);
    }

}

class MainRun8{
    static void main() {
        CoffeeFactory coffee = new CoffeeFactory();

        Coffee coffee1 = coffee.orderCoffee("Latte");

        coffee1.brew();





    }
}