package br.edu.ifg.tads.mtp.jdbc.visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ContatoView extends JFrame {
	private JTextField jtfPesquisar;
	private JTable table;
	private JButton jbtnPesquisar;
	private JButton jbtnNovoContato;

	/**
	 * Create the frame.
	 */
	public ContatoView(JDesktopPane desktopPane) {
		setContentPane(desktopPane);
		setTitle("Sistema Contatos v1.0");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 601);
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		desktopPane.setLayout(null);
		
		JLabel lblPesquisarPorNome = new JLabel("Pesquisar por nome");
		lblPesquisarPorNome.setForeground(new Color(0, 0, 128));
		lblPesquisarPorNome.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		lblPesquisarPorNome.setBounds(16, 98, 124, 16);
		desktopPane.add(lblPesquisarPorNome);
		
		jtfPesquisar = new JTextField();
		jtfPesquisar.setForeground(new Color(0, 0, 128));
		jtfPesquisar.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		jtfPesquisar.setBounds(152, 92, 513, 28);
		desktopPane.add(jtfPesquisar);
		jtfPesquisar.setColumns(10);
		
		jbtnPesquisar = new JButton("Pesquisar");
		jbtnPesquisar.setForeground(new Color(0, 0, 128));
		jbtnPesquisar.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		jbtnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jbtnPesquisar.setBounds(677, 93, 117, 29);
		desktopPane.add(jbtnPesquisar);
		
		JLabel lblSistemaContatosV = new JLabel("SISTEMA CONTATOS V1.0");
		lblSistemaContatosV.setForeground(new Color(0, 128, 128));
		lblSistemaContatosV.setFont(new Font("HanziPen TC", Font.BOLD, 24));
		lblSistemaContatosV.setBounds(263, 18, 357, 38);
		desktopPane.add(lblSistemaContatosV);
		
		jbtnNovoContato = new JButton("Novo Contato");
		jbtnNovoContato.setForeground(new Color(0, 0, 128));
		jbtnNovoContato.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		jbtnNovoContato.setBounds(6, 501, 117, 29);
		desktopPane.add(jbtnNovoContato);
		
		
		table = new JTable ();
		table.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		table.setBounds(16, 139, 778, 350);
		table.setBackground(UIManager.getColor("Button.background"));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(16, 139, 778, 350);
		desktopPane.add(jScrollPane);
	}

	public JTextField getJtfPesquisar() {
		return jtfPesquisar;
	}

	public void setJtfPesquisar(JTextField jtfPesquisar) {
		this.jtfPesquisar = jtfPesquisar;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getJbtnPesquisar() {
		return jbtnPesquisar;
	}

	public void setJbtnPesquisar(JButton jbtnPesquisar) {
		this.jbtnPesquisar = jbtnPesquisar;
	}

	public JButton getJbtnNovoContato() {
		return jbtnNovoContato;
	}

	public void setJbtnNovoContato(JButton jbtnNovoContato) {
		this.jbtnNovoContato = jbtnNovoContato;
	}
	
	
}
