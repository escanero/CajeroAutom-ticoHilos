package com.nebrija;

import java.text.DecimalFormat;

class CuentaCorriente {
	private double saldo;
	private DecimalFormat df = new DecimalFormat("#.00");

	// Constructor que inicializa la cuenta corriente con un saldo inicial
	public CuentaCorriente(double saldoInicial) {
		this.saldo = saldoInicial;
	}

	// Método sincronizado para consultar el saldo actual de la cuenta
	public synchronized double consultaSaldo() {
		// Formatea el saldo con dos decimales y lo devuelve como un valor double
		return Double.parseDouble(df.format(saldo));
	}

	// Método sincronizado para realizar un retiro de la cuenta
	public synchronized void sacarImporte(double importe) {
		// Verifica si hay suficiente saldo para el retiro
		if (saldo >= 0) {
			// Realiza el retiro y actualiza el saldo
			saldo -= importe;
			// Imprime un mensaje indicando el retiro y el saldo actualizado
			System.out.println(
					"Se ha retirado: " + df.format(importe) + "€ " + "- Saldo actual: " + df.format(saldo) + "€ ");
		} else {
			// Imprime un mensaje indicando que no hay suficiente saldo para el retiro
			System.out.println("No hay suficiente saldo para retirar: " + df.format(importe) + "€ ");
		}

		notify(); // Notifica a cualquier hilo en espera que el estado de la cuenta ha cambiado
	}

	// Método sincronizado para realizar un ingreso en la cuenta
	public synchronized void meterImporte(double importe) {
		// Realiza el ingreso y actualiza el saldo
		saldo += importe;
		// Imprime un mensaje indicando el ingreso y el saldo actualizado
		System.out.println("Se ha ingresado: " + df.format(importe) + "€ " + "- Saldo actual: " + df.format(saldo) + "€ ");

		notify();
	}
}
