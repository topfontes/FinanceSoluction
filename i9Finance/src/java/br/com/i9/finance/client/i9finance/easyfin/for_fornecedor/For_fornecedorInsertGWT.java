/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.for_fornecedor;

import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.CRUDBaseGWT;

import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import br.com.i9.finance.client.i9finance.easyfin.service.*;
import com.extjs.gxt.ui.client.widget.form.NumberField;

/**
 *
 * @author EasyNet
 */
public class For_fornecedorInsertGWT extends CRUDBaseGWT {

    protected For_fornecedorConsultGWT for_fornecedorConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> for_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> for_tx_endereco = new EasyTextField<String>();
    protected EasyTextField<String> for_tx_home_page = new EasyTextField<String>();
    protected EasyTextField<String> for_tx_contato = new EasyTextField<String>();
    protected EasyTextField<String> for_tx_cpf_cnpj = new EasyTextField<String>();
    protected EasyTextField<String> for_tx_email = new EasyTextField<String>();
    protected EasyTextField<String> for_tx_rg_inscricao = new EasyTextField<String>();
    protected NumberField for_tx_cep = new NumberField();
    protected EasyTextField<String> for_tx_cidade = new EasyTextField<String>();
    protected EasyTextField<String> for_tx_estado = new EasyTextField<String>();
    protected EasyTextField<String> for_tx_bairro = new EasyTextField<String>();
    protected EasyTextField<String> for_tx_nome = new EasyTextField<String>();
    protected EasyTextField<String> for_tx_status = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();
    protected int widthField = 30;

    public For_fornecedorInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
        setHeading("Cadastrar For_fornecedor");
        this.setSize("500", "400");
        TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

        LabelField lffor_tx_nome = new LabelField("Nome:");
        lffor_tx_nome.setId("lffor_tx_nome");
        getCpMaster().add(lffor_tx_nome);
        for_tx_nome.setId("for_tx_nome");
        for_tx_nome.setMaxLength(100);
        getCpMaster().add(for_tx_nome);
        for_tx_nome.setWidth(300);
        
        
        LabelField lffor_tx_cpf_cnpj = new LabelField("CPF:");
        lffor_tx_cpf_cnpj.setId("lffor_tx_cpf_cnpj");
        getCpMaster().add(lffor_tx_cpf_cnpj);
        for_tx_cpf_cnpj.setId("for_tx_cpf_cnpj");
        for_tx_cpf_cnpj.setMaxLength(14);
        getCpMaster().add(for_tx_cpf_cnpj);
        
       LabelField lffor_tx_rg_inscricao = new LabelField("Inscrição:");
        lffor_tx_rg_inscricao.setId("lffor_tx_rg_inscricao");
        getCpMaster().add(lffor_tx_rg_inscricao);
        for_tx_rg_inscricao.setId("Inscrição");
        for_tx_rg_inscricao.setMaxLength(18);
        getCpMaster().add(for_tx_rg_inscricao);         

        LabelField lffor_tx_endereco = new LabelField("Endereço:");
        lffor_tx_endereco.setId("lffor_tx_endereco");
        getCpMaster().add(lffor_tx_endereco);
        for_tx_endereco.setId("for_tx_endereco");
        for_tx_endereco.setMaxLength(100);
        getCpMaster().add(for_tx_endereco);
        for_tx_endereco.setWidth(400);

        LabelField lffor_tx_cep = new LabelField("CEP:");
        lffor_tx_cep.setId("lffor_tx_cep");
        getCpMaster().add(lffor_tx_cep);
        for_tx_cep.setId("for_tx_cep");
        for_tx_cep.setMaxLength(10);
        getCpMaster().add(for_tx_cep);
        
        LabelField lffor_tx_bairro = new LabelField("Bairro:");
        lffor_tx_bairro.setId("lffor_tx_bairro");
        getCpMaster().add(lffor_tx_bairro);
        for_tx_bairro.setId("for_tx_bairro");
        for_tx_bairro.setMaxLength(100);
        getCpMaster().add(for_tx_bairro);  
        for_tx_bairro.setWidth(300);

        LabelField lffor_tx_cidade = new LabelField("Cidade:");
        lffor_tx_cidade.setId("lffor_tx_cidade");
        getCpMaster().add(lffor_tx_cidade);
        for_tx_cidade.setId("for_tx_cidade");
        for_tx_cidade.setMaxLength(50);
        getCpMaster().add(for_tx_cidade);
        for_tx_cidade.setWidth(300);

        LabelField lffor_tx_estado = new LabelField("Estado:");
        lffor_tx_estado.setId("lffor_tx_estado");
        getCpMaster().add(lffor_tx_estado);
        for_tx_estado.setId("for_tx_estado");
        for_tx_estado.setMaxLength(2);
        for_tx_estado.setWidth(300);
        getCpMaster().add(for_tx_estado);
        
        LabelField lffor_tx_contato = new LabelField("Contato:");
        lffor_tx_contato.setId("lffor_tx_contato");
        getCpMaster().add(lffor_tx_contato);
        for_tx_contato.setId("for_tx_contato");
        for_tx_contato.setMaxLength(100);
        getCpMaster().add(for_tx_contato);   
        for_tx_contato.setWidth(300);

        LabelField lffor_tx_home_page = new LabelField("Home Page:");
        lffor_tx_home_page.setId("lffor_tx_home_page");
        getCpMaster().add(lffor_tx_home_page);
        for_tx_home_page.setId("for_tx_home_page");
        for_tx_home_page.setMaxLength(200);
        getCpMaster().add(for_tx_home_page);
        for_tx_home_page.setWidth(300);


        LabelField lffor_tx_email = new LabelField("E-mail:");
        lffor_tx_email.setId("lffor_tx_email");
        getCpMaster().add(lffor_tx_email);
        for_tx_email.setId("for_tx_email");
        for_tx_email.setMaxLength(200);
        getCpMaster().add(for_tx_email);    
        for_tx_email.setWidth(300);
    }

    public boolean valide() {
        return true;
    }

    public void btnInsertAction(ButtonEvent ce) {
        if (valide()) {
            For_fornecedorT for_fornecedorT = new For_fornecedorT();
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
            for_fornecedorT.setFor_tx_status("A");


            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    btnClearAction(null);
                    if (for_fornecedorConsult != null) {
                        for_fornecedorConsult.load();
                    }
                    setVisible(false);
                }
            };

            For_fornecedorServiceAsync for_fornecedorAsync = GWT.create(For_fornecedorService.class);
            for_fornecedorAsync.insert(for_fornecedorT, callback);

        }
    }

    public void btnClearAction(ButtonEvent ce) {
        for_nr_id.setValue("");
        for_tx_endereco.setValue("");
        for_tx_home_page.setValue("");
        for_tx_contato.setValue("");
        for_tx_cpf_cnpj.setValue("");
        for_tx_email.setValue("");
        for_tx_rg_inscricao.setValue("");
        for_tx_cep.setValue(null);
        for_tx_cidade.setValue("");
        for_tx_estado.setValue("");
        for_tx_bairro.setValue("");
        for_tx_nome.setValue("");
        for_tx_status.setValue("");
        loj_nr_id.setValue("");

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
