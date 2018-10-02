/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.plc_plano_contas;

import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.CRUDBaseGWT;
import br.com.i9.finance.client.Constantes;

import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.util.Tipo_contaGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import java.util.List;

/**
 *
 * @author EasyNet
 */
public class Plc_plano_contasInsertGWT extends CRUDBaseGWT {

    protected Plc_plano_contasConsultGWT plc_plano_contasConsult;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> plc_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> plc_nr_id_super = new EasyTextField<String>();
    protected EasyTextField<String> plc_nr_nivel = new EasyTextField<String>();
    protected EasyTextField<String> plc_tx_nome = new EasyTextField<String>();
    protected CheckBox plc_tx_banco = new CheckBox();
    protected ComboBox<Tipo_contaGWT> cb_tipo_conta = new ComboBox<Tipo_contaGWT>();
    protected EasyTextField<String> plc_tx_centro_custo = new EasyTextField<String>();
    protected EasyTextField<String> plc_nr_reduzido = new EasyTextField<String>();
    protected RadioGroup plc_tx_status = new RadioGroup();
    protected Radio rdAtivo = new Radio();
    protected Radio rdInativo = new Radio();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();
    protected ComboBox<Plc_plano_contasT> cb_Conta = new ComboBox<Plc_plano_contasT>();
    protected Plc_plano_contasT plc_plano_contasT;
    

    public Plc_plano_contasInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
        setHeading("Cadastrar plano de contas");
        this.setSize("500", "200");
        TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);
        
        
        rdAtivo.setBoxLabel("Ativo");
        rdAtivo.setBoxLabel("Inativo");
        plc_tx_status.add(rdAtivo);
        plc_tx_status.add(rdInativo);

        LabelField lfplc_tx_nome = new LabelField("Conta:");
        lfplc_tx_nome.setId("lfplc_tx_nome");
        getCpMaster().add(lfplc_tx_nome);
        plc_tx_nome.setId("plc_tx_nome");
        plc_tx_nome.setWidth(Constantes.widthField);
        plc_tx_nome.setMaxLength(50);
        getCpMaster().add(plc_tx_nome);

        LabelField lfplc_nr_id_super = new LabelField("Super Conta:");
        lfplc_nr_id_super.setId("lfplc_nr_id_super");
        getCpMaster().add(lfplc_nr_id_super);
        plc_nr_id_super.setId("plc_nr_id_super");
        plc_nr_id_super.setMaxLength(10);
        getCpMaster().add(cb_Conta);

//        LabelField lfplc_nr_nivel = new LabelField("plc_nr_nivel:");
//        lfplc_nr_nivel.setId("lfplc_nr_nivel");
//        getCpMaster().add(lfplc_nr_nivel);
//        plc_nr_nivel.setId("plc_nr_nivel");
//        plc_nr_nivel.setMaxLength(10);
//        getCpMaster().add(plc_nr_nivel);
        plc_tx_banco.setBoxLabel("");
        LabelField lfplc_tx_banco = new LabelField("Conta caixa e banco:");
        lfplc_tx_banco.setId("lfplc_tx_banco");
        getCpMaster().add(lfplc_tx_banco);
        plc_tx_banco.setId("plc_tx_banco");
        getCpMaster().add(plc_tx_banco);
        
        
//        LabelField lfplc_tx_tipo = new LabelField("Tipo conta:");
//        lfplc_tx_tipo.setId("lfplc_tx_tipo");
//        getCpMaster().add(lfplc_tx_tipo);
//        cb_tipo_conta.setId("plc_tx_tipo");
//        cb_tipo_conta.setMaxLength(1);
//        getCpMaster().add(cb_tipo_conta);

//        LabelField lfplc_tx_centro_custo = new LabelField("plc_tx_centro_custo:");
//        lfplc_tx_centro_custo.setId("lfplc_tx_centro_custo");
//        getCpMaster().add(lfplc_tx_centro_custo);
//        plc_tx_centro_custo.setId("plc_tx_centro_custo");
//        plc_tx_centro_custo.setMaxLength(10);
//        getCpMaster().add(plc_tx_centro_custo);
//        LabelField lfplc_nr_reduzido = new LabelField("plc_nr_reduzido:");
//        lfplc_nr_reduzido.setId("lfplc_nr_reduzido");
//        getCpMaster().add(lfplc_nr_reduzido);
//        plc_nr_reduzido.setId("plc_nr_reduzido");
//        plc_nr_reduzido.setMaxLength(10);
//        getCpMaster().add(plc_nr_reduzido);
        povoaContaSuper();
//        povoaTipoConta();

    }

//    public void povoaTipoConta() {
//        cb_tipo_conta.setDisplayField("descricao");
//        cb_tipo_conta.setEmptyText("Selecione tipo conta");
//        cb_tipo_conta.setTriggerAction(ComboBox.TriggerAction.ALL);
//        cb_tipo_conta.setMinChars(1);
//        ListStore<Tipo_contaGWT> store = new ListStore<Tipo_contaGWT>();
//        store.add(new Tipo_contaGWT("A", "Ativo"));
//        store.add(new Tipo_contaGWT("R", "Receita"));
//        store.add(new Tipo_contaGWT("D", "Despesas"));
//        store.add(new Tipo_contaGWT("I", "Investimento"));
//        cb_tipo_conta.setStore(store);
//        cb_tipo_conta.getListView().refresh();
//    }

    public void povoaContaSuper() {
        cb_Conta.setWidth(Constantes.widthField);
        cb_Conta.setDisplayField("plc_tx_nome");
        cb_Conta.setEmptyText("Selecione a super conta");
        cb_Conta.setTriggerAction(ComboBox.TriggerAction.ALL);
        cb_Conta.setMinChars(2);
        
        AsyncCallback<List<Plc_plano_contasT>> callback = new AsyncCallback<List<Plc_plano_contasT>>() {

            @Override
            public void onFailure(Throwable caught) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onSuccess(List<Plc_plano_contasT> result) {
                ListStore<Plc_plano_contasT> store = new ListStore<Plc_plano_contasT>();
                store.add(result);
                cb_Conta.setStore(store);
                cb_Conta.getListView().refresh();
            }
        };
        Plc_plano_contasServiceAsync serviceAsync = GWT.create(Plc_plano_contasService.class);
        serviceAsync.getAllSuper(callback);

    }

    public boolean valide() {
        return true;
    }

    public void setValueObjetoT() {
        plc_plano_contasT.setPlc_nr_id_super(cb_Conta.getValue().getPlc_nr_id());
        plc_plano_contasT.setPlc_nr_nivel(cb_Conta.getValue().getPlc_nr_nivel()+1);
        plc_plano_contasT.setPlc_tx_nome(plc_tx_nome.getValue());
        plc_plano_contasT.setPlc_tx_banco(plc_tx_banco.getValue().booleanValue() == true ?"T":"F");
        plc_plano_contasT.setPlc_tx_tipo(cb_Conta.getValue().getPlc_tx_tipo());
        plc_plano_contasT.setPlc_tx_centro_custo("F");
        plc_plano_contasT.setPlc_nr_reduzido(0);
        plc_plano_contasT.setPlc_tx_status("A");
    }

    public void btnInsertAction(ButtonEvent ce) {
        if (valide()) {
            plc_plano_contasT = new Plc_plano_contasT();

            setValueObjetoT();

            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    btnClearAction(null);
                    if (plc_plano_contasConsult != null) {
                        plc_plano_contasConsult.load();
                    }
                    //setVisible(false);
                }
            };

            Plc_plano_contasServiceAsync plc_plano_contasAsync = GWT.create(Plc_plano_contasService.class);
            plc_plano_contasAsync.insert(plc_plano_contasT, callback);

        }
    }

    public void btnClearAction(ButtonEvent ce) {
        plc_nr_id.setValue("");
        plc_nr_id_super.setValue("");
        plc_nr_nivel.setValue("");
        plc_tx_nome.setValue("");
        plc_tx_banco.setValue(null);
        cb_tipo_conta.setValue(null);
        plc_tx_centro_custo.setValue("");
        plc_nr_reduzido.setValue("");
        plc_tx_status.setValue(null);
        loj_nr_id.setValue("");

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
