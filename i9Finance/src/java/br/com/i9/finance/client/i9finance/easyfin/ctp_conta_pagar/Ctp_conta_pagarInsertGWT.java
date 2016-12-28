/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.ctp_conta_pagar;

import br.com.i9.finance.client.Constantes;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.CRUDBaseGWT;
import br.com.easynet.gwt.client.component.EasyMoneyField;
import br.com.easynet.gwt.client.component.EasyNumberField;

import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.v_conta_pagar.V_conta_pagarConsultGWT;
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
public class Ctp_conta_pagarInsertGWT extends CRUDBaseGWT {

    protected V_conta_pagarConsultGWT v_conta_pagarConsultGWT;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> ctp_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> ctp_nr_doc = new EasyTextField<String>();
    protected DateField ctp_dt_emissao = new DateField();
    protected DateField ctp_dt_vencimento = new DateField();
    protected EasyTextField<String> ctp_tx_pago = new EasyTextField<String>();
    protected EasyTextField<String> ban_nr_id = new EasyTextField<String>();
    protected EasyMoneyField ctp_valor = new EasyMoneyField();
    protected EasyTextField<String> ctp_tx_parcela = new EasyTextField<String>();
    protected DateField ctp_dt_pagamento = new DateField();
    protected EasyTextField<String> car_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> ctp_vl_pago = new EasyTextField<String>();
    protected EasyTextField<String> ctp_saldo = new EasyTextField<String>();
    protected EasyTextField<String> for_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> fop_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();
    protected TextArea ctp_tx_obs = new TextArea();
    protected EasyTextField<String> ctp_tx_tipo_vinculo = new EasyTextField<String>();
    protected EasyTextField<String> ctp_nr_id_vinculo = new EasyTextField<String>();
    protected Ctp_conta_pagarT ctp_conta_pagarT;
    protected ComboBox<For_fornecedorT> cb_fornec = new ComboBox<For_fornecedorT>();
    protected ComboBox<Fop_forma_pagamentoT> cb_Forma = new ComboBox<Fop_forma_pagamentoT>();
    protected ComboBox<Plc_plano_contasT> cb_Conta = new ComboBox<Plc_plano_contasT>();

    public Ctp_conta_pagarInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
        setHeading("Cadastrar Ctp_conta_pagar");
        this.setSize("500", "400");
        TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

       
        LabelField lfctp_dt_emissao = new LabelField("Dt. Emissão:");
        lfctp_dt_emissao.setId("lfctp_dt_emissao");
        getCpMaster().add(lfctp_dt_emissao);
        ctp_dt_emissao.setId("ctp_dt_emissao");
        ctp_dt_emissao.setMaxLength(13);
        ctp_dt_emissao.getPropertyEditor().setFormat(dtfDate);
        ctp_dt_emissao.setValue(new Date());
        getCpMaster().add(ctp_dt_emissao);

        LabelField lfctp_nr_doc = new LabelField("Documento:");
        lfctp_nr_doc.setId("lfctp_nr_doc");
        getCpMaster().add(lfctp_nr_doc);
        ctp_nr_doc.setId("ctp_nr_doc");
        ctp_nr_doc.setMaxLength(10);
        getCpMaster().add(ctp_nr_doc);

        LabelField lfcli_nr_id = new LabelField("Fornecedor:");
        lfcli_nr_id.setId("lfcli_nr_id");
        getCpMaster().add(lfcli_nr_id);
        for_nr_id.setId("cli_nr_id");
        for_nr_id.setMaxLength(10);
        getCpMaster().add(cb_fornec);

        LabelField lfctp_dt_vencimento = new LabelField("Vencimento:");
        lfctp_dt_vencimento.setId("lfctp_dt_vencimento");
        getCpMaster().add(lfctp_dt_vencimento);
        ctp_dt_vencimento.setId("ctp_dt_vencimento");
        ctp_dt_vencimento.setMaxLength(13);
        getCpMaster().add(ctp_dt_vencimento);
        ctp_dt_vencimento.getPropertyEditor().setFormat(dtfDate);

        LabelField lfctp_tx_parcela = new LabelField("Parcela:");
        lfctp_tx_parcela.setId("lfctp_tx_parcela");
        getCpMaster().add(lfctp_tx_parcela);
        ctp_tx_parcela.setId("ctp_tx_parcela");
        ctp_tx_parcela.setMaxLength(6);
        getCpMaster().add(ctp_tx_parcela);
        ctp_tx_parcela.setEmptyText("Exemplo: 0101");

        LabelField lffop_nr_id = new LabelField("Forma Pagamento:");
        lffop_nr_id.setId("lffop_nr_id");
        getCpMaster().add(lffop_nr_id);
        fop_nr_id.setId("fop_nr_id");
        fop_nr_id.setMaxLength(10);
        getCpMaster().add(cb_Forma);

        LabelField lfctp_valor = new LabelField("Valor:");
        lfctp_valor.setId("lfctp_valor");
        getCpMaster().add(lfctp_valor);
        ctp_valor.setId("ctp_valor");
        ctp_valor.setMaxLength(8);
        getCpMaster().add(ctp_valor);

        LabelField lfctp_conta = new LabelField("Conta:");
        lfctp_conta.setId("lfctp_valor");
        getCpMaster().add(lfctp_conta);
        ctp_valor.setId("ctp_valor");
        ctp_valor.setMaxLength(8);
        getCpMaster().add(cb_Conta);

        LabelField lfctp_tx_obs = new LabelField("Observação:");
        lfctp_tx_obs.setId("lfctp_tx_obs");
        getCpMaster().add(lfctp_tx_obs);
        ctp_tx_obs.setId("ctp_tx_obs");
        ctp_tx_obs.setMaxLength(50);
        getCpMaster().add(ctp_tx_obs);
        ctp_tx_obs.setHeight(60);
        ctp_tx_obs.setWidth(Constantes.widthField);
        povoaCb_formaPag();
        povoaConta();
        povoaFornec();

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

    public void povoaFornec() {
        cb_fornec.setDisplayField("for_tx_nome");
        cb_fornec.setEmptyText("Informe o fornecedor");
        cb_fornec.setWidth(Constantes.widthField);
        cb_fornec.setTriggerAction(ComboBox.TriggerAction.ALL);
        AsyncCallback<List<For_fornecedorT>> callback = new AsyncCallback<List<For_fornecedorT>>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<For_fornecedorT> result) {
                ListStore<For_fornecedorT> store = new ListStore<For_fornecedorT>();
                store.add(result);
                cb_fornec.setStore(store);
                cb_fornec.getListView().refresh();
            }
        };

        For_fornecedorServiceAsync for_fornecedorAsync = GWT.create(For_fornecedorService.class);
        for_fornecedorAsync.getAll(callback);
    }

    public boolean valide() {
        return true;
    }

    public void setValueObjetoT() {

        ctp_conta_pagarT.setCtp_nr_doc(Integer.parseInt(ctp_nr_doc.getValue()));
        ctp_conta_pagarT.setCtp_dt_emissao(ctp_dt_emissao.getValue());
        ctp_conta_pagarT.setCtp_dt_vencimento(ctp_dt_vencimento.getValue());
        ctp_conta_pagarT.setCtp_valor(ctp_valor.getValueMoney());
        ctp_conta_pagarT.setCtp_tx_parcela(ctp_tx_parcela.getValue());
        ctp_conta_pagarT.setCtp_saldo(ctp_valor.getValueMoney());
        ctp_conta_pagarT.setFor_nr_id(cb_fornec.getValue().getFor_nr_id());
        ctp_conta_pagarT.setFop_nr_id(cb_Forma.getValue().getFop_nr_id());

        ctp_conta_pagarT.setCtp_tx_obs(ctp_tx_obs.getValue());
        
        List<Ccp_conta_ct_pagarT> list = new ArrayList<Ccp_conta_ct_pagarT>();
        Ccp_conta_ct_pagarT ccp_conta_ct_pagarT = new Ccp_conta_ct_pagarT();
        ccp_conta_ct_pagarT.setPlc_nr_id(cb_Conta.getValue().getPlc_nr_id());
        ccp_conta_ct_pagarT.setCcp_valor(ctp_conta_pagarT.getCtp_valor());
        list.add(ccp_conta_ct_pagarT);
        
        ctp_conta_pagarT.setList(list);
    }

    public void btnInsertAction(ButtonEvent ce) {
        if (valide()) {
            ctp_conta_pagarT = new Ctp_conta_pagarT();
            setValueObjetoT();
            ctp_conta_pagarT.setCtp_tx_pago("F");
            ctp_conta_pagarT.setCtp_tx_tipo_vinculo("F");

            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    btnClearAction(null);
                    if (v_conta_pagarConsultGWT != null) {
                        v_conta_pagarConsultGWT.load();
                    }
                    setVisible(false);
                }
            };

            Ctp_conta_pagarServiceAsync ctp_conta_pagarAsync = GWT.create(Ctp_conta_pagarService.class);
            ctp_conta_pagarAsync.insert(ctp_conta_pagarT, callback);

        }
    }

    public void btnClearAction(ButtonEvent ce) {
        ctp_nr_id.setValue("");
        ctp_nr_doc.setValue("");
        ctp_dt_emissao.setValue(null);
        ctp_dt_vencimento.setValue(null);
        ctp_tx_pago.setValue("");
        ban_nr_id.setValue("");
        ctp_valor.setValue(null);
        ctp_tx_parcela.setValue("");
        ctp_dt_pagamento.setValue(null);
        car_nr_id.setValue("");
        ctp_vl_pago.setValue("");
        ctp_saldo.setValue("");
        for_nr_id.setValue("");
        fop_nr_id.setValue("");
        loj_nr_id.setValue("");
        ctp_tx_obs.setValue("");
        ctp_tx_tipo_vinculo.setValue("");
        ctp_nr_id_vinculo.setValue("");

    }

    /**
     * @return the ctp_conta_pagarConsult
     */
    public V_conta_pagarConsultGWT getV_conta_pagarConsultGWT() {
        return v_conta_pagarConsultGWT;
    }

    /**
     * @param ctp_conta_pagarConsult the ctp_conta_pagarConsult to set
     */
    public void setV_conta_pagarConsultGWT(V_conta_pagarConsultGWT v_conta_pagarConsultGWT) {
        this.v_conta_pagarConsultGWT = v_conta_pagarConsultGWT;
    }
}
