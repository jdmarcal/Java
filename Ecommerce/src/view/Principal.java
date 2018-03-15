package view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import dal.CategoriaDAO;
import dal.MarcaDAO;
import dal.ProdutoDAO;
import dal.VendaDAO;
import model.Categoria;
import model.ItemVenda;
import model.Marca;
import model.Produto;
import model.Venda;
import util.Console;

public class Principal {

	private static Categoria categoria = new Categoria();
	private static Marca marca = new Marca();
	private static Produto produto = new Produto();
	private static Venda venda = new Venda();
	private static ItemVenda itemVenda = new ItemVenda();

	public static void main(String[] args) {
		int opcao;
		do {
			System.out.println();
			System.out.println("--------MENU PRINCIPAL-----------");
			System.out.println("1 - Cadastrar categoria");
			System.out.println("2 - Cadastrar marca");
			System.out.println("3 - Cadastrar produto");
			System.out.println("4 - Listar produto");
			System.out.println("5 - Vender");
			System.out.println("6 - Lista de Vendas");
			System.out.println("0 - Sair");
			System.out.println("---------------------------------");
			opcao = Console.readInt("Digite uma opcao: ");
			switch (opcao) {
			case 1:
				cadastrarCategoria();
				break;
			case 2:
				cadastrarMarca();
				break;
			case 3:
				cadastrarProduto();
				break;
			case 4:
				listarProduto();
				break;
			case 5:
				vender();
				break;
			case 6:
				listarVendas();
				break;
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!!!");
				break;
			}
		} while (opcao != 0);

	}

	private static void cadastrarCategoria() {
		System.out.println();
		System.out.println(" -- CADASTRAR CATEGORIA -- ");
		System.out.println();

		categoria = new Categoria();

		categoria.setNome(Console.readString("Digite o nome da categoria: "));
		categoria.setDescricao(Console.readString("Digite a descrição da categoria: "));

		if (CategoriaDAO.cadastrarCategoria(categoria)) {
			System.out.println();
			System.out.println("Categoria gravada com sucesso!");
			System.out.println("-----------------------------");
			System.out.println();
		} else {
			System.out.println();
			System.out.println("Categoria já existente!");
			System.out.println("-----------------------------");
			System.out.println();
		}
	}

	private static void cadastrarMarca() {
		System.out.println();
		System.out.println(" -- CADASTRAR MARCA -- ");
		System.out.println();

		marca = new Marca();

		marca.setNome(Console.readString("Digite o nome da marca: "));
		marca.setEndereco(Console.readString("Digite o endereço da marca: "));

		if (MarcaDAO.cadastrarMarca(marca)) {
			System.out.println();
			System.out.println("Marca gravada com sucesso!");
			System.out.println("-----------------------------");
			System.out.println();
		} else {
			System.out.println();
			System.out.println("Marca já existente!");
			System.out.println("-----------------------------");
			System.out.println();
		}

	}

	private static void cadastrarProduto() {
		System.out.println();
		System.out.println(" -- CADASTRAR PRODUTO -- ");
		System.out.println();

		produto = new Produto();
		categoria = new Categoria();

		produto.setNome(Console.readString("Digite o nome do produto: "));
		produto.setDescricao(Console.readString("Digite a descrição do produto: "));
		produto.setValor(Console.readDouble("Digite o valor do produto: "));

		String nomeCategoria = Console.readString("Digite o nome da categoria: ");
		String nomeMarca = Console.readString("Digite o nome da marca: ");

		categoria = CategoriaDAO.buscarCategoriaPorNome(nomeCategoria);
		marca = MarcaDAO.buscarMarcaPorNome(nomeMarca);

		if (categoria != null) {
			if (marca != null) {
				produto.setCategoria(categoria);
				produto.setMarca(marca);
				ProdutoDAO.cadastrarProduto(produto);
				System.out.println();
				System.out.println("Produto gravado com sucesso!");
				System.out.println("-----------------------------");
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Marca não encontrada!");
				System.out.println("-----------------------------");
				System.out.println();
			}
		} else {
			System.out.println();
			System.out.println("Categoria não encontrada!");
			System.out.println("-----------------------------");
			System.out.println();
		}
	}
	
	private static void listarProduto() {
		System.out.println();
		System.out.println(" -- LISTAR PRODUTOS -- ");
		System.out.println();
		
		for (Produto produtoCadastrado : ProdutoDAO.retornarProdutos()) {
			System.out.println();
			System.out.println("Id: " + produtoCadastrado.getId());			
			System.out.println("Nome: " + produtoCadastrado.getNome());
			System.out.println("Valor: " + produtoCadastrado.getValor());
			System.out.println("Descrição: " + produtoCadastrado.getDescricao());
			System.out.println("Marca: " + produtoCadastrado.getMarca().getNome());
			System.out.println("Categoria: " + produtoCadastrado.getCategoria().getNome());
			System.out.println("---------------------------------------------------------");
		}
	}

	private static void vender() {
		System.out.println();
		System.out.println(" -- VENDER PRODUTOS -- ");
		System.out.println();
		
		venda = new Venda();
		
		String op, nomeProduto;
		double total = 0;
		do {
			produto = new Produto();
			itemVenda = new ItemVenda();
			nomeProduto = Console.readString("Digite o nome do produto: ");
			produto = ProdutoDAO.buscarProdutoPorNome(nomeProduto);
			if(produto != null){
				itemVenda.setProduto(produto);
				itemVenda.setQuantidade(Console.readInt("Digite a quantidade: "));
				itemVenda.setDataDaAdicao(Calendar.getInstance());
				venda.getItens().add(itemVenda);
				total += itemVenda.getQuantidade() * produto.getValor();
			}else{
				System.out.println("");
				System.out.println("Produto não encontrado!");
				System.out.println("");
			}			
			op = Console.readString("\nDeseja adicionar mais um produto no carrinho?   (S/N)");			
		} while (op.toUpperCase().equals("S"));
		venda.setCliente(Console.readString("Digite o nome do cliente: "));
		venda.setDataDaVenda(Calendar.getInstance());
		venda.setValorDaVenda(total);
		VendaDAO.cadastrarVenda(venda);
		System.out.println();
		System.out.println("Venda cadastrada com sucesso!");
		System.out.println();
	}

	private static void listarVendas() {
		System.out.println();
		System.out.println(" -- LISTAR VENDAS -- ");
		System.out.println();
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		
		for (Venda vendaCadastrada : VendaDAO.retornarVendas()) {
			System.out.println();
			System.out.println("Id: " + vendaCadastrada.getId());			
			System.out.println("Nome: " + vendaCadastrada.getCliente());
			System.out.println("Valor total: " + vendaCadastrada.getValorDaVenda());
			System.out.println("Data: " + df.format(vendaCadastrada.getDataDaVenda().getTime()));
			System.out.println("\n -- ITENS DA VENDA -- \n");
			for (ItemVenda itemVendaCadastrado : venda.getItens()) {
				System.out.println("\n\tProduto: " + itemVendaCadastrado.getProduto().getNome());
				System.out.println("\tQuantidade: " + itemVendaCadastrado.getQuantidade());
				System.out.println("\tData: " + df.format(itemVendaCadastrado.getDataDaAdicao().getTime()));
			}
		}
	}

}
