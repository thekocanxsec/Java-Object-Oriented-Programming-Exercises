public class CounterSyncWithoughtSynchronizedKeyword {
    private int count = 0;

    public void increment(){
        /*
         * PAŽNJA: Ovdje NAMJERNO NEMAMO "synchronized"!
         * Da imamo synchronized, Java bi zaključala vrata da samo jedna nit
         * može ući ovdje dok ne završi. Ovako, pošto je nemamo, obje niti
         * istovremeno upadaju ovdje i dolazi do "Race Condition" (stanje trke).
         *
         * Operacija "count++" u mašinskom kodu NIJE jedna, nego tri operacije:
         * 1. ČITA trenutnu vrijednost count-a iz memorije.
         * 2. MIJENJA (uvećava) je za 1.
         * 3. UPISUJE novu vrijednost nazad.
         *
         * Ako t1 pročita da je 5, pa u isto vrijeme i t2 pročita da je 5,
         * obe će izračunati 6 i obe upisati 6 nazad — i tako gubimo jedan korak!
         */
        count++;
    }

    public int getCount(){
        return this.count;
    }
}

class SynchronizationExampleWithoughSyncronizedKeyword {
    public static void main(String[] args) {
        CounterSyncWithoughtSynchronizedKeyword counter = new CounterSyncWithoughtSynchronizedKeyword();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Problem occurred while joining threads");
        }

        /*
         * ZAKLJUČAK ZAŠTO SE MORA KORISTITI "synchronized":
         * Zbog izostanka sinhronizacije, niti su se gazile i preklapale u memoriji.
         * Zato konačni ispis OVDJE ČESTO BUDE MANJI OD 20.000 (npr. 17540, 18900...)
         * umjesto savršenog zbira.
         *
         * Da bi rezultat UVIJEK bio tačno 20.000 i da spriječimo "otimanje" podataka,
         * MORAMO staviti "synchronized" ispred metode increment():
         * public synchronized void increment() { count++; }
         */
        System.out.println("Count: " + counter.getCount());
    }

}
