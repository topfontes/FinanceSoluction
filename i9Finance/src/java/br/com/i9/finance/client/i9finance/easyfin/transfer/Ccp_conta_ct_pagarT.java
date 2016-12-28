
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
public class Ccp_conta_ct_pagarT extends BaseModel {
  public static final String CCP_NR_ID = "ccp_nr_id";
  public static final String CTP_NR_ID = "ctp_nr_id";
  public static final String PLC_NR_ID = "plc_nr_id";
  public static final String CCP_VALOR = "ccp_valor";

  public Ccp_conta_ct_pagarT() {
  }

  public int getCcp_nr_id() {
    return   get(CCP_NR_ID)==null?0: ((Integer)get(CCP_NR_ID)).intValue();
  }

  public void setCcp_nr_id(int ccp_nr_id) {
    set(CCP_NR_ID, ccp_nr_id);
  }

  public int getCtp_nr_id() {
    return   get(CTP_NR_ID)==null?0: ((Integer)get(CTP_NR_ID)).intValue();
  }

  public void setCtp_nr_id(int ctp_nr_id) {
    set(CTP_NR_ID, ctp_nr_id);
  }

  public int getPlc_nr_id() {
    return   get(PLC_NR_ID)==null?0: ((Integer)get(PLC_NR_ID)).intValue();
  }

  public void setPlc_nr_id(int plc_nr_id) {
    set(PLC_NR_ID, plc_nr_id);
  }

  public double getCcp_valor() {
    return   get(CCP_VALOR)==null?0:((Double)get(CCP_VALOR)).doubleValue();
  }

  public void setCcp_valor(double ccp_valor) {
    set(CCP_VALOR, ccp_valor);
  }



}

