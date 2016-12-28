package br.com.i9.finance.server.relatorios.cucp_custo_conta_pagar;

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
public class Cucp_custo_conta_pagarReport extends RelatorioBase {

    private Cucp_custo_conta_pagarT cucp_custo_conta_pagarT = new Cucp_custo_conta_pagarT();

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

            Cucp_custo_conta_pagarBL cucp_custo_conta_pagarBL = new Cucp_custo_conta_pagarBL();
            List<Cucp_custo_conta_pagarT> list = cucp_custo_conta_pagarBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetCucp_custo_conta_pagar = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listCucp_custo_conta_pagar"
            getParameters().put("listCucp_custo_conta_pagar", dataSetCucp_custo_conta_pagar);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Cucp_custo_conta_pagarReport.class.getResource("Cucp_custo_conta_pagar.jasper");
            } else {
                is = Cucp_custo_conta_pagarReport.class.getResourceAsStream("Cucp_custo_conta_pagar.jasper");
            }

            defineParametros();
            print("Cucp_custo_conta_pagar", "Relacao de Cucp_custo_conta_pagar");


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

    public void setCucp_custo_conta_pagarT(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) {
    	this.cucp_custo_conta_pagarT = cucp_custo_conta_pagarT;  
    }

    public Cucp_custo_conta_pagarT getCucp_custo_conta_pagarT() {
    	return cucp_custo_conta_pagarT;  
    }

}
