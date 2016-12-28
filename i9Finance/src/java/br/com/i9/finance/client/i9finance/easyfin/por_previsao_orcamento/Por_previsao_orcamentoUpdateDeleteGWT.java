package br.com.i9.finance.client.i9finance.easyfin.por_previsao_orcamento;

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

/**
 *
 * @author geoleite
 */
public class Por_previsao_orcamentoUpdateDeleteGWT extends Por_previsao_orcamentoInsertGWT {

    public Por_previsao_orcamentoUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar previsão orcamentária");
    }

    public void load(final Por_previsao_orcamentoT por_previsao_orcamentoT) {
        this.por_previsao_orcamentoT = por_previsao_orcamentoT;
        por_nr_id.setValue(por_previsao_orcamentoT.getPor_nr_id() + "");
        por_nr_ano.setValue(por_previsao_orcamentoT.getPor_nr_ano());
        plc_nr_id.setValue(por_previsao_orcamentoT.getPlc_nr_id());
        por_vl_jan.setValue(por_previsao_orcamentoT.getPor_vl_jan());
        por_vl_fev.setValue(por_previsao_orcamentoT.getPor_vl_fev());
        por_vl_mar.setValue(por_previsao_orcamentoT.getPor_vl_mar());
        por_vl_abr.setValue(por_previsao_orcamentoT.getPor_vl_abr());
        por_vl_mai.setValue(por_previsao_orcamentoT.getPor_vl_mai());
        por_vl_jun.setValue(por_previsao_orcamentoT.getPor_vl_jun());
        por_vl_jul.setValue(por_previsao_orcamentoT.getPor_vl_jul());
        por_vl_ago.setValue(por_previsao_orcamentoT.getPor_vl_ago());
        por_vl_set.setValue(por_previsao_orcamentoT.getPor_vl_set());
        por_vl_out.setValue(por_previsao_orcamentoT.getPor_vl_out());
        por_vl_nov.setValue(por_previsao_orcamentoT.getPor_vl_nov());
        por_vl_dez.setValue(por_previsao_orcamentoT.getPor_vl_dez());
                Timer timer = new Timer() {
                    @Override
                    public void run() {
                        if (cb_Conta.getStore() == null) {
                            schedule(300);
                        } else {
                            cb_Conta.setValue(cb_Conta.getStore().findModel("plc_nr_id", por_previsao_orcamentoT.getPlc_nr_id()));
                        }
                    }
                };
                timer.schedule(10);
                

    }

    public void btnUpdateAction(ButtonEvent ce) {
        if (valide()) {
            setValueObjetoT();
            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    if (por_previsao_orcamentoConsult != null) {
                        por_previsao_orcamentoConsult.load();
                    }
                    setVisible(false);
                }
            };

            Por_previsao_orcamentoServiceAsync por_previsao_orcamentoAsync = GWT.create(Por_previsao_orcamentoService.class);
            por_previsao_orcamentoAsync.update(por_previsao_orcamentoT, callback);
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
                            if (por_previsao_orcamentoConsult != null) {
                                por_previsao_orcamentoConsult.load();
                            }
                            setVisible(false);
                        }
                    };

                    Por_previsao_orcamentoServiceAsync por_previsao_orcamentoAsync = GWT.create(Por_previsao_orcamentoService.class);
                    por_previsao_orcamentoAsync.delete(por_previsao_orcamentoT, callback);
                }
            }
        });
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
