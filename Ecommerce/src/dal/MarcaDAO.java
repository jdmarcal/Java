package dal;

import java.util.ArrayList;

import model.Marca;

public class MarcaDAO {

	private static ArrayList<Marca> marcas = new ArrayList<Marca>();

	public static boolean cadastrarMarca(Marca marca) {
		if (buscarMarcaPorNome(marca.getNome()) == null) {
			if (marcas.size() > 0) {
				int ultimoId = marcas.get(marcas.size() - 1).getId();
				marca.setId(ultimoId + 1);
			}else{
				marca.setId(1);
			}
			marcas.add(marca);
			return true;
		}
		return false;
	}

	public static Marca buscarMarcaPorNome(String nome) {
		for (Marca marcaCadastrada : marcas) {
			if (marcaCadastrada.getNome().equals(nome)) {
				return marcaCadastrada;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	

}
