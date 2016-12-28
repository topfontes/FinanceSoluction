/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.lan_lancamento;

import br.com.i9.finance.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.CRUDBaseGWT;
import br.com.easynet.gwt.client.component.EasyMoneyField;
import br.com.easynet.gwt.client.component.EasyNumberField;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Timer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.v_lancamentos.V_lancamentosConsultGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import java.util.Date;
import java.util.List;

/**
 *
 * @author EasyNet
 */
public class Lan_lancamentoInsertGWT extends CRUDBaseGWT {

    protected V_lancamentosConsultGWT v_lancamentosConsultGWT;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> lan_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> ctr_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> ctp_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> lan_plc_nr_id_deb = new EasyTextField<String>();
    protected EasyTextField<String> lan_plc_nr_id_cred = new EasyTextField<String>();
    protected DateField lan_dt_lancamento = new DateField();
    protected TextArea lan_tx_historico = new TextArea();
    protected EasyMoneyField lan_valor = new EasyMoneyField();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> lan_nr_id_super = new EasyTextField<String>();
    protected Lan_lancamentoT lan_lancamentoT;
    protected ComboBox<Plc_plano_contasT> cb_conta_deb = new ComboBox<Plc_plano_contasT>();
    protected ComboBox<Plc_plano_contasT> cb_conta_cred = new ComboBox<Plc_plano_contasT>();

    public Lan_lancamentoInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
        setHeading("Cadastrar lançamento");
        this.setSize("400", "300");
        TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

        LabelField lflan_dt_lancamento = new LabelField("Data:");
        lflan_dt_lancamento.setId("lflan_dt_lancamento");
        getCpMaster().add(lflan_dt_lancamento);
        lan_dt_lancamento.setId("lan_dt_lancamento");
        lan_dt_lancamento.setMaxLength(13);
        lan_dt_lancamento.getPropertyEditor().setFormat(dtfDate);
        //lan_dt_lancamento.setValue(new Date());
        getCpMaster().add(lan_dt_lancamento);

        LabelField lflan_valor = new LabelField("Valor:");
        lflan_valor.setId("lflan_valor");
        getCpMaster().add(lflan_valor);
        lan_valor.setId("lan_valor");
        lan_valor.setMaxLength(8);
        getCpMaster().add(lan_valor);

        LabelField lflan_plc_nr_id_cred = new LabelField("Crédito:");
        lflan_plc_nr_id_cred.setId("lflan_plc_nr_id_cred");
        getCpMaster().add(lflan_plc_nr_id_cred);
        lan_plc_nr_id_cred.setId("lan_plc_nr_id_cred");
        lan_plc_nr_id_cred.setMaxLength(10);
        getCpMaster().add(cb_conta_cred);

        LabelField lflan_plc_nr_id_deb = new LabelField("Débito:");
        lflan_plc_nr_id_deb.setId("lflan_plc_nr_id_deb");
        getCpMaster().add(lflan_plc_nr_id_deb);
        lan_plc_nr_id_deb.setId("lan_plc_nr_id_deb");
        lan_plc_nr_id_deb.setMaxLength(10);
        getCpMaster().add(cb_conta_deb);

        LabelField lflan_tx_historico = new LabelField("Histórico:");
        lflan_tx_historico.setId("lflan_tx_historico");
        getCpMaster().add(lflan_tx_historico);
        lan_tx_historico.setId("lan_tx_historico");
        lan_tx_historico.setHeight(70);
        lan_tx_historico.setWidth(Constantes.widthField);
        getCpMaster().add(lan_tx_historico);

        LoadCota();

    }

    public void LoadCota() {
        cb_conta_deb.setWidth(Constantes.widthField);
        cb_conta_deb.setDisplayField("plc_tx_nome");
        cb_conta_deb.setEmptyText("Conta de Entrada");
        cb_conta_deb.setTriggerAction(ComboBox.TriggerAction.ALL);
        cb_conta_deb.setMinChars(2);
        
        cb_conta_cred.setWidth(Constantes.widthField);
        cb_conta_cred.setDisplayField("plc_tx_nome");
        cb_conta_cred.setEmptyText("Conta de Saída");
        cb_conta_cred.setTriggerAction(ComboBox.TriggerAction.ALL);
        cb_conta_cred.setMinChars(2);

        AsyncCallback<List<Plc_plano_contasT>> callback = new AsyncCallback<List<Plc_plano_contasT>>() {

            @Override
            public void onFailure(Throwable caught) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onSuccess(List<Plc_plano_contasT> result) {
                povoaCb_conta_cred(result);
                povoaCb_conta_deb(result);
            }
        };
        Plc_plano_contasServiceAsync serviceAsync = GWT.create(Plc_plano_contasService.class);
        serviceAsync.getAllSub(callback);
    }

    public void povoaCb_conta_deb(List<Plc_plano_contasT> list) {

        ListStore<Plc_plano_contasT> store = new ListStore<Plc_plano_contasT>();
        store.add(list);
        cb_conta_deb.setStore(store);
        cb_conta_deb.getListView().refresh();
    }

    public void povoaCb_conta_cred(List<Plc_plano_contasT> list) {

        ListStore<Plc_plano_contasT> store = new ListStore<Plc_plano_contasT>();
        store.add(list);
        cb_conta_cred.setStore(store);
        cb_conta_cred.getListView().refresh();
    }

    public boolean valide() {
        return true;
    }

    public void setValueObjetoT(Lan_lancamentoT lan_lancamentoT) {

        lan_lancamentoT.setLan_plc_nr_id_deb(cb_conta_deb.getValue().getPlc_nr_id());
        lan_lancamentoT.setLan_plc_nr_id_cred(cb_conta_cred.getValue().getPlc_nr_id());
        lan_lancamentoT.setLan_dt_lancamento(lan_dt_lancamento.getValue());
        lan_lancamentoT.setLan_tx_historico(lan_tx_historico.getValue());
        lan_lancamentoT.setLan_valor(lan_valor.getValueMoney());

    }

    public void btnInsertAction(ButtonEvent ce) {
        if (valide()) {
            lan_lancamentoT = new Lan_lancamentoT();
            setValueObjetoT(lan_lancamentoT);
            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    btnClearAction(null);
                    if (v_lancamentosConsultGWT != null) {
                        v_lancamentosConsultGWT.load();
                    }
                    setVisible(false);
                }
            };

            Lan_lancamentoServiceAsync lan_lancamentoAsync = GWT.create(Lan_lancamentoService.class);
            lan_lancamentoAsync.insert(lan_lancamentoT, callback);

        }
    }

    public void btnClearAction(ButtonEvent ce) {
        lan_nr_id.setValue("");
        ctr_nr_id.setValue("");
        ctp_nr_id.setValue("");
        cb_conta_cred.setValue(null);
        cb_conta_deb.setValue(null);
        lan_dt_lancamento.setValue(null);
        lan_tx_historico.setValue("");
        lan_valor.setValue(null);
        loj_nr_id.setValue("");
        lan_nr_id_super.setValue("");

    }

    /**
     * @return the lan_lancamentoConsult
     */
    public V_lancamentosConsultGWT getV_lancamentosConsultGWT() {
        return v_lancamentosConsultGWT;
    }

    /**
     * @param lan_lancamentoConsult the lan_lancamentoConsult to set
     */
    public void setV_lancamentosConsultGWT(V_lancamentosConsultGWT v_lancamentosConsultGWT) {
        this.v_lancamentosConsultGWT = v_lancamentosConsultGWT;
    }
}
