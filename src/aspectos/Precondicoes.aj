package aspectos;

import contas.CadastroContas;
import contas.Conta;
import contas.ContaNaoEncontradaException;

public aspect Precondicoes {

	pointcut pcCreditar(double valor, Conta c):
		call(void Conta.creditar(double))  &&  target(c) && args (valor);

	void around(double valor, Conta c) : pcCreditar(valor, c){
		if (valor > 0) {
			proceed(valor, c);
			System.out.println("Creditar valor: R$ " + valor);
			System.out.println("Vou creditar");
			System.out.println("Credito efetivado com sucesso");
		} else {
			System.out.println("Credito não efetuado, valor abaixo de 0");
		}
	}

	pointcut pcDebitar(double valor, Conta c):
		call(void Conta.debitar(double))  &&  target(c) && args (valor);

	void around(double valor, Conta c) : pcDebitar(valor, c){
		if (valor > 0 && c.getSaldo() >= valor) {
			proceed(valor, c);
			System.out.println("Creditar valor: R$ " + valor);
			System.out.println("Vou debitar");
			System.out.println("Debito efetivado com sucesso");
		} else {
			System.out.println("Credito não efetuado, saldo insuficiente");
		}
	}

	pointcut pcTransferir(String numeroDe, String numeroPara, double valor, CadastroContas c):
		call(void CadastroContas.transferir(..))  &&  target(c) && args (numeroDe,numeroPara, valor);

	void around(String numeroDe, String numeroPara, double valor, CadastroContas c) : pcTransferir(numeroDe,numeroPara, valor,c){
		try {
			Conta origem = c.getRepositorio().procurar(numeroDe);

			if (valor > 0 && origem != null && origem.getSaldo() >= valor) {
				proceed(numeroDe, numeroPara, valor, c);
				System.out.println("Transferencia realizada com sucesso");
			} else {
				System.out.println("Tranferencia invalida");
			}
		} catch (ContaNaoEncontradaException e) {
			e.printStackTrace();
		}
	}
}
