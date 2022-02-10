package contas;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */

public class CadastroContas {

	private RepositorioContas contas;

	public CadastroContas(RepositorioContas repositorio) {
		contas = repositorio;
	}

	public void cadastrar(Conta conta) throws ContaJaCadastradaException {
		if (contas.existe(conta.getNumero())) {
			throw new ContaJaCadastradaException(conta.getNumero());
		} else {
			contas.inserir(conta);
		}
	}

	public void creditar(String numero, double valor)
		throws ContaNaoEncontradaException {
		Conta c = contas.procurar(numero);
		c.creditar(valor);
	}

	public void debitar(String numero, double valor)
		throws ContaNaoEncontradaException, SaldoInsuficienteException {
		Conta c = contas.procurar(numero);
		c.debitar(valor);
	}

	public void transferir(String numeroDe, String numeroPara, double valor)
		throws ContaNaoEncontradaException, SaldoInsuficienteException {
		Conta de = contas.procurar(numeroDe);
		Conta para = contas.procurar(numeroPara);
		de.debitar(valor);
		para.creditar(valor);
	}

	public double saldo(String numero) throws ContaNaoEncontradaException {
		Conta c = contas.procurar(numero);
		return c.getSaldo();
	}
	
	public RepositorioContas getRepositorio() {
		return this.contas;
	}

}