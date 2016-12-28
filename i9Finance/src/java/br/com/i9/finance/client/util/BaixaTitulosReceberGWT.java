/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.util;

import br.com.easynet.gwt.client.component.EasyMoneyField;
import br.com.easynet.gwt.client.component.EasyNumberField;
import br.com.i9.finance.client.Constantes;
import br.com.i9.finance.client.i9finance.easyfin.service.Ctr_conta_recebeService;
import br.com.i9.finance.client.i9finance.easyfin.service.Ctr_conta_recebeServiceAsync;
import br.com.i9.finance.client.i9finance.easyfin.service.Plc_plano_contasService;
import br.com.i9.finance.client.i9finance.easyfin.service.Plc_plano_contasServiceAsync;
import br.com.i9.finance.client.i9finance.easyfin.transfer.Ctr_conta_recebeT;
import br.com.i9.finance.client.i9finance.easyfin.transfer.Plc_plano_contasT;
import br.com.i9.finance.client.i9finance.easyfin.transfer.V_conta_receberT;
import br.com.i9.finance.client.i9finance.easyfin.v_conta_receber.V_conta_receberConsultGWT;
import br.com.i9.finance.client.i9finance.easyfin.v_conta_receber_conta.V_conta_receber_contaConsultGWT;
import br.com.i9.finance.client.icones.icons.Icones;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;

/**
 *
 * @author marcos
 */
public class BaixaTitulosReceberGWT extends Window {

    private V_conta_receberConsultGWT consultGWT;
    private V_conta_receberT v_conta_receberT;
    private ContentPanel cp = new ContentPanel();
    private ComboBox<Plc_plano_contasT> cb_Conta = new ComboBox<Plc_plano_contasT>();
    private DateField dt_pag = new DateField();
    private EasyMoneyField valor = new EasyMoneyField();
    private TextField<String> tx_obs = new TextField<String>();
    private TextField<String> tx_doc = new TextField<String>();
    private Button btnBaixar = new Button("Confima", Icones.ICONS.ok_blue());
    private DateField dtVen = new DateField();
    private TextField<String> tx_cli = new TextField<String>();
    private TextField<String> tx_parcela = new TextField<String>();
    private EasyNumberField saldo = new EasyNumberField();

    public BaixaTitulosReceberGWT(V_conta_receberT v_conta_receberT) {
        this.v_conta_receberT = v_conta_receberT;
        configForm();
    }

    public void configForm() {
        ToolBar bar = new ToolBar();
        bar.add(btnBaixar);
        bar.setAlignment(Style.HorizontalAlignment.CENTER);
        setBottomComponent(bar);
        setHeading("Baixa de Títulos");
        povoaConta();
        dt_pag.getPropertyEditor().setFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        setSize(450, 350);
        setLayout(new FillLayout());
        cp.setHeaderVisible(false);
        cp.getElement().setAttribute("backgroundColor", "white");
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(5);
        cp.setLayout(layout);
        cp.add(new LabelField("Dt. Recebimento:"));
        cp.add(dt_pag);
        cp.add(new LabelField("Valor Recebido:"));
        cp.add(valor);
        cp.add(new LabelField("Conta:"));
        cp.add(cb_Conta);
        cp.add(new LabelField("Observação:"));
        cp.add(tx_obs);
        tx_obs.setWidth(Constantes.widthField);

        add(cp);
        cp.setTopComponent(configTop());

        btnBaixar.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                EfetuarBaixa();
            }
        });
    }

    public void EfetuarBaixa() {
        AsyncCallback<Void> callback = new AsyncCallback<Void>() {

            @Override
            public void onFailure(Throwable caught) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onSuccess(Void result) {
                Info.display("Infomação", "Operação realizada com sucesso!");
                consultGWT.load();
                setVisible(false);
            }
        };

        Ctr_conta_recebeT ctr_conta_recebeT = new Ctr_conta_recebeT();
        ctr_conta_recebeT.setCtr_nr_id(v_conta_receberT.getCtr_nr_id());
        ctr_conta_recebeT.setCtr_vl_pago(valor.getValueMoney());
        ctr_conta_recebeT.setCtr_valor(v_conta_receberT.getValor());
        ctr_conta_recebeT.setCtr_dt_pagamento(dt_pag.getValue());
        ctr_conta_recebeT.setCtr_tx_obs(tx_obs.getValue());

        Ctr_conta_recebeServiceAsync serviceAsync = GWT.create(Ctr_conta_recebeService.class);
        serviceAsync.updateBaixa(ctr_conta_recebeT, cb_Conta.getValue().getPlc_nr_id(), callback);
    }

    public Component configTop() {
        PanelTopGWT panelTopGWT = new PanelTopGWT();

        tx_cli.setWidth(Constantes.widthField);
        tx_cli.setValue(v_conta_receberT.getNome());
        panelTopGWT.addComponent(new LabelField("Cliente:"), tx_cli);

        dtVen.setValue(v_conta_receberT.getVencimento());
        panelTopGWT.addComponent(new LabelField("Vencimento:"), dtVen);

        tx_doc.setValue(v_conta_receberT.getDocumento() + "");
        panelTopGWT.addComponent(new LabelField("Documento:"), tx_doc);

        tx_parcela.setValue(v_conta_receberT.getParcela());
        panelTopGWT.addComponent(new LabelField("Parcela:"), tx_parcela);

        saldo.setValue(v_conta_receberT.getValor());
        panelTopGWT.addComponent(new LabelField("Saldo:"), saldo);

        return panelTopGWT;
    }

    public void povoaConta() {
        cb_Conta.setWidth(Constantes.widthField);
        cb_Conta.setDisplayField("plc_tx_nome");
        cb_Conta.setEmptyText("Selecione a super conta");
        cb_Conta.setTriggerAction(ComboBox.TriggerAction.ALL);
        cb_Conta.setMinChars(2);

        AsyncCallback<List<Plc_plano_contasT>> callback = new AsyncCallback<List<Plc_plano_contasT>>() {

            @Override
            public void onFailure(Throwable caught) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onSuccess(List<Plc_plano_contasT> result) {
                ListStore<Plc_plano_contasT> store = new ListStore<Plc_plano_contasT>();
                store.add(result);
                cb_Conta.setStore(store);
                cb_Conta.getListView().refresh();
            }
        };
        Plc_plano_contasServiceAsync serviceAsync = GWT.create(Plc_plano_contasService.class);
        serviceAsync.getAllSub(callback);
    }

    /**
     * @return the consultGWT
     */
    public V_conta_receberConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(V_conta_receberConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

}
