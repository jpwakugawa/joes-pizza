package Pedido;
import Cliente.*;
import FormaDePagamento.*;
import Pizza.*;
import Principal.Gerenciador;

public class Pedido {
  private int id;
  private Pizza pizza;
  private Cliente cliente;
  
  Pedido() {}
  
  Pedido(Pizza pizza, Cliente cliente) {
	  setId();
	  setPizza(pizza);
	  setCliente(cliente);
  }
  
  Pedido(int id, Pizza pizza, Cliente cliente) {
	  setId(id);
	  setPizza(pizza);
	  setCliente(cliente);
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
  
  public String toString() {
	  return String.format("Id_Pedido: %d | Pizza > %s | Cliente > %s", id, pizza.toStringPedido(), cliente.toStringPedido());
  }
  
}