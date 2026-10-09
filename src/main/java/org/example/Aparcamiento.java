package main.java.org.example;

import java.util.concurrent.Semaphore;
import java.util.random.RandomGenerator;
public class Aparcamiento {
    public void aparcar(int coche) {

        try {
            System.out.println("Coche " + coche + " llega");

            Thread.sleep(RandomGenerator.getDefault().nextInt(1000, 3000));

            System.out.println("Coche " + coche + " se va");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
