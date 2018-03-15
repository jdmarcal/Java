package DAL;

import java.util.ArrayList;
import Model.DadosFuncionario;
import validacoes.CalculoFolhaPagamento;

public class FolhaDePagamentoDAO {

	private static ArrayList<DadosFuncionario> funcionarios = new ArrayList<DadosFuncionario>();

	public static void cadastrarFolhaPagamento(DadosFuncionario funcionario) {
		funcionarios.add(funcionario);
	}

	public static DadosFuncionario buscarFolhaPagamentoPorNome(String nome) {
		for (int i = 0; i < funcionarios.size(); i++) {
			if (nome.equals(funcionarios.get(i).getNome())) {
				return funcionarios.get(i);
			}
		}
		return null;
	}

	public static double buscarMaiorSalario() {
		double maiorSal = 0, salBruto;

		for (int i = 0; i < funcionarios.size(); i++) {
			salBruto = CalculoFolhaPagamento.calculoSalarioBruto(funcionarios.get(i).getHrsTrabalhadas(),
					funcionarios.get(i).getValorHrsTrab());
			if (salBruto > maiorSal) {
				maiorSal = salBruto;
			}
		}
		return maiorSal;
	}

	public static double buscarMenorSalario() {
		double menorSal = CalculoFolhaPagamento.calculoSalarioBruto(funcionarios.get(0).getHrsTrabalhadas(),
				funcionarios.get(0).getValorHrsTrab());
		double salBruto;
		for (int i = 0; i < funcionarios.size(); i++) {
			salBruto = CalculoFolhaPagamento.calculoSalarioBruto(funcionarios.get(i).getHrsTrabalhadas(),
					funcionarios.get(i).getValorHrsTrab());
			if(salBruto < menorSal){
				menorSal = salBruto;
			}
		}
		return menorSal;
	}

}