
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
public class Plc_plano_contasT extends BaseModel {
  public static final String PLC_NR_ID = "plc_nr_id";
  public static final String PLC_NR_ID_SUPER = "plc_nr_id_super";
  public static final String PLC_NR_NIVEL = "plc_nr_nivel";
  public static final String PLC_TX_NOME = "plc_tx_nome";
  public static final String PLC_TX_BANCO = "plc_tx_banco";
  public static final String PLC_TX_TIPO = "plc_tx_tipo";
  public static final String PLC_TX_CENTRO_CUSTO = "plc_tx_centro_custo";
  public static final String PLC_NR_REDUZIDO = "plc_nr_reduzido";
  public static final String PLC_TX_STATUS = "plc_tx_status";
  public static final String LOJ_NR_ID = "loj_nr_id";

  public Plc_plano_contasT() {
  }

  public int getPlc_nr_id() {
    return   get(PLC_NR_ID)==null?0: ((Integer)get(PLC_NR_ID)).intValue();
  }

  public void setPlc_nr_id(int plc_nr_id) {
    set(PLC_NR_ID, plc_nr_id);
  }

  public int getPlc_nr_id_super() {
    return   get(PLC_NR_ID_SUPER)==null?0: ((Integer)get(PLC_NR_ID_SUPER)).intValue();
  }

  public void setPlc_nr_id_super(int plc_nr_id_super) {
    set(PLC_NR_ID_SUPER, plc_nr_id_super);
  }

  public int getPlc_nr_nivel() {
    return   get(PLC_NR_NIVEL)==null?0: ((Integer)get(PLC_NR_NIVEL)).intValue();
  }

  public void setPlc_nr_nivel(int plc_nr_nivel) {
    set(PLC_NR_NIVEL, plc_nr_nivel);
  }

  public String getPlc_tx_nome() {
    return   get(PLC_TX_NOME)==null?"": (String)get(PLC_TX_NOME);
  }

  public void setPlc_tx_nome(String plc_tx_nome) {
    set(PLC_TX_NOME, plc_tx_nome);
  }

  public String getPlc_tx_banco() {
    return   get(PLC_TX_BANCO)==null?"": (String)get(PLC_TX_BANCO);
  }

  public void setPlc_tx_banco(String plc_tx_banco) {
    set(PLC_TX_BANCO, plc_tx_banco);
  }

  public String getPlc_tx_tipo() {
    return   get(PLC_TX_TIPO)==null?"": (String)get(PLC_TX_TIPO);
  }

  public void setPlc_tx_tipo(String plc_tx_tipo) {
    set(PLC_TX_TIPO, plc_tx_tipo);
  }

  public String getPlc_tx_centro_custo() {
    return   get(PLC_TX_CENTRO_CUSTO)==null?"": (String)get(PLC_TX_CENTRO_CUSTO);
  }

  public void setPlc_tx_centro_custo(String plc_tx_centro_custo) {
    set(PLC_TX_CENTRO_CUSTO, plc_tx_centro_custo);
  }

  public int getPlc_nr_reduzido() {
    return   get(PLC_NR_REDUZIDO)==null?0: ((Integer)get(PLC_NR_REDUZIDO)).intValue();
  }

  public void setPlc_nr_reduzido(int plc_nr_reduzido) {
    set(PLC_NR_REDUZIDO, plc_nr_reduzido);
  }

  public String getPlc_tx_status() {
    return   get(PLC_TX_STATUS)==null?"": (String)get(PLC_TX_STATUS);
  }

  public void setPlc_tx_status(String plc_tx_status) {
    set(PLC_TX_STATUS, plc_tx_status);
  }

  public int getLoj_nr_id() {
    return   get(LOJ_NR_ID)==null?0: ((Integer)get(LOJ_NR_ID)).intValue();
  }

  public void setLoj_nr_id(int loj_nr_id) {
    set(LOJ_NR_ID, loj_nr_id);
  }



}

