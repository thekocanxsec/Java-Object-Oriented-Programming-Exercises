import java.io.IOException;

interface Transport {
    void deliver();
}

class Truck implements Transport{
    @Override
    public void deliver(){
        System.out.println("Package is being transported via Truck.");

    }
}

class Ship implements Transport{
    @Override
    public void deliver(){
        System.out.println("Package is being transported via Ship.");
    }
}

class TransportFactory{
    private Transport transportType;

    public Transport createTransport(String type) {
        if (type.equalsIgnoreCase("Truck")) {
            return new Truck();
        }
        else if (type.equalsIgnoreCase("Ship")) {
            return new Ship();
        }
        throw new IllegalArgumentException("No type such as: " + type);

    }
}

class MainRun5{
    static void main() {
        TransportFactory factory = new TransportFactory();

        Transport t1 = factory.createTransport("Ship");
        t1.deliver();

        Transport t2 = factory.createTransport("Truck");
        t2.deliver();



    }
}
