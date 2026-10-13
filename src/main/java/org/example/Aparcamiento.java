package main.java.org.example;

import java.util.concurrent.Semaphore;
import java.util.random.RandomGenerator;
public class Aparcamiento {
    private Semaphore spaces = new Semaphore (3);
    public void aparcar(int coche) {

        try {
            System.out.println("Coche " + coche + " llega.");
            spaces.acquire();
            System.out.println("Coche " + coche + " aparcando. Quedan " + spaces.availablePermits() + " plazas libres");
            Thread.sleep(RandomGenerator.getDefault().nextInt(1000, 3000));

            System.out.println("Coche " + coche + " se va");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            spaces.release();
        }
    }
}
