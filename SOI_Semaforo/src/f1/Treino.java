package f1;

import java.util.concurrent.Semaphore;

public class Treino {

	public static void main(String[] args) {
		
		int permissaoPista = 5;
//		int permissaoEscuderia = 1;
		int permissaoTabela = 1;
		
		Semaphore carrosPista = new Semaphore(permissaoPista);
// ----------------------OUTRA FORMA DE DECLARAR O VETOR DE SEMAFOROS --------------------------------		
//		Semaphore[] carroEscuderia = new Semaphore [] {new Semaphore(1),
//			     new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1)};
		Semaphore[] carroEscuderia = new Semaphore [7];
		Semaphore tabela = new Semaphore(permissaoTabela);
		
		for(int idEscuderia = 0; idEscuderia < 7; idEscuderia++) {
			carroEscuderia[idEscuderia] = new Semaphore(1);
			for(int idCarro = 0; idCarro < 2; idCarro++) {
				Thread tCarro = new ThreadEscuderia(idEscuderia, idCarro, carrosPista, carroEscuderia[idEscuderia], tabela);
				tCarro.start();
			}
		}

// -----------------------OUTRA FORMA DE CHAMAR AS THREADS------------------------------
//		Semaphore carroEscuderia1 = new Semaphore(permissaoEscuderia);
//		Semaphore carroEscuderia2 = new Semaphore(permissaoEscuderia);
//		Semaphore carroEscuderia3 = new Semaphore(permissaoEscuderia);
//		Semaphore carroEscuderia4 = new Semaphore(permissaoEscuderia);
//		Semaphore carroEscuderia5 = new Semaphore(permissaoEscuderia);
//		Semaphore carroEscuderia6 = new Semaphore(permissaoEscuderia);
//		Semaphore carroEscuderia7 = new Semaphore(permissaoEscuderia);
		
//		Thread tCarro1 = new ThreadEscuderia(0, 0, carrosPista, carroEscuderia1, tabela);
//		Thread tCarro2 = new ThreadEscuderia(0, 1, carrosPista, carroEscuderia1, tabela);
//		Thread tCarro3 = new ThreadEscuderia(1, 0, carrosPista, carroEscuderia2, tabela);
//		Thread tCarro4 = new ThreadEscuderia(1, 1, carrosPista, carroEscuderia2, tabela);
//		Thread tCarro5 = new ThreadEscuderia(2, 0, carrosPista, carroEscuderia3, tabela);
//		Thread tCarro6 = new ThreadEscuderia(2, 1, carrosPista, carroEscuderia3, tabela);
//		Thread tCarro7 = new ThreadEscuderia(3, 0, carrosPista, carroEscuderia4, tabela);
//		Thread tCarro8 = new ThreadEscuderia(3, 1, carrosPista, carroEscuderia4, tabela);
//		Thread tCarro9 = new ThreadEscuderia(4, 0, carrosPista, carroEscuderia5, tabela);
//		Thread tCarro10 = new ThreadEscuderia(4, 1, carrosPista, carroEscuderia5, tabela);
//		Thread tCarro11 = new ThreadEscuderia(5, 0, carrosPista, carroEscuderia6, tabela);
//		Thread tCarro12 = new ThreadEscuderia(5, 1, carrosPista, carroEscuderia6, tabela);
//		Thread tCarro13 = new ThreadEscuderia(6, 0, carrosPista, carroEscuderia7, tabela);
//		Thread tCarro14 = new ThreadEscuderia(6, 1, carrosPista, carroEscuderia7, tabela);
//		tCarro1.start();
//		tCarro2.start();
//		tCarro3.start();
//		tCarro4.start();
//		tCarro5.start();
//		tCarro6.start();
//		tCarro7.start();
//		tCarro8.start();
//		tCarro9.start();
//		tCarro10.start();
//		tCarro11.start();
//		tCarro12.start();
//		tCarro13.start();
//		tCarro14.start();
		
	}

}
