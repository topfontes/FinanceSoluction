package br.com.i9.finance.server.relatorios.v_conta_receber_pago_conta;

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
public class V_conta_receber_pago_contaReport extends RelatorioBase {

    private V_conta_receber_pago_contaT v_conta_receber_pago_contaT = new V_conta_receber_pago_contaT();

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

            V_conta_receber_pago_contaBL v_conta_receber_pago_contaBL = new V_conta_receber_pago_contaBL();
            List<V_conta_receber_pago_contaT> list = v_conta_receber_pago_contaBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetV_conta_receber_pago_conta = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listV_conta_receber_pago_conta"
            getParameters().put("listV_conta_receber_pago_conta", dataSetV_conta_receber_pago_conta);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = V_conta_receber_pago_contaReport.class.getResource("V_conta_receber_pago_conta.jasper");
            } else {
                is = V_conta_receber_pago_contaReport.class.getResourceAsStream("V_conta_receber_pago_conta.jasper");
            }

            defineParametros();
            print("V_conta_receber_pago_conta", "Relacao de V_conta_receber_pago_conta");


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

    public void setV_conta_receber_pago_contaT(V_conta_receber_pago_contaT v_conta_receber_pago_contaT) {
    	this.v_conta_receber_pago_contaT = v_conta_receber_pago_contaT;  
    }

    public V_conta_receber_pago_contaT getV_conta_receber_pago_contaT() {
    	return v_conta_receber_pago_contaT;  
    }

}
