package contas;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */

public class RepositorioContasLista implements RepositorioContas {

	private Conta conta;
	private RepositorioContasLista proximo;

	public RepositorioContasLista() {
		conta = null;
		proximo = null;
	}

	public void inserir(Conta conta) {
		if (this.conta != null) {
			proximo.inserir(conta);
		} else {
			this.conta = conta;
			this.proximo = new RepositorioContasLista();
		}
	}

	public void atualizar(Conta conta) throws ContaNaoEncontradaException {
		if (this.conta != null) {
			if (this.conta.getNumero().equals(conta.getNumero())) {
				this.conta = conta;
			} else {
				proximo.atualizar(conta);
			}
		} else {
			throw new ContaNaoEncontradaException(conta.getNumero());
		}
	}

	public void remover(String numero) throws ContaNaoEncontradaException {
		if (this.conta != null) {
			if (this.conta.getNumero().equals(numero)) {
				this.conta = proximo.conta;
				this.proximo = proximo.proximo;
			} else {
				proximo.remover(numero);
			}
		} else {
			throw new ContaNaoEncontradaException(numero);
		}
	}

	public Conta procurar(String numero) throws ContaNaoEncontradaException {
		Conta resposta = null;
		if (this.conta != null) {
			if (this.conta.getNumero().equals(numero)) {
				resposta = this.conta;
			} else {
				resposta = proximo.procurar(numero);
			}
		} else {
			throw new ContaNaoEncontradaException(numero);
		}
		return resposta;
	}

	public boolean existe(String numero) {
		boolean resposta;
		if (this.conta != null) {
			if (this.conta.getNumero().equals(numero)) {
				resposta = true;
			} else {
				resposta = proximo.existe(numero);
			}
		} else {
			resposta = false;
		}
		return resposta;
	}

}