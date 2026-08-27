public class MultiThrededCounterWithInterface implements Runnable{
    private int threadNumber;

    public MultiThrededCounterWithInterface(int threadNumber){
        this.threadNumber = threadNumber;
    }

    @Override
    public void run(){
        for(int i = 0; i <= 5; i++){
            try{
                System.out.println(i + " from the thread: " + this.threadNumber);
                Thread.sleep(100);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}

class MainRun3{
    static void main(String[] args) {
        MultiThrededCounterWithInterface counter = new MultiThrededCounterWithInterface(2);
        Thread thread = new Thread(counter);

        MultiThrededCounterWithInterface counter2 = new MultiThrededCounterWithInterface(1);
        Thread thread2 = new Thread(counter2);

        thread.start();
        thread2.start();
    }
}
