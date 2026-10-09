package main.java.org.example;

public class Sala {
    public synchronized void entrar(String nombre) throws InterruptedException {
        System.out.println(nombre + " ENTRA");
        Thread.sleep(1000);
        System.out.println(nombre + " SALE");
    }
}
