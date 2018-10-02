/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.ccp_conta_ct_pagar;

import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.CRUDBaseGWT;

import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import br.com.i9.finance.client.i9finance.easyfin.service.*;

/**
 *
 * @author EasyNet
 */
public class Ccp_conta_ct_pagarInsertGWT extends CRUDBaseGWT {

    protected Ccp_conta_ct_pagarConsultGWT ccp_conta_ct_pagarConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> ccp_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> ctp_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> plc_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> ccp_valor = new EasyTextField<String>();

    public Ccp_conta_ct_pagarInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
        setHeading("Cadastrar Ccp_conta_ct_pagar");
        this.setSize("500", "400");
        TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

        LabelField lfccp_nr_id = new LabelField("ccp_nr_id:");
        lfccp_nr_id.setId("lfccp_nr_id");
        getCpMaster().add(lfccp_nr_id);
        ccp_nr_id.setId("ccp_nr_id");
        ccp_nr_id.setMaxLength(10);
        getCpMaster().add(ccp_nr_id);

        LabelField lfctp_nr_id = new LabelField("ctp_nr_id:");
        lfctp_nr_id.setId("lfctp_nr_id");
        getCpMaster().add(lfctp_nr_id);
        ctp_nr_id.setId("ctp_nr_id");
        ctp_nr_id.setMaxLength(10);
        getCpMaster().add(ctp_nr_id);

        LabelField lfplc_nr_id = new LabelField("plc_nr_id:");
        lfplc_nr_id.setId("lfplc_nr_id");
        getCpMaster().add(lfplc_nr_id);
        plc_nr_id.setId("plc_nr_id");
        plc_nr_id.setMaxLength(10);
        getCpMaster().add(plc_nr_id);

        LabelField lfccp_valor = new LabelField("ccp_valor:");
        lfccp_valor.setId("lfccp_valor");
        getCpMaster().add(lfccp_valor);
        ccp_valor.setId("ccp_valor");
        ccp_valor.setMaxLength(8);
        getCpMaster().add(ccp_valor);

    }

    public boolean valide() {
        return true;
    }

    public void btnInsertAction(ButtonEvent ce) {
        if (valide()) {
            Ccp_conta_ct_pagarT ccp_conta_ct_pagarT = new Ccp_conta_ct_pagarT();
            ccp_conta_ct_pagarT.setCcp_nr_id(Integer.parseInt(ccp_nr_id.getValue()));
            ccp_conta_ct_pagarT.setCtp_nr_id(Integer.parseInt(ctp_nr_id.getValue()));
            ccp_conta_ct_pagarT.setPlc_nr_id(Integer.parseInt(plc_nr_id.getValue()));
            ccp_conta_ct_pagarT.setCcp_valor(Double.parseDouble(ccp_valor.getValue()));

            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    btnClearAction(null);
                    if (ccp_conta_ct_pagarConsult != null) {
                        ccp_conta_ct_pagarConsult.load();
                    }
                    setVisible(false);
                }
            };
            Ccp_conta_ct_pagarServiceAsync ccp_conta_ct_pagarAsync = GWT.create(Ccp_conta_ct_pagarService.class);
            ccp_conta_ct_pagarAsync.insert(ccp_conta_ct_pagarT, callback);
        }
    }

    public void btnClearAction(ButtonEvent ce) {
        ccp_nr_id.setValue("");
        ctp_nr_id.setValue("");
        plc_nr_id.setValue("");
        ccp_valor.setValue("");

    }

    /**
     * @return the ccp_conta_ct_pagarConsult
     */
    public Ccp_conta_ct_pagarConsultGWT getCcp_conta_ct_pagarConsult() {
        return ccp_conta_ct_pagarConsult;
    }

    /**
     * @param ccp_conta_ct_pagarConsult the ccp_conta_ct_pagarConsult to set
     */
    public void setCcp_conta_ct_pagarConsult(Ccp_conta_ct_pagarConsultGWT ccp_conta_ct_pagarConsult) {
        this.ccp_conta_ct_pagarConsult = ccp_conta_ct_pagarConsult;
    }
}
