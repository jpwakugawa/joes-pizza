package Pedido;
import Cliente.*;
import FormaDePagamento.*;
import Pizza.*;

public class Pedido {
  private int id;
  private Pizza pizza;
  private Cliente cliente;
  private FormaDePagamento formaDePagamento;
  
  Pedido() {}
  
  Pedido(int id, Pizza pizza, Cliente cliente, FormaDePagamento formaDePagamento) {
	  setId(id);
	  setPizza(pizza);
	  setCliente(cliente);
	  setFormaDePagamento(formaDePagamento);
  }
  
  public int getId() {
  	return id;
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
  
}