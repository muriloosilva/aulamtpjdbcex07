package br.edu.ifg.tads.mtp.jdbc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.edu.ifg.tads.mtp.jdbc.dao.ContatoDAO;
import br.edu.ifg.tads.mtp.jdbc.modelo.Contato;
import br.edu.ifg.tads.mtp.jdbc.util.ButtonColumn;
import br.edu.ifg.tads.mtp.jdbc.util.Dispatcher;
import br.edu.ifg.tads.mtp.jdbc.util.Listener;
import br.edu.ifg.tads.mtp.jdbc.visao.ContatoView;
import br.edu.ifg.tads.mtp.jdbc.visao.ContatoViewAlterar;
import br.edu.ifg.tads.mtp.jdbc.visao.ContatoViewCadastrar;

public class ControladorContatoView{
	
	private ContatoView contatoView;
	private JDesktopPane desktopPane;
	private ContatoDAO contatoDAO = new ContatoDAO();
	private Action alterarAction;
	private Action excluirAction;
	
	public ControladorContatoView(ContatoView contatoView, JDesktopPane desktopPane){
		
		this.contatoView = contatoView;
		this.desktopPane = desktopPane;
		adicionaEventos();
		preencheTabela();
		adicionaListener();
		
	}
	
	public void adicionaListener(){
 
         
        // Outro modo para criar um listener (Anonymous inner type)
        Dispatcher.getInstance().addListener(new Listener() {
 

			@Override
			public void receivedEvent(br.edu.ifg.tads.mtp.jdbc.util.Event event) {
				if(event.getName().equals("alteracao") || event.getName().equals("cadastrar")){
					preencheTabela();
					
				}
				
			}
        });
	}
	
	public void adicionaEventos(){
		
		contatoView.getJbtnPesquisar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Contato c = new Contato();
				c.setNome(contatoView.getJtfPesquisar().getText());
				Vector<Vector<String>> listaContatos = contatoDAO.buscaContatosNome(c);
				preencheTabela(listaContatos);
			}
		});
		
		contatoView.getJbtnNovoContato().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ContatoViewCadastrar contatoViewCadastrar = new ContatoViewCadastrar();
				new ControladorContatoViewCadastrar(contatoViewCadastrar, contatoDAO);
				desktopPane.add(contatoViewCadastrar);
				desktopPane.moveToFront(contatoViewCadastrar);
				
			}
		});
		
		alterarAction = new AbstractAction()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = Integer.parseInt(e.getActionCommand());
				int id = Integer.parseInt(contatoView.getTable().getValueAt(index, 0).toString());
				Contato c = new Contato();
				c.setId((long)id);
				Contato bC = contatoDAO.buscaContato(c);
				ContatoViewAlterar contatoViewAlterar = new ContatoViewAlterar();
				new ControladorContatoViewAlterar(contatoViewAlterar, bC,contatoDAO);
				desktopPane.add(contatoViewAlterar);
				desktopPane.moveToFront(contatoViewAlterar);
				
			}
		};
		
		excluirAction = new AbstractAction()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = Integer.parseInt(e.getActionCommand());
				int id = Integer.parseInt(contatoView.getTable().getValueAt(index, 0).toString());
				Contato c = new Contato();
				c.setId((long)id);
				Contato bC = contatoDAO.buscaContato(c);
				int r = JOptionPane.showConfirmDialog(desktopPane, "Realmente deseja excluir o contato " + bC.getNome() + "?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION );
				if(r==0){
					contatoDAO.remove(bC);
					preencheTabela();
				}
			}
		};
		
		
	}
	
	public void preencheTabela(){
		
		Vector<Vector<String>> listaContatos = contatoDAO.buscaContatos();
		preencheTabela(listaContatos);
			
	}
	
	public void preencheTabela(Vector<Vector<String>> listaContatos){
		
		contatoView.getTable().clearSelection();
		contatoView.getTable().removeAll();
		
		Vector<String> colunas = new Vector<String>();
		colunas.add("id");
		colunas.add("Nome");
		colunas.add("EMail");
		colunas.add("Endereco");
		colunas.add("Data");
		colunas.add("");
		colunas.add("");
		
		DefaultTableModel model = new DefaultTableModel(listaContatos, colunas);
		contatoView.getTable().setModel(model);
		contatoView.getTable().getColumn("id").setMaxWidth(25);
		new ButtonColumn(contatoView.getTable(),alterarAction, 5); 
		new ButtonColumn(contatoView.getTable(),excluirAction, 6);
		
		
	}
	

}
