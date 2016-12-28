package br.com.i9.finance.server.relatorios.v_lan_centro_custo;

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
public class V_lan_centro_custoReport extends RelatorioBase {

    private V_lan_centro_custoT v_lan_centro_custoT = new V_lan_centro_custoT();

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

            V_lan_centro_custoBL v_lan_centro_custoBL = new V_lan_centro_custoBL();
            List<V_lan_centro_custoT> list = v_lan_centro_custoBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetV_lan_centro_custo = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listV_lan_centro_custo"
            getParameters().put("listV_lan_centro_custo", dataSetV_lan_centro_custo);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = V_lan_centro_custoReport.class.getResource("V_lan_centro_custo.jasper");
            } else {
                is = V_lan_centro_custoReport.class.getResourceAsStream("V_lan_centro_custo.jasper");
            }

            defineParametros();
            print("V_lan_centro_custo", "Relacao de V_lan_centro_custo");


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

    public void setV_lan_centro_custoT(V_lan_centro_custoT v_lan_centro_custoT) {
    	this.v_lan_centro_custoT = v_lan_centro_custoT;  
    }

    public V_lan_centro_custoT getV_lan_centro_custoT() {
    	return v_lan_centro_custoT;  
    }

}
