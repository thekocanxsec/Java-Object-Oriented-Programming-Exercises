

class Laptop{
    private String brand;
    private int ramSize;
    private int ssdCapacity;
    private boolean hasGraphics;

    private Laptop(LaptopBuilder builder){
        this.brand = builder.brand;
        this.ramSize = builder.ramSize;
        this.ssdCapacity = builder.ssdCapacity;
        this.hasGraphics = builder.hasGraphics;
    }

    public String getBrand(){
        return this.brand;
    }

    public int getRamSize(){
        return this.ramSize;
    }

    public int ssdCapacity(){
        return this.ssdCapacity;
    }

    public boolean hasGraphics(){
        return this.hasGraphics;
    }

    public static class LaptopBuilder{
        private String brand;
        private int ramSize;
        private int ssdCapacity;
        private boolean hasGraphics;

        public LaptopBuilder(String brand){
            this.brand = brand;
        }

        public LaptopBuilder setRamSize(int ramSize){
            this.ramSize = ramSize;
            return this;
        }

        public LaptopBuilder setSsdCapacity(int ssdCapacity){
            this.ssdCapacity = ssdCapacity;
            return this;
        }

        public LaptopBuilder setHasGraphicsCard(boolean hasGraphics){
            this.hasGraphics = hasGraphics;
            return this;
        }

        public Laptop build(){
            return new Laptop(this);
        }

    }
}

class MainRun {
    // ISPRAVAN POTPIS MAIN METODE
    public static void main(String[] args) {
        Laptop myLaptop = new Laptop.LaptopBuilder("Apple")
                .setRamSize(16)
                .setSsdCapacity(512)
                .setHasGraphicsCard(true)
                .build();

        // Čisto da provjerimo ispis
        System.out.println("Napravljen laptop: " + myLaptop.getBrand() + " sa " + myLaptop.getRamSize() + "GB RAM-a.");
    }
}