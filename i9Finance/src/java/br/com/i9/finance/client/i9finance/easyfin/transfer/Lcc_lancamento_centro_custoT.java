
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
public class Lcc_lancamento_centro_custoT extends BaseModel {
  public static final String LCC_NR_ID = "lcc_nr_id";
  public static final String CEN_NR_ID = "cen_nr_id";
  public static final String LCC_DT_LANCAMENTO = "lcc_dt_lancamento";
  public static final String LCC_VALOR = "lcc_valor";
  public static final String PLC_NR_ID = "plc_nr_id";
  public static final String LAN_NR_ID = "lan_nr_id";
  public static final String LOJ_NR_ID = "loj_nr_id";

  public Lcc_lancamento_centro_custoT() {
  }

  public int getLcc_nr_id() {
    return   get(LCC_NR_ID)==null?0: ((Integer)get(LCC_NR_ID)).intValue();
  }

  public void setLcc_nr_id(int lcc_nr_id) {
    set(LCC_NR_ID, lcc_nr_id);
  }

  public int getCen_nr_id() {
    return   get(CEN_NR_ID)==null?0: ((Integer)get(CEN_NR_ID)).intValue();
  }

  public void setCen_nr_id(int cen_nr_id) {
    set(CEN_NR_ID, cen_nr_id);
  }

  public Date getLcc_dt_lancamento() {
    return  (Date)get(LCC_DT_LANCAMENTO);
  }

  public void setLcc_dt_lancamento(Date lcc_dt_lancamento) {
    set(LCC_DT_LANCAMENTO, lcc_dt_lancamento);
  }

  public double getLcc_valor() {
    return   get(LCC_VALOR)==null?0:((Double)get(LCC_VALOR)).doubleValue();
  }

  public void setLcc_valor(double lcc_valor) {
    set(LCC_VALOR, lcc_valor);
  }

  public int getPlc_nr_id() {
    return   get(PLC_NR_ID)==null?0: ((Integer)get(PLC_NR_ID)).intValue();
  }

  public void setPlc_nr_id(int plc_nr_id) {
    set(PLC_NR_ID, plc_nr_id);
  }

  public int getLan_nr_id() {
    return   get(LAN_NR_ID)==null?0: ((Integer)get(LAN_NR_ID)).intValue();
  }

  public void setLan_nr_id(int lan_nr_id) {
    set(LAN_NR_ID, lan_nr_id);
  }

  public int getLoj_nr_id() {
    return   get(LOJ_NR_ID)==null?0: ((Integer)get(LOJ_NR_ID)).intValue();
  }

  public void setLoj_nr_id(int loj_nr_id) {
    set(LOJ_NR_ID, loj_nr_id);
  }



}

