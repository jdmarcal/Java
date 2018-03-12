package view;

import util.Console;
import java.util.ArrayList;
import DAL.LivroDAO;
import model.Livro;

public class Main {

	private static Livro livro = new Livro();

	public static void main(String[] args) {

		int opcao;
		do {
			System.out.println();
			System.out.println("1 - Cadastrar livro");
			System.out.println("2 - Emprestar livro");
			System.out.println("3 - Devolver livro");
			System.out.println("4 - Lista de livros emprestados");
			System.out.println("5 - Consultar livro");
			System.out.println("0 - Sair");
			opcao = Console.readInt("Digite uma opcao: ");
			switch (opcao) {
			case 1:
				cadastrarLivro();
				break;
			case 2:
				emprestarLivro();
				break;
			case 3:
				devolverLivro();
				break;
			case 4:
				livrosEmprestados();
				break;
			case 5:
				consultarLivro();
				break;
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				break;
			}
		} while (opcao != 0);

	}

	private static void cadastrarLivro() {
		livro = new Livro();
		livro.setTitulo(Console.readString("Digite o Tilulo do Livro: "));
		livro.setAutor(Console.readString("Digite o Autor do livro: "));
		livro.setIsbn(Console.readString("Digite ISBN do Livro: "));
		livro.setEstaEmprestado(false);
		LivroDAO.cadastrarLivro(livro);
		System.out.println("\nLivro cadastrado com sucesso!\n");
	}

	public static void emprestarLivro() {
		String titulo;
		System.out.println("");
		System.out.println("----Emprestimo de Livro----");
		System.out.println("");
		titulo = Console.readString("Tilulo do Livro:");
		livro = LivroDAO.buscarLivrooPorTitulo(titulo);

		if (livro != null) {
			System.out.println("");
			System.out.println(livro.getTitulo());
			System.out.println(livro.getAutor());
			System.out.println(livro.getIsbn());
			System.out.println("");
			System.out.println("----Emprestimo de Livro Concluído----");
			System.out.println("");
			LivroDAO.emprestarLivro(livro);
		} else {
			System.out.println("");
			System.out.println("Livro NÃO Encontrado!!!!");
			System.out.println("");
		}
	}

	public static void devolverLivro() {
		String titulo;
		System.out.println("");
		System.out.println("----Devolução de Livro----");
		System.out.println("");
		titulo = Console.readString("Tilulo do Livro:");
		livro = LivroDAO.buscarLivrooPorTitulo(titulo);

		if (livro != null) {
			System.out.println("");
			System.out.println(livro.getTitulo());
			System.out.println(livro.getAutor());
			System.out.println(livro.getIsbn());
			System.out.println("");
			System.out.println("----Devolução de Livro Concluído----");
			System.out.println("");
			LivroDAO.devolverLivro(livro);
		} else {
			System.out.println("");
			System.out.println("Livro NÃO Encontrado!!!!");
			System.out.println("");
		}
	}

	private static void livrosEmprestados() {
		System.out.println();
		System.out.println("---Livros Emprestados---");
		System.out.println();
		ArrayList<Livro> livrosEmprestados = LivroDAO.retornarLivroEmprestado();
		for (int i = 0; i < livrosEmprestados.size(); i++) {
			System.out.println(livrosEmprestados.get(i));
		}
	}

	private static void consultarLivro() {
		String titulo;

		titulo = Console.readString("Digite o Tilulo do Livro: ");
		livro = LivroDAO.buscarLivrooPorTitulo(titulo);
		System.out.println("");

		if (livro != null) {
			System.out.println("");
			System.out.println(livro.getAutor());
			System.out.println(livro.getAutor());
			System.out.println(livro.getIsbn());
			if (livro.isEstaEmprestado()) {
				System.out.print("Livro EMPRESTADO");
			} else {
				System.out.print("Livro DISPONÍVEL");
			}
			System.out.println("");
			System.out.println("");
		} else {
			System.out.println("");
			System.out.println("Livro NÃO Encontrado!!!!");
			System.out.println("");
		}
	}

}
