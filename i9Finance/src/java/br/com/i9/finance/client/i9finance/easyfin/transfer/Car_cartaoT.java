
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
public class Car_cartaoT extends BaseModel {
  public static final String CAR_NR_ID = "car_nr_id";
  public static final String CAR_PER_TAXA = "car_per_taxa";
  public static final String CAR_TX_STATUS = "car_tx_status";
  public static final String CAR_TX_NOME = "car_tx_nome";
  public static final String LOJ_NR_ID = "loj_nr_id";

  public Car_cartaoT() {
  }

  public int getCar_nr_id() {
    return   get(CAR_NR_ID)==null?0: ((Integer)get(CAR_NR_ID)).intValue();
  }

  public void setCar_nr_id(int car_nr_id) {
    set(CAR_NR_ID, car_nr_id);
  }

  public double getCar_per_taxa() {
    return   get(CAR_PER_TAXA)==null?0:((Double)get("CAR_PER_TAXA")).doubleValue();
  }

  public void setCar_per_taxa(double car_per_taxa) {
    set(CAR_PER_TAXA, car_per_taxa);
  }

  public String getCar_tx_status() {
    return   get(CAR_TX_STATUS)==null?"": (String)get(CAR_TX_STATUS);
  }

  public void setCar_tx_status(String car_tx_status) {
    set(CAR_TX_STATUS, car_tx_status);
  }

  public String getCar_tx_nome() {
    return   get(CAR_TX_NOME)==null?"": (String)get(CAR_TX_NOME);
  }

  public void setCar_tx_nome(String car_tx_nome) {
    set(CAR_TX_NOME, car_tx_nome);
  }

  public int getLoj_nr_id() {
    return   get(LOJ_NR_ID)==null?0: ((Integer)get(LOJ_NR_ID)).intValue();
  }

  public void setLoj_nr_id(int loj_nr_id) {
    set(LOJ_NR_ID, loj_nr_id);
  }



}

