/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.ctp_conta_pagar;

import static br.com.easynet.gwt.client.CPBaseGWT.ICONS;
import br.com.i9.finance.client.Constantes;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.CRUDBaseGWT;
import br.com.easynet.gwt.client.component.EasyMoneyField;
import br.com.easynet.gwt.client.component.EasyNumberField;
import br.com.i9.finance.client.i9finance.easyfin.ccp_conta_ct_pagar.Ccp_conta_ct_pagarConsultGWT;
import br.com.i9.finance.client.i9finance.easyfin.ccp_conta_ct_pagar.Ccp_conta_ct_pagarUpdateDeleteGWT;

import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.v_conta_pagar.V_conta_pagarConsultGWT;
import br.com.i9.finance.client.icones.icons.Icones;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author EasyNet
 */
public class Ctp_conta_pagarInsertGWT extends CRUDBaseGWT {

    protected V_conta_pagarConsultGWT v_conta_pagarConsultGWT;
    protected DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

    protected EasyTextField<String> ctp_nr_id = new EasyTextField<String>();
    protected NumberField ctp_nr_doc = new NumberField();
    protected DateField ctp_dt_emissao = new DateField();
    protected DateField ctp_dt_vencimento = new DateField();
    protected EasyTextField<String> ctp_tx_pago = new EasyTextField<String>();
    protected EasyTextField<String> ban_nr_id = new EasyTextField<String>();
    protected EasyMoneyField ctp_valor = new EasyMoneyField();
    protected EasyTextField<String> ctp_tx_parcela = new EasyTextField<String>();
    protected DateField ctp_dt_pagamento = new DateField();
    protected EasyTextField<String> car_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> ctp_vl_pago = new EasyTextField<String>();
    protected EasyTextField<String> ctp_saldo = new EasyTextField<String>();
    protected EasyTextField<String> for_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> fop_nr_id = new EasyTextField<String>();
    protected EasyTextField<String> loj_nr_id = new EasyTextField<String>();
    protected TextArea ctp_tx_obs = new TextArea();
    protected EasyTextField<String> ctp_tx_tipo_vinculo = new EasyTextField<String>();
    protected EasyTextField<String> ctp_nr_id_vinculo = new EasyTextField<String>();
    protected Ctp_conta_pagarT ctp_conta_pagarT;
    protected ComboBox<For_fornecedorT> cb_fornec = new ComboBox<For_fornecedorT>();
    protected ComboBox<Fop_forma_pagamentoT> cb_Forma = new ComboBox<Fop_forma_pagamentoT>();
    protected ComboBox<Plc_plano_contasT> cb_Conta = new ComboBox<Plc_plano_contasT>();
    protected LayoutContainer container = new LayoutContainer();
    protected LayoutContainer containerCtp = new LayoutContainer();
    protected ContentPanel containerConta = new ContentPanel();
    protected EasyMoneyField tx_valor = new EasyMoneyField();
    protected Button buttonAdd = new Button("", Icones.ICONS.add2());
    protected Grid<Ccp_conta_ct_pagarT> gridConta;

    public Ctp_conta_pagarInsertGWT() {
        getBtnDelete().setVisible(false);
        getBtnUpdate().setVisible(false);
        setHeading("Cadastrar Conta a pagar..");
        this.setSize("830", "370");
        TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(new RowLayout(Style.Orientation.HORIZONTAL));
        getCpMaster().add(containerCtp, new RowData(.50, 1));
        getCpMaster().add(containerConta, new RowData(.50, 1, new Margins(4, 4, 4, 4)));
        containerCtp.setLayout(tl);

        LabelField lfctp_dt_emissao = new LabelField("Dt. Emissão:");
        lfctp_dt_emissao.setId("lfctp_dt_emissao");
        containerCtp.add(lfctp_dt_emissao);
        ctp_dt_emissao.setId("ctp_dt_emissao");
        ctp_dt_emissao.setMaxLength(13);
        ctp_dt_emissao.getPropertyEditor().setFormat(dtfDate);
        ctp_dt_emissao.setValue(new Date());
        containerCtp.add(ctp_dt_emissao);

        LabelField lfctp_nr_doc = new LabelField("Documento:");
        lfctp_nr_doc.setId("lfctp_nr_doc");
        containerCtp.add(lfctp_nr_doc);
        ctp_nr_doc.setId("ctp_nr_doc");
        ctp_nr_doc.setMaxLength(10);
        containerCtp.add(ctp_nr_doc);

        LabelField lfcli_nr_id = new LabelField("Fornecedor:");
        lfcli_nr_id.setId("lfcli_nr_id");
        containerCtp.add(lfcli_nr_id);
        for_nr_id.setId("cli_nr_id");
        for_nr_id.setMaxLength(10);
        containerCtp.add(cb_fornec);

        LabelField lfctp_dt_vencimento = new LabelField("Vencimento:");
        lfctp_dt_vencimento.setId("lfctp_dt_vencimento");
        containerCtp.add(lfctp_dt_vencimento);
        ctp_dt_vencimento.setId("ctp_dt_vencimento");
        ctp_dt_vencimento.setMaxLength(13);
        containerCtp.add(ctp_dt_vencimento);
        ctp_dt_vencimento.getPropertyEditor().setFormat(dtfDate);

        LabelField lfctp_tx_parcela = new LabelField("Parcela:");
        lfctp_tx_parcela.setId("lfctp_tx_parcela");
        containerCtp.add(lfctp_tx_parcela);
        ctp_tx_parcela.setId("ctp_tx_parcela");
        ctp_tx_parcela.setMaxLength(6);
        containerCtp.add(ctp_tx_parcela);
        ctp_tx_parcela.setEmptyText("Exemplo: 0101");

        LabelField lffop_nr_id = new LabelField("Forma Pagamento:");
        lffop_nr_id.setId("lffop_nr_id");
        containerCtp.add(lffop_nr_id);
        fop_nr_id.setId("fop_nr_id");
        fop_nr_id.setMaxLength(10);
        containerCtp.add(cb_Forma);

        LabelField lfctp_valor = new LabelField("Valor:");
        lfctp_valor.setId("lfctp_valor");
        containerCtp.add(lfctp_valor);
        ctp_valor.setId("ctp_valor");
        ctp_valor.setMaxLength(8);
        containerCtp.add(ctp_valor);

//        LabelField lfctp_conta = new LabelField("Conta credora:");
//        lfctp_conta.setId("lfctp_valor");
//        containerCtp.add(lfctp_conta);
//        ctp_valor.setId("ctp_valor");
//        ctp_valor.setMaxLength(8);
//        containerCtp.add(cb_Conta);
        LabelField lfctp_tx_obs = new LabelField("Observação:");
        lfctp_tx_obs.setId("lfctp_tx_obs");
        containerCtp.add(lfctp_tx_obs);
        ctp_tx_obs.setId("ctp_tx_obs");
        ctp_tx_obs.setMaxLength(50);
        containerCtp.add(ctp_tx_obs);
        ctp_tx_obs.setHeight(60);
        ctp_tx_obs.setWidth(Constantes.widthField);
        povoaCb_formaPag();
        povoaConta();
        povoaFornec();
        montarContainerConta();

    }

    public void montarContainerConta() {
        //containerConta.setHeaderVisible(false);
        containerConta.setHeading("Contas de despesas");
        containerConta.setFrame(true);
        containerConta.setStyleAttribute("backgroundColor", "white");
        LayoutContainer containerTop = new LayoutContainer();
        TableLayout layout = new TableLayout(3);
        layout.setCellPadding(4);
        containerTop.setLayout(layout);
        containerTop.add(cb_Conta);
        containerTop.add(tx_valor);
        tx_valor.setEmptyText("R$ Valor");
        tx_valor.setWidth(80);
        buttonAdd.setWidth(24);

        containerTop.add(buttonAdd);
        containerConta.setTopComponent(containerTop);
        containerConta.setLayout(new FillLayout());

        buttonAdd.setIconAlign(Style.IconAlign.LEFT);
        buttonAdd.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                if (valideAddConta()) {
                    Ccp_conta_ct_pagarT ccp = new Ccp_conta_ct_pagarT();
                    ccp.setCcp_nr_id(gridConta.getStore().getCount() + 1);
                    ccp.setCtp_nr_id(ctp_conta_pagarT == null || ctp_conta_pagarT.getCtp_nr_id() == 0 ? 0 : ctp_conta_pagarT.getCtp_nr_id());
                    ccp.setPlc_nr_id(cb_Conta.getValue().getPlc_nr_id());
                    ccp.setCcp_valor(tx_valor.getValueMoney());
                    gridConta.getStore().add(ccp);
                    Info.display("", "adicionado com sucesso!");
                    cb_Conta.setValue(null);
                    tx_valor.setValue("");
                    cb_Conta.focus();
                }
            }
        });

        ColumnModel cm = new ColumnModel(getColumnGridConta());
        gridConta = new Grid<Ccp_conta_ct_pagarT>(new ListStore<Ccp_conta_ct_pagarT>(), cm);
        gridConta.setStripeRows(true);
        gridConta.setStyleAttribute("borderTop", "none");
        gridConta.setBorders(false);
        gridConta.getSelectionModel().setSelectionMode(Style.SelectionMode.SIMPLE);
        containerConta.add(gridConta);
    }

    public boolean valideAddConta() {
        if (cb_Conta.getValue() == null) {
            MessageBox.alert("ATENÇÃO", "O campo conta tem preenchimento obrigatório", null);
            return false;
        } else if (tx_valor.getValueMoney() == 0) {
            MessageBox.alert("ATENÇÃO", "O campo valor tem preenchimento obrigatório", null);
            return false;
        } else if (Double.parseDouble(ctp_valor.getValue()) < getSomaContaAdd()) {
            MessageBox.alert("ATENÇÃO", "A soma dos itens excede o valor do título", null);
            return false;
        }
        return true;
    }

    public double getSomaContaAdd() {
        double soma = 0;
        for (Ccp_conta_ct_pagarT model : gridConta.getStore().getModels()) {
            soma += model.getCcp_valor();
        }
        String strSoma = Double.toString(soma);

        return Double.parseDouble(strSoma);
    }

    public List<ColumnConfig> getColumnGridConta() {
        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
        ColumnConfig column = null;
//        RowNumberer numero = new RowNumberer();
//        column = new ColumnConfig();
//        configs.add(numero);

        column = new ColumnConfig();
        column.setId("plc_nr_id");
        column.setHeader("Plc_nr_id");
        column.setWidth(60);
        column.setAlignment(Style.HorizontalAlignment.LEFT);
        column.setHidden(true);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("conta");
        column.setHeader("Conta");
        column.setWidth(255);
        column.setAlignment(Style.HorizontalAlignment.LEFT);
        column.setRenderer(new GridCellRenderer<Ccp_conta_ct_pagarT>() {
            @Override
            public Object render(Ccp_conta_ct_pagarT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Ccp_conta_ct_pagarT> store, Grid<Ccp_conta_ct_pagarT> grid) {
                return cb_Conta.getStore().findModel("plc_nr_id", model.getPlc_nr_id()).getPlc_tx_nome();
            }
        });
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ccp_valor");
        column.setHeader("Valor");
        column.setWidth(80);
        column.setRenderer(new GridCellRenderer<Ccp_conta_ct_pagarT>() {
            @Override
            public Object render(Ccp_conta_ct_pagarT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Ccp_conta_ct_pagarT> store, Grid<Ccp_conta_ct_pagarT> grid) {
                config.style = "background-color: #F1F2F4; text-align: right !important;";
                NumberFormat format = NumberFormat.getFormat("#,##0.00");
                return "<span>" + format.format(model.getCcp_valor()) + "</span>";
            }
        });
        column.setAlignment(Style.HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("colEditar");
        column.setWidth(30);
        column.setAlignment(Style.HorizontalAlignment.CENTER);
        column.setRenderer(getDelRender());
        configs.add(column);
        return configs;
    }

    private GridCellRenderer<Ccp_conta_ct_pagarT> getDelRender() {
        return new GridCellRenderer<Ccp_conta_ct_pagarT>() {

            public Object render(final Ccp_conta_ct_pagarT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, final ListStore<Ccp_conta_ct_pagarT> store, final Grid<Ccp_conta_ct_pagarT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        store.remove(model);
                        grid.getView().refresh(true);
                        cb_Conta.focus();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(Icones.ICONS.delete());
                b.setId("btnEditar");

                return b;
            }
        };
    }

    public void povoaCb_formaPag() {
        cb_Forma.setDisplayField("fop_tx_nome");
        cb_Forma.setTriggerAction(ComboBox.TriggerAction.ALL);
        cb_Forma.setEmptyText("Forma de pagamento");
        AsyncCallback<List<Fop_forma_pagamentoT>> callback = new AsyncCallback<List<Fop_forma_pagamentoT>>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<Fop_forma_pagamentoT> result) {
                ListStore<Fop_forma_pagamentoT> store = new ListStore<Fop_forma_pagamentoT>();
                store.add(result);
                cb_Forma.setStore(store);
                cb_Forma.getListView().refresh();
            }
        };

        Fop_forma_pagamentoServiceAsync fop_forma_pagamentoAsync = GWT.create(Fop_forma_pagamentoService.class);
        fop_forma_pagamentoAsync.getAll(callback);
    }

    public void povoaConta() {
        //cb_Conta.setWidth(Constantes.widthField);
        cb_Conta.setDisplayField("plc_tx_nome");
        cb_Conta.setEmptyText("Selecione a conta de entrada");
        cb_Conta.setTriggerAction(ComboBox.TriggerAction.ALL);
        cb_Conta.setMinChars(2);
        cb_Conta.setWidth(250);

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
        serviceAsync.getAllSub(callback);
    }

    public void povoaFornec() {
        cb_fornec.setWidth(300);
        cb_fornec.setDisplayField("for_tx_nome");
        cb_fornec.setEmptyText("Informe o fornecedor");
        cb_fornec.setWidth(Constantes.widthField);
        cb_fornec.setTriggerAction(ComboBox.TriggerAction.ALL);
        AsyncCallback<List<For_fornecedorT>> callback = new AsyncCallback<List<For_fornecedorT>>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<For_fornecedorT> result) {
                ListStore<For_fornecedorT> store = new ListStore<For_fornecedorT>();
                store.add(result);
                cb_fornec.setStore(store);
                cb_fornec.getListView().refresh();
            }
        };

        For_fornecedorServiceAsync for_fornecedorAsync = GWT.create(For_fornecedorService.class);
        for_fornecedorAsync.getAll(callback);
    }

    public boolean valide() {

        double totalConta = getSomaContaAdd();

        if (ctp_dt_emissao.getValue() == null) {
            MessageBox.alert("ATENÇÃO", "O campo data de emissão tem preenchimento obrigatório", null);
            return false;
        } else if (ctp_nr_doc.getValue() == null) {
            MessageBox.alert("ATENÇÃO", "O campo documento tem preenchimento obrigatório", null);
            return false;
        } else if (cb_fornec.getValue() == null) {
            MessageBox.alert("ATENÇÃO", "O campo fornecedor tem preenchimento obrigatório", null);
            return false;
        } else if (ctp_dt_vencimento.getValue() == null) {
            MessageBox.alert("ATENÇÃO", "O campo vencimento tem preenchimento obrigatório", null);
            return false;
        }else if(cb_Forma.getValue() == null){
            MessageBox.alert("ATENÇÃO", "O campo forma de pagamento tem preenchimento obrigatório", null); 
           return false;
        }else if(ctp_valor.getValueMoney() == null || ctp_valor.getValueMoney() <= 0){
            MessageBox.alert("ATENÇÃO", "O campo valor tem preenchimento obrigatório", null); 
           return false;
        } else if (ctp_valor.getValueMoney() != totalConta) {
            MessageBox.alert("ATENÇÃO", "O total das contas de despesas está diferente do valor do título", null);
            return false;
        }

        return true;

    }

    public void setValueObjetoT() {

        ctp_conta_pagarT.setCtp_nr_doc(ctp_nr_doc.getValue().intValue());
        ctp_conta_pagarT.setCtp_dt_emissao(ctp_dt_emissao.getValue());
        ctp_conta_pagarT.setCtp_dt_vencimento(ctp_dt_vencimento.getValue());
        ctp_conta_pagarT.setCtp_valor(ctp_valor.getValueMoney());
        ctp_conta_pagarT.setCtp_tx_parcela(ctp_tx_parcela.getValue());
        ctp_conta_pagarT.setCtp_saldo(ctp_valor.getValueMoney());
        ctp_conta_pagarT.setFor_nr_id(cb_fornec.getValue().getFor_nr_id());
        ctp_conta_pagarT.setFop_nr_id(cb_Forma.getValue().getFop_nr_id());

        ctp_conta_pagarT.setCtp_tx_obs(ctp_tx_obs.getValue());

//        List<Ccp_conta_ct_pagarT> list = new ArrayList<Ccp_conta_ct_pagarT>();
//        Ccp_conta_ct_pagarT ccp_conta_ct_pagarT = new Ccp_conta_ct_pagarT();
//        ccp_conta_ct_pagarT.setPlc_nr_id(cb_Conta.getValue().getPlc_nr_id());
//        ccp_conta_ct_pagarT.setCcp_valor(ctp_conta_pagarT.getCtp_valor());
//        list.add(ccp_conta_ct_pagarT);
        ctp_conta_pagarT.setList(gridConta.getStore().getModels());
    }

    public void btnInsertAction(ButtonEvent ce) {
        if (valide()) {
            ctp_conta_pagarT = new Ctp_conta_pagarT();
            setValueObjetoT();
            ctp_conta_pagarT.setCtp_tx_pago("F");
            ctp_conta_pagarT.setCtp_tx_tipo_vinculo("F");

            AsyncCallback<Void> callback = new AsyncCallback<Void>() {

                public void onFailure(Throwable caught) {
                    MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
                }

                public void onSuccess(Void result) {
                    Info.display(EASY_LABELS.confirmation(), "Operação realizada com sucesso!");
                    btnClearAction(null);
                    if (v_conta_pagarConsultGWT != null) {
                        v_conta_pagarConsultGWT.load();
                    }
                    setVisible(false);
                }
            };
            Ctp_conta_pagarServiceAsync ctp_conta_pagarAsync = GWT.create(Ctp_conta_pagarService.class);
            ctp_conta_pagarAsync.insert(ctp_conta_pagarT, callback);
        } else {
            Info.display("", "Item não válido");
        }
    }

    public void btnClearAction(ButtonEvent ce) {
        ctp_nr_id.setValue("");
        ctp_nr_doc.setValue(null);
        ctp_dt_emissao.setValue(null);
        ctp_dt_vencimento.setValue(null);
        ctp_tx_pago.setValue("");
        ban_nr_id.setValue("");
        ctp_valor.setValue(null);
        ctp_tx_parcela.setValue("");
        ctp_dt_pagamento.setValue(null);
        car_nr_id.setValue("");
        ctp_vl_pago.setValue("");
        ctp_saldo.setValue("");
        for_nr_id.setValue("");
        fop_nr_id.setValue("");
        loj_nr_id.setValue("");
        ctp_tx_obs.setValue("");
        ctp_tx_tipo_vinculo.setValue("");
        ctp_nr_id_vinculo.setValue("");

    }

    /**
     * @return the ctp_conta_pagarConsult
     */
    public V_conta_pagarConsultGWT getV_conta_pagarConsultGWT() {
        return v_conta_pagarConsultGWT;
    }

    /**
     * @param ctp_conta_pagarConsult the ctp_conta_pagarConsult to set
     */
    public void setV_conta_pagarConsultGWT(V_conta_pagarConsultGWT v_conta_pagarConsultGWT) {
        this.v_conta_pagarConsultGWT = v_conta_pagarConsultGWT;
    }
}
