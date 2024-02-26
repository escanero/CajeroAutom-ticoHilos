package com.nebrija;

import java.util.Random;

class Consumidor extends Thread {
    private CuentaCorriente cuenta;
    private boolean esAleatorio;
    private Random random = new Random();

    // Constructor que recibe una referencia a la cuenta corriente y un booleano para determinar si el comportamiento es aleatorio
    public Consumidor(CuentaCorriente cuenta, boolean esAleatorio) {
        this.cuenta = cuenta;
        this.esAleatorio = esAleatorio;
    }

    // Método que simula retiros dependiendo del tipo de consumidor
    @Override
    public void run() {
        for (int i = 0; i < 12; i++) {
            double retiro;
            
            if (esAleatorio) {
                // Retiro aleatorio hasta $500
                retiro = random.nextDouble() * 500;
            } else {
                // Retiro del 10% del saldo
                retiro = cuenta.consultaSaldo() * 0.1;
            }

            synchronized (cuenta) {
                if (cuenta.consultaSaldo() < retiro) {
                    try {
                        cuenta.wait(); // Espera hasta que haya suficiente saldo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                cuenta.sacarImporte(retiro); // Realiza un retiro en la cuenta
            }

            try {
                sleep(2000); // Espera un mes 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
