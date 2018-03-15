package dal;

import java.util.ArrayList;

import model.Produto;

public class ProdutoDAO {

	private static ArrayList<Produto> produtos = new ArrayList<Produto>();

	public static void cadastrarProduto(Produto produto) {
		if (produtos.size() > 0) {
			int ultimoId = produtos.get(produtos.size() - 1).getId();
			produto.setId(ultimoId + 1);
		}else{
			produto.setId(1);
		}
		produtos.add(produto);
	}

	public static ArrayList<Produto> retornarProdutos() {
		return produtos;
	}

	public static Produto buscarProdutoPorNome(String nomeProduto){
		for(Produto produtoCadastrado : produtos){
			if(produtoCadastrado.getNome().equals(nomeProduto)){
				return produtoCadastrado;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
