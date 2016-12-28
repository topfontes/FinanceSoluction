package br.com.i9.finance.client.i9finance.easyfin.lan_lancamento;

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
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class Lan_lancamentoUpdateDeleteGWT extends Lan_lancamentoInsertGWT {
    private Lan_lancamentoT lan_lancamentoTUpdate;

    public Lan_lancamentoUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Lançamento");
    }

    public void load(V_lancamentosT V_lancamentosT) {
        Lan_lancamentoT lanT = new Lan_lancamentoT();
        lanT.setLan_nr_id(V_lancamentosT.getLan_nr_id());
        AsyncCallback<Lan_lancamentoT> callback = new AsyncCallback<Lan_lancamentoT>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(Lan_lancamentoT result) {
                //lan_lancamentoTUpdate = new Lan_lancamentoT();
                lan_lancamentoTUpdate = result;
                lan_nr_id.setValue(lan_lancamentoTUpdate.getLan_nr_id() + "");
                ctr_nr_id.setValue(lan_lancamentoTUpdate.getCtr_nr_id() + "");
                ctp_nr_id.setValue(lan_lancamentoTUpdate.getCtp_nr_id() + "");
                lan_plc_nr_id_deb.setValue(lan_lancamentoTUpdate.getLan_plc_nr_id_deb() + "");
                lan_plc_nr_id_cred.setValue(lan_lancamentoTUpdate.getLan_plc_nr_id_cred() + "");
                lan_dt_lancamento.setValue(lan_lancamentoTUpdate.getLan_dt_lancamento());
                lan_tx_historico.setValue(lan_lancamentoTUpdate.getLan_tx_historico());
                lan_valor.setValue(lan_lancamentoTUpdate.getLan_valor());
                loj_nr_id.setValue(lan_lancamentoTUpdate.getLoj_nr_id() + "");
                lan_nr_id_super.setValue(lan_lancamentoTUpdate.getLan_nr_id_super() + "");
                Timer timer = new Timer() {

                    @Override
                    public void run() {
                        if (cb_conta_cred.getStore() == null) {
                            schedule(300);
                        } else {
                            cb_conta_cred.setValue(cb_conta_cred.getStore().findModel("plc_nr_id", lan_lancamentoTUpdate.getLan_plc_nr_id_cred()));
                            cb_conta_deb.setValue(cb_conta_deb.getStore().findModel("plc_nr_id", lan_lancamentoTUpdate.getLan_plc_nr_id_deb()));
                        }
                    }
                };
                timer.schedule(10);
            }
        };

        Lan_lancamentoServiceAsync lan_lancamentoAsync = GWT.create(Lan_lancamentoService.class);
        lan_lancamentoAsync.findById(lanT, callback);
    }

    public void btnUpdateAction(ButtonEvent ce) {
        if (valide()) {
            setValueObjetoT(lan_lancamentoTUpdate);

            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    if (v_lancamentosConsultGWT != null) {
                        v_lancamentosConsultGWT.load();
                    }
                    setVisible(false);
                }
            };

            Lan_lancamentoServiceAsync lan_lancamentoAsync = GWT.create(Lan_lancamentoService.class);
            lan_lancamentoAsync.update(lan_lancamentoTUpdate, callback);
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
                            if (v_lancamentosConsultGWT != null) {
                                v_lancamentosConsultGWT.load();
                            }
                            setVisible(false);
                        }
                    };

                    Lan_lancamentoServiceAsync lan_lancamentoAsync = GWT.create(Lan_lancamentoService.class);
                    lan_lancamentoAsync.delete(lan_lancamentoTUpdate, callback);
                }
            }
        });
    }

}
