package banco;

import java.util.concurrent.Semaphore;

public class ThreadTransacao extends Thread{
	
	private int tipoTransacao;
	private int idConta;
	private double saldo;
	private double valorTransacao;
	
	Semaphore saque;
	Semaphore deposito;
	
	public ThreadTransacao(int tipoTransacao, Semaphore saque, Semaphore deposito, int idConta, double saldo, double valorTransacao) {
		this.tipoTransacao = tipoTransacao;
		this.saque = saque;
		this.deposito = deposito;
		this.idConta = idConta;
		this.saldo = saldo;
		this.valorTransacao = valorTransacao;
	}
	
	@Override
	public void run() {
		if (tipoTransacao == 1) {
			try {
				saque.acquire();
				realizarSaque();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				saque.release();
			}
		} else {
			try {
				deposito.acquire();
				realizarDeposito();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				deposito.release();
			}
		}
	}

	private void realizarSaque() {
		saldo -= valorTransacao;
		System.out.println("#Conta " + idConta + " realizou um saque de " + valorTransacao + ", saldo atual " + saldo);
	}
	
	private void realizarDeposito() {
		saldo += valorTransacao;
		System.out.println("#Conta " + idConta + " realizou um deposito de R$" + valorTransacao + ", saldo atual R$" + saldo);
	}
}
