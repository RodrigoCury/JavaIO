package br.dev.rodrigocury.modelo;

import java.io.Serializable;
import java.util.Locale;

/**
 * 
 * @author Rodrigo Cury
 *
 */

public abstract class Conta implements Comparable<Conta>, Serializable{

	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total = 0;

	public Conta(int agencia, int numero) {
		Conta.total++;
		// System.out.println("O total de contas é " + Conta.total);
		this.agencia = agencia;
		this.numero = numero;
		// this.saldo = 100;
		// System.out.println("Estou criando uma conta " + this.numero);
	}

	public abstract void deposita(double valor);

	public void saca(double valor) throws SaldoInsuficienteException {

		if (this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo: " + this.saldo + ", Valor: " + valor);
		}

		this.saldo -= valor;
	}

	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException {
		this.saca(valor);
		destino.deposita(valor);
	}

	public double getSaldo() {
		return this.saldo;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		if (numero <= 0) {
			System.out.println("Nao pode valor menor igual a 0");
			return;
		}
		this.numero = numero;
	}

	public int getAgencia() {
		return this.agencia;
	}

	public void setAgencia(int agencia) {
		if (agencia <= 0) {
			System.out.println("Nao pode valor menor igual a 0");
			return;
		}
		this.agencia = agencia;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public Cliente getTitular() {
		return this.titular;
	}

	public static int getTotal() {
		return Conta.total;
	}
	
	@Override
	public int compareTo(Conta c) {
		return Double.compare(this.saldo, c.saldo);
	}

	@Override
	public String toString() {
//    	String className = getClass().getName();
//    	int index = className.lastIndexOf('.') + 1;
//    	return getClass().getName().substring(index) + "\nAgência: " + this.getAgencia() + "\nConta: " + this.getNumero();
		return String.format(new Locale("pt", "BR"), "%s - %04d-%08d %s : $%.2f", this.getClass().getSimpleName(), agencia,
				numero, this.getTitular() != null ? this.getTitular().getNome(): "Sem Titular", saldo);
	}

	@Override
	public boolean equals(Object ref) {
		
		Conta c;
		try {
			c = (Conta) ref;
		} catch (ClassCastException e) {
			return false;
		}
		
//		if (this.getClass() == c.getClass()) {
//			if (this.getAgencia() == c.getAgencia() && this.getNumero() == c.getNumero()) {
//				return true;
//			}
//		}
//		return false;
		return this.getClass() == c.getClass() && 
				this.getAgencia() == c.getAgencia() && 
				this.getNumero() == c.getNumero() 
					? true 
					: false;
	}

}