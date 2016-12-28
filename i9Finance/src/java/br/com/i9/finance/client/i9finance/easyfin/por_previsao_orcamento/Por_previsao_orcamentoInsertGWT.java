/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.por_previsao_orcamento;

import br.com.i9.finance.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.CRUDBaseGWT;
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
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import java.util.List;

/**
 *
 * @author EasyNet
 */
public class Por_previsao_orcamentoInsertGWT extends CRUDBaseGWT {

    protected Por_previsao_orcamentoConsultGWT por_previsao_orcamentoConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> por_nr_id = new EasyTextField<String>();
    protected EasyNumberField por_nr_ano = new EasyNumberField();
    protected EasyNumberField plc_nr_id = new EasyNumberField();
    protected EasyNumberField por_vl_jan = new EasyNumberField();
    protected EasyNumberField por_vl_fev = new EasyNumberField();
    protected EasyNumberField por_vl_mar = new EasyNumberField();
    protected EasyNumberField por_vl_abr = new EasyNumberField();
    protected EasyNumberField por_vl_mai = new EasyNumberField();
    protected EasyNumberField por_vl_jun = new EasyNumberField();
    protected EasyNumberField por_vl_jul = new EasyNumberField();
    protected EasyNumberField por_vl_ago = new EasyNumberField();
    protected EasyNumberField por_vl_set = new EasyNumberField();
    protected EasyNumberField por_vl_out = new EasyNumberField();
    protected EasyNumberField por_vl_nov = new EasyNumberField();
    protected EasyNumberField por_vl_dez = new EasyNumberField();
    protected ComboBox<Plc_plano_contasT> cb_Conta = new ComboBox<Plc_plano_contasT>();
    protected Por_previsao_orcamentoT por_previsao_orcamentoT;

    public Por_previsao_orcamentoInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
        setHeading("Cadastrar previsão orcamentária");
        this.setSize("500", "520");
        TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

        LabelField lfpor_nr_ano = new LabelField("Ano:");
        lfpor_nr_ano.setId("lfpor_nr_ano");
        getCpMaster().add(lfpor_nr_ano);
        por_nr_ano.setId("por_nr_ano");
        por_nr_ano.setMaxLength(10);
        getCpMaster().add(por_nr_ano);

        LabelField lfplc_nr_id = new LabelField("Conta:");
        lfplc_nr_id.setId("lfplc_nr_id");
        getCpMaster().add(lfplc_nr_id);
        plc_nr_id.setId("plc_nr_id");
        plc_nr_id.setMaxLength(10);
        getCpMaster().add(cb_Conta);

        LabelField lfpor_vl_jan = new LabelField("Janeiro:");
        lfpor_vl_jan.setId("lfpor_vl_jan");
        getCpMaster().add(lfpor_vl_jan);
        por_vl_jan.setId("por_vl_jan");
        por_vl_jan.setMaxLength(8);
        getCpMaster().add(por_vl_jan);

        LabelField lfpor_vl_fev = new LabelField("Fevereiro:");
        lfpor_vl_fev.setId("lfpor_vl_fev");
        getCpMaster().add(lfpor_vl_fev);
        por_vl_fev.setId("por_vl_fev");
        por_vl_fev.setMaxLength(8);
        getCpMaster().add(por_vl_fev);

        LabelField lfpor_vl_mar = new LabelField("Março:");
        lfpor_vl_mar.setId("lfpor_vl_mar");
        getCpMaster().add(lfpor_vl_mar);
        por_vl_mar.setId("por_vl_mar");
        por_vl_mar.setMaxLength(8);
        getCpMaster().add(por_vl_mar);

        LabelField lfpor_vl_abr = new LabelField("Abril:");
        lfpor_vl_abr.setId("lfpor_vl_abr");
        getCpMaster().add(lfpor_vl_abr);
        por_vl_abr.setId("por_vl_abr");
        por_vl_abr.setMaxLength(8);
        getCpMaster().add(por_vl_abr);

        LabelField lfpor_vl_mai = new LabelField("Maio:");
        lfpor_vl_mai.setId("lfpor_vl_mai");
        getCpMaster().add(lfpor_vl_mai);
        por_vl_mai.setId("por_vl_mai");
        por_vl_mai.setMaxLength(8);
        getCpMaster().add(por_vl_mai);

        LabelField lfpor_vl_jun = new LabelField("Junho:");
        lfpor_vl_jun.setId("lfpor_vl_jun");
        getCpMaster().add(lfpor_vl_jun);
        por_vl_jun.setId("por_vl_jun");
        por_vl_jun.setMaxLength(8);
        getCpMaster().add(por_vl_jun);

        LabelField lfpor_vl_jul = new LabelField("Julho:");
        lfpor_vl_jul.setId("lfpor_vl_jul");
        getCpMaster().add(lfpor_vl_jul);
        por_vl_jul.setId("por_vl_jul");
        por_vl_jul.setMaxLength(8);
        getCpMaster().add(por_vl_jul);

        LabelField lfpor_vl_ago = new LabelField("Agosto:");
        lfpor_vl_ago.setId("lfpor_vl_ago");
        getCpMaster().add(lfpor_vl_ago);
        por_vl_ago.setId("por_vl_ago");
        por_vl_ago.setMaxLength(8);
        getCpMaster().add(por_vl_ago);

        LabelField lfpor_vl_set = new LabelField("Setembro:");
        lfpor_vl_set.setId("lfpor_vl_set");
        getCpMaster().add(lfpor_vl_set);
        por_vl_set.setId("por_vl_set");
        por_vl_set.setMaxLength(8);
        getCpMaster().add(por_vl_set);

        LabelField lfpor_vl_out = new LabelField("Outubro:");
        lfpor_vl_out.setId("lfpor_vl_out");
        getCpMaster().add(lfpor_vl_out);
        por_vl_out.setId("por_vl_out");
        por_vl_out.setMaxLength(8);
        getCpMaster().add(por_vl_out);

        LabelField lfpor_vl_nov = new LabelField("Novembro:");
        lfpor_vl_nov.setId("lfpor_vl_nov");
        getCpMaster().add(lfpor_vl_nov);
        por_vl_nov.setId("por_vl_nov");
        por_vl_nov.setMaxLength(8);
        getCpMaster().add(por_vl_nov);

        LabelField lfpor_vl_dez = new LabelField("Dezembro:");
        lfpor_vl_dez.setId("lfpor_vl_dez");
        getCpMaster().add(lfpor_vl_dez);
        por_vl_dez.setId("por_vl_dez");
        por_vl_dez.setMaxLength(8);
        getCpMaster().add(por_vl_dez);

        povoaConta();

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

    public boolean valide() {
        return true;
    }

    public void setValueObjetoT() {
        
        por_previsao_orcamentoT.setPor_nr_ano(por_nr_ano.getValue().intValue());
        por_previsao_orcamentoT.setPlc_nr_id(cb_Conta.getValue().getPlc_nr_id());
        por_previsao_orcamentoT.setPor_vl_jan(por_vl_jan.getValue().doubleValue());
        por_previsao_orcamentoT.setPor_vl_fev(por_vl_fev.getValue().doubleValue());
        por_previsao_orcamentoT.setPor_vl_mar(por_vl_mar.getValue().doubleValue());
        por_previsao_orcamentoT.setPor_vl_abr(por_vl_abr.getValue().doubleValue());
        por_previsao_orcamentoT.setPor_vl_mai(por_vl_mai.getValue().doubleValue());
        por_previsao_orcamentoT.setPor_vl_jun(por_vl_jun.getValue().doubleValue());
        por_previsao_orcamentoT.setPor_vl_jul(por_vl_jul.getValue().doubleValue());
        por_previsao_orcamentoT.setPor_vl_ago(por_vl_ago.getValue().doubleValue());
        por_previsao_orcamentoT.setPor_vl_set(por_vl_set.getValue().doubleValue());
        por_previsao_orcamentoT.setPor_vl_out(por_vl_out.getValue().doubleValue());
        por_previsao_orcamentoT.setPor_vl_nov(por_vl_nov.getValue().doubleValue());
        por_previsao_orcamentoT.setPor_vl_dez(por_vl_dez.getValue().doubleValue());

    }

    public void btnInsertAction(ButtonEvent ce) {
        if (valide()) {
            por_previsao_orcamentoT = new Por_previsao_orcamentoT();
            setValueObjetoT();
            
            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    btnClearAction(null);
                    if (por_previsao_orcamentoConsult != null) {
                        por_previsao_orcamentoConsult.load();
                    }
                    setVisible(false);
                    cb_Conta.focus();
                }
            };

            Por_previsao_orcamentoServiceAsync por_previsao_orcamentoAsync = GWT.create(Por_previsao_orcamentoService.class);
            por_previsao_orcamentoAsync.insert(por_previsao_orcamentoT, callback);

        }
    }

    public void btnClearAction(ButtonEvent ce) {
        por_nr_id.setValue("");
        cb_Conta.setValue(null);
        por_vl_jan.setValue(null);
        por_vl_fev.setValue(null);
        por_vl_mar.setValue(null);
        por_vl_abr.setValue(null);
        por_vl_mai.setValue(null);
        por_vl_jun.setValue(null);
        por_vl_jul.setValue(null);
        por_vl_ago.setValue(null);
        por_vl_set.setValue(null);
        por_vl_out.setValue(null);
        por_vl_nov.setValue(null);
        por_vl_dez.setValue(null);

    }

    /**
     * @return the por_previsao_orcamentoConsult
     */
    public Por_previsao_orcamentoConsultGWT getPor_previsao_orcamentoConsult() {
        return por_previsao_orcamentoConsult;
    }

    /**
     * @param por_previsao_orcamentoConsult the por_previsao_orcamentoConsult to
     * set
     */
    public void setPor_previsao_orcamentoConsult(Por_previsao_orcamentoConsultGWT por_previsao_orcamentoConsult) {
        this.por_previsao_orcamentoConsult = por_previsao_orcamentoConsult;
    }
}
