package br.com.i9.finance.client.i9finance.easyfin.ctp_conta_pagar;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.Dialog;

import br.com.i9.finance.client.i9finance.easyfin.service.*;
import com.extjs.gxt.ui.client.widget.Layout;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class Ctp_conta_pagarUpdateDeleteGWT extends Ctp_conta_pagarInsertGWT {

    private V_conta_pagarT v_conta_pagarT;

    public Ctp_conta_pagarUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Ctp_conta_pagar");
    }

    public void load(final V_conta_pagarT v_conta_pagarT) {
        this.v_conta_pagarT = v_conta_pagarT;

        AsyncCallback<Ctp_conta_pagarT> callback = new AsyncCallback<Ctp_conta_pagarT>() {

            @Override
            public void onFailure(Throwable caught) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onSuccess(Ctp_conta_pagarT result) {

                ctp_conta_pagarT = result;
                ctp_nr_id.setValue(ctp_conta_pagarT.getCtp_nr_id() + "");
                ctp_nr_doc.setValue(ctp_conta_pagarT.getCtp_nr_doc());
                ctp_dt_emissao.setValue(ctp_conta_pagarT.getCtp_dt_emissao());
                ctp_dt_vencimento.setValue(ctp_conta_pagarT.getCtp_dt_vencimento());
                ctp_tx_pago.setValue(ctp_conta_pagarT.getCtp_tx_pago());
                ban_nr_id.setValue(ctp_conta_pagarT.getBan_nr_id() + "");
                ctp_valor.setValue(ctp_conta_pagarT.getCtp_valor());
                ctp_tx_parcela.setValue(ctp_conta_pagarT.getCtp_tx_parcela());
                ctp_dt_pagamento.setValue(ctp_conta_pagarT.getCtp_dt_pagamento());
                car_nr_id.setValue(ctp_conta_pagarT.getCar_nr_id() + "");
                ctp_vl_pago.setValue(ctp_conta_pagarT.getCtp_vl_pago() + "");
                ctp_saldo.setValue(ctp_conta_pagarT.getCtp_saldo() + "");
                for_nr_id.setValue(ctp_conta_pagarT.getFor_nr_id() + "");
                fop_nr_id.setValue(ctp_conta_pagarT.getFop_nr_id() + "");
                loj_nr_id.setValue(ctp_conta_pagarT.getLoj_nr_id() + "");
                ctp_tx_obs.setValue(ctp_conta_pagarT.getCtp_tx_obs());
                ctp_tx_tipo_vinculo.setValue(ctp_conta_pagarT.getCtp_tx_tipo_vinculo());
                ctp_nr_id_vinculo.setValue(ctp_conta_pagarT.getCtp_nr_id_vinculo() + "");
                
                gridConta.getStore().add(ctp_conta_pagarT.getList());
                gridConta.getView().refresh(true);
                Timer timer = new Timer() {
                    @Override
                    public void run() {
                        if (cb_Conta.getStore() == null) {
                            schedule(300);
                        } else {
                            cb_Conta.setValue(cb_Conta.getStore().findModel("plc_nr_id", ctp_conta_pagarT.getList().get(0).getPlc_nr_id()));
                        }
                    }
                    
                };
                timer.schedule(10);

                timer = new Timer() {

                    @Override
                    public void run() {
                        if (cb_Forma.getStore() == null) {
                            schedule(300);
                        } else {
                            cb_Forma.setValue(cb_Forma.getStore().findModel("fop_nr_id", ctp_conta_pagarT.getFop_nr_id()));
                            cb_Forma.getListView().refresh();
                        }
                    }
                };
                timer.schedule(20);

                timer = new Timer() {

                    @Override
                    public void run() {
                        if (cb_fornec.getStore() == null) {
                            schedule(300);
                        } else {
                            cb_fornec.setValue(cb_fornec.getStore().findModel("for_nr_id", ctp_conta_pagarT.getFor_nr_id()));
                            cb_fornec.getListView().refresh();
                        }
                    }
                };
                timer.schedule(20);

                if (getSomaContaAdd() > 0) {
                    containerConta.setEnabled(false);
                    //ctp_valor.setReadOnly(true);
                    
                }
                
                if (v_conta_pagarT.getPago().equalsIgnoreCase("T")) {
                    getCpMaster().setEnabled(false);
                }
                getCpMaster().layout();
                gridConta.getView().refresh(true);

            }
            
        };
        Ctp_conta_pagarT ctpT = new Ctp_conta_pagarT();
        ctpT.setCtp_nr_id(v_conta_pagarT.getCtp_nr_id());

        Ctp_conta_pagarServiceAsync serviceAsync = GWT.create(Ctp_conta_pagarService.class);
        serviceAsync.findById(ctpT, callback);

    }

    public double ValideValue() {
        return ctp_valor.getValueMoney() - v_conta_pagarT.getVl_pago();
    }

    public void btnUpdateAction(ButtonEvent ce) {
        if (valide()) {
            if (ValideValue() > 0) {

                setValueObjetoT();

                AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                    public void onFailure(Throwable caught) {
                        MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                    }

                    public void onSuccess(Void result) {
                        Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                        if (v_conta_pagarConsultGWT != null) {
                            v_conta_pagarConsultGWT.load();
                        }
                        setVisible(false);
                    }
                };

                Ctp_conta_pagarServiceAsync ctp_conta_pagarAsync = GWT.create(Ctp_conta_pagarService.class);
                ctp_conta_pagarAsync.update(ctp_conta_pagarT, callback);
            }else{
                MessageBox.alert("ATENÇÃO", "O valor não pode ser menor que o valor já pago!", null);
            }
        }
    }

    private boolean valideDelete() {
        return this.v_conta_pagarT.getVl_pago() == 0;
    }

    public void btnDeleteAction(ButtonEvent ce) {

        if (valideDelete()) {
            MessageBox.confirm(EASY_LABELS.warning(), EASY_LABELS.messageDeleteConfirm(), new Listener<MessageBoxEvent>() {

                public void handleEvent(MessageBoxEvent be) {

                    if (new Dialog().yesText.equalsIgnoreCase(be.getButtonClicked().getText())) {

                        AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                            public void onFailure(Throwable caught) {
                                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                            }

                            public void onSuccess(Void result) {
                                Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                                if (v_conta_pagarConsultGWT != null) {
                                    v_conta_pagarConsultGWT.load();
                                }
                                setVisible(false);
                            }
                        };

                        Ctp_conta_pagarServiceAsync ctp_conta_pagarAsync = GWT.create(Ctp_conta_pagarService.class);
                        ctp_conta_pagarAsync.delete(ctp_conta_pagarT, callback);
                    }
                }
            });
        } else {
            MessageBox.alert("ATENÇÃO", "já existe pagamento(s) vinculado a este item!", null);
        }
    }

}
