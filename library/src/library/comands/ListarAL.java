package library.comands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.daos.AlunoDAO;
import library.daos.LivroDAO;
import library.models.Aluno;
import library.models.Livro;


public class ListarAL implements  Logica {
	
public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		LivroDAO dao = new LivroDAO();
		List<Livro> livros = dao.getLista();
		AlunoDAO dao2 = new AlunoDAO();
		List<Aluno> alunos = dao2.getLista();
		
		request.setAttribute("alunos", alunos);
		request.setAttribute("livros", livros);
				
		return "emprestimo.jsp";
	}

}
