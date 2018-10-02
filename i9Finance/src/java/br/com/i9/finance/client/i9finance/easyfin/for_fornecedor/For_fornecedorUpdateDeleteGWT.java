package br.com.i9.finance.client.i9finance.easyfin.for_fornecedor;

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
public class For_fornecedorUpdateDeleteGWT extends For_fornecedorInsertGWT {

    private For_fornecedorT for_fornecedorT;

    public For_fornecedorUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar For_fornecedor");
    }

    public void load(For_fornecedorT for_fornecedorT) {
        this.for_fornecedorT = for_fornecedorT;
        for_nr_id.setValue(for_fornecedorT.getFor_nr_id() + "");
        for_tx_endereco.setValue(for_fornecedorT.getFor_tx_endereco());
        for_tx_home_page.setValue(for_fornecedorT.getFor_tx_home_page());
        for_tx_contato.setValue(for_fornecedorT.getFor_tx_contato());
        for_tx_cpf_cnpj.setValue(for_fornecedorT.getFor_tx_cpf_cnpj());
        for_tx_email.setValue(for_fornecedorT.getFor_tx_email());
        for_tx_rg_inscricao.setValue(for_fornecedorT.getFor_tx_rg_inscricao());
        for_tx_cep.setValue(for_fornecedorT.getFor_tx_cep());
        for_tx_cidade.setValue(for_fornecedorT.getFor_tx_cidade());
        for_tx_estado.setValue(for_fornecedorT.getFor_tx_estado());
        for_tx_bairro.setValue(for_fornecedorT.getFor_tx_bairro());
        for_tx_nome.setValue(for_fornecedorT.getFor_tx_nome());
        for_tx_status.setValue(for_fornecedorT.getFor_tx_status());
        loj_nr_id.setValue(for_fornecedorT.getLoj_nr_id() + "");

    }

    public void btnUpdateAction(ButtonEvent ce) {
        if (valide()) {
            for_fornecedorT.setFor_nr_id(Integer.parseInt(for_nr_id.getValue()));
            for_fornecedorT.setFor_tx_endereco(for_tx_endereco.getValue());
            for_fornecedorT.setFor_tx_home_page(for_tx_home_page.getValue());
            for_fornecedorT.setFor_tx_contato(for_tx_contato.getValue());
            for_fornecedorT.setFor_tx_cpf_cnpj(for_tx_cpf_cnpj.getValue());
            for_fornecedorT.setFor_tx_email(for_tx_email.getValue());
            for_fornecedorT.setFor_tx_rg_inscricao(for_tx_rg_inscricao.getValue());
            for_fornecedorT.setFor_tx_cep(for_tx_cep.getValue().intValue());
            for_fornecedorT.setFor_tx_cidade(for_tx_cidade.getValue());
            for_fornecedorT.setFor_tx_estado(for_tx_estado.getValue());
            for_fornecedorT.setFor_tx_bairro(for_tx_bairro.getValue());
            for_fornecedorT.setFor_tx_nome(for_tx_nome.getValue());
            for_fornecedorT.setFor_tx_status(for_tx_status.getValue());
            for_fornecedorT.setLoj_nr_id(Integer.parseInt(loj_nr_id.getValue()));

            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    if (for_fornecedorConsult != null) {
                        for_fornecedorConsult.load();
                    }
                    setVisible(false);
                }
            };

            For_fornecedorServiceAsync for_fornecedorAsync = GWT.create(For_fornecedorService.class);
            for_fornecedorAsync.update(for_fornecedorT, callback);
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
                            if (for_fornecedorConsult != null) {
                                for_fornecedorConsult.load();
                            }
                            setVisible(false);
                        }
                    };

                    For_fornecedorServiceAsync for_fornecedorAsync = GWT.create(For_fornecedorService.class);
                    for_fornecedorAsync.delete(for_fornecedorT, callback);
                }
            }
        });
    }

    /**
     * @return the for_fornecedorConsult
     */
    public For_fornecedorConsultGWT getFor_fornecedorConsult() {
        return for_fornecedorConsult;
    }

    /**
     * @param for_fornecedorConsult the for_fornecedorConsult to set
     */
    public void setFor_fornecedorConsult(For_fornecedorConsultGWT for_fornecedorConsult) {
        this.for_fornecedorConsult = for_fornecedorConsult;
    }

}
