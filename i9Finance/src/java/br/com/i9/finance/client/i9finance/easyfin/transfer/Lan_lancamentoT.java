
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
public class Lan_lancamentoT extends BaseModel {
  public static final String LAN_NR_ID = "lan_nr_id";
  public static final String CTR_NR_ID = "ctr_nr_id";
  public static final String CTP_NR_ID = "ctp_nr_id";
  public static final String LAN_PLC_NR_ID_DEB = "lan_plc_nr_id_deb";
  public static final String LAN_PLC_NR_ID_CRED = "lan_plc_nr_id_cred";
  public static final String LAN_DT_LANCAMENTO = "lan_dt_lancamento";
  public static final String LAN_TX_HISTORICO = "lan_tx_historico";
  public static final String LAN_VALOR = "lan_valor";
  public static final String LOJ_NR_ID = "loj_nr_id";
  public static final String LAN_NR_ID_SUPER = "lan_nr_id_super";

  public Lan_lancamentoT() {
  }

  public int getLan_nr_id() {
    return   get(LAN_NR_ID)==null?0: ((Integer)get(LAN_NR_ID)).intValue();
  }

  public void setLan_nr_id(int lan_nr_id) {
    set(LAN_NR_ID, lan_nr_id);
  }

  public int getCtr_nr_id() {
    return   get(CTR_NR_ID)==null?0: ((Integer)get(CTR_NR_ID)).intValue();
  }

  public void setCtr_nr_id(int ctr_nr_id) {
    set(CTR_NR_ID, ctr_nr_id);
  }

  public int getCtp_nr_id() {
    return   get(CTP_NR_ID)==null?0: ((Integer)get(CTP_NR_ID)).intValue();
  }

  public void setCtp_nr_id(int ctp_nr_id) {
    set(CTP_NR_ID, ctp_nr_id);
  }

  public int getLan_plc_nr_id_deb() {
    return   get(LAN_PLC_NR_ID_DEB)==null?0: ((Integer)get(LAN_PLC_NR_ID_DEB)).intValue();
  }

  public void setLan_plc_nr_id_deb(int lan_plc_nr_id_deb) {
    set(LAN_PLC_NR_ID_DEB, lan_plc_nr_id_deb);
  }

  public int getLan_plc_nr_id_cred() {
    return   get(LAN_PLC_NR_ID_CRED)==null?0: ((Integer)get(LAN_PLC_NR_ID_CRED)).intValue();
  }

  public void setLan_plc_nr_id_cred(int lan_plc_nr_id_cred) {
    set(LAN_PLC_NR_ID_CRED, lan_plc_nr_id_cred);
  }

  public Date getLan_dt_lancamento() {
    return  (Date)get(LAN_DT_LANCAMENTO);
  }

  public void setLan_dt_lancamento(Date lan_dt_lancamento) {
    set(LAN_DT_LANCAMENTO, lan_dt_lancamento);
  }

  public String getLan_tx_historico() {
    return   get(LAN_TX_HISTORICO)==null?"": (String)get(LAN_TX_HISTORICO);
  }

  public void setLan_tx_historico(String lan_tx_historico) {
    set(LAN_TX_HISTORICO, lan_tx_historico);
  }

  public double getLan_valor() {
    return   get(LAN_VALOR)==null?0:((Double)get(LAN_VALOR)).doubleValue();
  }

  public void setLan_valor(double lan_valor) {
    set(LAN_VALOR, lan_valor);
  }

  public int getLoj_nr_id() {
    return   get(LOJ_NR_ID)==null?0: ((Integer)get(LOJ_NR_ID)).intValue();
  }

  public void setLoj_nr_id(int loj_nr_id) {
    set(LOJ_NR_ID, loj_nr_id);
  }

  public double getLan_nr_id_super() {
    return   get(LAN_NR_ID_SUPER)==null?0:((Double)get(LAN_NR_ID_SUPER)).doubleValue();
  }

  public void setLan_nr_id_super(double lan_nr_id_super) {
    set(LAN_NR_ID_SUPER, lan_nr_id_super);
  }



}

