
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
public class Par_parcelamentoT extends BaseModel {
  public static final String PAR_NR_ID = "par_nr_id";
  public static final String PAR_NR_PARCELA = "par_nr_parcela";
  public static final String PAR_TX_STATUS = "par_tx_status";
  public static final String PAR_TX_NOME = "par_tx_nome";
  public static final String LOJ_NR_ID = "loj_nr_id";

  public Par_parcelamentoT() {
  }

  public int getPar_nr_id() {
    return   get(PAR_NR_ID)==null?0: ((Integer)get(PAR_NR_ID)).intValue();
  }

  public void setPar_nr_id(int par_nr_id) {
    set(PAR_NR_ID, par_nr_id);
  }

  public int getPar_nr_parcela() {
    return   get(PAR_NR_PARCELA)==null?0: ((Integer)get(PAR_NR_PARCELA)).intValue();
  }

  public void setPar_nr_parcela(int par_nr_parcela) {
    set(PAR_NR_PARCELA, par_nr_parcela);
  }

  public String getPar_tx_status() {
    return   get(PAR_TX_STATUS)==null?"": (String)get(PAR_TX_STATUS);
  }

  public void setPar_tx_status(String par_tx_status) {
    set(PAR_TX_STATUS, par_tx_status);
  }

  public String getPar_tx_nome() {
    return   get(PAR_TX_NOME)==null?"": (String)get(PAR_TX_NOME);
  }

  public void setPar_tx_nome(String par_tx_nome) {
    set(PAR_TX_NOME, par_tx_nome);
  }

  public int getLoj_nr_id() {
    return   get(LOJ_NR_ID)==null?0: ((Integer)get(LOJ_NR_ID)).intValue();
  }

  public void setLoj_nr_id(int loj_nr_id) {
    set(LOJ_NR_ID, loj_nr_id);
  }



}

