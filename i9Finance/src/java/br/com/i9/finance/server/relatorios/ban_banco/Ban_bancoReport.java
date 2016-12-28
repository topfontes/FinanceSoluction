package br.com.i9.finance.server.relatorios.ban_banco;

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
public class Ban_bancoReport extends RelatorioBase {

    private Ban_bancoT ban_bancoT = new Ban_bancoT();

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

            Ban_bancoBL ban_bancoBL = new Ban_bancoBL();
            List<Ban_bancoT> list = ban_bancoBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetBan_banco = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listBan_banco"
            getParameters().put("listBan_banco", dataSetBan_banco);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Ban_bancoReport.class.getResource("Ban_banco.jasper");
            } else {
                is = Ban_bancoReport.class.getResourceAsStream("Ban_banco.jasper");
            }

            defineParametros();
            print("Ban_banco", "Relacao de Ban_banco");


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

    public void setBan_bancoT(Ban_bancoT ban_bancoT) {
    	this.ban_bancoT = ban_bancoT;  
    }

    public Ban_bancoT getBan_bancoT() {
    	return ban_bancoT;  
    }

}
