package view;

import java.util.ArrayList;

import DAL.RegistroDeVeiculoDAO;
import Model.DadosVeiculo;
import util.Console;

public class Principal {

	private static DadosVeiculo veiculo = new DadosVeiculo();

	public static void main(String[] args) {

		int opcao;

		do {
			System.out.println("");
			System.out.println("1 - Cadastrar carro");
			System.out.println("2 - Entrada do carro");
			System.out.println("3 - Saída do carro");
			System.out.println("4 – Listar carros DENTRO do estacionamento");
			System.out.println("5 – Listar carros FORA do estacionamento");
			System.out.println("0 - Sair");
			opcao = Console.readInt("Digite uma opção: ");
			switch (opcao) {
			case 1:
				cadastroVeiculo();
				break;
			case 2:
				entradaVeiculo();
				break;
			case 3:
				saidaVeiculo();
				break;
			case 4:
				listarVeiculoDentro();
				break;
			case 5:
				listarVeiculoFora();
				break;
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				break;
			}
		} while (opcao != 0);

	}

	public static void cadastroVeiculo() {

		veiculo = new DadosVeiculo();
		System.out.println("----Cadastro de Veículo----");
		System.out.println("");
		veiculo.setModelo(Console.readString("Modelo: "));
		veiculo.setPlaca(Console.readString("Placa:"));
		veiculo.setCor(Console.readString("Cor:"));
		System.out.println("----Cadastro Efetuado----");
		RegistroDeVeiculoDAO.cadastroVeiculo(veiculo);
	}

	public static void entradaVeiculo() {
		String placa;
		System.out.println("");
		System.out.println("----Entrada de Veículo----");
		System.out.println("");
		placa = Console.readString("Placa do Veículo:");
		veiculo = RegistroDeVeiculoDAO.buscarVeiculoPorPlaca(placa);

		if (veiculo != null) {
			System.out.println("");
			System.out.println(veiculo.getModelo());
			System.out.println(veiculo.getPlaca());
			System.out.println(veiculo.getCor());
			System.out.println("");
			System.out.println("----Entrada de Veículo Concluído----");
			System.out.println("");
			RegistroDeVeiculoDAO.entradaVeiculo(veiculo);
		} else {
			System.out.println("");
			System.out.println("Veículo NÃO Encontrado!!!!");
			System.out.println("");
		}
	}
	
	public static void saidaVeiculo() {
		String placa;
		System.out.println("");
		System.out.println("----Saida de Veículo----");
		System.out.println("");
		placa = Console.readString("Placa do Veículo:");
		veiculo = RegistroDeVeiculoDAO.buscarVeiculoPorPlaca(placa);

		if (veiculo != null) {
			System.out.println("");
			System.out.println(veiculo.getModelo());
			System.out.println(veiculo.getPlaca());
			System.out.println(veiculo.getCor());
			System.out.println("");
			System.out.println("----Saida de Veículo Concluído----");
			System.out.println("");
			RegistroDeVeiculoDAO.saidaVeiculo(veiculo);
		} else {
			System.out.println("");
			System.out.println("Veículo NÃO Encontrado!!!!");
			System.out.println("");
		}
	}

	public static void listarVeiculoDentro() {
		System.out.println();
		ArrayList<DadosVeiculo> listarVeiculoDentro = RegistroDeVeiculoDAO.listagemVeiculosDentro();
		for (int i = 0; i < listarVeiculoDentro.size(); i++) {
			System.out.println(listarVeiculoDentro.get(i));
		}
	}
	
	public static void listarVeiculoFora() {
		System.out.println();
		ArrayList<DadosVeiculo> listagemVeiculosFora = RegistroDeVeiculoDAO.listagemVeiculosFora();
		for (int i = 0; i < listagemVeiculosFora.size(); i++) {
			System.out.println(listagemVeiculosFora.get(i));
		}
		
	}
}
