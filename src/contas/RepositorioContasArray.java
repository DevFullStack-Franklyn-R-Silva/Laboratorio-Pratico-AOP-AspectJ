package contas;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */

public class RepositorioContasArray implements RepositorioContas {

	private Conta[] contas;
	private int indice;

	public RepositorioContasArray() {
		contas = new Conta[100];
		indice = 0;
	}

	public void inserir(Conta conta) {
		contas[indice] = conta;
		indice = indice + 1;
	}

	public void atualizar(Conta conta) throws ContaNaoEncontradaException {
		int i = getIndice(conta.getNumero());
		if (i == indice) {
			throw new ContaNaoEncontradaException(conta.getNumero());
		} else {
			contas[i] = conta;
		}
	}

	public void remover(String numero) throws ContaNaoEncontradaException {
		int i = getIndice(numero);
		if (i == indice) {
			throw new ContaNaoEncontradaException(numero);
		} else {
			contas[i] = contas[indice - 1];
			indice = indice - 1;
		}
	}

	public Conta procurar(String numero) throws ContaNaoEncontradaException {
		Conta resposta = null;
		int i = getIndice(numero);
		if (i == indice) {
			throw new ContaNaoEncontradaException(numero);
		} else {
			resposta = contas[i];
		}
		return resposta;
	}

	public boolean existe(String numero) {
		boolean resposta;
		int i = getIndice(numero);
		if (i == indice) {
			resposta = false;
		} else {
			resposta = true;
		}
		return resposta;
	}

	private int getIndice(String numero) {
		String n;
		boolean achou = false;
		int i = 0;
		while ((!achou) && (i < indice)) {
			n = contas[i].getNumero();
			if (n.equals(numero)) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}

}