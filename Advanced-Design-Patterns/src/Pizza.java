class Pizza{
    private String size;
    private boolean cheese;
    private String crust;
    private String extra;

    private Pizza(PizzaBuilder builder){
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.crust = builder.crust;
        this.extra = builder.extra;
    }

    public String getSize() {
        return size;
    }

    public boolean isCheese() {
        return cheese;
    }

    public String getCrust(){
        return crust;
    }

    public String getExtra(){
        return extra;
    }

    public static class PizzaBuilder{
        private String size;
        private boolean cheese;
        private String crust;
        private String extra;

        public PizzaBuilder(){

        }

        public PizzaBuilder setSize(String size){
            this.size = size;
            return this;
        }

        public PizzaBuilder setCheese(boolean cheese){
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder setCrust(String crust){
            this.crust = crust;
            return this;
        }

        public PizzaBuilder setExtra(String extra){
            this.extra = extra;
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }
    }
}

class MainRun4{
    static void main() {
        Pizza pizza1 = new Pizza.PizzaBuilder().setSize("Large").setCheese(true).setCrust("Soft").setExtra("BBQ").build();

        System.out.println("Pizza size: " + pizza1.getSize());
        System.out.println("Cheese: " + pizza1.isCheese());
    }
}