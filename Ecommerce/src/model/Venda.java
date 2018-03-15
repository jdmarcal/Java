package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Venda {

	private int id;
	private ArrayList<ItemVenda> itens;
	private double valorDaVenda;
	private Calendar dataDaVenda;
	private String cliente;
	
	public Venda(){
		itens = new ArrayList<ItemVenda>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<ItemVenda> getItens() {
		return itens;
	}
	public void setItens(ArrayList<ItemVenda> itens) {
		this.itens = itens;
	}
	public double getValorDaVenda() {
		return valorDaVenda;
	}
	public void setValorDaVenda(double valorDaVenda) {
		this.valorDaVenda = valorDaVenda;
	}
	public Calendar getDataDaVenda() {
		return dataDaVenda;
	}
	public void setDataDaVenda(Calendar dataDaVenda) {
		this.dataDaVenda = dataDaVenda;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
}
