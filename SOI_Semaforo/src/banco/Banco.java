package banco;

import java.util.concurrent.Semaphore;

public class Banco {

	public static void main(String[] args) {
		
		int permissoesSaque = 1;
		int permissoesDeposito = 1;
		int tipoTransacao;
		int saldo;
		int valorTransacao;
		
		Semaphore saque = new Semaphore(permissoesSaque);
		Semaphore deposito = new Semaphore(permissoesDeposito);
		
		for(int idConta = 0; idConta < 20; idConta++) {
			tipoTransacao = (int)((Math.random()*2)+1);
			saldo = (int)((Math.random()*5001)+3000);
			valorTransacao = (int)((Math.random()*2001)+1000);
			Thread tTransacao = new ThreadTransacao(tipoTransacao, saque, deposito, idConta, saldo, valorTransacao);
			tTransacao.start();
		}
	}

}
