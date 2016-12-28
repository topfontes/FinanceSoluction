package br.com.i9.finance.server.relatorios.cen_centro_custo;

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
public class Cen_centro_custoReport extends RelatorioBase {

    private Cen_centro_custoT cen_centro_custoT = new Cen_centro_custoT();

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

            Cen_centro_custoBL cen_centro_custoBL = new Cen_centro_custoBL();
            List<Cen_centro_custoT> list = cen_centro_custoBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetCen_centro_custo = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listCen_centro_custo"
            getParameters().put("listCen_centro_custo", dataSetCen_centro_custo);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Cen_centro_custoReport.class.getResource("Cen_centro_custo.jasper");
            } else {
                is = Cen_centro_custoReport.class.getResourceAsStream("Cen_centro_custo.jasper");
            }

            defineParametros();
            print("Cen_centro_custo", "Relacao de Cen_centro_custo");


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

    public void setCen_centro_custoT(Cen_centro_custoT cen_centro_custoT) {
    	this.cen_centro_custoT = cen_centro_custoT;  
    }

    public Cen_centro_custoT getCen_centro_custoT() {
    	return cen_centro_custoT;  
    }

}
