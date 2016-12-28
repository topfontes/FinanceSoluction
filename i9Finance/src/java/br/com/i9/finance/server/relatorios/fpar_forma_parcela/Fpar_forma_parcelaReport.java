package br.com.i9.finance.server.relatorios.fpar_forma_parcela;

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
public class Fpar_forma_parcelaReport extends RelatorioBase {

    private Fpar_forma_parcelaT fpar_forma_parcelaT = new Fpar_forma_parcelaT();

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

            Fpar_forma_parcelaBL fpar_forma_parcelaBL = new Fpar_forma_parcelaBL();
            List<Fpar_forma_parcelaT> list = fpar_forma_parcelaBL.consult();
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetFpar_forma_parcela = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listFpar_forma_parcela"
            getParameters().put("listFpar_forma_parcela", dataSetFpar_forma_parcela);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Fpar_forma_parcelaReport.class.getResource("Fpar_forma_parcela.jasper");
            } else {
                is = Fpar_forma_parcelaReport.class.getResourceAsStream("Fpar_forma_parcela.jasper");
            }

            defineParametros();
            print("Fpar_forma_parcela", "Relacao de Fpar_forma_parcela");


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

    public void setFpar_forma_parcelaT(Fpar_forma_parcelaT fpar_forma_parcelaT) {
    	this.fpar_forma_parcelaT = fpar_forma_parcelaT;  
    }

    public Fpar_forma_parcelaT getFpar_forma_parcelaT() {
    	return fpar_forma_parcelaT;  
    }

}
