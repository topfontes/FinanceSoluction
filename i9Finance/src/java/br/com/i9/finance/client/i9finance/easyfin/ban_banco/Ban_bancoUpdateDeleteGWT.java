package br.com.i9.finance.client.i9finance.easyfin.ban_banco;

import br.com.i9.finance.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Timer;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.Dialog;

import br.com.i9.finance.client.i9finance.easyfin.service.*;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;

/**
 *
 * @author geoleite
 */
public class Ban_bancoUpdateDeleteGWT extends Ban_bancoInsertGWT {

    private Ban_bancoT ban_bancoT;
    private RadioGroup rgStatus = new RadioGroup();
    private Radio rdAtivo = new Radio();
    private Radio rdInativo = new Radio();

    public Ban_bancoUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);
        setHeight(180);

        rdAtivo.setBoxLabel("Ativo");
        rdInativo.setBoxLabel("Inativo");
        rgStatus.add(rdAtivo);
        rgStatus.add(rdInativo);
        getCpMaster().add(rgStatus);
        setHeading("Alterar Banco");
    }

    public void load(Ban_bancoT ban_bancoT) {
        this.ban_bancoT = ban_bancoT;
        ban_tx_status.setValue(ban_bancoT.getBan_tx_status());
        ban_tx_nome.setValue(ban_bancoT.getBan_tx_nome());
        ban_nr_id.setValue(ban_bancoT.getBan_nr_id() + "");
        loj_nr_id.setValue(ban_bancoT.getLoj_nr_id() + "");

    }

    public void btnUpdateAction(ButtonEvent ce) {
        if (valide()) {
            ban_bancoT.setBan_tx_status(ban_tx_status.getValue());
            ban_bancoT.setBan_tx_nome(ban_tx_nome.getValue());
            ban_bancoT.setBan_nr_id(Integer.parseInt(ban_nr_id.getValue()));
            ban_bancoT.setLoj_nr_id(Integer.parseInt(loj_nr_id.getValue()));

            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    if (ban_bancoConsult != null) {
                        ban_bancoConsult.load();
                    }
                    setVisible(false);
                }
            };

            Ban_bancoServiceAsync ban_bancoAsync = GWT.create(Ban_bancoService.class);
            ban_bancoAsync.update(ban_bancoT, callback);
        }
    }

    public void btnDeletetAction(ButtonEvent ce) {

        MessageBox.confirm(EASY_LABELS.warning(), EASY_LABELS.messageDeleteConfirm(), new Listener<MessageBoxEvent>() {

            public void handleEvent(MessageBoxEvent be) {

                if (new Dialog().yesText.equalsIgnoreCase(be.getButtonClicked().getText())) {

                    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                        public void onFailure(Throwable caught) {
                            MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                        }

                        public void onSuccess(Void result) {
                            Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                            if (ban_bancoConsult != null) {
                                ban_bancoConsult.load();
                            }
                            setVisible(false);
                        }
                    };

                    Ban_bancoServiceAsync ban_bancoAsync = GWT.create(Ban_bancoService.class);
                    ban_bancoAsync.delete(ban_bancoT, callback);
                }
            }
        });
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
