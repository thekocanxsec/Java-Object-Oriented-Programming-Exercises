public class SmartphoneBuilderPattern {
}

class Smartphone{
    private String brand;
    private String model;
    private int storageGb;
    private int batteryCapacity;
    private boolean hasOledScreen;


    private Smartphone(SmartphoneBuilder builder){
        this.brand = builder.brand;
        this.model = builder.model;
        this.storageGb = builder.storageGb;
        this.batteryCapacity = builder.batteryCapacity;
        this.hasOledScreen = builder.hasOledScreen;
    }

    public String getBrand(){
        return this.brand;
    }

    public String getModel(){
        return this.model;
    }

    public int getStorageGb(){
        return this.storageGb;
    }

    public int getBatteryCapacity(){
        return this.batteryCapacity;
    }

    public boolean getHasOledScreen(){
        return this.hasOledScreen;
    }

    public static class SmartphoneBuilder{
        private String brand;
        private String model;
        private int storageGb;
        private int batteryCapacity;
        private boolean hasOledScreen;

        public SmartphoneBuilder(String brand, String model){
            this.brand = brand;
            this.model = model;
        }

        public SmartphoneBuilder setStorageGb(int storageGb){
            this.storageGb = storageGb;
            return this;
        }

        public SmartphoneBuilder setBatteryCapacity(int batteryCapacity){
            this.batteryCapacity = batteryCapacity;
            return this;
        }

        public SmartphoneBuilder setHasOledScreen(boolean hasOledScreen){
            this.hasOledScreen = hasOledScreen;
            return this;
        }

        public Smartphone build(){
            return new Smartphone(this);
        }

    }
}
