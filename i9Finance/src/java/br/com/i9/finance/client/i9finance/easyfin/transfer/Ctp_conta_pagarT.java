
/*
 * EasyNet JDragon
 */

package br.com.i9.finance.client.i9finance.easyfin.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author George Leite Junior
 */
public class Ctp_conta_pagarT extends BaseModel {
  public static final String CTP_NR_ID = "ctp_nr_id";
  public static final String CTP_NR_DOC = "ctp_nr_doc";
  public static final String CTP_DT_EMISSAO = "ctp_dt_emissao";
  public static final String CTP_DT_VENCIMENTO = "ctp_dt_vencimento";
  public static final String CTP_TX_PAGO = "ctp_tx_pago";
  public static final String BAN_NR_ID = "ban_nr_id";
  public static final String CTP_VALOR = "ctp_valor";
  public static final String CTP_TX_PARCELA = "ctp_tx_parcela";
  public static final String CTP_DT_PAGAMENTO = "ctp_dt_pagamento";
  public static final String CAR_NR_ID = "car_nr_id";
  public static final String CTP_VL_PAGO = "ctp_vl_pago";
  public static final String CTP_SALDO = "ctp_saldo";
  public static final String FOR_NR_ID = "for_nr_id";
  public static final String FOP_NR_ID = "fop_nr_id";
  public static final String LOJ_NR_ID = "loj_nr_id";
  public static final String CTP_TX_OBS = "ctp_tx_obs";
  public static final String CTP_TX_TIPO_VINCULO = "ctp_tx_tipo_vinculo";
  public static final String CTP_NR_ID_VINCULO = "ctp_nr_id_vinculo";
  private List<Ccp_conta_ct_pagarT> list = new ArrayList();

  public Ctp_conta_pagarT() {
  }

  public int getCtp_nr_id() {
    return   get(CTP_NR_ID)==null?0: ((Integer)get(CTP_NR_ID)).intValue();
  }

  public void setCtp_nr_id(int ctp_nr_id) {
    set(CTP_NR_ID, ctp_nr_id);
  }

  public int getCtp_nr_doc() {
    return   get(CTP_NR_DOC)==null?0: ((Integer)get(CTP_NR_DOC)).intValue();
  }

  public void setCtp_nr_doc(int ctp_nr_doc) {
    set(CTP_NR_DOC, ctp_nr_doc);
  }

  public Date getCtp_dt_emissao() {
    return  (Date)get(CTP_DT_EMISSAO);
  }

  public void setCtp_dt_emissao(Date ctp_dt_emissao) {
    set(CTP_DT_EMISSAO, ctp_dt_emissao);
  }

  public Date getCtp_dt_vencimento() {
    return  (Date)get(CTP_DT_VENCIMENTO);
  }

  public void setCtp_dt_vencimento(Date ctp_dt_vencimento) {
    set(CTP_DT_VENCIMENTO, ctp_dt_vencimento);
  }

  public String getCtp_tx_pago() {
    return   get(CTP_TX_PAGO)==null?"": (String)get(CTP_TX_PAGO);
  }

  public void setCtp_tx_pago(String ctp_tx_pago) {
    set(CTP_TX_PAGO, ctp_tx_pago);
  }

  public int getBan_nr_id() {
    return   get(BAN_NR_ID)==null?0: ((Integer)get(BAN_NR_ID)).intValue();
  }

  public void setBan_nr_id(int ban_nr_id) {
    set(BAN_NR_ID, ban_nr_id);
  }

  public double getCtp_valor() {
    return   get(CTP_VALOR)==null?0:((Double)get(CTP_VALOR)).doubleValue();
  }

  public void setCtp_valor(double ctp_valor) {
    set(CTP_VALOR, ctp_valor);
  }

  public String getCtp_tx_parcela() {
    return   get(CTP_TX_PARCELA)==null?"": (String)get(CTP_TX_PARCELA);
  }

  public void setCtp_tx_parcela(String ctp_tx_parcela) {
    set(CTP_TX_PARCELA, ctp_tx_parcela);
  }

  public Date getCtp_dt_pagamento() {
    return  (Date)get(CTP_DT_PAGAMENTO);
  }

  public void setCtp_dt_pagamento(Date ctp_dt_pagamento) {
    set(CTP_DT_PAGAMENTO, ctp_dt_pagamento);
  }

  public int getCar_nr_id() {
    return   get(CAR_NR_ID)==null?0: ((Integer)get(CAR_NR_ID)).intValue();
  }

  public void setCar_nr_id(int car_nr_id) {
    set(CAR_NR_ID, car_nr_id);
  }

  public double getCtp_vl_pago() {
    return   get(CTP_VL_PAGO)==null?0:((Double)get(CTP_VL_PAGO)).doubleValue();
  }

  public void setCtp_vl_pago(double ctp_vl_pago) {
    set(CTP_VL_PAGO, ctp_vl_pago);
  }

  public double getCtp_saldo() {
    return   get(CTP_SALDO)==null?0:((Double)get(CTP_SALDO)).doubleValue();
  }

  public void setCtp_saldo(double ctp_saldo) {
    set(CTP_SALDO, ctp_saldo);
  }

  public int getFor_nr_id() {
    return   get(FOR_NR_ID)==null?0: ((Integer)get(FOR_NR_ID)).intValue();
  }

  public void setFor_nr_id(int for_nr_id) {
    set(FOR_NR_ID, for_nr_id);
  }

  public int getFop_nr_id() {
    return   get(FOP_NR_ID)==null?0: ((Integer)get(FOP_NR_ID)).intValue();
  }

  public void setFop_nr_id(int fop_nr_id) {
    set(FOP_NR_ID, fop_nr_id);
  }

  public int getLoj_nr_id() {
    return   get(LOJ_NR_ID)==null?0: ((Integer)get(LOJ_NR_ID)).intValue();
  }

  public void setLoj_nr_id(int loj_nr_id) {
    set(LOJ_NR_ID, loj_nr_id);
  }

  public String getCtp_tx_obs() {
    return   get(CTP_TX_OBS)==null?"": (String)get(CTP_TX_OBS);
  }

  public void setCtp_tx_obs(String ctp_tx_obs) {
    set(CTP_TX_OBS, ctp_tx_obs);
  }

  public String getCtp_tx_tipo_vinculo() {
    return   get(CTP_TX_TIPO_VINCULO)==null?"": (String)get(CTP_TX_TIPO_VINCULO);
  }

  public void setCtp_tx_tipo_vinculo(String ctp_tx_tipo_vinculo) {
    set(CTP_TX_TIPO_VINCULO, ctp_tx_tipo_vinculo);
  }

  public int getCtp_nr_id_vinculo() {
    return   get(CTP_NR_ID_VINCULO)==null?0: ((Integer)get(CTP_NR_ID_VINCULO)).intValue();
  }

  public void setCtp_nr_id_vinculo(int ctp_nr_id_vinculo) {
    set(CTP_NR_ID_VINCULO, ctp_nr_id_vinculo);
  }

    /**
     * @return the list
     */
    public List<Ccp_conta_ct_pagarT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Ccp_conta_ct_pagarT> list) {
        this.list = list;
    }



}

