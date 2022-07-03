package Pizza;

import Principal.Gerenciador;

public class Pizza{
	private double preco;
	private String sabor;
    
    
    Pizza(){}
    
    Pizza(String sabor){
    	setPreco();
    	setSabor(sabor);
    }
    
    Pizza(double preco, String sabor) {
    	setPreco(preco);
    	setSabor(sabor);
    }

    public double getPreco() {
    	return preco;
    }
    
    public void setPreco() {
    	this.preco = Gerenciador.getListaDePizza().size();
    }
    
    public void setPreco(double preco) {
    	this.preco = preco;
    }

    public String getSabor(){
        return sabor;
    }
    
    public void setSabor(String sabor){
        this.sabor = sabor;
    }
   
    public String toString() {
  	  return String.format("sabor: %s | preço: %d ", sabor, preco);
  	  
    }
}