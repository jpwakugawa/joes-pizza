package Principal;

import Cliente.*;
import Pedido.*;
import Pizza.*;
import FormaDePagamento.*;
import java.util.ArrayList;

public class Gerenciador {
	static ArrayList<Cliente> listaDeClientes;
	static ArrayList<Pedido> listaDePedidos;
	static ArrayList<Pizza> listaDePizzas;
	static  ArrayList<FormaDePagamento> listaDeFormaDePagamentos;
	
	private Gerenciador() {}
	
	public static ArrayList<Cliente> getListaDeClientes() {
		if (listaDeClientes == null) {
			listaDeClientes = new ArrayList<Cliente>();
		}
		return listaDeClientes;
	}
	
	public static ArrayList<Pedido> getListaDePedidos() {
		if(listaDePedidos == null) {
			listaDePedidos = new ArrayList<Pedido>();
		}
		return listaDePedidos;
	}

	public static ArrayList<Pizza> getListaDePizzas(){
		if(listaDePizzas == null)
			listaDePizzas = new ArrayList<Pizza>();
		return listaDePizzas;
	}
	
	public static ArrayList<FormaDePagamento> getListaDeFormasDePagamentos(){
		if(listaDeFormaDePagamentos == null)
			listaDeFormaDePagamentos = new ArrayList<FormaDePagamento>();
		return listaDeFormaDePagamentos;
	}
}
