package br.com.i9.finance.server.relatorios.v_lancamentos;

import br.com.i9.finance.server.bl.*;
import br.com.i9.finance.server.relatorios.RelatorioBase;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import java.util.List;
import java.util.ArrayList;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author i9ti
 */
public class V_lancamentosReport extends RelatorioBase {

    private V_lancamentosT v_lancamentosT = new V_lancamentosT();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    @Override	
    public void imprimir() {
        try {
          

            V_lancamentosBL v_lancamentosBL = new V_lancamentosBL();
            List<V_lancamentosT> list = v_lancamentosBL.consult(getDateFormat(getDtInicio()), getDateFormat(getDtFim()), 0,usu_usuarioT);
            List<V_lancamentosTemp> listTemp = getListTemp(list);

            jRDataSource = new JRBeanCollectionDataSource(listTemp);


            if (getTipo().equalsIgnoreCase("XLS")) {
                url = V_lancamentosReport.class.getResource("V_lancamentos.jasper");
            } else {
                is = V_lancamentosReport.class.getResourceAsStream("V_lancamentos.jasper");
            }

            defineParametros();
            print("V_lancamentos", "Relação dos lançamentos");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<V_lancamentosTemp> getListTemp(List<V_lancamentosT> list ){
        List<V_lancamentosTemp> listTemp = new ArrayList<V_lancamentosTemp>();
        for (V_lancamentosT obj : list) {
            V_lancamentosTemp temp = new V_lancamentosTemp();
            temp.setLan_dt_lancamento(obj.getLan_dt_lancamento());
            temp.setLan_tx_historico(obj.getLan_tx_historico());
            temp.setLan_valor(obj.getLan_valor());
            temp.setPlc_tx_credito(obj.getPlc_tx_credito());
            temp.setPlc_tx_debito(obj.getPlc_tx_debito());
            listTemp.add(temp);
        }
        return listTemp;
    }

    public void defineParametros() {
        try {
	  //TODO: Parametros para o relatorio
            getParameters().put("periodo", "Período "+getDtInicio()+" a "+getDtFim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setV_lancamentosT(V_lancamentosT v_lancamentosT) {
    	this.v_lancamentosT = v_lancamentosT;  
    }

    public V_lancamentosT getV_lancamentosT() {
    	return v_lancamentosT;  
    }

}
