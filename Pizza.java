public class Pizza{
    private boolean status;
    private String sabor;
    private double preco;

    public boolean getStatus() {
      return status;
    }

    public void setStatus(boolean status) {
      this.status = status;
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
} 