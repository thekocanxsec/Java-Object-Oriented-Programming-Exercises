public class Singelton {
    private static volatile Singelton instance;
    private String data;

    private Singelton(String data){
        this.data=data;

    }

    public static Singelton getInstance(String data) {
        Singelton result = instance;
        if(result == null){
            synchronized (Singelton.class){
                if(result == null){
                    result = new Singelton(data);
                }
            }
        }
        return result;

    }
}

