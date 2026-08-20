class AbstractFactory3 {
}

interface Engine{
    void start();
}

interface Tires{
    void roll();
}

class V8Engine implements Engine{
    @Override
    public void start(){
        System.out.println("Loud noise of engine V8");
    }
}

class SportTires implements Tires{
    @Override
    public void roll(){
        System.out.println("Sport tires are ready");
    }
}

class ElectricEngine implements Engine{
    @Override
    public void start(){
        System.out.println("Quiet engine is started");
    }
}

class EcoTires implements Tires{
    @Override
    public void roll(){
        System.out.println("Eco friendly tires squeek");
    }
}

interface CarAbstractFactory{
    Engine createEngine();
    Tires createTires();
}

class SportCarFactory implements CarAbstractFactory{
    @Override
    public Engine createEngine(){
        return new V8Engine();
    }
    @Override
    public Tires createTires(){
        return new SportTires();
    }
}

class ElectricCarFactory implements CarAbstractFactory{
    @Override
    public Engine createEngine(){
        return new ElectricEngine();
    }

    public Tires createTires(){
        return new EcoTires();
    }
}

class MainRun6{
    static void main() {
        CarAbstractFactory sportsCar = new SportCarFactory();
        CarAbstractFactory electricCar = new ElectricCarFactory();

        Engine engineSport = sportsCar.createEngine();
        Tires tiresSport = sportsCar.createTires();

        engineSport.start();
        tiresSport.roll();




    }
}