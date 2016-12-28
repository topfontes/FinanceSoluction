package br.com.i9.finance.server.relatorios.plc_plano_contas;

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
public class Plc_plano_contasReport extends RelatorioBase {

    private Plc_plano_contasT plc_plano_contasT = new Plc_plano_contasT();

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

            Plc_plano_contasBL plc_plano_contasBL = new Plc_plano_contasBL();
            List<Plc_plano_contasT> list = plc_plano_contasBL.consult(usu_usuarioT);
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetPlc_plano_contas = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listPlc_plano_contas"
            getParameters().put("listPlc_plano_contas", dataSetPlc_plano_contas);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Plc_plano_contasReport.class.getResource("Plc_plano_contas.jasper");
            } else {
                is = Plc_plano_contasReport.class.getResourceAsStream("Plc_plano_contas.jasper");
            }

            defineParametros();
            print("Plc_plano_contas", "Relacao de Plc_plano_contas");


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

    public void setPlc_plano_contasT(Plc_plano_contasT plc_plano_contasT) {
    	this.plc_plano_contasT = plc_plano_contasT;  
    }

    public Plc_plano_contasT getPlc_plano_contasT() {
    	return plc_plano_contasT;  
    }

}
