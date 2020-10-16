/**
 * 
 */
package br.fatec;

/**
 * @author Denis Lima
 *
 */
public class Menu {
	public void asterisco() {
		System.out.println("*******************************");
	}
	
	public void principal() {
		asterisco();
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Agendar revisão");
		System.out.println("3 - Trocar data da revisão");
		System.out.println("4 - Cancelar revisão");
		System.out.println("5 - Relatório serviços prestados");
		System.out.println("6 - Salvar dados");
		System.out.println("7 - Carregar dados");
		System.out.println("8 - Listar revisões");
		System.out.println("0 - Sair");
		System.out.println("");
	}
	
	

}
