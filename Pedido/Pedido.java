package Pedido;
import Cliente.*;
import FormaDePagamento.*;
import Pizza.*;
import Principal.Gerenciador;

public class Pedido {
  private int id;
  private Pizza pizza;
  private Cliente cliente;
  private FormaDePagamento formaDePagamento;
  
  Pedido() {}
  
  Pedido(Pizza pizza, Cliente cliente, FormaDePagamento formaDePagamento) {
	  setId();
	  setPizza(pizza);
	  setCliente(cliente);
	  setFormaDePagamento(formaDePagamento);
  }
  
  Pedido(int id, Pizza pizza, Cliente cliente, FormaDePagamento formaDePagamento) {
	  setId(id);
	  setPizza(pizza);
	  setCliente(cliente);
	  setFormaDePagamento(formaDePagamento);
  }
  
  public int getId() {
  	return id;
  }
  
  public void setId() {
  	this.id = Gerenciador.getListaDePedidos().size();
  }
  
  public void setId(int id) {
	  this.id = id;
  }
  
  public Pizza getPizza() {
  	return pizza;
  }
  
  public void setPizza(Pizza pizza) {
  	this.pizza = pizza;
  }
  
  public Cliente getCliente() {
  	return cliente;
  }
  
  public void setCliente(Cliente cliente) {
  	this.cliente = cliente;
  }
  
  public FormaDePagamento getFormaDePagamento() {
  	return formaDePagamento;
  }
  
  public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
  	this.formaDePagamento = formaDePagamento;
  }
  
  public String toString() {
	  return String.format("Id_Pedido: %d | Pizza > %s | Cliente > %s | Forma de Pagamento > %s", id, pizza.toStringPedido(), cliente.toStringPedido(), formaDePagamento.toStringPedido());
  }
  
}