package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController{
	
	public RedesController() {
		super();
	}
	
	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	//IPv4 Windows and Linux
	public void ip(String SO) {
		String adaptador = null;
		//Windows
		if (SO.contains("Windows")){
			String process = "ipconfig";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("Adaptador")) {
						adaptador = linha.replace(":", "");
					}
					if (linha.contains("IPv4")) {
						String[] ip = linha.split(": ");
						System.out.println(adaptador + "\nIPv4: " + ip[1]);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Linux
		if (SO.contains("Linux")){
			String process = "ifconfig";
			try {
		   		 Process p = Runtime.getRuntime().exec(process);
		   		 InputStream fluxo = p.getInputStream();
		   		 InputStreamReader leitor = new InputStreamReader(fluxo);
		   		 BufferedReader buffer = new BufferedReader(leitor);
		   		 String linha = buffer.readLine();
		   		 while (linha!= null){
		   			 if(linha.contains("flags")){
		   				 adaptador = linha.substring(linha.indexOf("<")+1,linha.indexOf(">"));
		   			 }
		   			 if(linha.contains("inet ")){
		   				 String ip = linha.substring(linha.indexOf("inet")+5,linha.indexOf("netmask")-1);
		   				 System.out.println(adaptador + "\nIPv4: " + ip);
		   			 }
		   			 linha = buffer.readLine();
		   		 }
		   	 } catch (IOException e) {
		   		 String msgError = e.getMessage();
		   		 if (msgError.contains("=2,")){
		   			 System.out.println("Comando 'ifconfig' nao encontrado. Mas pode ser instalado com:\nsudo apt install net tools");;
		   		 }else{
		   		 e.printStackTrace();
		   		 }
		   	 }
		    

		}
	}
	
	
	//Average ping Windows and Linux
	public void ping(String SO) {
		//Windows
		if (SO.contains("Windows")){
			String process = "ping -n 10 www.google.com.br";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println("Running...");
					if (linha.contains("dia")) {
						linha = linha.replace(" ", "");
						String[] media = linha.split(",");
						for (String texto : media) {
							if (texto.contains("dia")) {
								media = texto.split("=");
								System.out.println("Tempo medio do ping: " + media[1]);
							}
						}
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Linux
		if (SO.contains("Linux")){
			String process = "ping -c 10 www.google.com.br";
			try {
	        	Process p = Runtime.getRuntime().exec(process);
	        	InputStream fluxo = p.getInputStream();
	        	InputStreamReader leitor = new InputStreamReader(fluxo);
	        	BufferedReader buffer = new BufferedReader(leitor);
	        	String linha = buffer.readLine();
	        	while (linha != null) {
	            	System.out.println("Running...");
	            	if (linha.contains("avg")) {
	                	linha = linha.replace(" ", "");
	                	String[] linhaSplit = linha.split("=");
	                	String[] referencia = linhaSplit[0].split("/");
	                	String[] valor = linhaSplit[1].split("/");
	                	int index = 0;
	                	for(String msg : referencia){
	               		 if(msg.contains("avg")){
	               			 break;
	               		 }else{
	               			 index += 1;
	               		 }
	                	}
	                	System.out.println("Tempo medio do ping: " + valor[index] + "ms.");
	            	}
	            	linha = buffer.readLine();
	        	}
	        	buffer.close();
	        	leitor.close();
	        	fluxo.close();
	    	} catch (Exception e) {
	        	e.printStackTrace();
	    	}
		}
	}	
}