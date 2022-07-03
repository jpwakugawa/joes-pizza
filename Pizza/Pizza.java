package Pizza;

import Principal.Gerenciador;

public class Pizza{
	private int id;
	private String sabor;
    private double preco;
    static Pizza[] listaDePizza= new Pizza[10];
    
    Pizza() {}
    
    Pizza(String sabor){
    	setId();
    	setSabor(sabor);
    }
    
    Pizza(int id, String sabor){
    	setId();
    	setSabor(sabor);
    }
    
    Pizza(String sabor, double preco){
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
  	  return String.format("Id: %d | sabor: %s | preço: %f", id, sabor, preco);
  	  
    }
}