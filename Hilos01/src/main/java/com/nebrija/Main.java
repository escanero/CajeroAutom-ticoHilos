package com.nebrija;

public class Main {
    public static void main(String[] args) {
        CuentaCorriente cuenta = new CuentaCorriente(0);

        // Crear los objetos consumidores usando la misma clase pero con comportamientos diferentes
        Consumidor consumidorPorcentaje = new Consumidor(cuenta, false);
        Consumidor consumidorAleatorio = new Consumidor(cuenta, true);

        // Crear el objeto productor (Nomina)
        Nomina nominas = new Nomina(cuenta); 

        // Iniciar los hilos
        nominas.start();
        consumidorPorcentaje.start();
        consumidorAleatorio.start();
    }
}


