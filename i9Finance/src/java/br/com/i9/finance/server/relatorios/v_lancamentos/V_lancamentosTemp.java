/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.server.relatorios.v_lancamentos;

import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.Date;

/**
 *br.com.i9.finance.server.relatorios.v_lancamentos.V_lancamentosTemp;
 * @author marcos
 */
public class V_lancamentosTemp {
  private Date lan_dt_lancamento;
  private String lan_tx_historico;
  private double lan_valor;
  private String plc_tx_credito;
  private String plc_tx_debito;
  private String plc_tx_super;

    /**
     * @return the lan_dt_lancamento
     */
    public Date getLan_dt_lancamento() {
        return lan_dt_lancamento;
    }

    /**
     * @param lan_dt_lancamento the lan_dt_lancamento to set
     */
    public void setLan_dt_lancamento(Date lan_dt_lancamento) {
        this.lan_dt_lancamento = lan_dt_lancamento;
    }

    /**
     * @return the lan_tx_historico
     */
    public String getLan_tx_historico() {
        return lan_tx_historico;
    }

    /**
     * @param lan_tx_historico the lan_tx_historico to set
     */
    public void setLan_tx_historico(String lan_tx_historico) {
        this.lan_tx_historico = lan_tx_historico;
    }

    /**
     * @return the lan_valor
     */
    public double getLan_valor() {
        return lan_valor;
    }

    /**
     * @param lan_valor the lan_valor to set
     */
    public void setLan_valor(double lan_valor) {
        this.lan_valor = lan_valor;
    }

    /**
     * @return the plc_tx_credito
     */
    public String getPlc_tx_credito() {
        return plc_tx_credito;
    }

    /**
     * @param plc_tx_credito the plc_tx_credito to set
     */
    public void setPlc_tx_credito(String plc_tx_credito) {
        this.plc_tx_credito = plc_tx_credito;
    }

    /**
     * @return the plc_tx_debito
     */
    public String getPlc_tx_debito() {
        return plc_tx_debito;
    }

    /**
     * @param plc_tx_debito the plc_tx_debito to set
     */
    public void setPlc_tx_debito(String plc_tx_debito) {
        this.plc_tx_debito = plc_tx_debito;
    }

    /**
     * @return the plc_tx_super
     */
    public String getPlc_tx_super() {
        return plc_tx_super;
    }

    /**
     * @param plc_tx_super the plc_tx_super to set
     */
    public void setPlc_tx_super(String plc_tx_super) {
        this.plc_tx_super = plc_tx_super;
    }
  
  
  
  
}