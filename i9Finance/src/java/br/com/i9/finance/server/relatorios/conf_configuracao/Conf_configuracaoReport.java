package br.com.i9.finance.server.relatorios.conf_configuracao;

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
public class Conf_configuracaoReport extends RelatorioBase {

    private Conf_configuracaoT conf_configuracaoT = new Conf_configuracaoT();

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

            Conf_configuracaoBL conf_configuracaoBL = new Conf_configuracaoBL();
            List<Conf_configuracaoT> list = conf_configuracaoBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetConf_configuracao = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listConf_configuracao"
            getParameters().put("listConf_configuracao", dataSetConf_configuracao);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Conf_configuracaoReport.class.getResource("Conf_configuracao.jasper");
            } else {
                is = Conf_configuracaoReport.class.getResourceAsStream("Conf_configuracao.jasper");
            }

            defineParametros();
            print("Conf_configuracao", "Relacao de Conf_configuracao");


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

    public void setConf_configuracaoT(Conf_configuracaoT conf_configuracaoT) {
    	this.conf_configuracaoT = conf_configuracaoT;  
    }

    public Conf_configuracaoT getConf_configuracaoT() {
    	return conf_configuracaoT;  
    }

}
