package model;


public class Livro {
	
	private String titulo;
	private String autor;
	private String isbn;
	private boolean estaEmprestado;	
	
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
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public boolean isEstaEmprestado() {
		return estaEmprestado;
	}
	public void setEstaEmprestado(boolean estaEmprestado) {
		this.estaEmprestado = estaEmprestado;
	}
	
	@Override
	public String toString() {
		return "Titulo: " + getTitulo() + "\nAutor: " + getAutor() + "\nISBN: " + getIsbn() + "\n";
	}
	

}
