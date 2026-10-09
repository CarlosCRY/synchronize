package main.java.org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.Scanner;

public class MainC {

    private static final int VUELTAS = 100_000;

    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) {
        Contador contador = new Contador();

        Runnable incrementarMuchasVeces = () -> {
            for (int i = 0; i < VUELTAS; i++) {
                contador.incrementar();
            }
        };

        System.out.println("Cantidad de hilos:");
        int nt = scr.nextInt();

        long sTime = System.nanoTime();

        try (ExecutorService pool = Executors.newFixedThreadPool(nt)) {
            for (int i = 0; i < nt; i++) {
                pool.submit(incrementarMuchasVeces);
            }
        }

        long fTime = System.nanoTime();

        System.out.println("Resultado: " + contador.getValor());
        System.out.println("Tiempo de procesamiento: " + ((fTime - sTime) / 1000));
    }
}