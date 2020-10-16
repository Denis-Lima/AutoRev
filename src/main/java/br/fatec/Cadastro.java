/**
 * 
 */
package br.fatec;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Denis Lima
 *
 */
public class Cadastro {
	private Map<Integer, Cliente> cadastro = new HashMap<Integer, Cliente>();
	private int id;
	
	
	public void adicionarCadastro(Cliente cliente) {
		if (this.cadastro.isEmpty()) this.id = 0;
		else id++;
		this.cadastro.put(id, cliente);
	}
	
	public HashMap<Integer,Cliente> getCadastro(){
		return (HashMap<Integer, Cliente>) this.cadastro;
	}
	
	public Cliente getCliente(String nome) {
		for (Map.Entry<Integer, Cliente> cliente : cadastro.entrySet()) {
			if (cliente.getValue().getName().toLowerCase().equals(nome.toLowerCase())) {
				return cliente.getValue();
			}
		}
		System.out.println("Não encontrado");
		return null;
	}
	
	public void salvar(Revisao revis) throws IOException {
		Gson gson = new Gson();
		String cadastro_json = gson.toJson(this.cadastro);
		String id_json = gson.toJson(this.id);
		String revisao_json = gson.toJson(revis.mapRevisao());
		String servico_json = gson.toJson(revis.mapServico());
		
		FileDialog fd = new FileDialog((Frame) null, "Salvar cadastro", FileDialog.SAVE);
        fd.setVisible(true);
        String caminho = fd.getDirectory() + fd.getFile();
        
        FileWriter escritor = new FileWriter(caminho + "_cad.json");
		escritor.write(cadastro_json);
		escritor.close();
		escritor = new FileWriter(caminho + "_id.json");
		escritor.write(id_json);
		escritor.close();
		escritor = new FileWriter(caminho + "_rev.json");
		escritor.write(revisao_json);
		escritor.close();
		escritor = new FileWriter(caminho + "_ser.json");
		escritor.write(servico_json);
		escritor.close();
		System.out.println("Salvo com sucesso!");
	}
	
	public void carregar(Revisao revis) throws IOException, ClassNotFoundException {
		
		FileDialog fd = new FileDialog((Frame) null, "Carregar cadastro", FileDialog.LOAD);
		fd.setFile("*_cad.json");
        fd.setVisible(true);
        String caminho = fd.getDirectory() + fd.getFile();
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        
		Gson gson = new Gson();
		this.cadastro = gson.fromJson(br, new TypeToken<Map<Integer, Cliente>>(){}.getType());
		br = new BufferedReader(new FileReader(caminho.replace("_cad", "_id")));
		this.id = gson.fromJson(br, new TypeToken<Integer>(){}.getType());
		br = new BufferedReader(new FileReader(caminho.replace("_cad", "_rev")));
		Map<String, Cliente> map = gson.fromJson(br, new TypeToken<Map<String, Cliente>>(){}.getType());
		revis.setRevisao(map);
		br = new BufferedReader(new FileReader(caminho.replace("_cad", "_ser")));
		map = gson.fromJson(br, new TypeToken<Map<String, Cliente>>(){}.getType());
		revis.setServico(map);
		System.out.println("Cadastros lidos com sucesso!");
	}

}
