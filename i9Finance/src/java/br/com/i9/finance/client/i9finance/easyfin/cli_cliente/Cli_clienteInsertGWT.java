/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.cli_cliente;

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
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;

/**
 *
 * @author EasyNet
 */
public class Cli_clienteInsertGWT extends CRUDBaseGWT {

    protected Cli_clienteConsultGWT cli_clienteConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> cli_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> cli_tx_nome = new EasyTextField<String>();
    protected EasyTextField<String> cli_tx_endereco = new EasyTextField<String>();
    protected EasyTextField<String> cli_tx_bairro = new EasyTextField<String>();
    protected EasyTextField<String> cli_tx_rg_inscricao = new EasyTextField<String>();
    protected EasyTextField<String> cli_tx_cidade = new EasyTextField<String>();
    protected EasyTextField<String> cli_tx_estado = new EasyTextField<String>();
    protected NumberField cli_tx_cep = new NumberField();
    protected EasyTextField<String> cli_tx_cpf_cnpj = new EasyTextField<String>();
    protected EasyTextField<String> cli_tx_email = new EasyTextField<String>();
    protected EasyTextField<String> cli_tx_home_page = new EasyTextField<String>();
    protected EasyTextField<String> cli_tx_contato = new EasyTextField<String>();
    protected EasyTextField<String> cli_tx_status = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();
    protected Cli_clienteT cli_clienteT;
    protected RadioGroup rgStatus = new RadioGroup();
    protected Radio rAtivo = new Radio();
    protected Radio rInativo = new Radio();

    public Cli_clienteInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
        setHeading("Cadastrar Cli_cliente");
        this.setSize("500", "500");
        TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

        rgStatus.add(rAtivo);
        rgStatus.add(rInativo);
        rAtivo.setBoxLabel("Ativo");
        rInativo.setBoxLabel("Inativo");
        rgStatus.setValue(rAtivo);
        
        LabelField lfcli_tx_nome = new LabelField("Nome:");
        lfcli_tx_nome.setId("lfcli_tx_nome");
        getCpMaster().add(lfcli_tx_nome);
        cli_tx_nome.setId("cli_tx_nome");
        cli_tx_nome.setMaxLength(100);
        cli_tx_nome.setWidth(Constantes.widthField);
        getCpMaster().add(cli_tx_nome);

        LabelField lfcli_tx_rg_inscricao = new LabelField("Rg:");
        lfcli_tx_rg_inscricao.setId("lfcli_tx_rg_inscricao");
        getCpMaster().add(lfcli_tx_rg_inscricao);
        cli_tx_rg_inscricao.setId("cli_tx_rg_inscricao");
        cli_tx_rg_inscricao.setMaxLength(18);
        getCpMaster().add(cli_tx_rg_inscricao);

        LabelField lfcli_tx_cpf_cnpj = new LabelField("CPF:");
        lfcli_tx_cpf_cnpj.setId("lfcli_tx_cpf_cnpj");
        getCpMaster().add(lfcli_tx_cpf_cnpj);
        cli_tx_cpf_cnpj.setId("cli_tx_cpf_cnpj");
        cli_tx_cpf_cnpj.setMaxLength(14);
        getCpMaster().add(cli_tx_cpf_cnpj);

        LabelField lfcli_tx_endereco = new LabelField("Endereço:");
        lfcli_tx_endereco.setId("lfcli_tx_endereco");
        getCpMaster().add(lfcli_tx_endereco);
        cli_tx_endereco.setId("cli_tx_endereco");
        cli_tx_endereco.setWidth(Constantes.widthField);
        cli_tx_endereco.setMaxLength(100);
        getCpMaster().add(cli_tx_endereco);

        LabelField lfcli_tx_bairro = new LabelField("Bairro:");
        lfcli_tx_bairro.setId("lfcli_tx_bairro");
        getCpMaster().add(lfcli_tx_bairro);
        cli_tx_bairro.setId("cli_tx_bairro");
        cli_tx_bairro.setMaxLength(50);
        cli_tx_bairro.setWidth(Constantes.widthField);
        getCpMaster().add(cli_tx_bairro);

        LabelField lfcli_tx_cidade = new LabelField("Cidade:");
        lfcli_tx_cidade.setId("lfcli_tx_cidade");
        getCpMaster().add(lfcli_tx_cidade);
        cli_tx_cidade.setId("cli_tx_cidade");
        cli_tx_cidade.setWidth(Constantes.widthField);
        cli_tx_cidade.setMaxLength(50);
        getCpMaster().add(cli_tx_cidade);

        LabelField lfcli_tx_estado = new LabelField("Estado:");
        lfcli_tx_estado.setId("lfcli_tx_estado");
        getCpMaster().add(lfcli_tx_estado);
        cli_tx_estado.setId("cli_tx_estado");
        cli_tx_estado.setMaxLength(2);
        getCpMaster().add(cli_tx_estado);

        LabelField lfcli_tx_cep = new LabelField("CEP:");
        lfcli_tx_cep.setId("lfcli_tx_cep");
        getCpMaster().add(lfcli_tx_cep);
        cli_tx_cep.setId("cli_tx_cep");
        cli_tx_cep.setMaxLength(10);
        getCpMaster().add(cli_tx_cep);

        LabelField lfcli_tx_email = new LabelField("Email:");
        lfcli_tx_email.setId("lfcli_tx_email");
        getCpMaster().add(lfcli_tx_email);
        cli_tx_email.setId("cli_tx_email");
        cli_tx_email.setMaxLength(200);
        cli_tx_email.setWidth(Constantes.widthField);
        getCpMaster().add(cli_tx_email);

        LabelField lfcli_tx_home_page = new LabelField("Home Page:");
        lfcli_tx_home_page.setId("lfcli_tx_home_page");
        getCpMaster().add(lfcli_tx_home_page);
        cli_tx_home_page.setId("cli_tx_home_page");
        cli_tx_home_page.setWidth(Constantes.widthField);
        cli_tx_home_page.setMaxLength(200);
        getCpMaster().add(cli_tx_home_page);

        LabelField lfcli_tx_contato = new LabelField("Contato:");
        lfcli_tx_contato.setId("lfcli_tx_contato");
        getCpMaster().add(lfcli_tx_contato);
        cli_tx_contato.setId("cli_tx_contato");
        cli_tx_contato.setMaxLength(100);
        cli_tx_contato.setWidth(Constantes.widthField);
        getCpMaster().add(cli_tx_contato);

        layout();

    }

    public boolean valide() {
        return true;
    }

    public void setValueObjetoT() {
        cli_clienteT.setCli_tx_nome(cli_tx_nome.getValue());
        cli_clienteT.setCli_tx_endereco(cli_tx_endereco.getValue());
        cli_clienteT.setCli_tx_bairro(cli_tx_bairro.getValue());
        cli_clienteT.setCli_tx_rg_inscricao(cli_tx_rg_inscricao.getValue());
        cli_clienteT.setCli_tx_cidade(cli_tx_cidade.getValue());
        cli_clienteT.setCli_tx_estado(cli_tx_estado.getValue());
        cli_clienteT.setCli_tx_cep(cli_tx_cep.getValue().intValue());
        cli_clienteT.setCli_tx_cpf_cnpj(cli_tx_cpf_cnpj.getValue());
        cli_clienteT.setCli_tx_email(cli_tx_email.getValue());
        cli_clienteT.setCli_tx_home_page(cli_tx_home_page.getValue());
        cli_clienteT.setCli_tx_contato(cli_tx_contato.getValue());
        cli_clienteT.setCli_tx_status(rgStatus.getValue() == rAtivo ?"A":"I");

    }

    public void btnInsertAction(ButtonEvent ce) {
        if (valide()) {
            cli_clienteT = new Cli_clienteT();
            setValueObjetoT();

            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    btnClearAction(null);
                    if (cli_clienteConsult != null) {
                        cli_clienteConsult.load();
                    }
                    setVisible(false);
                }
            };

            Cli_clienteServiceAsync cli_clienteAsync = GWT.create(Cli_clienteService.class);
            cli_clienteAsync.insert(cli_clienteT, callback);

        }
    }

    public void btnClearAction(ButtonEvent ce) {
        cli_nr_id.setValue("");
        cli_tx_nome.setValue("");
        cli_tx_endereco.setValue("");
        cli_tx_bairro.setValue("");
        cli_tx_rg_inscricao.setValue("");
        cli_tx_cidade.setValue("");
        cli_tx_estado.setValue("");
        cli_tx_cep.setValue(null);
        cli_tx_cpf_cnpj.setValue("");
        cli_tx_email.setValue("");
        cli_tx_home_page.setValue("");
        cli_tx_contato.setValue("");
        cli_tx_status.setValue("");
        loj_nr_id.setValue("");

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
