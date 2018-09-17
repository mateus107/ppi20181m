package library.comands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.daos.AlunoDAO;
import library.models.Aluno;



public class ListarAlunos implements  Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> alunos = dao.getLista();
		
		request.setAttribute("alunos", alunos);
				
		return "listaAluno.jsp";
	}

}
