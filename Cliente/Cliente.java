package Cliente;

import Principal.Gerenciador;

public class Cliente {
  private int id;
  private String nome;
  private String endereco;
  private String cpf;
  
  Cliente() {}
  
  Cliente(String nome, String endereco, String cpf) {
	  setId();
	  setNome(nome);
	  setEndereco(endereco);
	  setCpf(cpf);
  }
  
  public int getId() {
	  return id;
  }
  
  public void setId() {
	  this.id = Gerenciador.getListaDeClientes().size();
  }
  
  public String getNome() {
  	return nome;
  }
  
  public void setNome(String nome) {
  	this.nome = nome;
  }
  
  public String getEndereco() {
  	return endereco;
  }
  
  public void setEndereco(String endereco) {
  	this.endereco = endereco;
  }
  
  public String getCpf() {
  	return cpf;
  }
  
  public void setCpf(String cpf) {
  	this.cpf = cpf;
  }
  
  public String toString() {
	  return String.format("Id: %d | Nome: %s | Endereço: %s | CPF: %s", id, nome, endereco, cpf);
  }
  
  /*
  public void updateLista(int id, String nome, String endereco, String cpf) {
	  this.listaDeClientes[id].setNome(nome);
	  this.listaDeClientes[id].setEndereco(endereco);
	  this.listaDeClientes[id].setCpf(cpf);
  }
  
  public void deleteCliente(int id) {
	  this.listaDeClientes[id] = null;
  }
 */
}