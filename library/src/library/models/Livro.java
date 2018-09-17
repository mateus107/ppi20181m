package library.models;


public class Livro {
	private String titulo;
	private String autor;
	private String editora;
	private String anoPublicado;
	private String anoEditado;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getAnoPublicado() {
		return anoPublicado;
	}
	public void setAnoPublicado(String anoPublicado) {
		this.anoPublicado = anoPublicado;
	}
	public String getAnoEditado() {
		return anoEditado;
	}
	public void setAnoEditado(String anoEditado) {
		this.anoEditado = anoEditado;
	}
	
	
}
