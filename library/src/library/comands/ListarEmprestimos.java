package library.comands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.daos.AlunoDAO;
import library.daos.EmprestimoDAO;
import library.models.Aluno;
import library.models.Emprestimo;

public class ListarEmprestimos implements Logica{
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EmprestimoDAO dao = new EmprestimoDAO();

		List<Emprestimo> emprestimos = dao.getLista();

		request.setAttribute("emprestimos", emprestimos);

		return "listaEmprestimo.jsp";
		
		
		
		
	}
}
