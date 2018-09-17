package library.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import library.models.Aluno;

public class AlunoDAO {

	private Connection connection;

	public AlunoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Aluno aluno) {

		String sql = "insert into ficha (matricula, nome, cpf, dataNascimento, endereco) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getCpf());
			stmt.setDate(4, new java.sql.Date(aluno.getDataNascimento().getTimeInMillis()));
			stmt.setString(5, aluno.getEndereco());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Aluno> getLista() {
		List<Aluno> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from ficha;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setEndereco(rs.getString("endereco"));

				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				aluno.setDataNascimento(data);

				// adicionando o objeto lista
				result.add(aluno);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Aluno aluno) {
		String sql = "update ficha set matricula=?, nome=?, cpf=?, dataNascimento=? endereco=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getCpf());
			stmt.setString(4, aluno.getEndereco());
			stmt.setDate(5, new java.sql.Date(aluno.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Aluno aluno) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from ficha where matricula=?;");
			stmt.setString(1, aluno.getMatricula());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Aluno pegarPorMatricula(String matricula) {
		Aluno result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from ficha where matricula = ?;");
			stmt.setString(1, matricula);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Aluno
				result = new Aluno();
				result.setMatricula(rs.getString("matricula"));
				result.setNome(rs.getString("nome"));
				result.setCpf(rs.getString("cpf"));
				result.setEndereco(rs.getString("endereco"));
				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				result.setDataNascimento(data);
				
				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
