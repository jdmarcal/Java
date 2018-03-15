package view;

//import java.util.ArrayList;
//import validacoes.CalculoFolhaPagamento;

import DAL.FolhaDePagamentoDAO;
import Model.DadosFuncionario;
import validacoes.CalculoFolhaPagamento;
import validacoes.Console;
//import validacoes.Validacao;

public class Principal {

	private static DadosFuncionario funcionario = new DadosFuncionario();

	public static void main(String[] args) {

		int opcao;

		do {
			System.out.println("---------MENU PRINCIPAL---------");
			System.out.println("1 - Cadastrar folha de pagamento");
			System.out.println("2 - Calcular folha de pagamento");
			System.out.println("3 - Buscar maior sal�rio");
			System.out.println("4 � Buscar menor sal�rio");
			System.out.println("0 - Sair");
			System.out.println("--------------------------------");
			opcao = Console.readInt("Digite uma op��o: ");
			switch (opcao) {
			case 1:
				leituraDeDados();
				break;
			case 2:
				CalcularFolhaPagamento();
				break;
			case 3:
				maiorSalarioCalculado();
				break;
			case 4:
				menorSalarioCalculado();
				break;
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				break;
			}
		} while (opcao != 0);
	}

	public static void leituraDeDados() {
		// Leitura de dados do funcion�rio.
		funcionario = new DadosFuncionario();
		// Armazenar informa��es de cada atributo do objeto.
		System.out.println("");
		System.out.println("--------------Cadastro de Folha-----------------------");
		funcionario.setNome(Console.readString("Nome do Funcion�rio: "));
		funcionario.setHrsTrabalhadas(Console.readInt("Horas Trabalhadas: "));
		funcionario.setValorHrsTrab(Console.readDouble("Valor da Hora Trabalhada :"));
		System.out.println("");
		System.out.println("Folha cadastrada com sucesso!!!");
		System.out.println("------------------------------------------------------");
		System.out.println("");
		// Armazenar o objeto uncionario, dentro de um ArrayList.
		FolhaDePagamentoDAO.cadastrarFolhaPagamento(funcionario);
	}

	public static void CalcularFolhaPagamento() {
		double salBruto, ir, inss, fgts, salLiquido;
		String nome;

		System.out.println("");
		System.out.println("------Calcular folha de pagamento-------");
		System.out.println("");
		nome = Console.readString("Nome do Funcion�rio: ");
		System.out.println("");
		funcionario = FolhaDePagamentoDAO.buscarFolhaPagamentoPorNome(nome);
		System.out.println("");

		if (funcionario != null) {

			salBruto = CalculoFolhaPagamento.calculoSalarioBruto(funcionario.getHrsTrabalhadas(),
					funcionario.getValorHrsTrab());

			ir = CalculoFolhaPagamento.calculoImpostoDeRenda(salBruto);
			inss = CalculoFolhaPagamento.calculoINSS(salBruto);
			fgts = CalculoFolhaPagamento.calculoFGTS(salBruto);
			salLiquido = CalculoFolhaPagamento.calculoLiquido(ir, inss, salBruto);
			// Saida de dados
			
			System.out.println("---------Folha de pagamento--------");
			System.out.println("");
			System.out.println("Sal�rio Bruto: " + salBruto);
			System.out.format("Imposto de Renda: %.2f\n", ir);
			System.out.println("INSS: " + inss);
			System.out.println("FGTS: " + fgts);
			System.out.format("Salario Liquido: %.2f\n ", salLiquido);
			System.out.println("-----------------------------------");
			System.out.println("");

		} else {
			System.out.println("");
			System.out.println("Folha de pagamento n�o encontrada");
			System.out.println("");
		}

	}

	private static void maiorSalarioCalculado() {
		double maiorSalario = FolhaDePagamentoDAO.buscarMaiorSalario();
		System.out.println("");		
		System.out.println("Maior Sal�rio: " + maiorSalario);
		System.out.println("");
	}

	private static void menorSalarioCalculado() {
		double menorSalario = FolhaDePagamentoDAO.buscarMenorSalario();
		System.out.println("");		
		System.out.println("Menor Sal�rio: " + menorSalario);
		System.out.println("");
	}

}
