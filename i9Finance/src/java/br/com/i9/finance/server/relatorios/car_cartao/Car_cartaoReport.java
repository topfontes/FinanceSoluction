package br.com.i9.finance.server.relatorios.car_cartao;

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
public class Car_cartaoReport extends RelatorioBase {

    private Car_cartaoT car_cartaoT = new Car_cartaoT();

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

            Car_cartaoBL car_cartaoBL = new Car_cartaoBL();
            List<Car_cartaoT> list = car_cartaoBL.consult(usu_usuarioT);
            //Definindo o dataset passando a lista de clientes
            JRBeanCollectionDataSource dataSetCar_cartao = new JRBeanCollectionDataSource(list);
            //Atribuindo o dataSet ao parametro "listCar_cartao"
            getParameters().put("listCar_cartao", dataSetCar_cartao);

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Car_cartaoReport.class.getResource("Car_cartao.jasper");
            } else {
                is = Car_cartaoReport.class.getResourceAsStream("Car_cartao.jasper");
            }

            defineParametros();
            print("Car_cartao", "Relacao de Car_cartao");


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

    public void setCar_cartaoT(Car_cartaoT car_cartaoT) {
    	this.car_cartaoT = car_cartaoT;  
    }

    public Car_cartaoT getCar_cartaoT() {
    	return car_cartaoT;  
    }

}
