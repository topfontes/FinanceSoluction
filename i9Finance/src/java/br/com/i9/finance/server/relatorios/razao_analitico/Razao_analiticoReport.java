/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.server.relatorios.razao_analitico;

import br.com.i9.finance.client.i9finance.easyfin.transfer.Por_previsao_orcamentoT;
import br.com.i9.finance.client.i9finance.easyfin.transfer.RazaoAnaliticoTemp;
import br.com.i9.finance.client.i9finance.easyfin.transfer.V_lancamentosT;
import br.com.i9.finance.server.relatorios.RelatorioBase;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Razao_analiticoReport extends RelatorioBase {

    private Por_previsao_orcamentoT por_previsao_orcamentoT = new Por_previsao_orcamentoT();
    private int plc_nr_id;
    private double saldo_atual;
    private String conta;
    private String periodo;
    double saldoDeb = 0;
    double saldoCred = 0;
    private String orderby;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    @Override
    public void imprimir() {
        try {
            List<V_lancamentosT> list = new ArrayList<V_lancamentosT>();
            if (getStatus().equalsIgnoreCase("T")) {
                list = systemBase.getV_lancamentosDAO().getAll(systemBase.convertDateForSql(getDateFormat(getDtInicio())), systemBase.convertDateForSql(getDateFormat(getDtFim())), getPlc_nr_id(), systemBase.getIdLojaUsuarioLogado(usu_usuarioT),orderby);
            } else if (getStatus().equalsIgnoreCase("S")) {
                list = systemBase.getV_lancamentosDAO().getByLan_plc_nr_id_cred(systemBase.convertDateForSql(getDateFormat(getDtInicio())), systemBase.convertDateForSql(getDateFormat(getDtFim())), getPlc_nr_id(), systemBase.getIdLojaUsuarioLogado(usu_usuarioT),orderby);
            } else if (getStatus().equalsIgnoreCase("E")) {
                list = systemBase.getV_lancamentosDAO().getByLan_plc_nr_id_deb(systemBase.convertDateForSql(getDateFormat(getDtInicio())), systemBase.convertDateForSql(getDateFormat(getDtFim())), getPlc_nr_id(), systemBase.getIdLojaUsuarioLogado(usu_usuarioT),orderby);
            }
            systemBase.close();

            jRDataSource = new JRBeanCollectionDataSource(getListRazao(list));

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Razao_analiticoReport.class.getResource("razao_analitico.jasper");
            } else {
                is = Razao_analiticoReport.class.getResourceAsStream("razao_analitico.jasper");
            }

            defineParametros();
            print("razao_analitico", "Razão Analítico");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<RazaoAnaliticoTemp> getListRazao(List<V_lancamentosT> lst) throws Exception {

        saldoDeb = systemBase.getLan_lancamentoDAO().getBySaldoAnteriorDeb(systemBase.convertDateForSql(getDateFormat(getDtInicio())), getPlc_nr_id());
        systemBase.close();
        saldoCred = systemBase.getLan_lancamentoDAO().getBySaldoAnteriorCred(systemBase.convertDateForSql(getDateFormat(getDtInicio())), getPlc_nr_id());
        systemBase.close();
        saldo_atual = saldoDeb - saldoCred;

        List<RazaoAnaliticoTemp> listTemp = new ArrayList<RazaoAnaliticoTemp>();
        for (V_lancamentosT lanT : lst) {
//            System.out.println("PLC " + plc_nr_id);
//            System.out.println("plc deb " + lanT.getLan_plc_nr_id_deb() + " - plc_cred" + lanT.getLan_plc_nr_id_cred());
            RazaoAnaliticoTemp razaoAnaliticoTemp = new RazaoAnaliticoTemp();
            razaoAnaliticoTemp.setData(lanT.getLan_dt_lancamento());
            if (getPlc_nr_id() == lanT.getLan_plc_nr_id_cred()) {
                razaoAnaliticoTemp.setConta(lanT.getPlc_tx_debito());
                razaoAnaliticoTemp.setVl_saida(lanT.getLan_valor());
                saldo_atual -= lanT.getLan_valor();
                conta = lanT.getPlc_tx_credito();
            } else {
                razaoAnaliticoTemp.setConta(lanT.getPlc_tx_credito());
                razaoAnaliticoTemp.setVl_entrada(lanT.getLan_valor());
                saldo_atual += lanT.getLan_valor();
                conta = lanT.getPlc_tx_debito();
            }
            razaoAnaliticoTemp.setObs(lanT.getLan_tx_historico());
            listTemp.add(razaoAnaliticoTemp);
        }

        return listTemp;
    }

    public void defineParametros() {
        try {
            getParameters().put("saldo_anterior", saldoDeb - saldoCred);
            getParameters().put("periodo", "Período de " + getDtInicio() + " a " + getDtFim());
            getParameters().put("conta", conta);
            getParameters().put("saldo_atual", saldo_atual);
            //TODO: Parametros para o relatorio
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPor_previsao_orcamentoT(Por_previsao_orcamentoT por_previsao_orcamentoT) {
        this.por_previsao_orcamentoT = por_previsao_orcamentoT;
    }

    public Por_previsao_orcamentoT getPor_previsao_orcamentoT() {
        return por_previsao_orcamentoT;
    }

    /**
     * @return the plc_nr_id
     */
    public int getPlc_nr_id() {
        return plc_nr_id;
    }

    /**
     * @param plc_nr_id the plc_nr_id to set
     */
    public void setPlc_nr_id(int plc_nr_id) {
        this.plc_nr_id = plc_nr_id;
    }

    /**
     * @return the orderby
     */
    public String getOrderby() {
        return orderby;
    }

    /**
     * @param orderby the orderby to set
     */
    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }
}
