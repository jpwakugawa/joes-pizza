package Entidades;

public class FormaDePagamento{
  private int    id;
  private String tipo;
  private String moeda;
  private String ativo;
  static  FormaDePagamento[] listaFP = new FormaDePagamento[10];
  static  int nFP = 0;
  
  public FormaDePagamento() {}
  
  public FormaDePagamento(String tipo, String moeda, String ativo){
	  setId();
	  setTipo(tipo);
	  setMoeda(moeda);
	  setAtivo(ativo);
	  addFP(this);
  }
  
  public int getId() {
	return id;
  }

  public void setId() {
	this.id = nFP;
  }

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
  
  public String toString() {
	  return String.format("Id: %d | Descri��o: %s | Moeda: %s | Ativo: %s", id, tipo, moeda, ativo);
  }
  
  public void addFP(FormaDePagamento novaFP) {
	  listaFP[nFP++] = novaFP;
  }
  
  public String getListaFP() {
	  String lista = "";
	  
	  for(int i=0; i<nFP; i++) {
		  lista += listaFP[i].toString() + "\n";
	  }
	  
	  return lista;
  }
  
}