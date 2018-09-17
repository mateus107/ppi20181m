package library.comands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.daos.LivroDAO;
import library.models.Livro;

public class AdicionarLivro implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String editora = request.getParameter("editora");
		String anoPublicado = request.getParameter("anoPublicado");
		String anoEditado = request.getParameter("anoEditado");
		/* organizar calendario */
		
		/* declaração da data */
		

		Livro livro = new Livro();
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setEditora(editora);
		livro.setAnoPublicado(anoPublicado);
		livro.setAnoEditado(anoEditado);

		/* para o banco de dados */
		LivroDAO dao = new LivroDAO();
		dao.inserir(livro);
		request.setAttribute("mensagem", "O livro foi adicionado com sucesso!");

		return "sistema?comando=ListarLivros";
	}

}
