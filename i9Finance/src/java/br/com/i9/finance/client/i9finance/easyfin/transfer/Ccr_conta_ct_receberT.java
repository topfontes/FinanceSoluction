
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
public class Ccr_conta_ct_receberT extends BaseModel {
  public static final String CCR_NR_ID = "ccr_nr_id";
  public static final String CTR_NR_ID = "ctr_nr_id";
  public static final String PLC_NR_ID = "plc_nr_id";
  public static final String CCR_VALOR = "ccr_valor";

  public Ccr_conta_ct_receberT() {
  }

  public int getCcr_nr_id() {
    return   get(CCR_NR_ID)==null?0: ((Integer)get(CCR_NR_ID)).intValue();
  }

  public void setCcr_nr_id(int ccr_nr_id) {
    set(CCR_NR_ID, ccr_nr_id);
  }

  public int getCtr_nr_id() {
    return   get(CTR_NR_ID)==null?0: ((Integer)get(CTR_NR_ID)).intValue();
  }

  public void setCtr_nr_id(int ctr_nr_id) {
    set(CTR_NR_ID, ctr_nr_id);
  }

  public int getPlc_nr_id() {
    return   get(PLC_NR_ID)==null?0: ((Integer)get(PLC_NR_ID)).intValue();
  }

  public void setPlc_nr_id(int plc_nr_id) {
    set(PLC_NR_ID, plc_nr_id);
  }

  public double getCcr_valor() {
    return   get(CCR_VALOR)==null?0:((Double)get(CCR_VALOR)).doubleValue();
  }

  public void setCcr_valor(double ccr_valor) {
    set(CCR_VALOR, ccr_valor);
  }



}

