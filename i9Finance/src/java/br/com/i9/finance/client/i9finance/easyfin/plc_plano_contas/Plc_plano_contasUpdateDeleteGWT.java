package br.com.i9.finance.client.i9finance.easyfin.plc_plano_contas;

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
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Plc_plano_contasUpdateDeleteGWT extends Plc_plano_contasInsertGWT {

    public Plc_plano_contasUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Plano de contas");
        getCpMaster().add(new LabelField("Status"));
        getCpMaster().add(plc_tx_status);

    }

    public void load(Plc_plano_contasT plc_plano_contasT) {

        AsyncCallback<Plc_plano_contasT> callback = new AsyncCallback<Plc_plano_contasT>() {

            @Override
            public void onFailure(Throwable caught) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onSuccess(Plc_plano_contasT result) {
                setFieldObjetoLoad(result);
            }
        };
        Plc_plano_contasServiceAsync serviceAsync = GWT.create(Plc_plano_contasService.class);
        serviceAsync.findById(plc_plano_contasT, callback);

    }

    public void setFieldObjetoLoad(final Plc_plano_contasT plc_plano_contasT) {
        this.plc_plano_contasT = plc_plano_contasT;
        plc_nr_id_super.setValue(plc_plano_contasT.getPlc_nr_id_super() + "");
        plc_nr_nivel.setValue(plc_plano_contasT.getPlc_nr_nivel() + "");
        plc_tx_nome.setValue(plc_plano_contasT.getPlc_tx_nome());
        plc_tx_banco.setValue(plc_plano_contasT.getPlc_tx_banco().equalsIgnoreCase("T") ? true : false);
        cb_tipo_conta.setValue(cb_tipo_conta.getStore().findModel("tipo", plc_plano_contasT.getPlc_tx_tipo()));
        plc_tx_centro_custo.setValue(plc_plano_contasT.getPlc_tx_centro_custo());
        plc_nr_reduzido.setValue(plc_plano_contasT.getPlc_nr_reduzido() + "");
        plc_tx_status.setValue(plc_plano_contasT.getPlc_tx_status().equalsIgnoreCase("A") ? rdAtivo : rdInativo);
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (cb_Conta.getStore() == null) {
                    schedule(300);
                } else {
                    cb_Conta.setValue(cb_Conta.getStore().findModel("plc_nr_id", plc_plano_contasT.getPlc_nr_id_super()));
                }
            }
        };
        timer.schedule(10);
    }

    public void btnUpdateAction(ButtonEvent ce) {
        if (valide()) {
            setValueObjetoT();
            plc_plano_contasT.setPlc_tx_status(plc_tx_status.getValue() == rdAtivo ? "A" : "I");

            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    if (plc_plano_contasConsult != null) {
                        plc_plano_contasConsult.load();
                    }
                    setVisible(false);
                }
            };

            Plc_plano_contasServiceAsync plc_plano_contasAsync = GWT.create(Plc_plano_contasService.class);
            plc_plano_contasAsync.update(plc_plano_contasT, callback);
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
                            if (plc_plano_contasConsult != null) {
                                plc_plano_contasConsult.load();
                            }
                            setVisible(false);
                        }
                    };

                    Plc_plano_contasServiceAsync plc_plano_contasAsync = GWT.create(Plc_plano_contasService.class);
                    plc_plano_contasAsync.delete(plc_plano_contasT, callback);
                }
            }
        });
    }

    /**
     * @return the plc_plano_contasConsult
     */
    public Plc_plano_contasConsultGWT getPlc_plano_contasConsult() {
        return plc_plano_contasConsult;
    }

    /**
     * @param plc_plano_contasConsult the plc_plano_contasConsult to set
     */
    public void setPlc_plano_contasConsult(Plc_plano_contasConsultGWT plc_plano_contasConsult) {
        this.plc_plano_contasConsult = plc_plano_contasConsult;
    }

}
