/**
 * 
 */
package br.fatec;

/**
 * @author Denis Lima
 *
 */
public class Cliente {
	private String name;
	private String fone;
	private String addres;
	private String cpf;
	private Carro carro;
	
	
	public Cliente(String name, String fone, String addres, String cpf, Carro carro) {
		this.name = name;
		this.fone = fone;
		this.addres = addres;
		this.cpf = cpf;
		this.carro = carro;
	}
	
	
	public void removerCarro() {
		this.carro = null;
	}
	
	public Carro getCarro() {
		return this.carro;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFone() {
		return fone;
	}


	public void setFone(String fone) {
		this.fone = fone;
	}


	public String getAddres() {
		return addres;
	}


	public void setAddres(String addres) {
		this.addres = addres;
	}


	public String getCpf() {
		return cpf;
	}
	
	
	
	
	

}
