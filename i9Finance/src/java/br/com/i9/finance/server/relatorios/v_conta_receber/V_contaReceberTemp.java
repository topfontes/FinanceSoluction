/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.server.relatorios.v_conta_receber;

import br.com.i9.finance.server.relatorios.v_conta_pagar.*;
import java.util.Date;

/**
 * br.com.i9.finance.server.relatorios.v_conta_pagar.V_contaReceberTemp
 * @author marcos
 */
public class V_contaReceberTemp {

    private Date dt_pagamento;
    private double valor;
    private int id_cli_fab;
    private String nome;
    private String forma;
    private int ban_nr_id;
    private String banco;
    private String pago;
    private String parcela;
    private int documento;
    private Date dt_emissao;
    private Date vencimento;
    private String obs;
    private int car_nr_id;
    private String cartao;
    private int loj_nr_id;
    private int ctp_nr_id;
    private double vl_pago;
    private double saldo;

    /**
     * @return the dt_pagamento
     */
    public Date getDt_pagamento() {
        return dt_pagamento;
    }

    /**
     * @param dt_pagamento the dt_pagamento to set
     */
    public void setDt_pagamento(Date dt_pagamento) {
        this.dt_pagamento = dt_pagamento;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the id_cli_fab
     */
    public int getId_cli_fab() {
        return id_cli_fab;
    }

    /**
     * @param id_cli_fab the id_cli_fab to set
     */
    public void setId_cli_fab(int id_cli_fab) {
        this.id_cli_fab = id_cli_fab;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the forma
     */
    public String getForma() {
        return forma;
    }

    /**
     * @param forma the forma to set
     */
    public void setForma(String forma) {
        this.forma = forma;
    }

    /**
     * @return the ban_nr_id
     */
    public int getBan_nr_id() {
        return ban_nr_id;
    }

    /**
     * @param ban_nr_id the ban_nr_id to set
     */
    public void setBan_nr_id(int ban_nr_id) {
        this.ban_nr_id = ban_nr_id;
    }

    /**
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the pago
     */
    public String getPago() {
        return pago;
    }

    /**
     * @param pago the pago to set
     */
    public void setPago(String pago) {
        this.pago = pago;
    }

    /**
     * @return the parcela
     */
    public String getParcela() {
        return parcela;
    }

    /**
     * @param parcela the parcela to set
     */
    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    /**
     * @return the documento
     */
    public int getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(int documento) {
        this.documento = documento;
    }

    /**
     * @return the dt_emissao
     */
    public Date getDt_emissao() {
        return dt_emissao;
    }

    /**
     * @param dt_emissao the dt_emissao to set
     */
    public void setDt_emissao(Date dt_emissao) {
        this.dt_emissao = dt_emissao;
    }

    /**
     * @return the vencimento
     */
    public Date getVencimento() {
        return vencimento;
    }

    /**
     * @param vencimento the vencimento to set
     */
    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @return the car_nr_id
     */
    public int getCar_nr_id() {
        return car_nr_id;
    }

    /**
     * @param car_nr_id the car_nr_id to set
     */
    public void setCar_nr_id(int car_nr_id) {
        this.car_nr_id = car_nr_id;
    }

    /**
     * @return the cartao
     */
    public String getCartao() {
        return cartao;
    }

    /**
     * @param cartao the cartao to set
     */
    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    /**
     * @return the loj_nr_id
     */
    public int getLoj_nr_id() {
        return loj_nr_id;
    }

    /**
     * @param loj_nr_id the loj_nr_id to set
     */
    public void setLoj_nr_id(int loj_nr_id) {
        this.loj_nr_id = loj_nr_id;
    }

    /**
     * @return the ctp_nr_id
     */
    public int getCtp_nr_id() {
        return ctp_nr_id;
    }

    /**
     * @param ctp_nr_id the ctp_nr_id to set
     */
    public void setCtp_nr_id(int ctp_nr_id) {
        this.ctp_nr_id = ctp_nr_id;
    }

    /**
     * @return the vl_pago
     */
    public double getVl_pago() {
        return vl_pago;
    }

    /**
     * @param vl_pago the vl_pago to set
     */
    public void setVl_pago(double vl_pago) {
        this.vl_pago = vl_pago;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
