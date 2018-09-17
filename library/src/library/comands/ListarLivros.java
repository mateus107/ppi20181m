package library.comands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.daos.LivroDAO;
import library.models.Livro;

public class ListarLivros implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		LivroDAO dao = new LivroDAO();
		List<Livro> livros = dao.getLista();
		
		
		
		request.setAttribute("livros", livros);
				
		return "listaLivro.jsp";
	}

}
