/**
 * 
 */
package br.fatec;

/**
 * @author Denis Lima
 *
 */
public class Carro {
	private String placa;
	private String modelo;
	private int ano;
	private int valor;
	
	
	public Carro(String placa, String modelo, int ano, int valor) {
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
	

}
