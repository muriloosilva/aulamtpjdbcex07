package br.edu.ifg.tads.mtp.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.edu.ifg.tads.mtp.jdbc.dao.ContatoDAO;
import br.edu.ifg.tads.mtp.jdbc.modelo.Contato;
import br.edu.ifg.tads.mtp.jdbc.util.Dispatcher;
import br.edu.ifg.tads.mtp.jdbc.util.Event;
import br.edu.ifg.tads.mtp.jdbc.visao.ContatoViewAlterar;

public class ControladorContatoViewAlterar{
	
	private ContatoViewAlterar contatoViewAlterar;
	private Contato contato;
	private ContatoDAO cDAO;
	
	public ControladorContatoViewAlterar(ContatoViewAlterar contatoViewAlterar, Contato contato, ContatoDAO cDAO){
		this.contatoViewAlterar = contatoViewAlterar;
		this.contato = contato;
		this.cDAO = cDAO;
		
		adicionaEventos();
		carregaDadosContato();
	}
	
	public void carregaDadosContato(){
		
		contatoViewAlterar.getJtfNomeAlterar().setText(contato.getNome());
		contatoViewAlterar.getJtfEmailAlterar().setText(contato.getEmail());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		contatoViewAlterar.getJtfDataAlterar().setText(sdf.format(contato.getDataNascimento().getTime()));
		contatoViewAlterar.getJtfEnderecoAlterar().setText(contato.getEndereco());
		
		
	}
	
	public void adicionaEventos(){
		
		contatoViewAlterar.getJbtnCancelarAlterar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contatoViewAlterar.dispose();
				
			}
		});	
		
		contatoViewAlterar.getJbtnAlterar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Contato c = new Contato();
				
				c.setNome(contatoViewAlterar.getJtfNomeAlterar().getText());
				c.setEmail(contatoViewAlterar.getJtfEmailAlterar().getText());
				c.setEndereco(contatoViewAlterar.getJtfEnderecoAlterar().getText());
				c.setId(contato.getId());
				
				Calendar data = Calendar.getInstance();
	             data.setTime(new Date(contatoViewAlterar.getJtfDataAlterar().getText()));
				
				c.setDataNascimento(data);
				try{
					cDAO.altera(c);
				}catch(Exception ex){
					System.out.println(ex);
				}
				
				Dispatcher.getInstance().dispatchEvent(new Event("alteracao"));
				
				contatoViewAlterar.dispose();
				
			}
		});	
	}

}
