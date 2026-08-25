interface EuropeanSocket {
    void provideElectricity();
}

class USPlug{
    public void connectToUSOutlet(){
        System.out.println("Connected to US outlet (110V).");
    }
}

class SocketAdapter implements EuropeanSocket{
    private USPlug usPlug;

    public SocketAdapter(USPlug usPlug){
        this.usPlug = usPlug;
    }
    @Override
    public void provideElectricity(){
        System.out.println("Adapter converting European socket to US standard...");
        usPlug.connectToUSOutlet();
    }
}

class MainRun7 {
    static void main() {
        USPlug myUsPlug = new USPlug();

        EuropeanSocket socket = new SocketAdapter(myUsPlug);

        socket.provideElectricity();
    }
}
