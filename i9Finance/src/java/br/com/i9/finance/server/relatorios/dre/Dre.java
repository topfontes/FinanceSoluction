/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.server.relatorios.dre;

import br.com.i9.finance.client.i9finance.easyfin.transfer.V_lancamentosT;
import br.com.i9.finance.server.bl.LojaSesion;
import br.com.i9.finance.server.bl.V_conta_pagarBL;
import br.com.i9.finance.server.bl.V_lancamentosBL;
import br.com.i9.finance.server.relatorios.RelatorioBase;
import br.com.i9.finance.server.relatorios.razao_analitico.Razao_analiticoReport;
import br.com.i9.finance.server.relatorios.v_lancamentos.V_lancamentosTemp;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

/**
 *
 * @author marcos
 */
public class Dre extends RelatorioBase {
    

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    @Override
    public void imprimir() {
        try {
            V_lancamentosBL bL = new V_lancamentosBL();
            List<V_lancamentosT> list = bL.consultSuperAgrupado(getDateFormat(getDtInicio()),getDateFormat(getDtFim()), getUsu_usuarioT());

            jRDataSource = new JRBeanCollectionDataSource(getListTemp(list));

            if (getTipo().equalsIgnoreCase("XLS")) {
                url = Dre.class.getResource("dre.jasper");
            } else {
                is = Dre.class.getResourceAsStream("dre.jasper");
            }

            defineParametros();
            print("razao_analitico", "Razão Analítico");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<V_lancamentosTemp> getListTemp(List<V_lancamentosT> list){
        List<V_lancamentosTemp> listTemp = new ArrayList<V_lancamentosTemp>();
        for (V_lancamentosT obj : list) {
            V_lancamentosTemp temp = new V_lancamentosTemp();
            temp.setPlc_tx_super(obj.getPlc_super());
            temp.setPlc_tx_credito(obj.getPlc_tx_credito());
            temp.setLan_valor(obj.getLan_valor());
            listTemp.add(temp);
        }
        
        for (V_lancamentosTemp temp : listTemp) {
            System.out.println(temp.getPlc_tx_super());
            System.out.println(temp.getPlc_tx_credito());
            
        }
        
        System.out.println("List temp "+listTemp.size());
        return listTemp;
    }
    
    public void defineParametros() {
        try {
            getParameters().put("periodo", "Período de " + getDtInicio() + " a " + getDtInicio());
            //TODO: Parametros para o relatorio
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
