package br.com.i9.finance.server.relatorios.lan_lancamento;

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
public class Lan_lancamentoReport extends RelatorioBase {

    private Lan_lancamentoT lan_lancamentoT = new Lan_lancamentoT();

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

            Lan_lancamentoBL lan_lancamentoBL = new Lan_lancamentoBL();
            List<Lan_lancamentoT> list = lan_lancamentoBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetLan_lancamento = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listLan_lancamento"
            getParameters().put("listLan_lancamento", dataSetLan_lancamento);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Lan_lancamentoReport.class.getResource("Lan_lancamento.jasper");
            } else {
                is = Lan_lancamentoReport.class.getResourceAsStream("Lan_lancamento.jasper");
            }

            defineParametros();
            print("Lan_lancamento", "Relacao de Lan_lancamento");


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

    public void setLan_lancamentoT(Lan_lancamentoT lan_lancamentoT) {
    	this.lan_lancamentoT = lan_lancamentoT;  
    }

    public Lan_lancamentoT getLan_lancamentoT() {
    	return lan_lancamentoT;  
    }

}
