public class Cliente {
  private String nome;
  private String endereco;
  private String cpf;
  static Cliente[] listaDeClientes = new Cliente[10];
  static int nClientes = 0;
  
  Cliente() {}
  
  Cliente(String nome, String endereco, String cpf) {
	  setNome(nome);
	  setEndereco(endereco);
	  setCpf(cpf);
	  addCliente(this);
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
	  return String.format("Nome: %s | Endereço: %s | CPF: %s", nome, endereco, cpf);
  }
  
  public void addCliente(Cliente novoCliente) {
	  listaDeClientes[nClientes++] = novoCliente;
  }
  
  public String getListaDeClientes() {
	  String lista = "";
	  
	  for(int i=0; i<nClientes; i++) {
		  lista += listaDeClientes[i].toString() + "\n";
	  }
	  
	  return lista;
  }
}