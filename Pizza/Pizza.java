package Pizza;

public class Pizza{
	private String sabor;
    private double preco;
    static Pizza[] listaDePizza= new Pizza[10];
    static int nPizzas = 0;
    
    Pizza() {}
    
    Pizza(String sabor){
    	setSabor(sabor);
    }
    
    Pizza(String sabor, double preco){
    	setSabor(sabor);
    	setPreco(preco);
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
  	  return String.format("sabor: %d | preço: %d |  status: %b", sabor, preco);
  	  
    }
}