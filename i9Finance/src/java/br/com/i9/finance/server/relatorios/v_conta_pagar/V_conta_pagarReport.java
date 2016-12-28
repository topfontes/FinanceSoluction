package br.com.i9.finance.server.relatorios.v_conta_pagar;

import br.com.i9.finance.server.bl.*;
import br.com.i9.finance.server.relatorios.RelatorioBase;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import java.util.List;
import java.util.ArrayList;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

/**
 *
 * @author i9ti
 */
public class V_conta_pagarReport extends RelatorioBase {

    private V_conta_pagarT v_conta_pagarT = new V_conta_pagarT();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    @Override
    public void imprimir() {
        try {

            V_conta_pagarBL v_conta_pagarBL = new V_conta_pagarBL();
            List<V_conta_pagarT> list = v_conta_pagarBL.consult(getDateFormat(getDtInicio()), getDateFormat(getDtFim()), getStatus());

            List<V_contaPagarTemp> listTemp = getListObjetoTemp(list);
            jRDataSource = new JRBeanCollectionDataSource(listTemp);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = V_conta_pagarReport.class.getResource("V_conta_pagar.jasper");
            } else {
                is = V_conta_pagarReport.class.getResourceAsStream("V_conta_pagar.jasper");
            }

            defineParametros();
            print("V_conta_pagar", "Relacao de V_conta_pagar");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<V_contaPagarTemp> getListObjetoTemp(List<V_conta_pagarT> list) {
        List<V_contaPagarTemp> listTemp = new ArrayList<V_contaPagarTemp>();
        for (V_conta_pagarT objT : list) {
            V_contaPagarTemp pagarTemp = new V_contaPagarTemp();
            pagarTemp.setBan_nr_id(objT.getBan_nr_id());
            pagarTemp.setBanco(objT.getBanco());
            pagarTemp.setCar_nr_id(objT.getCar_nr_id());
            pagarTemp.setCartao(objT.getCartao());
            pagarTemp.setDocumento(objT.getDocumento());
            pagarTemp.setDt_emissao(objT.getDt_emissao());
            pagarTemp.setDt_pagamento(objT.getDt_pagamento());
            pagarTemp.setForma(objT.getForma());
            pagarTemp.setNome(objT.getNome());
            pagarTemp.setObs(objT.getObs());
            pagarTemp.setParcela(objT.getParcela());
            pagarTemp.setSaldo(objT.getSaldo());
            pagarTemp.setValor(objT.getValor());
            pagarTemp.setVencimento(objT.getVencimento());
            pagarTemp.setVl_pago(objT.getVl_pago());
            listTemp.add(pagarTemp);
        }
        return listTemp;
    }

    public void defineParametros() {
        try {
            //TODO: Parametros para o relatorio
            getParameters().put("periodo","Período de "+getDtInicio()+" a "+getDtFim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setV_conta_pagarT(V_conta_pagarT v_conta_pagarT) {
        this.v_conta_pagarT = v_conta_pagarT;
    }

    public V_conta_pagarT getV_conta_pagarT() {
        return v_conta_pagarT;
    }

}
