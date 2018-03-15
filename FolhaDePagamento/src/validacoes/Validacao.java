package validacoes;

public class Validacao {

	private static double maiorSalario = 0, menorSalario = 0;	
	
	public static void validarMaiorSalario(double salLiquido){
		if(salLiquido > maiorSalario){
			maiorSalario = salLiquido;
		}
	}
	
	public static void validarMenorSalario(double salLiquido){
		if(menorSalario == 0){
			menorSalario = salLiquido;
		}else{
			if(salLiquido < menorSalario){
				menorSalario = salLiquido;
			}
		}
	}
	
	public static double retornarMenorSalario(){
		return menorSalario;
	}
	
	public static double retornarMaiorSalario(){
		return maiorSalario;
	}
}
