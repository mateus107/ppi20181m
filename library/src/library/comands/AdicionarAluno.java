package library.comands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.daos.AlunoDAO;
import library.models.Aluno;

public class AdicionarAluno implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String matricula = request.getParameter("matricula");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		/* organizar calendario */
		Calendar dataFinal = null;
		/* declaração da data */
		try {
			Date dataProvisoria = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			/* traduzindo da data string para data java util */
			dataFinal = Calendar.getInstance();
			dataFinal.setTime(dataProvisoria);
			/* preenchendo a variavel calendario la em cima pra data traduzida a pouco */
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setEndereco(endereco);
		aluno.setDataNascimento(dataFinal);

		/* para o banco de dados */
		AlunoDAO dao = new AlunoDAO();
		dao.inserir(aluno);
		request.setAttribute("mensagem", "O aluno foi adicionado com sucesso!");
		return "sistema?comando=ListarAlunos";
	}

}
