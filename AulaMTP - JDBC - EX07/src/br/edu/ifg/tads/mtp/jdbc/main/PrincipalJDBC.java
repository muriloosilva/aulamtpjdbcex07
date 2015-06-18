package br.edu.ifg.tads.mtp.jdbc.main;

import javax.swing.JDesktopPane;

import br.edu.ifg.tads.mtp.jdbc.controlador.ControladorContatoView;
import br.edu.ifg.tads.mtp.jdbc.visao.ContatoView;

public class PrincipalJDBC {
	
	public static void main(String args[]){
		
		JDesktopPane deskPanel = new JDesktopPane();  
		ContatoView contatoView = new ContatoView(deskPanel);
		new ControladorContatoView(contatoView, deskPanel);
		contatoView.setVisible(true);
	}

}
