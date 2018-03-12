package Model;

public class DadosVeiculo {
	
	private String modelo;
	private String placa;
	private String cor;
	private boolean Estacionado;
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public boolean Estacionado() {
		return Estacionado;
	}
	public void setEstacionado(boolean estacionado) {
		Estacionado = estacionado;
	}
}
