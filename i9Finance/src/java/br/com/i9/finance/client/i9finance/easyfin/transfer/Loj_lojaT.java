
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
public class Loj_lojaT extends BaseModel {
  public static final String LOJ_TX_RAZAO_SOCIAL = "loj_tx_razao_social";
  public static final String LOJ_TX_MATRIZ = "loj_tx_matriz";
  public static final String LOJ_TX_NOME_FANTASIA = "loj_tx_nome_fantasia";
  public static final String LOJ_TX_CIDADE = "loj_tx_cidade";
  public static final String LOJ_TX_STATUS = "loj_tx_status";
  public static final String LOJ_TX_CNPJ = "loj_tx_cnpj";
  public static final String LOJ_TX_INSCRICAO = "loj_tx_inscricao";
  public static final String LOJ_TX_ESTADO = "loj_tx_estado";
  public static final String LOJ_TX_BAIRRO = "loj_tx_bairro";
  public static final String LOJ_TX_CEP = "loj_tx_cep";
  public static final String LOJ_TX_ENDERECO = "loj_tx_endereco";
  public static final String LOJ_TX_EMAIL = "loj_tx_email";
  public static final String LOJ_TX_HOME_PAGE = "loj_tx_home_page";
  public static final String LOJ_NR_ID = "loj_nr_id";

  public Loj_lojaT() {
  }

  public String getLoj_tx_razao_social() {
    return   get(LOJ_TX_RAZAO_SOCIAL)==null?"": (String)get(LOJ_TX_RAZAO_SOCIAL);
  }

  public void setLoj_tx_razao_social(String loj_tx_razao_social) {
    set(LOJ_TX_RAZAO_SOCIAL, loj_tx_razao_social);
  }

  public String getLoj_tx_matriz() {
    return   get(LOJ_TX_MATRIZ)==null?"": (String)get(LOJ_TX_MATRIZ);
  }

  public void setLoj_tx_matriz(String loj_tx_matriz) {
    set(LOJ_TX_MATRIZ, loj_tx_matriz);
  }

  public String getLoj_tx_nome_fantasia() {
    return   get(LOJ_TX_NOME_FANTASIA)==null?"": (String)get(LOJ_TX_NOME_FANTASIA);
  }

  public void setLoj_tx_nome_fantasia(String loj_tx_nome_fantasia) {
    set(LOJ_TX_NOME_FANTASIA, loj_tx_nome_fantasia);
  }

  public String getLoj_tx_cidade() {
    return   get(LOJ_TX_CIDADE)==null?"": (String)get(LOJ_TX_CIDADE);
  }

  public void setLoj_tx_cidade(String loj_tx_cidade) {
    set(LOJ_TX_CIDADE, loj_tx_cidade);
  }

  public String getLoj_tx_status() {
    return   get(LOJ_TX_STATUS)==null?"": (String)get(LOJ_TX_STATUS);
  }

  public void setLoj_tx_status(String loj_tx_status) {
    set(LOJ_TX_STATUS, loj_tx_status);
  }

  public String getLoj_tx_cnpj() {
    return   get(LOJ_TX_CNPJ)==null?"": (String)get(LOJ_TX_CNPJ);
  }

  public void setLoj_tx_cnpj(String loj_tx_cnpj) {
    set(LOJ_TX_CNPJ, loj_tx_cnpj);
  }

  public String getLoj_tx_inscricao() {
    return   get(LOJ_TX_INSCRICAO)==null?"": (String)get(LOJ_TX_INSCRICAO);
  }

  public void setLoj_tx_inscricao(String loj_tx_inscricao) {
    set(LOJ_TX_INSCRICAO, loj_tx_inscricao);
  }

  public String getLoj_tx_estado() {
    return   get(LOJ_TX_ESTADO)==null?"": (String)get(LOJ_TX_ESTADO);
  }

  public void setLoj_tx_estado(String loj_tx_estado) {
    set(LOJ_TX_ESTADO, loj_tx_estado);
  }

  public String getLoj_tx_bairro() {
    return   get(LOJ_TX_BAIRRO)==null?"": (String)get(LOJ_TX_BAIRRO);
  }

  public void setLoj_tx_bairro(String loj_tx_bairro) {
    set(LOJ_TX_BAIRRO, loj_tx_bairro);
  }

  public String getLoj_tx_cep() {
    return   get(LOJ_TX_CEP)==null?"": (String)get(LOJ_TX_CEP);
  }

  public void setLoj_tx_cep(String loj_tx_cep) {
    set(LOJ_TX_CEP, loj_tx_cep);
  }

  public String getLoj_tx_endereco() {
    return   get(LOJ_TX_ENDERECO)==null?"": (String)get(LOJ_TX_ENDERECO);
  }

  public void setLoj_tx_endereco(String loj_tx_endereco) {
    set(LOJ_TX_ENDERECO, loj_tx_endereco);
  }

  public String getLoj_tx_email() {
    return   get(LOJ_TX_EMAIL)==null?"": (String)get(LOJ_TX_EMAIL);
  }

  public void setLoj_tx_email(String loj_tx_email) {
    set(LOJ_TX_EMAIL, loj_tx_email);
  }

  public String getLoj_tx_home_page() {
    return   get(LOJ_TX_HOME_PAGE)==null?"": (String)get(LOJ_TX_HOME_PAGE);
  }

  public void setLoj_tx_home_page(String loj_tx_home_page) {
    set(LOJ_TX_HOME_PAGE, loj_tx_home_page);
  }

  public int getLoj_nr_id() {
    return   get(LOJ_NR_ID)==null?0: ((Integer)get(LOJ_NR_ID)).intValue();
  }

  public void setLoj_nr_id(int loj_nr_id) {
    set(LOJ_NR_ID, loj_nr_id);
  }



}

