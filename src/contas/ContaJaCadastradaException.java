package contas;

public class ContaJaCadastradaException extends Exception {
	private static final long serialVersionUID = 1L;

	private String numero;

	public ContaJaCadastradaException(String numero) {
		super("Conta j� existente!");
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}
}