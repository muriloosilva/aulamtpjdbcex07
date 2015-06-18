package br.edu.ifg.tads.mtp.jdbc.visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class ContatoViewCadastrar extends JInternalFrame {
	private JTextField jtfNomeCadastrar;
	private JTextField jtfEmailCadastrar;
	private JTextField jtfEnderecoCadastrar;
	private JFormattedTextField jtfDataCadastrar;
	private JButton jbtnCancelarCadastrar;
	private JButton jbtnCadastrar;

	/**
	 * Create the frame.
	 */
	public ContatoViewCadastrar() {
		setClosable(true);
		
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblCadastrarContato = new JLabel("Cadastrar Contato");
		lblCadastrarContato.setForeground(new Color(0, 139, 139));
		lblCadastrarContato.setFont(new Font("HanziPen TC", Font.BOLD, 24));
		lblCadastrarContato.setBounds(202, 20, 201, 42);
		getContentPane().add(lblCadastrarContato);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		lblNome.setForeground(new Color(0, 0, 128));
		lblNome.setBounds(36, 100, 61, 16);
		getContentPane().add(lblNome);
		
		jtfNomeCadastrar = new JTextField();
		jtfNomeCadastrar.setFont(new Font("HanziPen TC", Font.PLAIN, 15));
		jtfNomeCadastrar.setBounds(97, 94, 434, 28);
		getContentPane().add(jtfNomeCadastrar);
		jtfNomeCadastrar.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		lblEmail.setForeground(new Color(0, 0, 128));
		lblEmail.setBounds(247, 134, 61, 16);
		getContentPane().add(lblEmail);
		
		jtfEmailCadastrar = new JTextField();
		jtfEmailCadastrar.setFont(new Font("HanziPen TC", Font.PLAIN, 15));
		jtfEmailCadastrar.setColumns(10);
		jtfEmailCadastrar.setBounds(308, 128, 223, 28);
		getContentPane().add(jtfEmailCadastrar);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		lblEndereo.setForeground(new Color(0, 0, 128));
		lblEndereo.setBounds(36, 168, 61, 16);
		getContentPane().add(lblEndereo);
		
		jtfEnderecoCadastrar = new JTextField();
		jtfEnderecoCadastrar.setFont(new Font("HanziPen TC", Font.PLAIN, 15));
		jtfEnderecoCadastrar.setColumns(10);
		jtfEnderecoCadastrar.setBounds(97, 162, 434, 28);
		getContentPane().add(jtfEnderecoCadastrar);
		
		jtfDataCadastrar = new JFormattedTextField();
		jtfDataCadastrar.setFont(new Font("HanziPen TC", Font.PLAIN, 15));
		jtfDataCadastrar.setText("dd/mm/aaaa");
		jtfDataCadastrar.setBounds(97, 128, 144, 28);
		getContentPane().add(jtfDataCadastrar);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		lblData.setForeground(new Color(0, 0, 128));
		lblData.setBounds(36, 134, 61, 16);
		getContentPane().add(lblData);
		
		jbtnCancelarCadastrar = new JButton("Cancelar");
		jbtnCancelarCadastrar.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		jbtnCancelarCadastrar.setBounds(124, 222, 117, 29);
		getContentPane().add(jbtnCancelarCadastrar);
		
		jbtnCadastrar = new JButton("Cadastrar");
		jbtnCadastrar.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		jbtnCadastrar.setBounds(286, 222, 117, 29);
		getContentPane().add(jbtnCadastrar);
		setBounds(100, 100, 587, 325);
		
		this.setVisible(true);

	}

	public JTextField getJtfNomeCadastrar() {
		return jtfNomeCadastrar;
	}

	public void setJtfNomeCadastrar(JTextField jtfNomeCadastrar) {
		this.jtfNomeCadastrar = jtfNomeCadastrar;
	}

	public JTextField getJtfEmailCadastrar() {
		return jtfEmailCadastrar;
	}

	public void setJtfEmailCadastrar(JTextField jtfEmailCadastrar) {
		this.jtfEmailCadastrar = jtfEmailCadastrar;
	}

	public JTextField getJtfEnderecoCadastrar() {
		return jtfEnderecoCadastrar;
	}

	public void setJtfEnderecoCadastrar(JTextField jtfEnderecoCadastrar) {
		this.jtfEnderecoCadastrar = jtfEnderecoCadastrar;
	}

	public JFormattedTextField getJtfDataCadastrar() {
		return jtfDataCadastrar;
	}

	public void setJtfDataCadastrar(JFormattedTextField jtfDataCadastrar) {
		this.jtfDataCadastrar = jtfDataCadastrar;
	}

	public JButton getJbtnCancelarCadastrar() {
		return jbtnCancelarCadastrar;
	}

	public void setJbtnCancelarCadastrar(JButton jbtnCancelarCadastrar) {
		this.jbtnCancelarCadastrar = jbtnCancelarCadastrar;
	}

	public JButton getJbtnCadastrar() {
		return jbtnCadastrar;
	}

	public void setJbtnCadastrar(JButton jbtnCadastrar) {
		this.jbtnCadastrar = jbtnCadastrar;
	}
	
	
}
