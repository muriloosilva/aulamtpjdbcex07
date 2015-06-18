package br.edu.ifg.tads.mtp.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import br.edu.ifg.tads.mtp.jdbc.dao.ContatoDAO;
import br.edu.ifg.tads.mtp.jdbc.modelo.Contato;
import br.edu.ifg.tads.mtp.jdbc.util.Dispatcher;
import br.edu.ifg.tads.mtp.jdbc.util.Event;
import br.edu.ifg.tads.mtp.jdbc.visao.ContatoViewCadastrar;

public class ControladorContatoViewCadastrar {
	
	private ContatoViewCadastrar contatoViewCadastrar;
	private ContatoDAO cDAO;
	
	public ControladorContatoViewCadastrar(ContatoViewCadastrar contatoViewCadastrar, ContatoDAO cDAO){
		this.contatoViewCadastrar = contatoViewCadastrar;
		this.cDAO = cDAO;
		adicionaEventos();
	}
	
	public void adicionaEventos(){
		
		contatoViewCadastrar.getJbtnCancelarCadastrar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contatoViewCadastrar.dispose();
				
			}
		});		
		
		contatoViewCadastrar.getJbtnCadastrar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Contato c = new Contato();
				
				c.setNome(contatoViewCadastrar.getJtfNomeCadastrar().getText());
				c.setEmail(contatoViewCadastrar.getJtfEmailCadastrar().getText());
				c.setEndereco(contatoViewCadastrar.getJtfEnderecoCadastrar().getText());
				
				Calendar data = Calendar.getInstance();
	             data.setTime(new Date(contatoViewCadastrar.getJtfDataCadastrar().getText()));
				
				c.setDataNascimento(data);
				try{
					cDAO.adiciona(c);
				}catch(Exception ex){
					System.out.println(ex);
				}
				
				Dispatcher.getInstance().dispatchEvent(new Event("cadastrar"));
				
				contatoViewCadastrar.dispose();
			
				
			}
		});	
	}

}
