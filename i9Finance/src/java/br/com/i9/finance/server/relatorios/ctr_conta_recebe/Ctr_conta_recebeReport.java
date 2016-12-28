package br.com.i9.finance.server.relatorios.ctr_conta_recebe;

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
public class Ctr_conta_recebeReport extends RelatorioBase {

    private Ctr_conta_recebeT ctr_conta_recebeT = new Ctr_conta_recebeT();

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

            Ctr_conta_recebeBL ctr_conta_recebeBL = new Ctr_conta_recebeBL();
            List<Ctr_conta_recebeT> list = ctr_conta_recebeBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetCtr_conta_recebe = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listCtr_conta_recebe"
            getParameters().put("listCtr_conta_recebe", dataSetCtr_conta_recebe);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Ctr_conta_recebeReport.class.getResource("Ctr_conta_recebe.jasper");
            } else {
                is = Ctr_conta_recebeReport.class.getResourceAsStream("Ctr_conta_recebe.jasper");
            }

            defineParametros();
            print("Ctr_conta_recebe", "Relacao de Ctr_conta_recebe");


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

    public void setCtr_conta_recebeT(Ctr_conta_recebeT ctr_conta_recebeT) {
    	this.ctr_conta_recebeT = ctr_conta_recebeT;  
    }

    public Ctr_conta_recebeT getCtr_conta_recebeT() {
    	return ctr_conta_recebeT;  
    }

}
