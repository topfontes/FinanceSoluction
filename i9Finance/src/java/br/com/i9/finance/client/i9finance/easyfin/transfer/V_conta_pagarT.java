
/*
 * EasyNet JDragon
 */
package br.com.i9.finance.client.i9finance.easyfin.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.Date;

/**
 * br.com.i9.finance.client.i9finance.easyfin.transfer.RazaoAnaliticoTemp
 * br.com.i9.finance.client.i9finance.easyfin.transfer.V_conta_pagarT;
 * @author George Leite Junior
 */
public class V_conta_pagarT extends BaseModel {

    public static final String DT_PAGAMENTO = "dt_pagamento";
    public static final String VALOR = "valor";
    public static final String ID_CLI_FAB = "id_cli_fab";
    public static final String NOME = "nome";
    public static final String FOP_NR_ID = "fop_nr_id";
    public static final String FORMA = "forma";
    public static final String BAN_NR_ID = "ban_nr_id";
    public static final String BANCO = "banco";
    public static final String PAGO = "pago";
    public static final String PARCELA = "parcela";
    public static final String DOCUMENTO = "documento";
    public static final String DT_EMISSAO = "dt_emissao";
    public static final String VENCIMENTO = "vencimento";
    public static final String OBS = "obs";
    public static final String CAR_NR_ID = "car_nr_id";
    public static final String CARTAO = "cartao";
    public static final String LOJ_NR_ID = "loj_nr_id";
    public static final String CTP_NR_ID = "ctp_nr_id";
    public static final String VL_PAGO = "vl_pago";
    public static final String SALDO = "saldo";

    public V_conta_pagarT() {
    }

    public Date getDt_pagamento() {
        return (Date) get(DT_PAGAMENTO);
    }

    public void setDt_pagamento(Date dt_pagamento) {
        set(DT_PAGAMENTO, dt_pagamento);
    }

    public double getValor() {
        return get(VALOR) == null ? 0 : ((Double) get(VALOR)).doubleValue();
    }

    public void setValor(double valor) {
        set(VALOR, valor);
    }

    public int getId_cli_fab() {
        return get(ID_CLI_FAB) == null ? 0 : ((Integer) get(ID_CLI_FAB)).intValue();
    }

    public void setId_cli_fab(int id_cli_fab) {
        set(ID_CLI_FAB, id_cli_fab);
    }

    public String getNome() {
        return get(NOME) == null ? "" : (String) get(NOME);
    }

    public void setNome(String nome) {
        set(NOME, nome);
    }

    public int getFop_nr_id() {
        return get(FOP_NR_ID) == null ? 0 : ((Integer) get(FOP_NR_ID)).intValue();
    }

    public void setFop_nr_id(int fop_nr_id) {
        set(FOP_NR_ID, fop_nr_id);
    }

    public String getForma() {
        return get(FORMA) == null ? "" : (String) get(FORMA);
    }

    public void setForma(String forma) {
        set(FORMA, forma);
    }

    public int getBan_nr_id() {
        return get(BAN_NR_ID) == null ? 0 : ((Integer) get(BAN_NR_ID)).intValue();
    }

    public void setBan_nr_id(int ban_nr_id) {
        set(BAN_NR_ID, ban_nr_id);
    }

    public String getBanco() {
        return get(BANCO) == null ? "" : (String) get(BANCO);
    }

    public void setBanco(String banco) {
        set(BANCO, banco);
    }

    public String getPago() {
        return get(PAGO) == null ? "" : (String) get(PAGO);
    }

    public void setPago(String pago) {
        set(PAGO, pago);
    }

    public String getParcela() {
        return get(PARCELA) == null ? "" : (String) get(PARCELA);
    }

    public void setParcela(String parcela) {
        set(PARCELA, parcela);
    }

    public int getDocumento() {
        return get(DOCUMENTO) == null ? 0 : ((Integer) get(DOCUMENTO)).intValue();
    }

    public void setDocumento(int documento) {
        set(DOCUMENTO, documento);
    }

    public Date getDt_emissao() {
        return (Date) get(DT_EMISSAO);
    }

    public void setDt_emissao(Date dt_emissao) {
        set(DT_EMISSAO, dt_emissao);
    }

    public Date getVencimento() {
        return (Date) get(VENCIMENTO);
    }

    public void setVencimento(Date vencimento) {
        set(VENCIMENTO, vencimento);
    }

    public String getObs() {
        return get(OBS) == null ? "" : (String) get(OBS);
    }

    public void setObs(String obs) {
        set(OBS, obs);
    }

    public int getCar_nr_id() {
        return get(CAR_NR_ID) == null ? 0 : ((Integer) get(CAR_NR_ID)).intValue();
    }

    public void setCar_nr_id(int car_nr_id) {
        set(CAR_NR_ID, car_nr_id);
    }

    public String getCartao() {
        return get(CARTAO) == null ? "" : (String) get(CARTAO);
    }

    public void setCartao(String cartao) {
        set(CARTAO, cartao);
    }

    public int getLoj_nr_id() {
        return get(LOJ_NR_ID) == null ? 0 : ((Integer) get(LOJ_NR_ID)).intValue();
    }

    public void setLoj_nr_id(int loj_nr_id) {
        set(LOJ_NR_ID, loj_nr_id);
    }

    public int getCtp_nr_id() {
        return get(CTP_NR_ID) == null ? 0 : ((Integer) get(CTP_NR_ID)).intValue();
    }

    public void setCtp_nr_id(int loj_nr_id) {
        set(CTP_NR_ID, loj_nr_id);
    }


    public double getVl_pago() {
        return get(VL_PAGO) == null ? 0 : ((Double) get(VL_PAGO)).doubleValue();
    }

    public void setVl_pago(double vl_pago) {
        set(VL_PAGO, vl_pago);
    }    
    
    public double getSaldo() {
        return get(SALDO) == null ? 0 : ((Double) get(SALDO)).doubleValue();
    }

    public void setSaldo(double saldo) {
        set(SALDO, saldo);
    }     
}
