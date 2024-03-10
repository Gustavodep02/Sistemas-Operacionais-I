package view;
import javax.swing.JOptionPane;

import controller.RedesController;
public class Main {
	public static void main(String[] args) {
		RedesController r = new RedesController();
		r.Ping();
		int escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opcao\n1- Metodo IP\n2- Metodo Ping"));
		switch(escolha) {
		case 1:
			r.Ip();
			break;
		
		case 2:
			r.Ping();
			break;
		default:
				System.out.println("numero invalido");
				break;
		}
	}
}
