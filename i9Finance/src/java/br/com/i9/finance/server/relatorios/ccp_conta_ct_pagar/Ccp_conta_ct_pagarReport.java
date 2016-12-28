package br.com.i9.finance.server.relatorios.ccp_conta_ct_pagar;

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
public class Ccp_conta_ct_pagarReport extends RelatorioBase {

    private Ccp_conta_ct_pagarT ccp_conta_ct_pagarT = new Ccp_conta_ct_pagarT();

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

            Ccp_conta_ct_pagarBL ccp_conta_ct_pagarBL = new Ccp_conta_ct_pagarBL();
            List<Ccp_conta_ct_pagarT> list = ccp_conta_ct_pagarBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetCcp_conta_ct_pagar = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listCcp_conta_ct_pagar"
            getParameters().put("listCcp_conta_ct_pagar", dataSetCcp_conta_ct_pagar);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Ccp_conta_ct_pagarReport.class.getResource("Ccp_conta_ct_pagar.jasper");
            } else {
                is = Ccp_conta_ct_pagarReport.class.getResourceAsStream("Ccp_conta_ct_pagar.jasper");
            }

            defineParametros();
            print("Ccp_conta_ct_pagar", "Relacao de Ccp_conta_ct_pagar");


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

    public void setCcp_conta_ct_pagarT(Ccp_conta_ct_pagarT ccp_conta_ct_pagarT) {
    	this.ccp_conta_ct_pagarT = ccp_conta_ct_pagarT;  
    }

    public Ccp_conta_ct_pagarT getCcp_conta_ct_pagarT() {
    	return ccp_conta_ct_pagarT;  
    }

}
