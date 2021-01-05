package view;

import controller.CorridaSapos;

public class Main{
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Thread corridaSapos = new CorridaSapos(i+1);
			corridaSapos.start();
		}
		
	}
}