class AbstractFactory4 {
}

interface Light{
    void turnOn();
}

interface Thermostat{
    void regulate();
}

class LuxuryLight implements Light{
    @Override
    public void turnOn(){
        System.out.println("Luxury RGB lights are displayed");
    }
}

class AiThermostat implements Thermostat{
    @Override
    public void regulate(){
        System.out.println("Luxury thermostat works its magic");
    }
}

class BudgetLight implements Light{
    @Override
    public void turnOn(){
        System.out.println("Budget RGB lights are displayed");
    }
}

class ManualThermostat implements Thermostat{
    @Override
    public void regulate(){
        System.out.println("Manual thermostat works its magic");
    }
}

interface SmartHomeFactory{
    Light createLight();
    Thermostat createThermostat();
}

class LuxurySmartHome implements SmartHomeFactory{
    @Override
    public Light createLight(){
        return new LuxuryLight();
    }

    public Thermostat createThermostat(){
        return new AiThermostat();
    }
}

class BudgetSmartHome implements SmartHomeFactory{
    @Override
    public Light createLight(){
        return new BudgetLight();
    }

    @Override
    public Thermostat createThermostat(){
        return new ManualThermostat();
    }
}

class MainRun7{
    static void main() {
        SmartHomeFactory luxuryHome = new LuxurySmartHome();
        SmartHomeFactory budgetHome = new BudgetSmartHome();

        Light luxuryLights = luxuryHome.createLight();
        Thermostat luxuryThermostat = luxuryHome.createThermostat();

        Light budgetLights = budgetHome.createLight();
        Thermostat budgetThermostat = budgetHome.createThermostat();

        luxuryLights.turnOn();
        luxuryThermostat.regulate();
    }
}