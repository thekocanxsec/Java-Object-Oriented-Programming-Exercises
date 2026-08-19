class VehicleFactory {
    public Vehicle2 createVehicle(String type){
        if(type == null){
            return null;
        }
        else if(type.equalsIgnoreCase("Car")){
            return new Car();
        }
        else if(type.equalsIgnoreCase("Motorcycle")){
            return new Motorcycle();
        }
        else if(type.equalsIgnoreCase("Truck")){
            return new Truck();
        }

        throw new IllegalArgumentException("No such type of vehicle called: " + type);
    }
}

interface Vehicle2{
    void drive();
}

class Car implements Vehicle2{
    @Override
    public void drive(){
        System.out.println("Driving CAR on the asphalt");
    }
}

class Motorcycle implements Vehicle2{
    @Override
    public void drive(){
        System.out.println("Driving MOTORCYCLE on the asphalt");
    }
}

class Truck implements Vehicle2{
    @Override
    public void drive(){
        System.out.println("Driving TRUCK on the asphalt");
    }
}

class MainRun3{
    static void main() {
        VehicleFactory vehicle = new VehicleFactory();

        Vehicle2 v1 = vehicle.createVehicle("Car");
        Vehicle2 v2 = vehicle.createVehicle("Motorcycle");
        Vehicle2 v3 = vehicle.createVehicle("Truck");

        v1.drive();
        v2.drive();
        v3.drive();
    }
}



