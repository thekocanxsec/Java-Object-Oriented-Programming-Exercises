class CounterSync {
    public static int count = 0;

    /*
     * KKLJUČNA PROMJENA: Dodali smo "synchronized" na metodu increment()!
     *
     * ŠTA OVO SADA RADI?
     * 1. ZAKLJUČAVANJE (Monitor Lock / Mutex): Kada nit t1 uđe u ovu metodu,
     *    Java automatski zaključava "vrata" ovog objekta (CounterSync).
     * 2. EKSKLUZIVNI PRISTUP: Dok god t1 radi operaciju "count++" (čitanje, mijenjanje, upis),
     *    nijedna druga nit (pa ni t2) ne može ući u ovu metodu.
     * 3. ČEKANJE: Ako t2 pokuša ući dok je t1 unutra, t2 mora da stane u red i sačeka
     *    da t1 završi i otključa vrata.
     *
     * Zato se operacija više ne može preklapati, nema gubljenja podataka,
     * i konačni rezultat će UVJEK biti savršenih 20.000!
     */
    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}

class SynchronizationExample {
    public static void main(String[] args) {
        CounterSync counter = new CounterSync();

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

        // Sada, zahvaljujući "synchronized", ovdje će uvijek pisati tačno: Count: 20000
        System.out.println("Count: " + counter.getCount());
    }
}