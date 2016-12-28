package br.com.i9.finance.server.relatorios.ccr_conta_ct_receber;

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
public class Ccr_conta_ct_receberReport extends RelatorioBase {

    private Ccr_conta_ct_receberT ccr_conta_ct_receberT = new Ccr_conta_ct_receberT();

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

            Ccr_conta_ct_receberBL ccr_conta_ct_receberBL = new Ccr_conta_ct_receberBL();
            List<Ccr_conta_ct_receberT> list = ccr_conta_ct_receberBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetCcr_conta_ct_receber = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listCcr_conta_ct_receber"
            getParameters().put("listCcr_conta_ct_receber", dataSetCcr_conta_ct_receber);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Ccr_conta_ct_receberReport.class.getResource("Ccr_conta_ct_receber.jasper");
            } else {
                is = Ccr_conta_ct_receberReport.class.getResourceAsStream("Ccr_conta_ct_receber.jasper");
            }

            defineParametros();
            print("Ccr_conta_ct_receber", "Relacao de Ccr_conta_ct_receber");


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

    public void setCcr_conta_ct_receberT(Ccr_conta_ct_receberT ccr_conta_ct_receberT) {
    	this.ccr_conta_ct_receberT = ccr_conta_ct_receberT;  
    }

    public Ccr_conta_ct_receberT getCcr_conta_ct_receberT() {
    	return ccr_conta_ct_receberT;  
    }

}
