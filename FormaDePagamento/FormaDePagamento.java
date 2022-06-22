package FormaDePagamento;
public class FormaDePagamento{
	
  private String tipo;
  private String moeda;
  private String ativo;

  public String getTipo(){
    return tipo;
  }

  public void setTipo(String tipo){
    this.tipo = tipo;
  }

  public String getMoeda(){
    return moeda;
  }

  public void setMoeda(String moeda){
    this.moeda = moeda;
  }

  public String getAtivo() {
	return ativo;
  }
	
  public void setAtivo(String ativo) {
	this.ativo = ativo;
  }
  
}