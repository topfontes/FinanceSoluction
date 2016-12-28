package br.com.i9.finance.server.relatorios.int_intervalo_parcelamento;

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
public class Int_intervalo_parcelamentoReport extends RelatorioBase {

    private Int_intervalo_parcelamentoT int_intervalo_parcelamentoT = new Int_intervalo_parcelamentoT();

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

            Int_intervalo_parcelamentoBL int_intervalo_parcelamentoBL = new Int_intervalo_parcelamentoBL();
            List<Int_intervalo_parcelamentoT> list = int_intervalo_parcelamentoBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetInt_intervalo_parcelamento = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listInt_intervalo_parcelamento"
            getParameters().put("listInt_intervalo_parcelamento", dataSetInt_intervalo_parcelamento);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Int_intervalo_parcelamentoReport.class.getResource("Int_intervalo_parcelamento.jasper");
            } else {
                is = Int_intervalo_parcelamentoReport.class.getResourceAsStream("Int_intervalo_parcelamento.jasper");
            }

            defineParametros();
            print("Int_intervalo_parcelamento", "Relacao de Int_intervalo_parcelamento");


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

    public void setInt_intervalo_parcelamentoT(Int_intervalo_parcelamentoT int_intervalo_parcelamentoT) {
    	this.int_intervalo_parcelamentoT = int_intervalo_parcelamentoT;  
    }

    public Int_intervalo_parcelamentoT getInt_intervalo_parcelamentoT() {
    	return int_intervalo_parcelamentoT;  
    }

}
