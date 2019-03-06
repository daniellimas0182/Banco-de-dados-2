package bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Objects.Comunicados;
import Objects.DadosRegistro;
import Objects.Endereco;
import Objects.Localizacao;
import Objects.Reunioes;

public class BancoDados {
	private static final String url = "jdbc:mysql://localhost/dti17";//porta 3306
    private static final String user = "root";
    private static final String senha = "";
    private static final String driver = "com.mysql.jdbc.Driver";
	private static Connection conexao = null;
	public static String nomeRegistro;
	static int idR;
	
	public BancoDados() {}
	
	public static Connection getConexao(){
		if(conexao == null) {
			try {
			conexao = (Connection)DriverManager.getConnection(url, user, senha);
			System.out.println("conectou");
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro na conexao com o banco", "Atencao", JOptionPane.WARNING_MESSAGE);
			}
		}
	return conexao;
}
	public static void fecharConexao() {
		if(conexao != null) {
			try {
				conexao.close();
				System.out.println("fechou");
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro na conexao com o banco", "Atencao", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	 public static boolean validarLogin(String usuario, String senha) {
	        boolean x = false;
	    	try {
	    	PreparedStatement stmt = conexao.prepareStatement("SELECT nome, senha FROM registro WHERE nome = ? and senha = ?");
	    	stmt.setString(1, usuario);
	        stmt.setString(2, senha);
	        ResultSet rs = stmt.executeQuery();
	        if(rs.next()) {
	    		x = true;
	    	}
	    	}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro em: "+e, "Atencao", JOptionPane.WARNING_MESSAGE);
	    	}
			return x;
	    }
	
	public static void RegistroEndereUser(Endereco end) {
		try {
			PreparedStatement stmt = ((java.sql.Connection) conexao).prepareStatement("insert into endereco(rua, bairro, estado, cidade, complemento) values(?,?,?,?,?)");
			stmt.setString(1, end.getRua());
			stmt.setString(2, end.getBairro());
			stmt.setString(3, end.getUf());
			stmt.setString(4, end.getCidade());
			stmt.setString(5, end.getComplemento());		
			stmt.execute();
			System.out.println("FECHO1");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro em: "+e, "Atencao", JOptionPane.WARNING_MESSAGE);
		}
	}
	public static void RegistroUser(DadosRegistro dadosR, Endereco end) {
		/*Registro rg = new Registro();
		Endereco dr = rg.getDadosEndereco();
		System.out.println("aaa--> "+end.getComplemento());*/
		try {
			PreparedStatement stmt = ((java.sql.Connection) conexao).prepareStatement("insert into registro(nome, senha, email, cold, endereco_idendereco) values(?,?,?,?,?)");
			stmt.setString(1, dadosR.getNome());
			stmt.setString(2, dadosR.getSenha());
			stmt.setString(3, dadosR.getEmail());
			stmt.setInt(4, dadosR.getCold());
			stmt.setInt(5, pegaIdEndereco(end.getComplemento()));
			stmt.execute();
			System.out.println("FECHO2");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro em: "+e, "Atencao", JOptionPane.WARNING_MESSAGE);
		}
		}

	public static List<DadosRegistro> setaIdEndereco(String n){
		String n2 = "'"+n+"'";
    	List<DadosRegistro> lista = new ArrayList<DadosRegistro>();
    	//System.out.println("n2: "+n2);
    	try {
        	PreparedStatement stmt = ((java.sql.Connection) conexao).prepareStatement("SELECT idendereco FROM endereco WHERE complemento = "+n2);
        	ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			DadosRegistro drt = new DadosRegistro();
    			drt.setIdRegistro(rs.getInt("idendereco"));
    			lista.add(drt);
        	}
    	}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro em: "+e, "Atencao", JOptionPane.WARNING_MESSAGE);
    	}
    	return lista;
    }
	
	private static int pegaIdEndereco(String nome) {
		int retorno = 0;
		for(DadosRegistro dr: setaIdEndereco(nome)) {
			retorno = dr.getIdRegistro();
		}
		return retorno;
	}
	public static List<String> populaMoradores(){
    	List<String> lista = new ArrayList<String>();
    	try {
        	PreparedStatement stmt = ((java.sql.Connection) conexao).prepareStatement("SELECT nome FROM registro");
        	ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			lista.add(rs.getString("nome"));
        	}
    	}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro em: "+e, "Atencao", JOptionPane.WARNING_MESSAGE);
    	}
    	return lista;
    }

	public static void RegistroLocalizacao(Localizacao local) {
		try {
			PreparedStatement stmt = ((java.sql.Connection) conexao).prepareStatement("insert into localizacao(rua, complemento, pontuacao) values(?,?,?)");
			stmt.setString(1, local.getRua());
			stmt.setString(2, local.getComplemento());
			stmt.setInt(3, local.getPonto());
			stmt.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro em: "+e, "Atencao", JOptionPane.WARNING_MESSAGE);
		}
	}

	public static void registroComuni(Comunicados c, Localizacao l, String name) {
		try {
			PreparedStatement stmt = ((java.sql.Connection) conexao).prepareStatement("insert into comunicados(nomeInfo,comunicado, moradores, horasDispo, descricao, Registro_idRegistro, Localizacao_idLocalizacao) values(?,?,?,?,?,?,?)");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getComunicado());
			stmt.setString(3, c.getMoradores());
			stmt.setString(4, c.getHorasDispo());
			stmt.setString(5, c.getDescricao());
			stmt.setInt(6, procuraidLogado(name));
			stmt.setInt(7, procuraidLocali(l.getComplemento()));
			stmt.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro em: "+e, "Atencao", JOptionPane.WARNING_MESSAGE);
		}
	}
	public static void registroReuniao(Reunioes r, String name) {
		try {
			PreparedStatement stmt = ((java.sql.Connection) conexao).prepareStatement("insert into reunioes(daata, horario, localizacao, assuntos, Registro_idRegistro) values(?,?,?,?,?)");
			stmt.setString(1, r.getData());
			stmt.setString(2, r.getHorario());
			stmt.setString(3, r.getLocalizacao());
			stmt.setString(4, r.getAssunto());
			stmt.setInt(5, procuraidLogado(name));
			stmt.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro em: "+e, "Atencao", JOptionPane.WARNING_MESSAGE);
		}
	}

	private static int procuraidLocali(String complemento) {
		int retorno = 0;
		for(Localizacao dr: setaIdLocali(complemento)) {
			retorno = dr.getIdLocalizacao();
		}
		return retorno;
	}
	public static List<Localizacao> setaIdLocali(String n){
		String n2 = "'"+n+"'";
    	List<Localizacao> lista = new ArrayList<Localizacao>();
    	//System.out.println("n2: "+n2);
    	try {
        	PreparedStatement stmt = ((java.sql.Connection) conexao).prepareStatement("SELECT idLocalizacao FROM localizacao WHERE complemento = "+n2);
        	ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			Localizacao drt = new Localizacao();
    			drt.setIdLocalizacao(rs.getInt("idLocalizacao"));
    			lista.add(drt);
        	}
    	}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro em: "+e, "Atencao", JOptionPane.WARNING_MESSAGE);
    	}
    	return lista;
    }

	private static int procuraidLogado(String name) {
		int retorno = 0;
		for(DadosRegistro co: setaIdLogado(name)) {
			retorno = co.getIdRegistro();
		}
		return retorno;
	}
	public static List<DadosRegistro> setaIdLogado(String n){
		String n2 = "'"+n+"'";
    	List<DadosRegistro> lista = new ArrayList<DadosRegistro>();
    	try {
        	PreparedStatement stmt = ((java.sql.Connection) conexao).prepareStatement("SELECT idRegistro FROM registro WHERE nome = "+n2);
        	ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			DadosRegistro drt = new DadosRegistro();
    			drt.setIdRegistro(rs.getInt("idRegistro"));
    			lista.add(drt);
        	}
    	}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro em: "+e, "Atencao", JOptionPane.WARNING_MESSAGE);
    	}
    	return lista;
    }

	public static List<Comunicados> consultas(){
    	List<Comunicados> lista = new ArrayList<Comunicados>();
    	try {
        	PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM comunicados");
        	ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			Comunicados tb = new Comunicados();
    			tb.setNome(rs.getString("nomeInfo"));
    			tb.setComunicado(rs.getString("comunicado"));
    			tb.setDescricao(rs.getString("descricao"));
    			lista.add(tb);
        	}
    	}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro em: "+e, "Atencao", JOptionPane.WARNING_MESSAGE);
    	}
    	return lista;
    }

	public static List<Reunioes> consultaReunioes(){
    	List<Reunioes> lista = new ArrayList<Reunioes>();
    	try {
        	PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM reunioes");
        	ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			Reunioes tb = new Reunioes();
    			tb.setData(rs.getString("daata"));
    			tb.setHorario(rs.getString("horario"));
    			tb.setLocalizacao(rs.getString("localizacao"));
    			tb.setAssunto(rs.getString("assuntos"));
    			lista.add(tb);
        	}
    	}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro em: "+e, "Atencao", JOptionPane.WARNING_MESSAGE);
    	}
    	return lista;
    }

}
