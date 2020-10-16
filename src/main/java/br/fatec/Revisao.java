/**
 * 
 */
package br.fatec;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Denis Lima
 *
 */
public class Revisao {
	private Map<String, Cliente> revisao = new HashMap<String, Cliente>(); 		 // <data, Cliente (cliente, carro)>
	private Map<String, Cliente> servico = new HashMap<String, Cliente>();       // <serviço, Cliente (cliente,carro)>
	private int id;
	
	public void setRevisao(Map<String, Cliente> rev) {
		this.revisao = rev;
	}
	
	public void setServico(Map<String, Cliente> serv) {
		this.servico = serv;
	}
	
	public Map<String, Cliente> mapRevisao() {
		return this.revisao;
	}
	
	public Map<String, Cliente> mapServico() {
		return this.servico;
	}
	
	
	public void relatorio() {
		for (Map.Entry<String, Cliente> serv : this.servico.entrySet()) {
			System.out.println("*******************************");
			System.out.println("Cliente: " + serv.getValue().getName());
			System.out.println("Carro: " + serv.getValue().getCarro().getModelo() + " com placa " + serv.getValue().getCarro().getPlaca());
			System.out.println("Serviço: " + serv.getKey().substring(1, serv.getKey().length()));
		}
	}
	
	public void agendarRevisao(String data, Cliente cliente) {
		if (servico.isEmpty()) id = 0;
		else id++;
		this.revisao.put(id + data, cliente);
		this.servico.put(id + "Revisão", cliente);
	}
	
	public void removerAgendamento(String data, Cliente cliente) {
		if (this.revisao.isEmpty()) return;
		else {
		String data_r = this.getRevisao(data, cliente);
		if (data_r.length() > 4) {
			this.revisao.remove(data_r);
			this.servico.remove(data_r);
			System.out.println("Agendamento cancelado!");
		} else System.out.println("Não encontrado!");
		}
	}
	
	public String listarRevisao() {
		if (this.revisao.isEmpty()) {
			System.out.println("Não há revisões");
			return "n";
		}
		else {
			for (Map.Entry<String, Cliente> data : this.revisao.entrySet()) {
				System.out.println("*******************************");
				System.out.println("Cliente: " + data.getValue().getName());
				System.out.println("Carro: " + data.getValue().getCarro().getModelo() + " com placa " + data.getValue().getCarro().getPlaca());
				System.out.println("Data da revisão: " + data.getKey().substring(data.getKey().length()-10, data.getKey().length()));
			}
		} return "s";
	}
	
	public String getRevisao (String data, Cliente cliente) {
		for (Map.Entry<String, Cliente> rev : revisao.entrySet()) {
			if ((data.equals(rev.getKey().substring(rev.getKey().length()-10, rev.getKey().length()))) && (rev.getValue().getCpf().equals(cliente.getCpf()))) return rev.getKey();
		}
		return "";
	}
	
	public void adicionarServico(String serv, Cliente cliente) {
		if (servico.isEmpty()) id = 0;
		else id++;
		String nome_serv = id + serv;
		this.servico.put(nome_serv, cliente);
	}
	
	public void trocarData(String data, Cliente cliente) {
		if (this.revisao.isEmpty()) return;
		else {
			Controle controle = new Controle();
			System.out.println("Digite a data nova");
			String nova_data = controle.texto();
			data = this.getRevisao(data, cliente);
			if (data.length() > 4) {
				this.revisao.remove(data);
				this.servico.remove(data);
				id++;
				this.revisao.put(id + nova_data, cliente);
				this.servico.put(id + "Revisão", cliente);
				
			} else System.out.println("Não encontrado!");
		}
	}

}
