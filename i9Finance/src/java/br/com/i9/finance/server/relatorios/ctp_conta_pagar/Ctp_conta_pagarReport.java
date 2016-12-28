package br.com.i9.finance.server.relatorios.ctp_conta_pagar;

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
public class Ctp_conta_pagarReport extends RelatorioBase {

    private Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();

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

            Ctp_conta_pagarBL ctp_conta_pagarBL = new Ctp_conta_pagarBL();
            List<Ctp_conta_pagarT> list = ctp_conta_pagarBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetCtp_conta_pagar = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listCtp_conta_pagar"
            getParameters().put("listCtp_conta_pagar", dataSetCtp_conta_pagar);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Ctp_conta_pagarReport.class.getResource("Ctp_conta_pagar.jasper");
            } else {
                is = Ctp_conta_pagarReport.class.getResourceAsStream("Ctp_conta_pagar.jasper");
            }

            defineParametros();
            print("Ctp_conta_pagar", "Relacao de Ctp_conta_pagar");


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

    public void setCtp_conta_pagarT(Ctp_conta_pagarT ctp_conta_pagarT) {
    	this.ctp_conta_pagarT = ctp_conta_pagarT;  
    }

    public Ctp_conta_pagarT getCtp_conta_pagarT() {
    	return ctp_conta_pagarT;  
    }

}
