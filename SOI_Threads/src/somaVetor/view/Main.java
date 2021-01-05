package view;

import java.util.Random;
import controller.SomaVetor;

public class Main{
	
	public static void main(String[] args) {
		int[][] array = new int[3][5];
		Random random = new Random();
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				array[i][j] = random.nextInt(100);
			}
		}
		
		for(int i = 0; i < 3; i++) {
			Thread somaVetor = new SomaVetor(i, array[i]);
			somaVetor.start();
		}
		
//		int somaMatriz = 0;
//		for(int i = 0; i < 3; i++) {
//			for(int j = 0; j < 5; j++) {
//				somaMatriz += array[i][j];
//			}			
//		}
//		System.out.println("Soma Matriz: " + somaMatriz);
	}
	
}