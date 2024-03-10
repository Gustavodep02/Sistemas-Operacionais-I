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
					if(linha.contains("inet" )|| linha.contains("inet6")) {
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
		}
	}
	public void Ping() {
		String os = Os();
		String processo = "ping -4 -c 10 www.google.com.br";
		if(os.contains("Windows")) {
			processo = "ping -4 -n 10 www.google.com.br";
		}
		Process ping;
			try {
				ping =Runtime.getRuntime().exec(processo);
				InputStream fluxo = ping.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha;
				String ultima = "";
	            while ((linha = buffer.readLine()) != null) {
	                ultima = linha;
	            }
	            buffer.close();
	            leitor.close();
	            fluxo.close();
	            if (os.contains("Windows")) {
	                String[] split = ultima.split(" = ");
	                System.out.println("Média = " + split[split.length - 1]);
	            } else {
	                String[] split = ultima.split("/");
	                System.out.println("Média = " + split[split.length - 3]);
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
		}
	}
}
