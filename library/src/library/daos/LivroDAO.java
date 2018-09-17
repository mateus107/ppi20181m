package library.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import library.models.Livro;

public class LivroDAO {
	
	private Connection connection;

	public LivroDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Livro livro) {

		String sql = "insert into estante (titulo, autor, editora, anoPublicado, anoEditado) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setString(4, livro.getAnoPublicado());
			stmt.setString(5, livro.getAnoEditado());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Livro> getLista() {
		List<Livro> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from estante;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Livro livro = new Livro();
				livro.setId(rs.getInt("id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setEditora(rs.getString("editora"));
				livro.setAnoPublicado(rs.getString("anoPublicado"));
				livro.setAnoEditado(rs.getString("anoEditado"));
				// adicionando o objeto lista
				result.add(livro);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

//	public boolean alterar(Livro livro) {
//		String sql = "update estante set titulo=?, autor=?, editora=?, ano=? where id=?;";
//		try {
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			stmt.setString(1, livro.getTitulo());
//			stmt.setString(2, livro.getAutor());
//			stmt.setString(3, livro.getEditora());
//			stmt.setString(4, livro.getAnoPublicado());
//			stmt.setString(5, livro.getAnoEditado());
//			stmt.execute();
//			stmt.close();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}

//	public boolean remover(Livro livro) {
//		try {
//			PreparedStatement stmt = connection.prepareStatement("delete from contatos where matricula=?;");
//			stmt.setString(1, livro.getTitulo());
//			stmt.execute();
//			stmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}

	public Livro pegarPorId(int id) {
		Livro result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from estante where id = ?;");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Aluno
				result = new Livro();
				result.setId(rs.getInt("id"));
				result.setTitulo(rs.getString("titulo"));
				result.setAutor(rs.getString("autor"));
				result.setEditora(rs.getString("editora"));
				result.setAnoPublicado(rs.getString("anoPublicado"));
				result.setAnoEditado(rs.getString("anoEditado"));
				
				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	
	
}
