package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class RedesController {
	public RedesController(){
		
	}
	private String Os(){
		return System.getProperty("os.name");// pega o SO e retorna
		 
	}
	public void Ip() {
		String os = Os();// recebe o SO
		Process ip;
		if(os.contains("Windows")){//caso seja windows
			try {
				ip =Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = ip.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha !=null) {
					if(linha.contains("Adaptador" )|| linha.contains("IPv4")) {
						System.out.println(linha);
					}
						linha = buffer.readLine();
					
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else {//caso seja linux
			try {
				ip =Runtime.getRuntime().exec("ifconfig");
				InputStream fluxo = ip.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha !=null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	public void Ping() {
		
	}
}
