
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
public class Cli_clienteT extends BaseModel {
  public static final String CLI_NR_ID = "cli_nr_id";
  public static final String CLI_TX_NOME = "cli_tx_nome";
  public static final String CLI_TX_ENDERECO = "cli_tx_endereco";
  public static final String CLI_TX_BAIRRO = "cli_tx_bairro";
  public static final String CLI_TX_RG_INSCRICAO = "cli_tx_rg_inscricao";
  public static final String CLI_TX_CIDADE = "cli_tx_cidade";
  public static final String CLI_TX_ESTADO = "cli_tx_estado";
  public static final String CLI_TX_CEP = "cli_tx_cep";
  public static final String CLI_TX_CPF_CNPJ = "cli_tx_cpf_cnpj";
  public static final String CLI_TX_EMAIL = "cli_tx_email";
  public static final String CLI_TX_HOME_PAGE = "cli_tx_home_page";
  public static final String CLI_TX_CONTATO = "cli_tx_contato";
  public static final String CLI_TX_STATUS = "cli_tx_status";
  public static final String LOJ_NR_ID = "loj_nr_id";

  public Cli_clienteT() {
  }

  public int getCli_nr_id() {
    return   get(CLI_NR_ID)==null?0: ((Integer)get(CLI_NR_ID)).intValue();
  }

  public void setCli_nr_id(int cli_nr_id) {
    set(CLI_NR_ID, cli_nr_id);
  }

  public String getCli_tx_nome() {
    return   get(CLI_TX_NOME)==null?"": (String)get(CLI_TX_NOME);
  }

  public void setCli_tx_nome(String cli_tx_nome) {
    set(CLI_TX_NOME, cli_tx_nome);
  }

  public String getCli_tx_endereco() {
    return   get(CLI_TX_ENDERECO)==null?"": (String)get(CLI_TX_ENDERECO);
  }

  public void setCli_tx_endereco(String cli_tx_endereco) {
    set(CLI_TX_ENDERECO, cli_tx_endereco);
  }

  public String getCli_tx_bairro() {
    return   get(CLI_TX_BAIRRO)==null?"": (String)get(CLI_TX_BAIRRO);
  }

  public void setCli_tx_bairro(String cli_tx_bairro) {
    set(CLI_TX_BAIRRO, cli_tx_bairro);
  }

  public String getCli_tx_rg_inscricao() {
    return   get(CLI_TX_RG_INSCRICAO)==null?"": (String)get(CLI_TX_RG_INSCRICAO);
  }

  public void setCli_tx_rg_inscricao(String cli_tx_rg_inscricao) {
    set(CLI_TX_RG_INSCRICAO, cli_tx_rg_inscricao);
  }

  public String getCli_tx_cidade() {
    return   get(CLI_TX_CIDADE)==null?"": (String)get(CLI_TX_CIDADE);
  }

  public void setCli_tx_cidade(String cli_tx_cidade) {
    set(CLI_TX_CIDADE, cli_tx_cidade);
  }

  public String getCli_tx_estado() {
    return   get(CLI_TX_ESTADO)==null?"": (String)get(CLI_TX_ESTADO);
  }

  public void setCli_tx_estado(String cli_tx_estado) {
    set(CLI_TX_ESTADO, cli_tx_estado);
  }

  public int getCli_tx_cep() {
    return   get(CLI_TX_CEP)==null?0: ((Integer)get(CLI_TX_CEP)).intValue();
  }

  public void setCli_tx_cep(int cli_tx_cep) {
    set(CLI_TX_CEP, cli_tx_cep);
  }

  public String getCli_tx_cpf_cnpj() {
    return   get(CLI_TX_CPF_CNPJ)==null?"": (String)get(CLI_TX_CPF_CNPJ);
  }

  public void setCli_tx_cpf_cnpj(String cli_tx_cpf_cnpj) {
    set(CLI_TX_CPF_CNPJ, cli_tx_cpf_cnpj);
  }

  public String getCli_tx_email() {
    return   get(CLI_TX_EMAIL)==null?"": (String)get(CLI_TX_EMAIL);
  }

  public void setCli_tx_email(String cli_tx_email) {
    set(CLI_TX_EMAIL, cli_tx_email);
  }

  public String getCli_tx_home_page() {
    return   get(CLI_TX_HOME_PAGE)==null?"": (String)get(CLI_TX_HOME_PAGE);
  }

  public void setCli_tx_home_page(String cli_tx_home_page) {
    set(CLI_TX_HOME_PAGE, cli_tx_home_page);
  }

  public String getCli_tx_contato() {
    return   get(CLI_TX_CONTATO)==null?"": (String)get(CLI_TX_CONTATO);
  }

  public void setCli_tx_contato(String cli_tx_contato) {
    set(CLI_TX_CONTATO, cli_tx_contato);
  }

  public String getCli_tx_status() {
    return   get(CLI_TX_STATUS)==null?"": (String)get(CLI_TX_STATUS);
  }

  public void setCli_tx_status(String cli_tx_status) {
    set(CLI_TX_STATUS, cli_tx_status);
  }

  public int getLoj_nr_id() {
    return   get(LOJ_NR_ID)==null?0: ((Integer)get(LOJ_NR_ID)).intValue();
  }

  public void setLoj_nr_id(int loj_nr_id) {
    set(LOJ_NR_ID, loj_nr_id);
  }



}

