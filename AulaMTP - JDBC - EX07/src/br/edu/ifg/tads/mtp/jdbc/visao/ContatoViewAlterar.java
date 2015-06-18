package br.edu.ifg.tads.mtp.jdbc.visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ContatoViewAlterar extends JInternalFrame {
	private JTextField jtfNomeAlterar;
	private JTextField jtfEmailAlterar;
	private JTextField jtfEnderecoAlterar;
	private JFormattedTextField jtfDataAlterar;
	private JButton jbtnCancelarAlterar;
	private JButton jbtnAlterar;

	/**
	 * Create the frame.
	 */
	public ContatoViewAlterar() {
		setClosable(true);
		
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblCadastrarContato = new JLabel("Alterar Contato");
		lblCadastrarContato.setForeground(new Color(0, 139, 139));
		lblCadastrarContato.setFont(new Font("HanziPen TC", Font.BOLD, 24));
		lblCadastrarContato.setBounds(202, 20, 201, 42);
		getContentPane().add(lblCadastrarContato);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		lblNome.setForeground(new Color(0, 0, 128));
		lblNome.setBounds(36, 100, 61, 16);
		getContentPane().add(lblNome);
		
		jtfNomeAlterar = new JTextField() ;
		jtfNomeAlterar.setFont(new Font("HanziPen TC", Font.PLAIN, 15));
		jtfNomeAlterar.setBounds(97, 94, 434, 28);
		getContentPane().add(jtfNomeAlterar);
		jtfNomeAlterar.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		lblEmail.setForeground(new Color(0, 0, 128));
		lblEmail.setBounds(247, 134, 61, 16);
		getContentPane().add(lblEmail);
		
		jtfEmailAlterar = new JTextField();
		jtfEmailAlterar.setFont(new Font("HanziPen TC", Font.PLAIN, 15));
		jtfEmailAlterar.setColumns(10);
		jtfEmailAlterar.setBounds(308, 128, 223, 28);
		getContentPane().add(jtfEmailAlterar);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		lblEndereo.setForeground(new Color(0, 0, 128));
		lblEndereo.setBounds(36, 168, 61, 16);
		getContentPane().add(lblEndereo);
		
		jtfEnderecoAlterar = new JTextField();
		jtfEnderecoAlterar.setFont(new Font("HanziPen TC", Font.PLAIN, 15));
		jtfEnderecoAlterar.setColumns(10);
		jtfEnderecoAlterar.setBounds(97, 162, 434, 28);
		getContentPane().add(jtfEnderecoAlterar);
		
		jtfDataAlterar = new JFormattedTextField() ;
		jtfDataAlterar.setFont(new Font("HanziPen TC", Font.PLAIN, 15));
		jtfDataAlterar.setText("dd/mm/aaaa");
		jtfDataAlterar.setBounds(97, 128, 144, 28);
		getContentPane().add(jtfDataAlterar);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		lblData.setForeground(new Color(0, 0, 128));
		lblData.setBounds(36, 134, 61, 16);
		getContentPane().add(lblData);
		
		jbtnCancelarAlterar = new JButton("Cancelar");
		jbtnCancelarAlterar.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		jbtnCancelarAlterar.setBounds(124, 222, 117, 29);
		getContentPane().add(jbtnCancelarAlterar);
		
		jbtnAlterar = new JButton("Alterar");
		jbtnAlterar.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		jbtnAlterar.setBounds(286, 222, 117, 29);
		getContentPane().add(jbtnAlterar);
		setBounds(100, 100, 587, 325);
		
		this.setVisible(true);

	}

	public JTextField getJtfNomeAlterar() {
		return jtfNomeAlterar;
	}

	public void setJtfNomeAlterar(JTextField jtfNomeAlterar) {
		this.jtfNomeAlterar = jtfNomeAlterar;
	}

	public JTextField getJtfEmailAlterar() {
		return jtfEmailAlterar;
	}

	public void setJtfEmailAlterar(JTextField jtfEmailAlterar) {
		this.jtfEmailAlterar = jtfEmailAlterar;
	}

	public JTextField getJtfEnderecoAlterar() {
		return jtfEnderecoAlterar;
	}

	public void setJtfEnderecoAlterar(JTextField jtfEnderecoAlterar) {
		this.jtfEnderecoAlterar = jtfEnderecoAlterar;
	}

	public JFormattedTextField getJtfDataAlterar() {
		return jtfDataAlterar;
	}

	public void setJtfDataAlterar(JFormattedTextField jtfDataAlterar) {
		this.jtfDataAlterar = jtfDataAlterar;
	}

	public JButton getJbtnCancelarAlterar() {
		return jbtnCancelarAlterar;
	}

	public void setJbtnCancelarAlterar(JButton jbtnCancelarAlterar) {
		this.jbtnCancelarAlterar = jbtnCancelarAlterar;
	}

	public JButton getJbtnAlterar() {
		return jbtnAlterar;
	}

	public void setJbtnAlterar(JButton jbtnAlterar) {
		this.jbtnAlterar = jbtnAlterar;
	}
	
	
}
