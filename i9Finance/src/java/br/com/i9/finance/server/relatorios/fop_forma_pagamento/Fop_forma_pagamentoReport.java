package br.com.i9.finance.server.relatorios.fop_forma_pagamento;

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
public class Fop_forma_pagamentoReport extends RelatorioBase {

    private Fop_forma_pagamentoT fop_forma_pagamentoT = new Fop_forma_pagamentoT();

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

            Fop_forma_pagamentoBL fop_forma_pagamentoBL = new Fop_forma_pagamentoBL();
            List<Fop_forma_pagamentoT> list = fop_forma_pagamentoBL.consult(usu_usuarioT);
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetFop_forma_pagamento = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listFop_forma_pagamento"
            getParameters().put("listFop_forma_pagamento", dataSetFop_forma_pagamento);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Fop_forma_pagamentoReport.class.getResource("Fop_forma_pagamento.jasper");
            } else {
                is = Fop_forma_pagamentoReport.class.getResourceAsStream("Fop_forma_pagamento.jasper");
            }

            defineParametros();
            print("Fop_forma_pagamento", "Relacao de Fop_forma_pagamento");


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

    public void setFop_forma_pagamentoT(Fop_forma_pagamentoT fop_forma_pagamentoT) {
    	this.fop_forma_pagamentoT = fop_forma_pagamentoT;  
    }

    public Fop_forma_pagamentoT getFop_forma_pagamentoT() {
    	return fop_forma_pagamentoT;  
    }

}
