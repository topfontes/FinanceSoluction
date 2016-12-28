/*
 * EasyNet JDragon
 */
package br.com.i9.finance.client.i9finance.easyfin.v_lancamentos;

import br.com.i9.finance.client.Constantes;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9.finance.client.i9finance.easyfin.lan_lancamento.Lan_lancamentoInsertGWT;
import br.com.i9.finance.client.i9finance.easyfin.lan_lancamento.Lan_lancamentoUpdateDeleteGWT;

import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;

import br.com.i9.finance.client.i9finance.easyfin.service.*;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;

/**
 *
 * @author geoleite
 */
public class V_lancamentosConsultGWT extends CPConsultarBaseGWT {

    private Grid<V_lancamentosT> grid = null;
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private ComboBox<Plc_plano_contasT> cb_Conta = new ComboBox<Plc_plano_contasT>();
    private DateField dtInicio = new DateField();
    private DateField dtFim = new DateField();
    private ToolBar toolBar = new ToolBar();
    private DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
    private Button btnFiltrar = new Button("Filtrar", ICONS.filter());   
    private ContentPanel cpMain = new ContentPanel(new FillLayout());

    public V_lancamentosConsultGWT() {
        setHeaderVisible(false);
        
        getBtnRefersh().setVisible(false);
        
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("#,##0.00");
        final NumberCellRenderer<Grid<V_lancamentosT>> numberRenderer = new NumberCellRenderer<Grid<V_lancamentosT>>(currency);

        ColumnConfig column = null;
        RowNumberer numero = new RowNumberer();
        column = new ColumnConfig();
        configs.add(numero);

        column = new ColumnConfig();
        column.setId("lan_dt_lancamento");
        column.setHeader("Data");
        column.setWidth(80);
        column.setAlignment(HorizontalAlignment.LEFT);
        column.setDateTimeFormat(dtf);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plc_tx_credito");
        column.setHeader("Conta credora");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plc_tx_debito");
        column.setHeader("Conta devedora");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);
        
        column = new ColumnConfig();
        column.setId("lan_valor");
        column.setHeader("Valor");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(number);
        configs.add(column);  

        column = new ColumnConfig();
        column.setId("lan_tx_historico");
        column.setHeader("Histórico");
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);        

        column = new ColumnConfig();
        column.setId("colEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);

        btnFiltrar.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                load();
            }
        });
        cpMain.setHeaderVisible(false);
        cpMain.setBodyBorder(false);
        cpMain.setBorders(false);
        getCpMaster().add(cpMain);
        cpMain.setTopComponent(toolBar);
        povoaCb_conta();
        addPeriodo();
        addConta();
        addFiltrar();
        load();
    }
    public void addFiltrar(){
        toolBar.add(new SeparatorToolItem());
        toolBar.add(new SeparatorToolItem());
        toolBar.add(btnFiltrar);
    }
    
    public void addPeriodo() {
        toolBar.add(new LabelToolItem("Período :"));
        toolBar.add(dtInicio);
        dtInicio.setValue(new Date());
        dtFim.setValue(new Date());
        dtFim.getPropertyEditor().setFormat(dtf);
        dtInicio.getPropertyEditor().setFormat(dtf);
        toolBar.add(new LabelToolItem(" a "));
        toolBar.add(dtFim);
        toolBar.add(new SeparatorToolItem());
        toolBar.add(new SeparatorToolItem());
    }

    public void addConta() {
        toolBar.add(new LabelToolItem("Conta"));
        toolBar.add(cb_Conta);
    }

    public void povoaCb_conta() {
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
        serviceAsync.getAll(callback);

    }

    public void btnAtualizarAction(ButtonEvent be) {
        super.btnAtualizarAction(be);
    }

    public void btnNovoAction(ButtonEvent be) {
        Lan_lancamentoInsertGWT lan_lancamentoInsertGWT = new Lan_lancamentoInsertGWT();
        lan_lancamentoInsertGWT.setV_lancamentosConsultGWT(this);
        lan_lancamentoInsertGWT.setModal(true);
        lan_lancamentoInsertGWT.show();
    }

    private GridCellRenderer<V_lancamentosT> getEditarRender() {
        return new GridCellRenderer<V_lancamentosT>() {

            public Object render(final V_lancamentosT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<V_lancamentosT> store, Grid<V_lancamentosT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Lan_lancamentoUpdateDeleteGWT lan_lancamentoUpdateDeleteGWT = new Lan_lancamentoUpdateDeleteGWT();
                        
                        lan_lancamentoUpdateDeleteGWT.setV_lancamentosConsultGWT(V_lancamentosConsultGWT.this);
                        lan_lancamentoUpdateDeleteGWT.load(model);
                        lan_lancamentoUpdateDeleteGWT.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());
                b.setId("btnEditar");

                return b;
            }
        };
    }

    /**
     * Opcão para exportar dados
     *
     * @param formato
     */
    public void export(String formato) {
        //FORMAT_CSV
        //FORMAT_PDF
        //FORMAT_TXT
/*
         String url = V_lancamentosDAOGWT.PAGE_REPORT;  
         if (FORMAT_CSV.equals(formato)) {
         url += "?op=imprimir&tipo=PDF&download=true";
         } else if (FORMAT_PDF.equals(formato)) {
         url += "?op=imprimir&tipo=CSV&download=true";
         } else {
         url += "?op=imprimir&tipo=TXT&download=true";
         }
         */
    }

    public void load() {
        AsyncCallback<List<V_lancamentosT>> callback = new AsyncCallback<List<V_lancamentosT>>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<V_lancamentosT> result) {
                if (grid != null) {
                    grid.removeFromParent();
                }
                ListStore<V_lancamentosT> list = new ListStore<V_lancamentosT>();
                list.add(result);

                ColumnModel cm = new ColumnModel(configs);

                PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                PagingLoader<PagingLoadResult<V_lancamentosT>> loader = new BasePagingLoader<PagingLoadResult<V_lancamentosT>>(proxy);
                loader.setRemoteSort(true);

                ListStore<V_lancamentosT> store = new ListStore<V_lancamentosT>(loader);
                store.add(list.getModels());

                getToolBarPage().setPageSize(20);
                getToolBarPage().bind(loader);
                loader.load(0, 20);

                grid = new Grid<V_lancamentosT>(store, cm);
                grid.setAutoExpandColumn("lan_tx_historico");
                grid.setColumnReordering(true);
                grid.setId("grid");
                grid.setLoadMask(true);
                grid.setStripeRows(true);

                grid.setStyleAttribute("borderTop", "none");
                grid.setBorders(true);
                grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                cpMain.add(grid);
                cpMain.layout();
                getCpMaster().layout();
            }
        };

        V_lancamentosServiceAsync v_lancamentosAsync = GWT.create(V_lancamentosService.class);
        v_lancamentosAsync.getAll(dtInicio.getValue(),dtFim.getValue(),cb_Conta.getValue() == null?0:cb_Conta.getValue().getPlc_nr_id() ,callback);
    }
}
