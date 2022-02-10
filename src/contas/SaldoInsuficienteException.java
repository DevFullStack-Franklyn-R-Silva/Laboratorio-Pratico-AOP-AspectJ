package contas;

public class SaldoInsuficienteException extends Exception {
	private static final long serialVersionUID = 1L;

	private double saldo;
	private String numero;

	public SaldoInsuficienteException(double saldo, String numero) {
		super("Saldo Insuficiente!");
		this.saldo = saldo;
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getNumero() {
		return numero;
	}

}
