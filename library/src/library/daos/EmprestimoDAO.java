package library.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import library.models.Aluno;
import library.models.Emprestimo;
import library.models.Emprestimo;
import library.models.Livro;

public class EmprestimoDAO {
	
	private Connection connection;

	public EmprestimoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Emprestimo emprestimo) {

		String sql = "insert into emprestimo (id_aluno, id_livro, dataEmprestimo) values (?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, emprestimo.getAluno().getMatricula());
			stmt.setInt(2, emprestimo.getLivro().getId());
			stmt.setDate(3, new java.sql.Date(emprestimo.getDataEmprestimo().getTimeInMillis()));
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public boolean remover(Emprestimo emprestimo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from emprestimo where id=?;");
			stmt.setLong(1, emprestimo.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<Emprestimo> getLista() {
		List<Emprestimo> result = null;
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo;");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Aluno al = new Aluno();
				Livro livro = new Livro();
				
				
				// criando o objeto Contato
				Emprestimo emprestimo = new Emprestimo();
				
				
				emprestimo.setId((rs.getLong("id")));
				emprestimo.setAluno(rs.getString("id_aluno"));
				emprestimo.setLivro(rs.getInt(Integer.parseInt("id_livro")));
				
				
				
				


				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataEmprestimo"));
				emprestimo.setDataEmprestimo(data);
				

				// adicionando o objeto lista
				result.add(emprestimo);
			}
			if (rs.next()) {
				// criando o objeto Aluno
//				result = new Aluno();
//				result.setMatricula(rs.getString("matricula"));
//				result.setNome(rs.getString("nome"));
//				result.setCpf(rs.getString("cpf"));
//				result.setEndereco(rs.getString("endereco"));
//				// montando a data através do Calendar
//				Calendar data = Calendar.getInstance();
//				data.setTime(rs.getDate("dataNascimento"));
//				result.setDataNascimento(data);
				
				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public Livro pegarPorTitulo(String titulo) {
		Livro result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo where titulo = ?;");
			stmt.setString(1, titulo);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Aluno
				result = new Livro();
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