/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client;

import br.com.easyportal.gwt.client.accordionModel.AMenuHandlerAccordion;
import br.com.i9.finance.client.i9finance.easyfin.ban_banco.Ban_bancoConsultGWT;
import br.com.i9.finance.client.i9finance.easyfin.car_cartao.Car_cartaoConsultGWT;
import br.com.i9.finance.client.i9finance.easyfin.cen_centro_custo.Cen_centro_custoConsultGWT;
import br.com.i9.finance.client.i9finance.easyfin.cli_cliente.Cli_clienteConsultGWT;
import br.com.i9.finance.client.i9finance.easyfin.fop_forma_pagamento.Fop_forma_pagamentoConsultGWT;
import br.com.i9.finance.client.i9finance.easyfin.for_fornecedor.For_fornecedorConsultGWT;
import br.com.i9.finance.client.i9finance.easyfin.loj_loja.Loj_lojaConsultGWT;
import br.com.i9.finance.client.i9finance.easyfin.par_parcelamento.Par_parcelamentoConsultGWT;
import br.com.i9.finance.client.i9finance.easyfin.plc_plano_contas.Plc_plano_contasConsultGWT;
import br.com.i9.finance.client.i9finance.easyfin.por_previsao_orcamento.Por_previsao_orcamentoConsultGWT;

import br.com.i9.finance.client.i9finance.easyfin.relatorios.ContasAPagar_RelGWT;
import br.com.i9.finance.client.i9finance.easyfin.relatorios.ContasAReceberRelGWT;
import br.com.i9.finance.client.i9finance.easyfin.relatorios.Dre_RelGWT;
import br.com.i9.finance.client.i9finance.easyfin.relatorios.LancamentosRelGWT;
import br.com.i9.finance.client.i9finance.easyfin.relatorios.RazaoAnalitico_RelGWT;
import br.com.i9.finance.client.i9finance.easyfin.v_conta_pagar.V_conta_pagarConsultGWT;
import br.com.i9.finance.client.i9finance.easyfin.v_conta_receber.V_conta_receberConsultGWT;
import br.com.i9.finance.client.i9finance.easyfin.v_lancamentos.V_lancamentosConsultGWT;



import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class AdminFINANCEAccordion extends AMenuHandlerAccordion {

    private HashMap<String, TabItem> itens = new HashMap<String, TabItem>();

    public AdminFINANCEAccordion() {
        setSystem("I9FIN");
    }

    @Override
    public void actionEventMenu(Object me, String acao) {
        actionEventMenu(me, acao, "");
    }

    @Override
    public void actionEventMenu(Object me, String acao, String url) {
//        super.actionEventMenu(me, acao, url); //To change body of generated methods, choose Tools | Templates.
        TabItem tabItem = null;
        tabItem = itens.get(acao);

        if (tabItem == null) {
            tabItem = new TabItem();
             tabItem.setClosable(true);
            tabItem.setLayout(new FitLayout());
            ContentPanel cp = new ContentPanel();
            cp.setFrame(false);
            cp.setBorders(false);
            cp.setHeaderVisible(false);
            cp.setBodyBorder(false);
            cp.setLayout(new FitLayout());
            if ("I9FIN.Banco".equalsIgnoreCase(acao)) {
                tabItem.setText("Bancos");
                cp.add(new Ban_bancoConsultGWT());
            } else
            if ("I9FIN.Clientes".equalsIgnoreCase(acao)) {
                tabItem.setText("Clientes");
                cp.add(new Cli_clienteConsultGWT());
            } else
               if ("I9FIN.Fornecedor".equalsIgnoreCase(acao)) {
                tabItem.setText("Fornecedor");
                cp.add(new For_fornecedorConsultGWT());
            } else
                if ("I9FIN.Plano".equalsIgnoreCase(acao)) {
                tabItem.setText("Plano Conta");
                cp.add(new Plc_plano_contasConsultGWT());
            } else
                if ("I9FIN.Cartao".equalsIgnoreCase(acao)) {
                tabItem.setText("Cartao");
                cp.add(new Car_cartaoConsultGWT());
            } else if ("I9FIN.forma_pag".equalsIgnoreCase(acao)) {
                tabItem.setText("Forma Pagamento");
                cp.add(new Fop_forma_pagamentoConsultGWT());
            } else
                if ("I9FIN.Parc".equalsIgnoreCase(acao)) {
                tabItem.setText("Parcelamento");
                cp.add(new Par_parcelamentoConsultGWT());
            } else
                if ("I9FIN.Centro".equalsIgnoreCase(acao)) {
                tabItem.setText("Centro de Custo");
                cp.add(new Cen_centro_custoConsultGWT());
            } else if ("I9FIN.Loja".equalsIgnoreCase(acao)) {
                tabItem.setText("Loja");
                cp.add(new Loj_lojaConsultGWT());
            } else if ("I9FIN.ctr".equalsIgnoreCase(acao)) {
                tabItem.setText("Canta a receber");
                cp.add(new V_conta_receberConsultGWT());
            }  else if ("I9FIN.ctp".equalsIgnoreCase(acao)) {
                tabItem.setText("Conta a pagar");
                cp.add(new V_conta_pagarConsultGWT());
            }  else if ("I9FIN.lan".equalsIgnoreCase(acao)) {
                tabItem.setText("Lançamentos");
                cp.add(new V_lancamentosConsultGWT());
            } else if ("I9FIN.previsao".equalsIgnoreCase(acao)) {
                tabItem.setText("Previsão orçamentária");
                cp.add(new Por_previsao_orcamentoConsultGWT());
            }  else if ("I9FIN.rel_apagar".equalsIgnoreCase(acao)) {
                tabItem.setText("Relatório conta a pagar");
                cp.add(new ContasAPagar_RelGWT());
            }  else if ("I9FIN.rel_areceber".equalsIgnoreCase(acao)) {
                tabItem.setText("Relatório conta a receber");
                cp.add(new ContasAReceberRelGWT());
            }  else if ("I9FIN.razao".equalsIgnoreCase(acao)) {
                tabItem.setText("Razão analítico");
                cp.add(new RazaoAnalitico_RelGWT());
            }  else if ("I9FIN.dre".equalsIgnoreCase(acao)) {
                tabItem.setText("Demostrativo resultado da empresa");
                cp.add(new Dre_RelGWT());
            }  else if ("I9FIN.rel_lan".equalsIgnoreCase(acao)) {
                tabItem.setText("Lançamentos Contábeis");
                cp.add(new LancamentosRelGWT());
            } else {
                MessageBox.alert("Opcao ainda nao implementada", "Em breve esta opcao estara disponivel!", null);
            }   
            if (cp != null) {
                tabItem.add(cp);
                getPortalAccordionGWT().getTabPanel().add(tabItem);
                itens.put(acao, tabItem);
            }
        } else {
            TabItem tabTemp = getPortalAccordionGWT().getTabPanel().getItemByItemId(acao);
            if (tabTemp == null) {
                getPortalAccordionGWT().getTabPanel().add(tabItem);
            }
        }
        getPortalAccordionGWT().getTabPanel().setSelection(tabItem);
        getPortalAccordionGWT().layout();
    }
    
    
}
