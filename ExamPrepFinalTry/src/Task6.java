public class Task6 {
}

class Vehicle{
    private String model;
    private int year;
    private boolean isElectric;

    private Vehicle(VehicleBuilder builder){
        this.model = builder.model;
        this.year = builder.year;
        this.isElectric = builder.isElectric;

    }

    public String getModel(){
        return this.model;
    }

    public int getYear(){
        return this.year;
    }

    public boolean getIsElectric(){
        return this.isElectric;
    }

    static class VehicleBuilder{
        private String model;
        private int year;
        private boolean isElectric;

        public VehicleBuilder(String model){
            this.model = model;
        }

        public VehicleBuilder setYear(int year){
            this.year = year;
            return this;
        }

        public VehicleBuilder setIsElectric(boolean isElectric){
            this.isElectric = isElectric;
            return this;
        }

        public Vehicle build(){
            return new Vehicle(this);
        }
    }
}

class MainRun5{
    public static void main(String[] args) {
        Vehicle tesla = new Vehicle.VehicleBuilder("Tesla Model 3")
                .setYear(2022)
                .setIsElectric(true)
                .build();

        System.out.println("Model: " + tesla.getModel());
        System.out.println("Year: " + tesla.getYear());
        System.out.println("Is Electric: " + tesla.getIsElectric());
    }
}