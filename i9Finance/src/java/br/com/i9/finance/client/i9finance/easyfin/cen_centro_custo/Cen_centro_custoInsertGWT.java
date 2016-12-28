/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.cen_centro_custo;

import br.com.i9.finance.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.CRUDBaseGWT;

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

/**
 *
 * @author EasyNet
 */
public class Cen_centro_custoInsertGWT extends CRUDBaseGWT {

    protected Cen_centro_custoConsultGWT cen_centro_custoConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> cen_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> cen_tx_status = new EasyTextField<String>();
    protected EasyTextField<String> cen_tx_nome = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();

    public Cen_centro_custoInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
        setHeading("Cadastrar Centro de custo");
        this.setSize("500", "400");
        TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

        LabelField lfcen_tx_nome = new LabelField("Centro custo:");
        lfcen_tx_nome.setId("lfcen_tx_nome");
        getCpMaster().add(lfcen_tx_nome);
        cen_tx_nome.setId("cen_tx_nome");
        cen_tx_nome.setMaxLength(50);
        getCpMaster().add(cen_tx_nome);

        LabelField lfloj_nr_id = new LabelField("loj_nr_id:");
        lfloj_nr_id.setId("lfloj_nr_id");
        getCpMaster().add(lfloj_nr_id);
        loj_nr_id.setId("loj_nr_id");
        loj_nr_id.setMaxLength(10);
        getCpMaster().add(loj_nr_id);

    }

    public boolean valide() {
        return true;
    }

    public void btnInsertAction(ButtonEvent ce) {
        if (valide()) {
            Cen_centro_custoT cen_centro_custoT = new Cen_centro_custoT();
            cen_centro_custoT.setCen_tx_status("A");
            cen_centro_custoT.setCen_tx_nome(cen_tx_nome.getValue());

            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    btnClearAction(null);
                    if (cen_centro_custoConsult != null) {
                        cen_centro_custoConsult.load();
                    }
                    setVisible(false);
                }
            };

            Cen_centro_custoServiceAsync cen_centro_custoAsync = GWT.create(Cen_centro_custoService.class);
            cen_centro_custoAsync.insert(cen_centro_custoT, callback);

        }
    }

    public void btnClearAction(ButtonEvent ce) {
        cen_nr_id.setValue("");
        cen_tx_status.setValue("");
        cen_tx_nome.setValue("");
        loj_nr_id.setValue("");

    }

    /**
     * @return the cen_centro_custoConsult
     */
    public Cen_centro_custoConsultGWT getCen_centro_custoConsult() {
        return cen_centro_custoConsult;
    }

    /**
     * @param cen_centro_custoConsult the cen_centro_custoConsult to set
     */
    public void setCen_centro_custoConsult(Cen_centro_custoConsultGWT cen_centro_custoConsult) {
        this.cen_centro_custoConsult = cen_centro_custoConsult;
    }
}
