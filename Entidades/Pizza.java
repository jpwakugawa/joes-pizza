package Entidades;

import Principal.Gerenciador;

public class Pizza{
	private int id;
	private String sabor;
    private double preco;
    
    public Pizza() {}
    
    public Pizza(String sabor){
    	setId();
    	setSabor(sabor);
    }
    
    public Pizza(int id, String sabor, double preco){
    	setId(id);
    	setSabor(sabor);
    	setPreco(preco);
    }
    
    public Pizza(String sabor, double preco){
    	setId();
    	setSabor(sabor);
    	setPreco(preco);
    }
    
    public int getId() {
		return id;
	}

	public void setId() {
		this.id = Gerenciador.getListaDePizzas().size();
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getSabor(){
        return sabor;
    }
    
    public void setSabor(String sabor){
        this.sabor = sabor;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }
    
    public String toString() {
    	return String.format("Id: %d | Sabor: %s | Preço: %.2f", id, sabor, preco);
    }
    
    public String toStringPedido() {
    	return String.format("Sabor: %s | Preço: %.2f", sabor, preco);
    }
}