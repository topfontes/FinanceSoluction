
/*
 * EasyNet JDragon
 */

package br.com.i9.finance.client.i9finance.easyfin.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.Date;

/**
 *
 * @author George Leite Junior
 */
public class Fop_forma_pagamentoT extends BaseModel {
  public static final String FOP_NR_ID = "fop_nr_id";
  public static final String FOP_TX_AVISTA = "fop_tx_avista";
  public static final String FOP_TX_STATUS = "fop_tx_status";
  public static final String FOP_TX_NOME = "fop_tx_nome";
  public static final String LOJ_NR_ID = "loj_nr_id";

  public Fop_forma_pagamentoT() {
  }

  public int getFop_nr_id() {
    return   get(FOP_NR_ID)==null?0: ((Integer)get(FOP_NR_ID)).intValue();
  }

  public void setFop_nr_id(int fop_nr_id) {
    set(FOP_NR_ID, fop_nr_id);
  }

  public String getFop_tx_avista() {
    return   get(FOP_TX_AVISTA)==null?"": (String)get(FOP_TX_AVISTA);
  }

  public void setFop_tx_avista(String fop_tx_avista) {
    set(FOP_TX_AVISTA, fop_tx_avista);
  }

  public String getFop_tx_status() {
    return   get(FOP_TX_STATUS)==null?"": (String)get(FOP_TX_STATUS);
  }

  public void setFop_tx_status(String fop_tx_status) {
    set(FOP_TX_STATUS, fop_tx_status);
  }

  public String getFop_tx_nome() {
    return   get(FOP_TX_NOME)==null?"": (String)get(FOP_TX_NOME);
  }

  public void setFop_tx_nome(String fop_tx_nome) {
    set(FOP_TX_NOME, fop_tx_nome);
  }

  public int getLoj_nr_id() {
    return   get(LOJ_NR_ID)==null?0: ((Integer)get(LOJ_NR_ID)).intValue();
  }

  public void setLoj_nr_id(int loj_nr_id) {
    set(LOJ_NR_ID, loj_nr_id);
  }



}

