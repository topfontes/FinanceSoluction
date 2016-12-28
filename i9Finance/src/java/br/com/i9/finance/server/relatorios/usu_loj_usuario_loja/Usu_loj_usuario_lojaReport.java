package br.com.i9.finance.server.relatorios.usu_loj_usuario_loja;

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
public class Usu_loj_usuario_lojaReport extends RelatorioBase {

    private Usu_loj_usuario_lojaT usu_loj_usuario_lojaT = new Usu_loj_usuario_lojaT();

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

            Usu_loj_usuario_lojaBL usu_loj_usuario_lojaBL = new Usu_loj_usuario_lojaBL();
            List<Usu_loj_usuario_lojaT> list = usu_loj_usuario_lojaBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetUsu_loj_usuario_loja = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listUsu_loj_usuario_loja"
            getParameters().put("listUsu_loj_usuario_loja", dataSetUsu_loj_usuario_loja);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Usu_loj_usuario_lojaReport.class.getResource("Usu_loj_usuario_loja.jasper");
            } else {
                is = Usu_loj_usuario_lojaReport.class.getResourceAsStream("Usu_loj_usuario_loja.jasper");
            }

            defineParametros();
            print("Usu_loj_usuario_loja", "Relacao de Usu_loj_usuario_loja");


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

    public void setUsu_loj_usuario_lojaT(Usu_loj_usuario_lojaT usu_loj_usuario_lojaT) {
    	this.usu_loj_usuario_lojaT = usu_loj_usuario_lojaT;  
    }

    public Usu_loj_usuario_lojaT getUsu_loj_usuario_lojaT() {
    	return usu_loj_usuario_lojaT;  
    }

}
