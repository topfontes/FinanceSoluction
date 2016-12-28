
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
public class Cen_centro_custoT extends BaseModel {
  public static final String CEN_NR_ID = "cen_nr_id";
  public static final String CEN_TX_STATUS = "cen_tx_status";
  public static final String CEN_TX_NOME = "cen_tx_nome";
  public static final String LOJ_NR_ID = "loj_nr_id";

  public Cen_centro_custoT() {
  }

  public int getCen_nr_id() {
    return   get(CEN_NR_ID)==null?0: ((Integer)get(CEN_NR_ID)).intValue();
  }

  public void setCen_nr_id(int cen_nr_id) {
    set(CEN_NR_ID, cen_nr_id);
  }

  public String getCen_tx_status() {
    return   get(CEN_TX_STATUS)==null?"": (String)get(CEN_TX_STATUS);
  }

  public void setCen_tx_status(String cen_tx_status) {
    set(CEN_TX_STATUS, cen_tx_status);
  }

  public String getCen_tx_nome() {
    return   get(CEN_TX_NOME)==null?"": (String)get(CEN_TX_NOME);
  }

  public void setCen_tx_nome(String cen_tx_nome) {
    set(CEN_TX_NOME, cen_tx_nome);
  }

  public int getLoj_nr_id() {
    return   get(LOJ_NR_ID)==null?0: ((Integer)get(LOJ_NR_ID)).intValue();
  }

  public void setLoj_nr_id(int loj_nr_id) {
    set(LOJ_NR_ID, loj_nr_id);
  }



}

