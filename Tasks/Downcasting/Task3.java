package Downcasting;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
}

interface Controllable{
    String getStatus();
}

abstract class SmartDevice implements Controllable{
    private String deviceId;
    private double powerConsumption;
    private boolean isOn;

    public SmartDevice(String deviceId, double powerConsumption, boolean isOn){
        this.deviceId = deviceId;
        this.powerConsumption = powerConsumption;
        this.isOn = isOn;
    }

    public String getDeviceId(){
        return this.deviceId;
    }

    public double getPowerConsumption(){
        return this.powerConsumption;
    }

    public boolean getIsOn(){
        return this.isOn;
    }

    public void setDeviceId(String deviceId){
        this.deviceId = deviceId;
    }

    public void setPowerConsumption(double powerConsumption){
        this.powerConsumption = powerConsumption;
    }

    public void setIsOn(boolean isOn){
        this.isOn = isOn;
    }

}

class SmartLight extends SmartDevice{
    private int brightness;
    private String color;

    public SmartLight(String deviceId, double powerConsumption, boolean isOn, int brightness, String color){
        super(deviceId,powerConsumption,isOn);
        this.brightness = brightness;
        this.color = color;
    }

    @Override
    public String getStatus(){
        return "SmartLight - Status: " + (getIsOn() ? "ON" : "OFF");
    }

    public int getBrightness(){
        return this.brightness;
    }

    public void setBrightness(int brightness){
        this.brightness = brightness;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

}

class SmartAC extends SmartDevice{
    private double temperature;
    private String mode;

    public SmartAC(String deviceId, double powerConsumption, boolean isOn, double temperature, String mode){
        super(deviceId,powerConsumption,isOn);
        this.temperature = temperature;
        this.mode = mode;
    }

    @Override
    public String getStatus(){
        return "SmartAC - Status: " + (getIsOn() ? "ON" : "OFF");
    }

    public void setTemperature(double temperature){
        this.temperature = temperature;
    }

    public double getTemperature(){
        return this.temperature;
    }

    public String getMode(){
        return this.mode;
    }

    public void setMode(String mode){
        this.mode = mode;
    }


}

class SmartHomeHub{
    public List<SmartDevice> optimizeEnergy(List<SmartDevice> devices){
        for(SmartDevice device : devices){
            if(device instanceof SmartLight){
                SmartLight smartLight = (SmartLight) device;
                if(smartLight.getBrightness() > 80){
                    smartLight.setBrightness(50);
                    smartLight.setColor("Warm White");
                    if(smartLight.getIsOn() == false){
                        smartLight.setIsOn(true);
                    }
                }
            }
            if(device instanceof SmartAC){
                SmartAC smartAC = (SmartAC) device;
                if(smartAC.getTemperature() < 20){
                    smartAC.setTemperature(22.0);
                    smartAC.setMode("Eco");
                }
            }
        }
        return devices;
    }
}

class MainRun3 {
    public static void main(String[] args) {
        List<SmartDevice> devices = new ArrayList<>();

        SmartLight light1 = new SmartLight("L1", 10.5, false, 95, "Cool White");
        SmartAC ac1 = new SmartAC("AC1", 1200.0, true, 18.5, "Cooling");

        devices.add(light1);
        devices.add(ac1);

        System.out.println("--- BEFORE OPTIMIZATION ---");
        System.out.println(light1.getStatus() + " | Brightness: " + light1.getBrightness() + " | Color: " + light1.getColor());
        System.out.println(ac1.getStatus() + " | Temp: " + ac1.getTemperature() + " | Mode: " + ac1.getMode());

        SmartHomeHub hub = new SmartHomeHub();
        hub.optimizeEnergy(devices);

        System.out.println("\n--- AFTER OPTIMIZATION ---");
        System.out.println(light1.getStatus() + " | Brightness: " + light1.getBrightness() + " | Color: " + light1.getColor());
        System.out.println(ac1.getStatus() + " | Temp: " + ac1.getTemperature() + " | Mode: " + ac1.getMode());
    }
}