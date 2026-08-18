public class Builder {
}

class Vehicle{
    private String model;
    private int year;
    private boolean isElectric;

    private Vehicle(VehicleBuilder builder){
        this.model = model;
        this.year = year;
        this.isElectric = isElectric;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public static class VehicleBuilder{
        private final String model;
        private int year = 0;
        private boolean isElectric = false;

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
