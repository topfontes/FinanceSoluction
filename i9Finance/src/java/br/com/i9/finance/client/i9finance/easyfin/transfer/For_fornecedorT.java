
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
public class For_fornecedorT extends BaseModel {
  public static final String FOR_NR_ID = "for_nr_id";
  public static final String FOR_TX_ENDERECO = "for_tx_endereco";
  public static final String FOR_TX_HOME_PAGE = "for_tx_home_page";
  public static final String FOR_TX_CONTATO = "for_tx_contato";
  public static final String FOR_TX_CPF_CNPJ = "for_tx_cpf_cnpj";
  public static final String FOR_TX_EMAIL = "for_tx_email";
  public static final String FOR_TX_RG_INSCRICAO = "for_tx_rg_inscricao";
  public static final String FOR_TX_CEP = "for_tx_cep";
  public static final String FOR_TX_CIDADE = "for_tx_cidade";
  public static final String FOR_TX_ESTADO = "for_tx_estado";
  public static final String FOR_TX_BAIRRO = "for_tx_bairro";
  public static final String FOR_TX_NOME = "for_tx_nome";
  public static final String FOR_TX_STATUS = "for_tx_status";
  public static final String LOJ_NR_ID = "loj_nr_id";

  public For_fornecedorT() {
  }

  public int getFor_nr_id() {
    return   get(FOR_NR_ID)==null?0: ((Integer)get(FOR_NR_ID)).intValue();
  }

  public void setFor_nr_id(int for_nr_id) {
    set(FOR_NR_ID, for_nr_id);
  }

  public String getFor_tx_endereco() {
    return   get(FOR_TX_ENDERECO)==null?"": (String)get(FOR_TX_ENDERECO);
  }

  public void setFor_tx_endereco(String for_tx_endereco) {
    set(FOR_TX_ENDERECO, for_tx_endereco);
  }

  public String getFor_tx_home_page() {
    return   get(FOR_TX_HOME_PAGE)==null?"": (String)get(FOR_TX_HOME_PAGE);
  }

  public void setFor_tx_home_page(String for_tx_home_page) {
    set(FOR_TX_HOME_PAGE, for_tx_home_page);
  }

  public String getFor_tx_contato() {
    return   get(FOR_TX_CONTATO)==null?"": (String)get(FOR_TX_CONTATO);
  }

  public void setFor_tx_contato(String for_tx_contato) {
    set(FOR_TX_CONTATO, for_tx_contato);
  }

  public String getFor_tx_cpf_cnpj() {
    return   get(FOR_TX_CPF_CNPJ)==null?"": (String)get(FOR_TX_CPF_CNPJ);
  }

  public void setFor_tx_cpf_cnpj(String for_tx_cpf_cnpj) {
    set(FOR_TX_CPF_CNPJ, for_tx_cpf_cnpj);
  }

  public String getFor_tx_email() {
    return   get(FOR_TX_EMAIL)==null?"": (String)get(FOR_TX_EMAIL);
  }

  public void setFor_tx_email(String for_tx_email) {
    set(FOR_TX_EMAIL, for_tx_email);
  }

  public String getFor_tx_rg_inscricao() {
    return   get(FOR_TX_RG_INSCRICAO)==null?"": (String)get(FOR_TX_RG_INSCRICAO);
  }

  public void setFor_tx_rg_inscricao(String for_tx_rg_inscricao) {
    set(FOR_TX_RG_INSCRICAO, for_tx_rg_inscricao);
  }

  public int getFor_tx_cep() {
    return   get(FOR_TX_CEP)==null?0: ((Integer)get(FOR_TX_CEP)).intValue();
  }

  public void setFor_tx_cep(int for_tx_cep) {
    set(FOR_TX_CEP, for_tx_cep);
  }

  public String getFor_tx_cidade() {
    return   get(FOR_TX_CIDADE)==null?"": (String)get(FOR_TX_CIDADE);
  }

  public void setFor_tx_cidade(String for_tx_cidade) {
    set(FOR_TX_CIDADE, for_tx_cidade);
  }

  public String getFor_tx_estado() {
    return   get(FOR_TX_ESTADO)==null?"": (String)get(FOR_TX_ESTADO);
  }

  public void setFor_tx_estado(String for_tx_estado) {
    set(FOR_TX_ESTADO, for_tx_estado);
  }

  public String getFor_tx_bairro() {
    return   get(FOR_TX_BAIRRO)==null?"": (String)get(FOR_TX_BAIRRO);
  }

  public void setFor_tx_bairro(String for_tx_bairro) {
    set(FOR_TX_BAIRRO, for_tx_bairro);
  }

  public String getFor_tx_nome() {
    return   get(FOR_TX_NOME)==null?"": (String)get(FOR_TX_NOME);
  }

  public void setFor_tx_nome(String for_tx_nome) {
    set(FOR_TX_NOME, for_tx_nome);
  }

  public String getFor_tx_status() {
    return   get(FOR_TX_STATUS)==null?"": (String)get(FOR_TX_STATUS);
  }

  public void setFor_tx_status(String for_tx_status) {
    set(FOR_TX_STATUS, for_tx_status);
  }

  public int getLoj_nr_id() {
    return   get(LOJ_NR_ID)==null?0: ((Integer)get(LOJ_NR_ID)).intValue();
  }

  public void setLoj_nr_id(int loj_nr_id) {
    set(LOJ_NR_ID, loj_nr_id);
  }



}

