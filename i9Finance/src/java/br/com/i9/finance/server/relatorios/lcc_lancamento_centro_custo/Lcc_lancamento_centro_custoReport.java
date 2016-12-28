package br.com.i9.finance.server.relatorios.lcc_lancamento_centro_custo;

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
public class Lcc_lancamento_centro_custoReport extends RelatorioBase {

    private Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT = new Lcc_lancamento_centro_custoT();

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

            Lcc_lancamento_centro_custoBL lcc_lancamento_centro_custoBL = new Lcc_lancamento_centro_custoBL();
            List<Lcc_lancamento_centro_custoT> list = lcc_lancamento_centro_custoBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetLcc_lancamento_centro_custo = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listLcc_lancamento_centro_custo"
            getParameters().put("listLcc_lancamento_centro_custo", dataSetLcc_lancamento_centro_custo);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Lcc_lancamento_centro_custoReport.class.getResource("Lcc_lancamento_centro_custo.jasper");
            } else {
                is = Lcc_lancamento_centro_custoReport.class.getResourceAsStream("Lcc_lancamento_centro_custo.jasper");
            }

            defineParametros();
            print("Lcc_lancamento_centro_custo", "Relacao de Lcc_lancamento_centro_custo");


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

    public void setLcc_lancamento_centro_custoT(Lcc_lancamento_centro_custoT lcc_lancamento_centro_custoT) {
    	this.lcc_lancamento_centro_custoT = lcc_lancamento_centro_custoT;  
    }

    public Lcc_lancamento_centro_custoT getLcc_lancamento_centro_custoT() {
    	return lcc_lancamento_centro_custoT;  
    }

}
