
/*
 * EasyNet JDragon
 */

package br.com.i9.finance.client.i9finance.easyfin.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.Date;

/**
 * br.com.i9.finance.client.i9finance.easyfin.transfer.Ban_bancoT
 * @author George Leite Junior
 */
public class Ban_bancoT extends BaseModel {
  public static final String BAN_TX_STATUS = "ban_tx_status";
  public static final String BAN_TX_NOME = "ban_tx_nome";
  public static final String BAN_NR_ID = "ban_nr_id";
  public static final String LOJ_NR_ID = "loj_nr_id";

  public Ban_bancoT() {
  }

  public String getBan_tx_status() {
    return   get(BAN_TX_STATUS)==null?"": (String)get(BAN_TX_STATUS);
  }

  public void setBan_tx_status(String ban_tx_status) {
    set(BAN_TX_STATUS, ban_tx_status);
  }

  public String getBan_tx_nome() {
    return   get(BAN_TX_NOME)==null?"": (String)get(BAN_TX_NOME);
  }

  public void setBan_tx_nome(String ban_tx_nome) {
    set(BAN_TX_NOME, ban_tx_nome);
  }

  public int getBan_nr_id() {
    return   get(BAN_NR_ID)==null?0: ((Integer)get(BAN_NR_ID)).intValue();
  }

  public void setBan_nr_id(int ban_nr_id) {
    set(BAN_NR_ID, ban_nr_id);
  }

  public int getLoj_nr_id() {
    return   get(LOJ_NR_ID)==null?0: ((Integer)get(LOJ_NR_ID)).intValue();
  }

  public void setLoj_nr_id(int loj_nr_id) {
    set(LOJ_NR_ID, loj_nr_id);
  }



}

