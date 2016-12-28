/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.ban_banco;

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
public class Ban_bancoInsertGWT extends CRUDBaseGWT {

    protected Ban_bancoConsultGWT ban_bancoConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> ban_tx_status = new EasyTextField<String>();
    protected EasyTextField<String> ban_tx_nome = new EasyTextField<String>();
    protected EasyTextField<String> ban_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();

    public Ban_bancoInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
        setHeading("Cadastrar Banco");
        this.setSize("400", "150");
        TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

        LabelField lfban_tx_nome = new LabelField("Nome:");
        lfban_tx_nome.setId("lfban_tx_nome");
        getCpMaster().add(lfban_tx_nome);
        ban_tx_nome.setId("ban_tx_nome");
        ban_tx_nome.setWidth(300);
        ban_tx_nome.setMaxLength(50);
        getCpMaster().add(ban_tx_nome);

    }

    public boolean valide() {
        return true;
    }

    public void btnInsertAction(ButtonEvent ce) {
        if (valide()) {
            Ban_bancoT ban_bancoT = new Ban_bancoT();
            ban_bancoT.setBan_tx_status("A");
            ban_bancoT.setBan_tx_nome(ban_tx_nome.getValue());
             AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    btnClearAction(null);
                    if (ban_bancoConsult != null) {
                        ban_bancoConsult.load();
                    }
                    setVisible(false);
                }
            };

            Ban_bancoServiceAsync ban_bancoAsync = GWT.create(Ban_bancoService.class);
            ban_bancoAsync.insert(ban_bancoT, callback);

        }
    }

    public void btnClearAction(ButtonEvent ce) {
        ban_tx_status.setValue("");
        ban_tx_nome.setValue("");
        ban_nr_id.setValue("");
        loj_nr_id.setValue("");

    }

    /**
     * @return the ban_bancoConsult
     */
    public Ban_bancoConsultGWT getBan_bancoConsult() {
        return ban_bancoConsult;
    }

    /**
     * @param ban_bancoConsult the ban_bancoConsult to set
     */
    public void setBan_bancoConsult(Ban_bancoConsultGWT ban_bancoConsult) {
        this.ban_bancoConsult = ban_bancoConsult;
    }
}
