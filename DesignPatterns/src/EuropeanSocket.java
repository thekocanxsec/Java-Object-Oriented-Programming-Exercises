interface EuropeanSocket {
    void plugInEuropean();
}

class USAPlugDevice{
    public void plugInUSAStyle(){
        System.out.println("Connected successfully using USA flat pins (110V)!");
    }
}

class TravelAdapter implements EuropeanSocket{
    private USAPlugDevice usaPlugDevice;

    public TravelAdapter(USAPlugDevice usaPlugDevice){
        this.usaPlugDevice = usaPlugDevice;
    }

    @Override
    public void plugInEuropean(){
        System.out.println("Travel adapter converts European socket to USA style... ");
        usaPlugDevice.plugInUSAStyle();
    }
}

class MainRun14{
    static void main() {
        USAPlugDevice myDevice = new USAPlugDevice();
        EuropeanSocket socket = new TravelAdapter(myDevice);

        socket.plugInEuropean();

    }
}
