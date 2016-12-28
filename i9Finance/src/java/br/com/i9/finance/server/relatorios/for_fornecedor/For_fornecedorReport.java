package br.com.i9.finance.server.relatorios.for_fornecedor;

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
public class For_fornecedorReport extends RelatorioBase {

    private For_fornecedorT for_fornecedorT = new For_fornecedorT();

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

            For_fornecedorBL for_fornecedorBL = new For_fornecedorBL();
            List<For_fornecedorT> list = for_fornecedorBL.consult(usu_usuarioT);
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetFor_fornecedor = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listFor_fornecedor"
            getParameters().put("listFor_fornecedor", dataSetFor_fornecedor);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = For_fornecedorReport.class.getResource("For_fornecedor.jasper");
            } else {
                is = For_fornecedorReport.class.getResourceAsStream("For_fornecedor.jasper");
            }

            defineParametros();
            print("For_fornecedor", "Relacao de For_fornecedor");


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

    public void setFor_fornecedorT(For_fornecedorT for_fornecedorT) {
    	this.for_fornecedorT = for_fornecedorT;  
    }

    public For_fornecedorT getFor_fornecedorT() {
    	return for_fornecedorT;  
    }

}
