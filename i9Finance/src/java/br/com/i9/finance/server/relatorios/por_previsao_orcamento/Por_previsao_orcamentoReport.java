package br.com.i9.finance.server.relatorios.por_previsao_orcamento;

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
public class Por_previsao_orcamentoReport extends RelatorioBase {

    private Por_previsao_orcamentoT por_previsao_orcamentoT = new Por_previsao_orcamentoT();

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

            Por_previsao_orcamentoBL por_previsao_orcamentoBL = new Por_previsao_orcamentoBL();
            List<Por_previsao_orcamentoT> list = por_previsao_orcamentoBL.consult(0,usu_usuarioT);
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetPor_previsao_orcamento = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listPor_previsao_orcamento"
            getParameters().put("listPor_previsao_orcamento", dataSetPor_previsao_orcamento);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Por_previsao_orcamentoReport.class.getResource("Por_previsao_orcamento.jasper");
            } else {
                is = Por_previsao_orcamentoReport.class.getResourceAsStream("Por_previsao_orcamento.jasper");
            }

            defineParametros();
            print("Por_previsao_orcamento", "Relacao de Por_previsao_orcamento");


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

    public void setPor_previsao_orcamentoT(Por_previsao_orcamentoT por_previsao_orcamentoT) {
    	this.por_previsao_orcamentoT = por_previsao_orcamentoT;  
    }

    public Por_previsao_orcamentoT getPor_previsao_orcamentoT() {
    	return por_previsao_orcamentoT;  
    }

}
