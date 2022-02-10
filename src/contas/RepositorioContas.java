package contas;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */

public interface RepositorioContas {

	public void inserir(Conta conta);

	public void atualizar(Conta conta) throws ContaNaoEncontradaException;

	public void remover(String numero) throws ContaNaoEncontradaException;

	public Conta procurar(String numero) throws ContaNaoEncontradaException;

	public boolean existe(String numero);

}