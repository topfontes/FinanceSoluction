
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
public class Cucp_custo_conta_pagarT extends BaseModel {
  public static final String CUCP_NR_ID = "cucp_nr_id";
  public static final String CEN_NR_ID = "cen_nr_id";
  public static final String CUCP_VALOR = "cucp_valor";
  public static final String CCP_NR_ID = "ccp_nr_id";

  public Cucp_custo_conta_pagarT() {
  }

  public int getCucp_nr_id() {
    return   get(CUCP_NR_ID)==null?0: ((Integer)get(CUCP_NR_ID)).intValue();
  }

  public void setCucp_nr_id(int cucp_nr_id) {
    set(CUCP_NR_ID, cucp_nr_id);
  }

  public int getCen_nr_id() {
    return   get(CEN_NR_ID)==null?0: ((Integer)get(CEN_NR_ID)).intValue();
  }

  public void setCen_nr_id(int cen_nr_id) {
    set(CEN_NR_ID, cen_nr_id);
  }

  public double getCucp_valor() {
    return   get(CUCP_VALOR)==null?0:((Double)get("CUCP_VALOR")).doubleValue();
  }

  public void setCucp_valor(double cucp_valor) {
    set(CUCP_VALOR, cucp_valor);
  }

  public int getCcp_nr_id() {
    return   get(CCP_NR_ID)==null?0: ((Integer)get(CCP_NR_ID)).intValue();
  }

  public void setCcp_nr_id(int ccp_nr_id) {
    set(CCP_NR_ID, ccp_nr_id);
  }



}

