package DAL;

import java.util.ArrayList;
import model.Livro;

public class LivroDAO {
	
	private static ArrayList<Livro> livros = new ArrayList<Livro>();
	
	public static void cadastrarLivro(Livro livro) {
		livros.add(livro);
	}
	
	public static Livro buscarLivrooPorTitulo(String titulo) {
		for (int i = 0; i < livros.size(); i++) {
			if (titulo.equals(livros.get(i).getTitulo())) {
				return livros.get(i);
			}
		}
		return null;
	}
	
	public static void emprestarLivro(Livro l){
		l.setEstaEmprestado(true);
	}
	
	public static void devolverLivro(Livro l){
		l.setEstaEmprestado(false);
	}
	
	public static ArrayList<Livro> retornarLivroEmprestado(){
		ArrayList<Livro> listaAux = new ArrayList<Livro>();
		for (int i = 0; i < livros.size(); i++) {
			if(livros.get(i).isEstaEmprestado() == true){
				listaAux.add(livros.get(i));
			}
		}
		return listaAux;
	}

}
