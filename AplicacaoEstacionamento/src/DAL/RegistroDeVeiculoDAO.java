package DAL;

import java.util.ArrayList;
import Model.DadosVeiculo;

public class RegistroDeVeiculoDAO {

	private static ArrayList<DadosVeiculo> veiculos = new ArrayList<DadosVeiculo>();

	public static void cadastroVeiculo(DadosVeiculo veiculo) {
		veiculos.add(veiculo);
	}

	public static DadosVeiculo buscarVeiculoPorPlaca(String placa) {
		for (int i = 0; i < veiculos.size(); i++) {
			if (placa.equals(veiculos.get(i).getPlaca())) {
				return veiculos.get(i);
			}
		}
		return null;
	}

	public static void entradaVeiculo(DadosVeiculo veiculo) {
		veiculo.setEstacionado(true);
	}

	public static void saidaVeiculo(DadosVeiculo veiculo) {
		veiculo.setEstacionado(false);
	}

	public static ArrayList<DadosVeiculo> listagemVeiculosDentro() {
		ArrayList<DadosVeiculo> listaAux = new ArrayList<DadosVeiculo>();
		for (int i = 0; i < veiculos.size(); i++) {
			if (veiculos.get(i).Estacionado() == true) {
				listaAux.add(veiculos.get(i));
			}
		}
		return listaAux;
	}
	
	public static ArrayList<DadosVeiculo> listagemVeiculosFora() {
		ArrayList<DadosVeiculo> listaAux = new ArrayList<DadosVeiculo>();
		for (int i = 0; i < veiculos.size(); i++) {
			if (veiculos.get(i).Estacionado() == false) {
				listaAux.add(veiculos.get(i));
			}
		}
		return listaAux;
	}
}
