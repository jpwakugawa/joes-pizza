package FormaDePagamento;

import Principal.Gerenciador;

public class FormaDePagamento{
  private int    id;
  private String tipo;
  private String moeda;
  private String ativo;
  
  FormaDePagamento() {}
  
  FormaDePagamento(String tipo, String moeda, String ativo){
	  setId();
	  setTipo(tipo);
	  setMoeda(moeda);
	  setAtivo(ativo);
  }
  
  FormaDePagamento(int id, String tipo, String moeda, String ativo){
	  setId(id);
	  setTipo(tipo);
	  setMoeda(moeda);
	  setAtivo(ativo);
  }
  
  public int getId() {
	return id;
  }

  public void setId() {
	this.id = Gerenciador.getListaDeFormasDePagamentos().size();
  }
  
  public void setId(int id) {
		this.id = id;
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
	  return String.format("Id: %d | Descrição: %s | Moeda: %s | Ativo: %s", id, tipo, moeda, ativo);
  }
}