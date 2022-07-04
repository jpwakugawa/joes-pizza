package Cliente;

import FormaDePagamento.FormaDePagamento;
import Principal.Gerenciador;

public class Cliente {
  private int id;
  private String nome;
  private String endereco;
  private String cpf;
  private FormaDePagamento novaFP;
  
  Cliente() {}
  
  Cliente(String nome, String endereco, String cpf, FormaDePagamento novaFP) {
	  setId();
	  setNome(nome);
	  setEndereco(endereco);
	  setCpf(cpf);
	  setNovaFP(novaFP);
  }
  
  Cliente(int id, String nome, String endereco, String cpf, FormaDePagamento novaFP) {
	  setId(id);
	  setNome(nome);
	  setEndereco(endereco);
	  setCpf(cpf);
	  setNovaFP(novaFP);
  }
  
  public int getId() {
	  return id;
  }
  
  public void setId() {
	  this.id = Gerenciador.getListaDeClientes().size();
  }
  
  public void setId(int id) {
	  this.id = id;
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
  
  public FormaDePagamento getNovaFP() {
	return novaFP;
  }

  public void setNovaFP(FormaDePagamento novaFP) {
	this.novaFP = novaFP;
  }

  public String toString() {
	  return String.format("Id: %d | Nome: %s | EndereÃ§o: %s | CPF: %s | Forma de Pagamento: %s", id, nome, endereco, cpf, novaFP.getTipo());
  }
  
  public String toStringPedido() {
	  return String.format("Nome: %s | Endereço: %s | Forma de Pagamento: %s ", nome, endereco, novaFP.getTipo());
  }
  
}