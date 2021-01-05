package view;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

import controller.FifaController;
import controller.IFifaController;

public class Principal {
	public static void main(String[] args) {
		IFifaController fifaCon = new FifaController();
		try {
			Stack<String> pilha = fifaCon.empilhaBrasileiros("C:\\TEMP", "data.csv");
			System.out.println("------------- Pilha de bons brasileiros -----------------\n");
			fifaCon.desempilhaBonsBrasileiros(pilha);
			
			List<String> lista = fifaCon.listaRevelacoes("C:\\TEMP", "data.csv");
			System.out.println("\n------------- Lista de bons jovens -----------------\n");
			fifaCon.buscaListaBonsJovens(lista);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
