/**
 * 
 */
package br.fatec;

import java.util.Scanner;

/**
 * @author Denis Lima
 *
 */
public class Controle {
	private Scanner leitor;

	public Controle() {
		leitor = new Scanner(System.in);
	}

	public synchronized int opcao() {
		int op = leitor.nextInt();
		leitor = leitor.reset();
		return op;
	}

	public synchronized String texto() {
		leitor = new Scanner(System.in);
		String t = leitor.nextLine();
		t = t.substring(0, 1).toUpperCase() + t.substring(1);
		leitor = leitor.reset();
		return t;
	}

	@Override
	protected void finalize() throws Throwable {
		leitor.close();
	}
}
