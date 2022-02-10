package aspectos;

import contas.Conta;

public aspect Mensagens {
	/*
	 * JoinPoint : Joinpoint são pontos na execução do seu programa onde o fluxo de
	 * execução foi alterado como captura de exceção, chamada de outro método.
	 * 
	 * PointCut : PointCut são basicamente aqueles pontos de junção onde você pode
	 * colocar seu conselho (ou aspecto de chamada). Basicamente, os PointCuts são o
	 * subconjunto dos JoinPoints .
	 * 
	 * Os três pointcuts primitivos (this , target e args) são usados ​​para
	 * publicar esses valores.
	 * 
	 */
	/*
	 * @Before métodos anotados são executados exatamente antes de todos os métodos
	 * correspondentes à expressão pointcut
	 */
	/*
	 * @Aftermétodos anotados são executados exatamente após todos os métodos
	 * correspondentes à expressão pointcut.
	 */
	before(double valor, Conta c) : pcCreditar(valor,c){
		System.out.println("Seu saldo Atual: " + c.getSaldo());
	}

	before(double valor, Conta c) : pcCreditar(valor,c) {
		System.out.println("Vou creditar: " + valor);
	}

	after(double valor, Conta c) : pcCreditar(valor, c){
		System.out.println("Seu saldo Atualizado: " + c.getSaldo());
	}

	pointcut pcCreditar(double valor, Conta c): call(public * creditar(..)) && target(c)
	&& args (valor);

}
