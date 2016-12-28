
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
public class Conf_configuracaoT extends BaseModel {
  public static final String CONF_PLC_NR_ID_JUROS_RECEBIDO = "conf_plc_nr_id_juros_recebido";
  public static final String CONF_PLC_NR_ID_DESCONTO_CONSEDIDO = "conf_plc_nr_id_desconto_consedido";
  public static final String CONF_PLC_NR_ID_DESCONTO_RECEBIDO = "conf_plc_nr_id_desconto_recebido";
  public static final String LOJ_NR_ID = "loj_nr_id";
  public static final String CONF_PLC_NR_ID_TAXA_CARTAO = "conf_plc_nr_id_taxa_cartao";
  public static final String CONF_TX_LANCAMENTO_AUTO_TAXA_CARTAO = "conf_tx_lancamento_auto_taxa_cartao";
  public static final String CONF_PLC_NR_ID_JUROS_CONSEDIDO = "conf_plc_nr_id_juros_consedido";
  public static final String CONF_TX_BAIXA_CARTAO_AUTOMATICO = "conf_tx_baixa_cartao_automatico";
  public static final String CONF_NR_ID = "conf_nr_id";
  public static final String CONF_PLC_NR_ID_DEFAULT = "conf_plc_nr_id_default";
  public static final String CONF_PLC_NR_ID_CAIXA = "conf_plc_nr_id_caixa";
  public static final String CONF_TX_LAN_AUTO_CONTA_VINC_CTR = "conf_tx_lan_auto_conta_vinc_ctr";
  public static final String CONF_TX_LAN_AUTO_CONTA_VINC_CTP = "conf_tx_lan_auto_conta_vinc_ctp";

  public Conf_configuracaoT() {
  }

  public int getConf_plc_nr_id_juros_recebido() {
    return   get(CONF_PLC_NR_ID_JUROS_RECEBIDO)==null?0: ((Integer)get(CONF_PLC_NR_ID_JUROS_RECEBIDO)).intValue();
  }

  public void setConf_plc_nr_id_juros_recebido(int conf_plc_nr_id_juros_recebido) {
    set(CONF_PLC_NR_ID_JUROS_RECEBIDO, conf_plc_nr_id_juros_recebido);
  }

  public int getConf_plc_nr_id_desconto_consedido() {
    return   get(CONF_PLC_NR_ID_DESCONTO_CONSEDIDO)==null?0: ((Integer)get(CONF_PLC_NR_ID_DESCONTO_CONSEDIDO)).intValue();
  }

  public void setConf_plc_nr_id_desconto_consedido(int conf_plc_nr_id_desconto_consedido) {
    set(CONF_PLC_NR_ID_DESCONTO_CONSEDIDO, conf_plc_nr_id_desconto_consedido);
  }

  public int getConf_plc_nr_id_desconto_recebido() {
    return   get(CONF_PLC_NR_ID_DESCONTO_RECEBIDO)==null?0: ((Integer)get(CONF_PLC_NR_ID_DESCONTO_RECEBIDO)).intValue();
  }

  public void setConf_plc_nr_id_desconto_recebido(int conf_plc_nr_id_desconto_recebido) {
    set(CONF_PLC_NR_ID_DESCONTO_RECEBIDO, conf_plc_nr_id_desconto_recebido);
  }

  public int getLoj_nr_id() {
    return   get(LOJ_NR_ID)==null?0: ((Integer)get(LOJ_NR_ID)).intValue();
  }

  public void setLoj_nr_id(int loj_nr_id) {
    set(LOJ_NR_ID, loj_nr_id);
  }

  public int getConf_plc_nr_id_taxa_cartao() {
    return   get(CONF_PLC_NR_ID_TAXA_CARTAO)==null?0: ((Integer)get(CONF_PLC_NR_ID_TAXA_CARTAO)).intValue();
  }

  public void setConf_plc_nr_id_taxa_cartao(int conf_plc_nr_id_taxa_cartao) {
    set(CONF_PLC_NR_ID_TAXA_CARTAO, conf_plc_nr_id_taxa_cartao);
  }

  public String getConf_tx_lancamento_auto_taxa_cartao() {
    return   get(CONF_TX_LANCAMENTO_AUTO_TAXA_CARTAO)==null?"": (String)get(CONF_TX_LANCAMENTO_AUTO_TAXA_CARTAO);
  }

  public void setConf_tx_lancamento_auto_taxa_cartao(String conf_tx_lancamento_auto_taxa_cartao) {
    set(CONF_TX_LANCAMENTO_AUTO_TAXA_CARTAO, conf_tx_lancamento_auto_taxa_cartao);
  }

  public int getConf_plc_nr_id_juros_consedido() {
    return   get(CONF_PLC_NR_ID_JUROS_CONSEDIDO)==null?0: ((Integer)get(CONF_PLC_NR_ID_JUROS_CONSEDIDO)).intValue();
  }

  public void setConf_plc_nr_id_juros_consedido(int conf_plc_nr_id_juros_consedido) {
    set(CONF_PLC_NR_ID_JUROS_CONSEDIDO, conf_plc_nr_id_juros_consedido);
  }

  public String getConf_tx_baixa_cartao_automatico() {
    return   get(CONF_TX_BAIXA_CARTAO_AUTOMATICO)==null?"": (String)get(CONF_TX_BAIXA_CARTAO_AUTOMATICO);
  }

  public void setConf_tx_baixa_cartao_automatico(String conf_tx_baixa_cartao_automatico) {
    set(CONF_TX_BAIXA_CARTAO_AUTOMATICO, conf_tx_baixa_cartao_automatico);
  }

  public int getConf_nr_id() {
    return   get(CONF_NR_ID)==null?0: ((Integer)get(CONF_NR_ID)).intValue();
  }

  public void setConf_nr_id(int conf_nr_id) {
    set(CONF_NR_ID, conf_nr_id);
  }

  public int getConf_plc_nr_id_default() {
    return   get(CONF_PLC_NR_ID_DEFAULT)==null?0: ((Integer)get(CONF_PLC_NR_ID_DEFAULT)).intValue();
  }

  public void setConf_plc_nr_id_default(int conf_plc_nr_id_default) {
    set(CONF_PLC_NR_ID_DEFAULT, conf_plc_nr_id_default);
  }

  public int getConf_plc_nr_id_caixa() {
    return   get(CONF_PLC_NR_ID_CAIXA)==null?0: ((Integer)get(CONF_PLC_NR_ID_CAIXA)).intValue();
  }

  public void setConf_plc_nr_id_caixa(int conf_plc_nr_id_caixa) {
    set(CONF_PLC_NR_ID_CAIXA, conf_plc_nr_id_caixa);
  }

  public String getConf_tx_lan_auto_conta_vinc_ctr() {
    return   get(CONF_TX_LAN_AUTO_CONTA_VINC_CTR)==null?"": (String)get(CONF_TX_LAN_AUTO_CONTA_VINC_CTR);
  }

  public void setConf_tx_lan_auto_conta_vinc_ctr(String conf_tx_lan_auto_conta_vinc_ctr) {
    set(CONF_TX_LAN_AUTO_CONTA_VINC_CTR, conf_tx_lan_auto_conta_vinc_ctr);
  }

  public String getConf_tx_lan_auto_conta_vinc_ctp() {
    return   get(CONF_TX_LAN_AUTO_CONTA_VINC_CTP)==null?"": (String)get(CONF_TX_LAN_AUTO_CONTA_VINC_CTP);
  }

  public void setConf_tx_lan_auto_conta_vinc_ctp(String conf_tx_lan_auto_conta_vinc_ctp) {
    set(CONF_TX_LAN_AUTO_CONTA_VINC_CTP, conf_tx_lan_auto_conta_vinc_ctp);
  }



}

