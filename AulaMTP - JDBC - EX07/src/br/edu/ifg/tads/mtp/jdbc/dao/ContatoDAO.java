package br.edu.ifg.tads.mtp.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import br.edu.ifg.tads.mtp.jdbc.bd.ConnectionFactory;
import br.edu.ifg.tads.mtp.jdbc.modelo.Contato;

public class ContatoDAO {
	
	public void adiciona(Contato contato) {
	     String sql = "insert into contatos " +
	             "(nome,email,endereco,dataNascimento)" +
	             " values (?,?,?,?)";
	     Connection con = null;
	     try {
	         // prepared statement para inserção
	    	 con = new ConnectionFactory().getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql);
	 
	         // seta os valores
	         stmt.setString(1,contato.getNome());
	         stmt.setString(2,contato.getEmail());
	         stmt.setString(3,contato.getEndereco());
	         stmt.setDate(4, new Date(
	                 contato.getDataNascimento().getTimeInMillis()));
	 
	         // executa
	         stmt.execute();
	     } catch (Exception e) {
	         throw new RuntimeException("falha ao tentar executar um comando no BD. Verifique sua conexão");
	     }finally{
	    	 try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException("não foi possível fechar a conexão com o BD");
			}
	     }
	 }
	
	public Contato buscaContato(Contato c){
		System.out.println(c.getId());
		PreparedStatement stmt;
		Contato contato = new Contato();
		try {
			Connection con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement("select * from contatos where id = "+ c.getId());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				// criando o objeto Contato
				contato.setId(rs.getLong("id"));
	             contato.setNome(rs.getString("nome"));
	             contato.setEmail(rs.getString("email"));
	             contato.setEndereco(rs.getString("endereco"));
	 
	             // montando a data através do Calendar
	             Calendar data = Calendar.getInstance();
	             data.setTime(rs.getDate("dataNascimento"));
	             contato.setDataNascimento(data);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return contato;
		
	}
	
	public Vector<Vector<String>> buscaContatos(){
		
		try {
			Vector<Vector<String>> contatos = new Vector<Vector<String>>();
	         PreparedStatement stmt = new ConnectionFactory().getConnection().
	                 prepareStatement("select * from contatos order by id");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	             // criando o objeto Contato
	             Contato contato = new Contato();
	             contato.setId(rs.getLong("id"));
	             contato.setNome(rs.getString("nome"));
	             contato.setEmail(rs.getString("email"));
	             contato.setEndereco(rs.getString("endereco"));
	 
	             // montando a data através do Calendar
	             Calendar data = Calendar.getInstance();
	             data.setTime(rs.getDate("dataNascimento"));
	             contato.setDataNascimento(data);
	             System.out.println(contato.getDataNascimento());
	             
	             Vector<String> colunas = new Vector<String>();
	     		colunas.add(""+contato.getId());
	     		colunas.add(contato.getNome());
	     		colunas.add(contato.getEndereco());
	     		colunas.add(contato.getEmail());
	     		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	     		colunas.add(sdf.format(contato.getDataNascimento().getTime()));
	     		 System.out.println(contato.getDataNascimento().getTime());
	     		colunas.add("alterar");
	     		colunas.add("excluir");
	 
	             // adicionando o objeto à lista
	             contatos.add(colunas);
	         }
	         rs.close();
	         stmt.close();
	         return contatos;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	public Vector<Vector<String>> buscaContatosNome(Contato c){
		
		try {
			Vector<Vector<String>> contatos = new Vector<Vector<String>>();
	         PreparedStatement stmt = new ConnectionFactory().getConnection().
	                 prepareStatement("select * from contatos where nome like '%"+c.getNome()+"%'");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	             // criando o objeto Contato
	             Contato contato = new Contato();
	             contato.setId(rs.getLong("id"));
	             contato.setNome(rs.getString("nome"));
	             contato.setEmail(rs.getString("email"));
	             contato.setEndereco(rs.getString("endereco"));
	 
	             // montando a data através do Calendar
	             Calendar data = Calendar.getInstance();
	             data.setTime(rs.getDate("dataNascimento"));
	             contato.setDataNascimento(data);
	             
	             Vector<String> colunas = new Vector<String>();
	     		colunas.add(""+contato.getId());
	     		colunas.add(contato.getNome());
	     		colunas.add(contato.getEndereco());
	     		colunas.add(contato.getEmail());
	     		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	     		colunas.add(sdf.format(contato.getDataNascimento().getTime()));
	     		colunas.add("alterar");
	     		colunas.add("excluir");
	 
	             // adicionando o objeto à lista
	             contatos.add(colunas);
	         }
	         rs.close();
	         stmt.close();
	         return contatos;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	public void altera(Contato contato) {
	     String sql = "update contatos set nome=?, email=?, endereco=?," +
	             "datanascimento=? where id=?";
	     try {
	         PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement(sql);
	         stmt.setString(1, contato.getNome());
	         stmt.setString(2, contato.getEmail());
	         stmt.setString(3, contato.getEndereco());
	         stmt.setDate(4, new Date(contato.getDataNascimento()
	                 .getTimeInMillis()));
	         stmt.setLong(5, contato.getId());
	         System.out.println(stmt.toString());
	         stmt.executeUpdate();
	         stmt.close();
	     } catch (SQLException e) {
	    	 System.out.println(e);
	         throw new RuntimeException(e);
	     }
	 }
	
	public void remove(Contato contato) {
	     try {
	         PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement("delete from contatos where id=?");
	         stmt.setLong(1, contato.getId());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

}
