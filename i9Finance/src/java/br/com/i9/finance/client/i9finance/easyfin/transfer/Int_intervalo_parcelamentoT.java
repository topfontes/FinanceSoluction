
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
public class Int_intervalo_parcelamentoT extends BaseModel {
  public static final String INT_NR_ID = "int_nr_id";
  public static final String INT_NR_DIA = "int_nr_dia";
  public static final String INT_PERC_VALOR = "int_perc_valor";
  public static final String PAR_NR_ID = "par_nr_id";

  public Int_intervalo_parcelamentoT() {
  }

  public int getInt_nr_id() {
    return   get(INT_NR_ID)==null?0: ((Integer)get(INT_NR_ID)).intValue();
  }

  public void setInt_nr_id(int int_nr_id) {
    set(INT_NR_ID, int_nr_id);
  }

  public int getInt_nr_dia() {
    return   get(INT_NR_DIA)==null?0: ((Integer)get(INT_NR_DIA)).intValue();
  }

  public void setInt_nr_dia(int int_nr_dia) {
    set(INT_NR_DIA, int_nr_dia);
  }

  public double getInt_perc_valor() {
    return   get(INT_PERC_VALOR)==null?0:((Double)get(INT_PERC_VALOR)).doubleValue();
  }

  public void setInt_perc_valor(double int_perc_valor) {
    set(INT_PERC_VALOR, int_perc_valor);
  }

  public int getPar_nr_id() {
    return   get(PAR_NR_ID)==null?0: ((Integer)get(PAR_NR_ID)).intValue();
  }

  public void setPar_nr_id(int par_nr_id) {
    set(PAR_NR_ID, par_nr_id);
  }



}

