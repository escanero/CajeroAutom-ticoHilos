package com.nebrija;

class Nomina extends Thread {
	private CuentaCorriente cuenta;

	// Constructor que recibe una referencia a la cuenta corriente
	public Nomina(CuentaCorriente cuenta) {
		this.cuenta = cuenta;
	}

	// Método que simula el ingreso mensual del SMI durante un año
	@Override
	public void run() {
		for (int i = 0; i < 12; i++) {
			double ingreso = 1140; // Simulación de ingreso mensual del SMI
			cuenta.meterImporte(ingreso); // Realiza un ingreso en la cuenta
			try {
				sleep(2000); // Simula el paso de un mes
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
/*
 * La excepción InterruptedException se lanza cuando un hilo en Java que está
 * esperando, durmiendo o bloqueado es interrumpido por otro hilo, generalmente
 * para indicar que debería detener su operación actual o terminar su ejecución.
 */