package Principal;
import Cliente.*;
import Pedido.*;
import java.util.ArrayList;

public class Gerenciador {
	static ArrayList<Cliente> listaDeClientes;
	static ArrayList<Pedido> listaDePedidos;
	
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
}
