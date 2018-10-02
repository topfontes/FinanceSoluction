package br.com.i9.finance.client.i9finance.easyfin.cli_cliente;

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
public class Cli_clienteUpdateDeleteGWT extends Cli_clienteInsertGWT {

    private Cli_clienteT cli_clienteT;

    public Cli_clienteUpdateDeleteGWT() {
        getBtnClear().setVisible(false);
        getBtnInsert().setVisible(false);
        getBtnUpdate().setVisible(true);
        getBtnDelete().setVisible(true);

        setHeading("Alterar Cli_cliente");
    }

    public void load(Cli_clienteT cli_clienteT) {
        this.cli_clienteT = cli_clienteT;
        cli_nr_id.setValue(cli_clienteT.getCli_nr_id() + "");
        cli_tx_nome.setValue(cli_clienteT.getCli_tx_nome());
        cli_tx_endereco.setValue(cli_clienteT.getCli_tx_endereco());
        cli_tx_bairro.setValue(cli_clienteT.getCli_tx_bairro());
        cli_tx_rg_inscricao.setValue(cli_clienteT.getCli_tx_rg_inscricao());
        cli_tx_cidade.setValue(cli_clienteT.getCli_tx_cidade());
        cli_tx_estado.setValue(cli_clienteT.getCli_tx_estado());
        cli_tx_cep.setValue(cli_clienteT.getCli_tx_cep());
        cli_tx_cpf_cnpj.setValue(cli_clienteT.getCli_tx_cpf_cnpj());
        cli_tx_email.setValue(cli_clienteT.getCli_tx_email());
        cli_tx_home_page.setValue(cli_clienteT.getCli_tx_home_page());
        cli_tx_contato.setValue(cli_clienteT.getCli_tx_contato());
        rgStatus.setValue(cli_clienteT.getCli_tx_status().equalsIgnoreCase("A") ? rAtivo : rInativo);

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
                    if (cli_clienteConsult != null) {
                        cli_clienteConsult.load();
                    }
                    setVisible(false);
                }
            };

            Cli_clienteServiceAsync cli_clienteAsync = GWT.create(Cli_clienteService.class);
            cli_clienteAsync.update(cli_clienteT, callback);
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
                            if (cli_clienteConsult != null) {
                                cli_clienteConsult.load();
                            }
                            setVisible(false);
                        }
                    };

                    Cli_clienteServiceAsync cli_clienteAsync = GWT.create(Cli_clienteService.class);
                    cli_clienteAsync.delete(cli_clienteT, callback);
                }
            }
        });
    }

    /**
     * @return the cli_clienteConsult
     */
    public Cli_clienteConsultGWT getCli_clienteConsult() {
        return cli_clienteConsult;
    }

    /**
     * @param cli_clienteConsult the cli_clienteConsult to set
     */
    public void setCli_clienteConsult(Cli_clienteConsultGWT cli_clienteConsult) {
        this.cli_clienteConsult = cli_clienteConsult;
    }

}
