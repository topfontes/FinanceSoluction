package br.com.i9.finance.server.relatorios.cli_cliente;

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
public class Cli_clienteReport extends RelatorioBase {

    private Cli_clienteT cli_clienteT = new Cli_clienteT();

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

            Cli_clienteBL cli_clienteBL = new Cli_clienteBL();
            List<Cli_clienteT> list = cli_clienteBL.consult(usu_usuarioT);
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetCli_cliente = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listCli_cliente"
            getParameters().put("listCli_cliente", dataSetCli_cliente);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Cli_clienteReport.class.getResource("Cli_cliente.jasper");
            } else {
                is = Cli_clienteReport.class.getResourceAsStream("Cli_cliente.jasper");
            }

            defineParametros();
            print("Cli_cliente", "Relacao de Cli_cliente");


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

    public void setCli_clienteT(Cli_clienteT cli_clienteT) {
    	this.cli_clienteT = cli_clienteT;  
    }

    public Cli_clienteT getCli_clienteT() {
    	return cli_clienteT;  
    }

}
