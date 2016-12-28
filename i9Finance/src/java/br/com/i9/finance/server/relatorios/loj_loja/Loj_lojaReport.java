package br.com.i9.finance.server.relatorios.loj_loja;

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
public class Loj_lojaReport extends RelatorioBase {

    private Loj_lojaT loj_lojaT = new Loj_lojaT();

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

            Loj_lojaBL loj_lojaBL = new Loj_lojaBL();
            List<Loj_lojaT> list = loj_lojaBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetLoj_loja = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listLoj_loja"
            getParameters().put("listLoj_loja", dataSetLoj_loja);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Loj_lojaReport.class.getResource("Loj_loja.jasper");
            } else {
                is = Loj_lojaReport.class.getResourceAsStream("Loj_loja.jasper");
            }

            defineParametros();
            print("Loj_loja", "Relacao de Loj_loja");


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

    public void setLoj_lojaT(Loj_lojaT loj_lojaT) {
    	this.loj_lojaT = loj_lojaT;  
    }

    public Loj_lojaT getLoj_lojaT() {
    	return loj_lojaT;  
    }

}
