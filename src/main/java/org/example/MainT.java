package main.java.org.example;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainT {
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Cantidad de hilos:");
        int nt = scr.nextInt();

        long sTime = System.nanoTime();

        try (ExecutorService pool = Executors.newFixedThreadPool(nt)) {
            for (int i = 0; i < nt; i++) {
                pool.submit(parking(i + 1));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long fTime = System.nanoTime();

        System.out.println("Tiempo de procesamiento: " + ((fTime - sTime) / 1000));
    }

    public static Runnable parking(int n) throws InterruptedException{
        Runnable d = () -> {
            Aparcamiento car = new Aparcamiento();
            car.aparcar(n);
        };
        return d;
    }
}