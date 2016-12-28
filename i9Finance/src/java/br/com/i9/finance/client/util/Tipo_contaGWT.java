package br.com.i9.finance.client.util;


import static br.com.i9.finance.client.i9finance.easyfin.transfer.Car_cartaoT.CAR_NR_ID;
import static br.com.i9.finance.client.i9finance.easyfin.transfer.Car_cartaoT.CAR_PER_TAXA;
import com.extjs.gxt.ui.client.data.BaseModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author marcos
 */
public class Tipo_contaGWT extends BaseModel{
    
    private static final String TIPO ="tipo";
    private static final String DESCRICAO ="descricao";
    
  public Tipo_contaGWT(String tipo, String descricao) {
      setTipo(tipo);
      setDescricao(descricao);
      
  }


  public String getTipo() {
    return   get(TIPO)==null?"":(String)get(TIPO);
  }

  public void setTipo(String tipo) {
    set(TIPO, tipo);
  }    
    
  
  public String getDescricao() {
    return   get(DESCRICAO)==null?"":(String)get(DESCRICAO);
  }

  public void setDescricao(String desc) {
    set(DESCRICAO, desc);
  }     
  
}
