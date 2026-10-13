package main.java.org.example;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainT {
    public static Scanner scr = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Cantidad de coches:");
        int cars = scr.nextInt();

        Aparcamiento parking = new Aparcamiento();

        long sTime = System.nanoTime();

        try (ExecutorService eso = Executors.newFixedThreadPool(cars)) {
            for (int i = 0; i < cars; i++) {
                int nCar = i + 1;
                eso.submit(() -> {
                    parking.aparcar(nCar);
                });
            }
        }

        long fTime = System.nanoTime();

        System.out.println("Tiempo de procesamiento: " + ((fTime - sTime) / 1000));
    }
}