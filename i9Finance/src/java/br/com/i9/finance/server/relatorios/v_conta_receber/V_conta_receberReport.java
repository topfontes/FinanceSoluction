package br.com.i9.finance.server.relatorios.v_conta_receber;

import br.com.i9.finance.server.bl.*;
import br.com.i9.finance.server.relatorios.RelatorioBase;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.relatorios.v_conta_pagar.V_contaPagarTemp;
import java.util.List;
import java.util.ArrayList;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;
/**
 *
 * @author i9ti
 */
public class V_conta_receberReport extends RelatorioBase {

    private V_conta_receberT v_conta_receberT = new V_conta_receberT();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    @Override	
    public void imprimir() {
        try {

            V_conta_receberBL v_conta_receberBL = new V_conta_receberBL();
            List<V_conta_receberT> list = v_conta_receberBL.consult(getDateFormat(getDtInicio()),getDateFormat(getDtFim()),getStatus());
            List<V_contaReceberTemp> listTemp = getListObjetoTemp(list);
            jRDataSource = new JRBeanCollectionDataSource(listTemp);


            if (getTipo().equalsIgnoreCase("XLS")) {
                url = V_conta_receberReport.class.getResource("V_conta_receber.jasper");
            } else {
                is = V_conta_receberReport.class.getResourceAsStream("V_conta_receber.jasper");
            }

            defineParametros();
            print("V_conta_receber", "Relação de contas a receber");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<V_contaReceberTemp> getListObjetoTemp(List<V_conta_receberT> list) {
        List<V_contaReceberTemp> listTemp = new ArrayList<V_contaReceberTemp>();
        for (V_conta_receberT objT : list) {
            V_contaReceberTemp temp = new V_contaReceberTemp();
            temp.setBan_nr_id(objT.getBan_nr_id());
            temp.setCar_nr_id(objT.getCar_nr_id());
            temp.setCartao(objT.getCartao());
            temp.setDocumento(objT.getDocumento());
            temp.setDt_emissao(objT.getDt_emissao());
            temp.setDt_pagamento(objT.getDt_pagamento());
            temp.setForma(objT.getForma());
            temp.setNome(objT.getNome());
            temp.setObs(objT.getObs());
            temp.setParcela(objT.getParcela());
            temp.setSaldo(objT.getSaldo());
            temp.setValor(objT.getValor());
            temp.setVencimento(objT.getVencimento());
            temp.setVl_pago(objT.getVl_pago());
            listTemp.add(temp);
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

    public void setV_conta_receberT(V_conta_receberT v_conta_receberT) {
    	this.v_conta_receberT = v_conta_receberT;  
    }

    public V_conta_receberT getV_conta_receberT() {
    	return v_conta_receberT;  
    }

}
