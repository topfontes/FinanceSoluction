package br.com.i9.finance.server.relatorios.v_conta_pagar_pago;

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
public class V_conta_pagar_pagoReport extends RelatorioBase {

    private V_conta_pagar_pagoT v_conta_pagar_pagoT = new V_conta_pagar_pagoT();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    @Override	
    public void imprimir() {
        try {

            List<String> lisStr = new ArrayList<String>();
            lisStr.add("uma ocorrencia");

            jRDataSource = new JRBeanCollectionDataSource(lisStr);

            V_conta_pagar_pagoBL v_conta_pagar_pagoBL = new V_conta_pagar_pagoBL();
            List<V_conta_pagar_pagoT> list = v_conta_pagar_pagoBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetV_conta_pagar_pago = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listV_conta_pagar_pago"
            getParameters().put("listV_conta_pagar_pago", dataSetV_conta_pagar_pago);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = V_conta_pagar_pagoReport.class.getResource("V_conta_pagar_pago.jasper");
            } else {
                is = V_conta_pagar_pagoReport.class.getResourceAsStream("V_conta_pagar_pago.jasper");
            }

            defineParametros();
            print("V_conta_pagar_pago", "Relacao de V_conta_pagar_pago");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void defineParametros() {
        try {
	  //TODO: Parametros para o relatorio
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setV_conta_pagar_pagoT(V_conta_pagar_pagoT v_conta_pagar_pagoT) {
    	this.v_conta_pagar_pagoT = v_conta_pagar_pagoT;  
    }

    public V_conta_pagar_pagoT getV_conta_pagar_pagoT() {
    	return v_conta_pagar_pagoT;  
    }

}
