package validacoes;

public class CalculoFolhaPagamento {

	// Metodo para calcular salario bruto:
	public static double calculoSalarioBruto(int hrsTrabalhadas, double valorHrsTrab) {
		double salBruto;
		salBruto = hrsTrabalhadas * valorHrsTrab;
		return salBruto;
	}

	// Metodo para calcular Imposto de renda:
	public static double calculoImpostoDeRenda(double salBruto) {
		double ir;
		if (salBruto < 1903.98) {
			return 0;
		} else {
			if (salBruto <= 2826.65) {
				ir = salBruto * 0.075 - 142.80;
				return ir;
			} else {
				if (salBruto <= 3751.05) {
					ir = salBruto * 0.15 - 354.80;
					return ir;
				} else {
					if (salBruto <= 4664.68) {
						ir = salBruto * 0.225 - 636.13;
						return ir;
					} else {
						ir = (salBruto * 0.275) - 869.36;
					}
				}
			}
		}
		return ir;
	}

	// Metodo para calcular INSS:
	public static double calculoINSS(double salBruto) {
		if (salBruto < 1659.39) {
			return salBruto * 0.08;
		} else {
			if (salBruto < 2765.67) {
				return salBruto * 0.09;
			} else {
				if (salBruto < 5531.32) {
					return salBruto * 0.11;
				} else {
					if (salBruto > 5531.31) {
						return 608.44;
					}
				}
			}
		}
		return 0;
	}

	// Metodo para calcular FGTS:
	public static double calculoFGTS(double salBruto) {
		return salBruto * 0.08;
	}

	// Metodo para calcular Salário Liquido:
	public static double calculoLiquido(double ir, double inss, double salBruto) {
		return salBruto - ir - inss;
	}

}
