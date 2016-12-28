/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.ctr_conta_recebe;

import br.com.i9.finance.client.Constantes;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.CRUDBaseGWT;
import br.com.easynet.gwt.client.component.EasyMoneyField;
import br.com.easynet.gwt.client.component.EasyNumberField;

import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.v_conta_receber.V_conta_receberConsultGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author EasyNet
 */
public class Ctr_conta_recebeInsertGWT extends CRUDBaseGWT {

    protected V_conta_receberConsultGWT v_conta_receberConsultGWT;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> ctr_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> cli_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> ctr_nr_doc = new EasyTextField<String>();
    protected DateField ctr_dt_emissao = new DateField();
    protected DateField ctr_dt_vencimento = new DateField();
    protected EasyTextField<String> fop_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> ctr_tx_pago = new EasyTextField<String>();
    protected EasyTextField<String> ban_nr_id = new EasyTextField<String>();
    protected EasyMoneyField ctr_valor = new EasyMoneyField();
    protected TextField<String> ctr_tx_parcela = new TextField<String>();
    protected DateField ctr_dt_pagamento = new DateField();
    protected EasyTextField<String> car_nr_id = new EasyTextField<String>();
    protected EasyNumberField ctr_vl_pago = new EasyNumberField();
    protected EasyTextField<String> ctr_saldo = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();
    protected TextArea ctr_tx_obs = new TextArea();
    protected EasyTextField<String> ctr_tx_tipo_vinculo = new EasyTextField<String>();
    protected EasyTextField<String> ctr_nr_id_vinculo = new EasyTextField<String>();
    protected Ctr_conta_recebeT ctr_conta_recebeT;

    protected ComboBox<Cli_clienteT> cb_cliente = new ComboBox<Cli_clienteT>();
    protected ComboBox<Fop_forma_pagamentoT> cb_Forma = new ComboBox<Fop_forma_pagamentoT>();
    protected ComboBox<Plc_plano_contasT> cb_Conta = new ComboBox<Plc_plano_contasT>();

    public Ctr_conta_recebeInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
        setHeading("Cadastrar conta a receber");
        this.setSize("500", "400");
        TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

        LabelField lfctr_dt_emissao = new LabelField("Dt. Emissão:");
        lfctr_dt_emissao.setId("lfctr_dt_emissao");
        getCpMaster().add(lfctr_dt_emissao);
        ctr_dt_emissao.setId("ctr_dt_emissao");
        ctr_dt_emissao.setMaxLength(13);
        ctr_dt_emissao.getPropertyEditor().setFormat(dtfDate);
        ctr_dt_emissao.setValue(new Date());
        getCpMaster().add(ctr_dt_emissao);

        LabelField lfctr_nr_doc = new LabelField("Documento:");
        lfctr_nr_doc.setId("lfctr_nr_doc");
        getCpMaster().add(lfctr_nr_doc);
        ctr_nr_doc.setId("ctr_nr_doc");
        ctr_nr_doc.setMaxLength(10);
        getCpMaster().add(ctr_nr_doc);

        LabelField lfcli_nr_id = new LabelField("Cliente:");
        lfcli_nr_id.setId("lfcli_nr_id");
        getCpMaster().add(lfcli_nr_id);
        cli_nr_id.setId("cli_nr_id");
        cli_nr_id.setMaxLength(10);
        getCpMaster().add(cb_cliente);

        LabelField lfctr_dt_vencimento = new LabelField("Vencimento:");
        lfctr_dt_vencimento.setId("lfctr_dt_vencimento");
        getCpMaster().add(lfctr_dt_vencimento);
        ctr_dt_vencimento.setId("ctr_dt_vencimento");
        ctr_dt_vencimento.setMaxLength(13);
        getCpMaster().add(ctr_dt_vencimento);
        ctr_dt_vencimento.getPropertyEditor().setFormat(dtfDate);

        LabelField lfctr_tx_parcela = new LabelField("Parcela:");
        lfctr_tx_parcela.setId("lfctr_tx_parcela");
        getCpMaster().add(lfctr_tx_parcela);
        ctr_tx_parcela.setId("ctr_tx_parcela");
        ctr_tx_parcela.setMaxLength(6);
        getCpMaster().add(ctr_tx_parcela);
        ctr_tx_parcela.setEmptyText("Exemplo: 0101");

        LabelField lffop_nr_id = new LabelField("Forma Pagamento:");
        lffop_nr_id.setId("lffop_nr_id");
        getCpMaster().add(lffop_nr_id);
        fop_nr_id.setId("fop_nr_id");
        fop_nr_id.setMaxLength(10);
        getCpMaster().add(cb_Forma);

        LabelField lfctr_valor = new LabelField("Valor:");
        lfctr_valor.setId("lfctr_valor");
        getCpMaster().add(lfctr_valor);
        ctr_valor.setId("ctr_valor");
        ctr_valor.setMaxLength(8);
        getCpMaster().add(ctr_valor);

        LabelField lfctr_conta = new LabelField("Conta:");
        lfctr_conta.setId("lfctr_valor");
        getCpMaster().add(lfctr_conta);
        ctr_valor.setId("ctr_valor");
        ctr_valor.setMaxLength(8);
        getCpMaster().add(cb_Conta);

        LabelField lfctr_tx_obs = new LabelField("Observação:");
        lfctr_tx_obs.setId("lfctr_tx_obs");
        getCpMaster().add(lfctr_tx_obs);
        ctr_tx_obs.setId("ctr_tx_obs");
        ctr_tx_obs.setMaxLength(50);
        getCpMaster().add(ctr_tx_obs);
        ctr_tx_obs.setHeight(60);
        ctr_tx_obs.setWidth(Constantes.widthField);
        povoaCb_Clientes();
        povoaCb_formaPag();
        povoaConta();
        layout();

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

    public void povoaCb_Clientes() {
        cb_cliente.setDisplayField("cli_tx_nome");
        cb_cliente.setTriggerAction(ComboBox.TriggerAction.ALL);
        cb_cliente.setEmptyText("Informe o Cliente");
        cb_cliente.setWidth(Constantes.widthField);

        AsyncCallback<List<Cli_clienteT>> callback = new AsyncCallback<List<Cli_clienteT>>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<Cli_clienteT> result) {
                ListStore<Cli_clienteT> store = new ListStore<Cli_clienteT>();
                store.add(result);
                cb_cliente.setStore(store);
                cb_cliente.getListView().refresh();
            }
        };

        Cli_clienteServiceAsync cli_clienteAsync = GWT.create(Cli_clienteService.class);
        cli_clienteAsync.getAll(callback);
    }

    public void povoaCb_formaPag() {
        cb_Forma.setDisplayField("fop_tx_nome");
        cb_Forma.setTriggerAction(ComboBox.TriggerAction.ALL);
        cb_Forma.setEmptyText("Forma de pagamento");
        AsyncCallback<List<Fop_forma_pagamentoT>> callback = new AsyncCallback<List<Fop_forma_pagamentoT>>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<Fop_forma_pagamentoT> result) {
                ListStore<Fop_forma_pagamentoT> store = new ListStore<Fop_forma_pagamentoT>();
                store.add(result);
                cb_Forma.setStore(store);
                cb_Forma.getListView().refresh();
            }
        };

        Fop_forma_pagamentoServiceAsync fop_forma_pagamentoAsync = GWT.create(Fop_forma_pagamentoService.class);
        fop_forma_pagamentoAsync.getAll(callback);
    }

    public boolean valide() {
        return true;
    }

    public void setValueObjetoT() {

        ctr_conta_recebeT.setCli_nr_id(cb_cliente.getValue().getCli_nr_id());
        ctr_conta_recebeT.setCtr_nr_doc(Integer.parseInt(ctr_nr_doc.getValue()));
        ctr_conta_recebeT.setCtr_dt_emissao(ctr_dt_emissao.getValue());
        ctr_conta_recebeT.setCtr_dt_vencimento(ctr_dt_vencimento.getValue());
        ctr_conta_recebeT.setFop_nr_id(cb_Forma.getValue().getFop_nr_id());

        
        ctr_conta_recebeT.setCtr_valor(ctr_valor.getValueMoney());
        ctr_conta_recebeT.setCtr_tx_parcela(ctr_tx_parcela.getValue());

        ctr_conta_recebeT.setCtr_vl_pago(0);
        ctr_conta_recebeT.setCtr_saldo(ctr_valor.getValueMoney());
        
        ctr_conta_recebeT.setCtr_tx_obs(ctr_tx_obs.getValue());
        
        List<Ccr_conta_ct_receberT> list = new ArrayList<Ccr_conta_ct_receberT>();
        Ccr_conta_ct_receberT ccr_conta_ct_receberT = new Ccr_conta_ct_receberT();
        ccr_conta_ct_receberT.setPlc_nr_id(cb_Conta.getValue().getPlc_nr_id());
        ccr_conta_ct_receberT.setCcr_valor(ctr_conta_recebeT.getCtr_valor());
        list.add(ccr_conta_ct_receberT);

        ctr_conta_recebeT.setListContas(list);

        
    }

    public void btnInsertAction(ButtonEvent ce) {
        if (valide()) {
            ctr_conta_recebeT = new Ctr_conta_recebeT();
            setValueObjetoT();
            ctr_conta_recebeT.setCtr_tx_pago("F");
            ctr_conta_recebeT.setCtr_tx_tipo_vinculo("F");

            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    btnClearAction(null);
                    if (v_conta_receberConsultGWT != null) {
                        v_conta_receberConsultGWT.load();
                    }
                    setVisible(false);
                }
            };

            Ctr_conta_recebeServiceAsync ctr_conta_recebeAsync = GWT.create(Ctr_conta_recebeService.class);
            ctr_conta_recebeAsync.insert(ctr_conta_recebeT, callback);

        }
    }

    public void btnClearAction(ButtonEvent ce) {
        ctr_nr_id.setValue("");
        cli_nr_id.setValue("");
        ctr_nr_doc.setValue("");
        ctr_dt_emissao.setValue(null);
        ctr_dt_vencimento.setValue(null);
        fop_nr_id.setValue("");
        ctr_tx_pago.setValue("");
        ban_nr_id.setValue("");
        ctr_valor.setValue(null);
        ctr_tx_parcela.setValue("");
        ctr_dt_pagamento.setValue(null);
        car_nr_id.setValue("");
        ctr_saldo.setValue("");
        loj_nr_id.setValue("");
        ctr_tx_obs.setValue("");
        ctr_tx_tipo_vinculo.setValue("");
        ctr_nr_id_vinculo.setValue("");

    }

    /**
     * @return the ctr_conta_recebeConsult
     */
    public V_conta_receberConsultGWT getV_conta_receberConsultGWT() {
        return v_conta_receberConsultGWT;
    }

    /**
     * @param ctr_conta_recebeConsult the ctr_conta_recebeConsult to set
     */
    public void setV_conta_receberConsultGWT(V_conta_receberConsultGWT v_conta_receberConsultGWT) {
        this.v_conta_receberConsultGWT = v_conta_receberConsultGWT;
    }
}
