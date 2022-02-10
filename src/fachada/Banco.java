package fachada;

import contas.*;

public class Banco {

	private CadastroContas contas;

	public Banco(RepositorioContas repositorio) {
		contas = new CadastroContas(repositorio);
	}

	public void cadastrar(Conta conta) throws ContaJaCadastradaException {
		contas.cadastrar(conta);
	}

	public void creditar(String numero, double valor)
		throws ContaNaoEncontradaException {
		contas.creditar(numero, valor);
	}

	public void debitar(String numero, double valor)
		throws ContaNaoEncontradaException, SaldoInsuficienteException {
		contas.debitar(numero, valor);
	}

	public void transferir(String numeroDe, String numeroPara, double valor)
		throws ContaNaoEncontradaException, SaldoInsuficienteException {
		contas.transferir(numeroDe, numeroPara, valor);
	}

	public double saldo(String numero) throws ContaNaoEncontradaException {
		return contas.saldo(numero);
	}

}