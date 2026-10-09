package main.java.org.example;

public class Contador {

    private int valor = 0;

    public void incrementar() {
        synchronized (this) {
            valor++;
        }
    }

    public int getValor() {
        return valor;
    }
}
