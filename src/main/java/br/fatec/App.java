/**
 * 
 */
package br.fatec;

import java.io.IOException;

/**
 * @author Denis Lima
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Controle controle = new Controle();
		Cadastro cadastro = new Cadastro();
		Revisao revis = new Revisao();
		int opcao = 99;
		Menu menu = new Menu();
		
		while (opcao != 0) {
			menu.principal();
			opcao = controle.opcao();
			
			if (opcao == 1) {
				System.out.println("Digite o nome completo");
				String nome = controle.texto();
				System.out.println("Digite o telefone");
				String telefone = controle.texto();
				System.out.println("Digite o endereço");
				String endereco = controle.texto();
				System.out.println("Digite o CPF");
				String cpf = controle.texto();
				System.out.println("Digite a placa do carro");
				String placa = controle.texto();
				System.out.println("Digite o modelo");
				String modelo = controle.texto();
				System.out.println("Digite o ano do carro");
				int ano = controle.opcao();
				System.out.println("Digite o valor do carro");
				int valor = controle.opcao();
				Carro car = new Carro(placa, modelo, ano, valor);
				Cliente cliente = new Cliente(nome, telefone, endereco, cpf, car);
				cadastro.adicionarCadastro(cliente);
				System.out.println("Cadastro concluído!");
			}
			
			if (opcao == 2) {
				System.out.println("Digite a data do agendamento");
				String data = controle.texto();
				System.out.println("Digite o nome do cliente");
				String nome = controle.texto();
				Cliente cliente = cadastro.getCliente(nome);
				if (!(cliente.equals(null))) {
					revis.agendarRevisao(data, cliente);
				} else System.out.println("Cliente não encontrado");
			}
			
			if (opcao == 3) {
				String decisao = revis.listarRevisao();
				if (decisao.equals("s")) {
					System.out.println("Digite a data antiga da revisão");
					String data = controle.texto();
					System.out.println("Digite o nome do cliente");
					String nome = controle.texto();
					Cliente cliente = cadastro.getCliente(nome);
					if (cliente.equals(null)) {
						System.out.println("Cliente não encontrado");		
					} else revis.trocarData(data, cliente);
				}
			}
			
			if (opcao == 4) {
				String decisao = revis.listarRevisao();
				if (decisao.equals("s")) {
					System.out.println("Digite a data da revisão");
					String data = controle.texto();
					System.out.println("Digite o nome do cliente");
					String nome = controle.texto();
					Cliente cliente = cadastro.getCliente(nome);
					if (cliente.equals(null)) {
						System.out.println("Cliente não encontrado");
					} else revis.removerAgendamento(data, cliente);
				}
			}
			
			if (opcao == 5) {
				System.out.println("Relatório dos clientes");
				revis.relatorio();
			}
			
			if (opcao == 6) {
				try {
					cadastro.salvar(revis);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (opcao == 7) {
				try {
					cadastro.carregar(revis);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (opcao == 8) {
				revis.listarRevisao();
			}
			
		}
		System.out.println("Obrigado por utilizar o APP!");

	}

}
