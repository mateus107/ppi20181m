package library.comands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.daos.AlunoDAO;
import library.daos.EmprestimoDAO;
import library.daos.LivroDAO;
import library.models.Aluno;
import library.models.Emprestimo;
import library.models.Livro;

public class AdicionarEmprestimo implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int livroID = Integer.parseInt(request.getParameter("livro"));
		String matricula = request.getParameter("aluno");
		String dataEmprestimo = request.getParameter("dataEmprestimo");
		
		
	
		System.out.println("Livro: " + livroID );
		System.out.println("Aluno: " + matricula );
		System.out.println("Data Emprestimo: " + dataEmprestimo);
		
		
		
		
		
		/* organizar calendario */
		Calendar dataFinal = null;
		/* declaração da data */
		try {
			Date dataProvisoria = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmprestimo);
			/* traduzindo da data string para data java util */
			dataFinal = Calendar.getInstance();
			System.out.println(dataFinal);
			dataFinal.setTime(dataProvisoria);
			/* preenchendo a variavel calendario la em cima pra data traduzida a pouco */
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Calendar dataFinal2 = null; 
//		try {
//			Date dataProvisoria2 = new SimpleDateFormat("dd/MM/yyyy").parse(dataEntrega);
//			/* traduzindo da data string para data java util */
//			dataFinal2 = Calendar.getInstance();
//			dataFinal2.setTime(dataProvisoria2);
//			/* preenchendo a variavel calendario la em cima pra data traduzida a pouco */
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
// 
		Emprestimo emprestimo = new Emprestimo();
		Aluno aluno = new AlunoDAO().pegarPorMatricula(matricula);
		emprestimo.setAluno(aluno);
		
		Livro livro = new LivroDAO().pegarPorId(livroID);
		emprestimo.setLivro(livro);
		
		emprestimo.setDataEmprestimo(dataFinal);
//		emprestimo.setDataEntrega(dataFinal2);

		/* para o banco de dados */
		EmprestimoDAO dao = new EmprestimoDAO();
		dao.inserir(emprestimo);
		request.setAttribute("mensagem", "O emprestimo foi adicionado com sucesso!");

		return "sistema?comando=ListarAL";
	}
}
