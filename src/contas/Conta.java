package contas;

/**
 * Classe que modela objetos que representam contas de um banco.
 */
public class Conta {

	// representa o número da conta
	private String numero;

	// representa o saldo da conta
	private double saldo;

	/**
	 * Construtor que recebe um String para inicializar o
	 * atributo número e um double para inicializar o saldo.
	 */
	public Conta(String numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}

	/**
	 * Construtor que recebe um String para inicializar o
	 * atributo número. O saldo é inicializado com zero.
	 */
	public Conta(String numero) {
		this(numero, 0.0);
	}

	/**
	 * Retorna o valor do atributo numero do objeto.
	 */
	public String getNumero() {
		return this.numero;
	}

	/**
	 * Retorna o valor do atributo saldo do objeto.
	 */
	public double getSaldo() {
		return this.saldo;
	}

	/**
	 * Soma ao saldo um valor recebido como parâmetro
	 */
	public void creditar(double valor) {
		this.saldo = this.saldo + valor;
	}

	public void debitar(double valor) throws SaldoInsuficienteException {
		if (valor > saldo) {
			throw new SaldoInsuficienteException(saldo, numero);
		} else {
			this.saldo = this.saldo - valor;
		}
	}

}