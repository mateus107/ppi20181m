package library.models;

import java.util.Calendar;

public class Emprestimo {

	private Long id;
	private Aluno aluno;
	private Livro livro;
	private Calendar dataEmprestimo;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public void setAluno(String matricula) {
			aluno.setMatricula(matricula);
		
	}
	public void setLivro(int id) {
	     	livro.setId(id);
		
	}


	
}
