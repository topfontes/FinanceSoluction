package br.com.i9.finance.client.i9finance.easyfin.ctr_conta_recebe;

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
public class Ctr_conta_recebeUpdateDeleteGWT extends Ctr_conta_recebeInsertGWT {

    public Ctr_conta_recebeUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Ctr_conta_recebe");
    }

    public void load(V_conta_receberT v_conta_receberT) {

        AsyncCallback<Ctr_conta_recebeT> claCallback = new AsyncCallback<Ctr_conta_recebeT>() {

            @Override
            public void onFailure(Throwable caught) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onSuccess(Ctr_conta_recebeT result) {
                ctr_conta_recebeT = result;
                ctr_nr_id.setValue(ctr_conta_recebeT.getCtr_nr_id() + "");
                //cli_nr_id.setValue(ctr_conta_recebeT.getCli_nr_id() + "");
                ctr_nr_doc.setValue(ctr_conta_recebeT.getCtr_nr_doc() + "");
                ctr_dt_emissao.setValue(ctr_conta_recebeT.getCtr_dt_emissao());
                ctr_dt_vencimento.setValue(ctr_conta_recebeT.getCtr_dt_vencimento());
                //fop_nr_id.setValue(ctr_conta_recebeT.getFop_nr_id() + "");
                ctr_tx_pago.setValue(ctr_conta_recebeT.getCtr_tx_pago());
                //ban_nr_id.setValue(ctr_conta_recebeT.getBan_nr_id() + "");
                ctr_valor.setValue(ctr_conta_recebeT.getCtr_valor());
                ctr_tx_parcela.setValue(ctr_conta_recebeT.getCtr_tx_parcela());
                ctr_dt_pagamento.setValue(ctr_conta_recebeT.getCtr_dt_pagamento());
                car_nr_id.setValue(ctr_conta_recebeT.getCar_nr_id() + "");

                ctr_saldo.setValue(ctr_conta_recebeT.getCtr_saldo() + "");
                ctr_tx_obs.setValue(ctr_conta_recebeT.getCtr_tx_obs());
//                ctr_tx_tipo_vinculo.setValue(ctr_conta_recebeT.getCtr_tx_tipo_vinculo());
//                ctr_nr_id_vinculo.setValue(ctr_conta_recebeT.getCtr_nr_id_vinculo() + "");
                Timer timer = new Timer() {

                    @Override
                    public void run() {
                        if (cb_Forma.getStore() == null) {
                            schedule(300);
                        } else {
                            cb_Forma.setValue(cb_Forma.getStore().findModel("fop_nr_id", ctr_conta_recebeT.getFop_nr_id()));
                        }
                    }
                };
                timer.schedule(10);

                timer = new Timer() {

                    @Override
                    public void run() {
                        if (cb_cliente.getStore() == null) {
                            schedule(300);
                        } else {
                            cb_cliente.setValue(cb_cliente.getStore().findModel("cli_nr_id", ctr_conta_recebeT.getCli_nr_id()));
                        }

                    }
                };
                timer.schedule(10);

                timer = new Timer() {

                    @Override
                    public void run() {
                        if (cb_Conta.getStore() == null) {
                            schedule(300);
                        } else {
                            cb_Conta.setValue(cb_Conta.getStore().findModel("plc_nr_id", ctr_conta_recebeT.getListContas().get(0).getPlc_nr_id()));
                        }
                    }
                };
                timer.schedule(20);

            }
        };
        Ctr_conta_recebeT ct = new Ctr_conta_recebeT();
        ct.setCtr_nr_id(v_conta_receberT.getCtr_nr_id());
        Ctr_conta_recebeServiceAsync serviceAsync = GWT.create(Ctr_conta_recebeService.class);
        serviceAsync.findById(ct, claCallback);
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
                    if (v_conta_receberConsultGWT != null) {
                        v_conta_receberConsultGWT.load();
                    }
                    setVisible(false);
                }
            };

            Ctr_conta_recebeServiceAsync ctr_conta_recebeAsync = GWT.create(Ctr_conta_recebeService.class);
            ctr_conta_recebeAsync.update(ctr_conta_recebeT, callback);
        }
    }

    public void btnDeleteAction(ButtonEvent ce) {

        MessageBox.confirm(EASY_LABELS.warning(), EASY_LABELS.messageDeleteConfirm(), new Listener<MessageBoxEvent>() {

            public void handleEvent(MessageBoxEvent be) {

                if (new Dialog().yesText.equalsIgnoreCase(be.getButtonClicked().getText())) {

                    AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                        public void onFailure(Throwable caught) {
                            MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                        }

                        public void onSuccess(Void result) {
                            Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                            if (v_conta_receberConsultGWT != null) {
                                v_conta_receberConsultGWT.load();
                            }
                            setVisible(false);
                        }
                    };

                    Ctr_conta_recebeServiceAsync ctr_conta_recebeAsync = GWT.create(Ctr_conta_recebeService.class);
                    ctr_conta_recebeAsync.delete(ctr_conta_recebeT, callback);
                }
            }
        });
    }

}
