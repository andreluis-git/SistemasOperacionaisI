package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FifaController implements IFifaController{

	@Override
	public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		File dir = new File(caminho,nome);
		Stack<String> pilha = new Stack<String>();
		FileInputStream fluxo = new FileInputStream(dir);
		InputStreamReader leitor = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(leitor);
		String linha = buffer.readLine();
		linha = buffer.readLine();
		while(linha != null) {
			String linhaSplit[] = linha.split(",");
			if(linhaSplit[5].equals("Brazil")) {
				pilha.push(linha);
			}
			linha = buffer.readLine();
		}
		buffer.close();
		leitor.close();
		fluxo.close();
		return pilha;
	}

	@Override
	public void desempilhaBonsBrasileiros(Stack<String> pilha) throws IOException {
		String linha;
		while(!pilha.isEmpty()) {
			linha = pilha.pop();
			String linhaSplit[] = linha.split(",");
			if(Integer.parseInt(linhaSplit[7]) > 80) {
				System.out.println("Jogador: " + linhaSplit[2] + " -- Overall: " + linhaSplit[7]);
			}
		}
	}

	@Override
	public List<String> listaRevelacoes(String caminho, String nome) throws IOException {
		File dir = new File(caminho,nome);
		List<String> lista = new LinkedList<>();
		FileInputStream fluxo = new FileInputStream(dir);
		InputStreamReader leitor = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(leitor);
		String linha = buffer.readLine();
		linha = buffer.readLine();
		while(linha != null) {
			String linhaSplit[] = linha.split(",");
			if(Integer.parseInt(linhaSplit[3]) <= 20) {
				lista.add(linha);
			}
			linha = buffer.readLine();
		}
		buffer.close();
		leitor.close();
		fluxo.close();
		return lista;
	}

	@Override
	public void buscaListaBonsJovens(List<String> lista) throws IOException {
		String linha;
		for (int i = lista.size() - 1; i >= 0; i--){
			linha = lista.get(i);
			String linhaSplit[] = linha.split(",");
			if(Integer.parseInt(linhaSplit[7]) > 80) {
				System.out.println("Jogador: " + linhaSplit[2] + " -- Overall: " + linhaSplit[7]);
			}
		}
	}
	
}
