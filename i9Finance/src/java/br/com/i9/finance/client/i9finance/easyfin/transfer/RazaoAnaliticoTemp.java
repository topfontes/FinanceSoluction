/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.transfer;

import java.util.Date;

/**
 * br.com.i9.finance.client.i9finance.easyfin.transfer.RazaoAnaliticoTemp
 * @author marcos
 */
public class RazaoAnaliticoTemp {
    private Date data;
    private String conta;
    private String obs;
    private double vl_entrada;
    private double vl_saida;

    /**
     * @return the conta
     */
    public String getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(String conta) {
        this.conta = conta;
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
     * @return the vl_entrada
     */
    public double getVl_entrada() {
        return vl_entrada;
    }

    /**
     * @param vl_entrada the vl_entrada to set
     */
    public void setVl_entrada(double vl_entrada) {
        this.vl_entrada = vl_entrada;
    }

    /**
     * @return the vl_saida
     */
    public double getVl_saida() {
        return vl_saida;
    }

    /**
     * @param vl_saida the vl_saida to set
     */
    public void setVl_saida(double vl_saida) {
        this.vl_saida = vl_saida;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }
    
    
}
