package br.com.i9.finance.server.relatorios.par_parcelamento;

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
public class Par_parcelamentoReport extends RelatorioBase {

    private Par_parcelamentoT par_parcelamentoT = new Par_parcelamentoT();

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

            Par_parcelamentoBL par_parcelamentoBL = new Par_parcelamentoBL();
            List<Par_parcelamentoT> list = par_parcelamentoBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetPar_parcelamento = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listPar_parcelamento"
            getParameters().put("listPar_parcelamento", dataSetPar_parcelamento);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Par_parcelamentoReport.class.getResource("Par_parcelamento.jasper");
            } else {
                is = Par_parcelamentoReport.class.getResourceAsStream("Par_parcelamento.jasper");
            }

            defineParametros();
            print("Par_parcelamento", "Relacao de Par_parcelamento");


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

    public void setPar_parcelamentoT(Par_parcelamentoT par_parcelamentoT) {
    	this.par_parcelamentoT = par_parcelamentoT;  
    }

    public Par_parcelamentoT getPar_parcelamentoT() {
    	return par_parcelamentoT;  
    }

}
