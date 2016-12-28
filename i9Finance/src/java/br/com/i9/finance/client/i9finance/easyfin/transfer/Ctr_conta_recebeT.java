
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
public class Ctr_conta_recebeT extends BaseModel {
  public static final String CTR_NR_ID = "ctr_nr_id";
  public static final String CLI_NR_ID = "cli_nr_id";
  public static final String CTR_NR_DOC = "ctr_nr_doc";
  public static final String CTR_DT_EMISSAO = "ctr_dt_emissao";
  public static final String CTR_DT_VENCIMENTO = "ctr_dt_vencimento";
  public static final String FOP_NR_ID = "fop_nr_id";
  public static final String CTR_TX_PAGO = "ctr_tx_pago";
  public static final String BAN_NR_ID = "ban_nr_id";
  public static final String CTR_VALOR = "ctr_valor";
  public static final String CTR_TX_PARCELA = "ctr_tx_parcela";
  public static final String CTR_DT_PAGAMENTO = "ctr_dt_pagamento";
  public static final String CAR_NR_ID = "car_nr_id";
  public static final String CTR_VL_PAGO = "ctr_vl_pago";
  public static final String CTR_SALDO = "ctr_saldo";
  public static final String LOJ_NR_ID = "loj_nr_id";
  public static final String CTR_TX_OBS = "ctr_tx_obs";
  public static final String CTR_TX_TIPO_VINCULO = "ctr_tx_tipo_vinculo";
  public static final String CTR_NR_ID_VINCULO = "ctr_nr_id_vinculo";
  private List<Ccr_conta_ct_receberT> listContas = new ArrayList<Ccr_conta_ct_receberT>();

  public Ctr_conta_recebeT() {
  }

  public int getCtr_nr_id() {
    return   get(CTR_NR_ID)==null?0: ((Integer)get(CTR_NR_ID)).intValue();
  }

  public void setCtr_nr_id(int ctr_nr_id) {
    set(CTR_NR_ID, ctr_nr_id);
  }

  public int getCli_nr_id() {
    return   get(CLI_NR_ID)==null?0: ((Integer)get(CLI_NR_ID)).intValue();
  }

  public void setCli_nr_id(int cli_nr_id) {
    set(CLI_NR_ID, cli_nr_id);
  }

  public int getCtr_nr_doc() {
    return   get(CTR_NR_DOC)==null?0: ((Integer)get(CTR_NR_DOC)).intValue();
  }

  public void setCtr_nr_doc(int ctr_nr_doc) {
    set(CTR_NR_DOC, ctr_nr_doc);
  }

  public Date getCtr_dt_emissao() {
    return  (Date)get(CTR_DT_EMISSAO);
  }

  public void setCtr_dt_emissao(Date ctr_dt_emissao) {
    set(CTR_DT_EMISSAO, ctr_dt_emissao);
  }

  public Date getCtr_dt_vencimento() {
    return  (Date)get(CTR_DT_VENCIMENTO);
  }

  public void setCtr_dt_vencimento(Date ctr_dt_vencimento) {
    set(CTR_DT_VENCIMENTO, ctr_dt_vencimento);
  }

  public int getFop_nr_id() {
    return   get(FOP_NR_ID)==null?0: ((Integer)get(FOP_NR_ID)).intValue();
  }

  public void setFop_nr_id(int fop_nr_id) {
    set(FOP_NR_ID, fop_nr_id);
  }

  public String getCtr_tx_pago() {
    return   get(CTR_TX_PAGO)==null?"": (String)get(CTR_TX_PAGO);
  }

  public void setCtr_tx_pago(String ctr_tx_pago) {
    set(CTR_TX_PAGO, ctr_tx_pago);
  }

  public int getBan_nr_id() {
    return   get(BAN_NR_ID)==null?0: ((Integer)get(BAN_NR_ID)).intValue();
  }

  public void setBan_nr_id(int ban_nr_id) {
    set(BAN_NR_ID, ban_nr_id);
  }

  public double getCtr_valor() {
    return   get(CTR_VALOR)==null?0:((Double)get(CTR_VALOR)).doubleValue();
  }

  public void setCtr_valor(double ctr_valor) {
    set(CTR_VALOR, ctr_valor);
  }

  public String getCtr_tx_parcela() {
    return   get(CTR_TX_PARCELA)==null?"": (String)get(CTR_TX_PARCELA);
  }

  public void setCtr_tx_parcela(String ctr_tx_parcela) {
    set(CTR_TX_PARCELA, ctr_tx_parcela);
  }

  public Date getCtr_dt_pagamento() {
    return  (Date)get(CTR_DT_PAGAMENTO);
  }

  public void setCtr_dt_pagamento(Date ctr_dt_pagamento) {
    set(CTR_DT_PAGAMENTO, ctr_dt_pagamento);
  }

  public int getCar_nr_id() {
    return   get(CAR_NR_ID)==null?0: ((Integer)get(CAR_NR_ID)).intValue();
  }

  public void setCar_nr_id(int car_nr_id) {
    set(CAR_NR_ID, car_nr_id);
  }

  public double getCtr_vl_pago() {
    return   get(CTR_VL_PAGO)==null?0:((Double)get(CTR_VL_PAGO)).doubleValue();
  }

  public void setCtr_vl_pago(double ctr_vl_pago) {
    set(CTR_VL_PAGO, ctr_vl_pago);
  }

  public double getCtr_saldo() {
    return   get(CTR_SALDO)==null?0:((Double)get(CTR_SALDO)).doubleValue();
  }

  public void setCtr_saldo(double ctr_saldo) {
    set(CTR_SALDO, ctr_saldo);
  }

  public int getLoj_nr_id() {
    return   get(LOJ_NR_ID)==null?0: ((Integer)get(LOJ_NR_ID)).intValue();
  }

  public void setLoj_nr_id(int loj_nr_id) {
    set(LOJ_NR_ID, loj_nr_id);
  }

  public String getCtr_tx_obs() {
    return   get(CTR_TX_OBS)==null?"": (String)get(CTR_TX_OBS);
  }

  public void setCtr_tx_obs(String ctr_tx_obs) {
    set(CTR_TX_OBS, ctr_tx_obs);
  }

  public String getCtr_tx_tipo_vinculo() {
    return   get(CTR_TX_TIPO_VINCULO)==null?"": (String)get(CTR_TX_TIPO_VINCULO);
  }

  public void setCtr_tx_tipo_vinculo(String ctr_tx_tipo_vinculo) {
    set(CTR_TX_TIPO_VINCULO, ctr_tx_tipo_vinculo);
  }

  public int getCtr_nr_id_vinculo() {
    return   get(CTR_NR_ID_VINCULO)==null?0: ((Integer)get(CTR_NR_ID_VINCULO)).intValue();
  }

  public void setCtr_nr_id_vinculo(int ctr_nr_id_vinculo) {
    set(CTR_NR_ID_VINCULO, ctr_nr_id_vinculo);
  }

    /**
     * @return the listContas
     */
    public List<Ccr_conta_ct_receberT> getListContas() {
        return listContas;
    }

    /**
     * @param listContas the listContas to set
     */
    public void setListContas(List<Ccr_conta_ct_receberT> listContas) {
        this.listContas = listContas;
    }



}

