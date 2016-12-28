/*
 * EasyNet JDragon
 */
package br.com.i9.finance.client.i9finance.easyfin.por_previsao_orcamento;

import br.com.i9.finance.client.Constantes;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;
import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.easynet.gwt.client.component.EasyNumberField;

import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
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
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
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
import com.google.gwt.user.client.Timer;

import br.com.i9.finance.client.i9finance.easyfin.service.*;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import java.util.TreeMap;

/**
 *
 * @author geoleite
 */
public class Por_previsao_orcamentoConsultGWT extends CPConsultarBaseGWT {

    private Grid<Por_previsao_orcamentoT> grid = null;
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private ContentPanel cpMain = new ContentPanel(new FillLayout());
    private EasyNumberField fieldAno = new EasyNumberField();
    private ToolBar bar = new ToolBar();
    private TreeMap<Integer, Plc_plano_contasT> treeContas = new TreeMap<Integer, Plc_plano_contasT>();

    public Por_previsao_orcamentoConsultGWT() {
        setHeaderVisible(false);
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("#,##0.00");
        final NumberCellRenderer<Grid<Por_previsao_orcamentoT>> numberRenderer = new NumberCellRenderer<Grid<Por_previsao_orcamentoT>>(currency);
        /*
         GridCellRenderer<Stock> change = new GridCellRenderer<Stock>() {
         public String render(Stock model, String property, ColumnData config, int rowIndex,
         int colIndex, ListStore<Stock> store) {
         double val = (Double) model.get(property);
         String style = val < 0 ? "red" : "green";
         return "<span style='color:" + style + "'>" + number.format(val) + "</span>";
         }
         };
         GridCellRenderer<Stock> gridNumber = new GridCellRenderer<Stock>() {
         public String render(Stock model, String property, ColumnData config, int rowIndex,
         int colIndex, ListStore<Stock> store) {
         return numberRenderer.render(null, property, model.get(property));
         }
         };
         */

        getToolBarMaster().remove(getBtnExportar());

        bar.add(new LabelToolItem("Ano"));
        bar.add(fieldAno);
        bar.add(getBtnRefersh());
        cpMain.setTopComponent(bar);

        cpMain.setHeaderVisible(false);
        cpMain.setBodyBorder(false);
        cpMain.setBorders(false);
        getCpMaster().add(cpMain);
        ColumnConfig column = null;
        RowNumberer numero = new RowNumberer();
        column = new ColumnConfig();
        configs.add(numero);

        column = new ColumnConfig();
        column.setId("plc_nr_id");
        column.setHeader("Conta");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        column.setRenderer(new GridCellRenderer<Por_previsao_orcamentoT>() {

            @Override
            public String render(Por_previsao_orcamentoT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Por_previsao_orcamentoT> store, Grid<Por_previsao_orcamentoT> grid) {
                config.style = "background-color: #F1F2F4";
                return treeContas.get(model.getPlc_nr_id()).getPlc_tx_nome();
            }
        });
        configs.add(column);

        column = new ColumnConfig();
        column.setId("por_vl_jan");
        column.setHeader("Jan");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(number);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("por_vl_fev");
        column.setHeader("Fev");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(number);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("por_vl_mar");
        column.setHeader("Mar");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(number);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("por_vl_abr");
        column.setHeader("Abr");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(number);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("por_vl_mai");
        column.setHeader("Mai");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(number);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("por_vl_jun");
        column.setHeader("Jun");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(number);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("por_vl_jul");
        column.setHeader("Jul");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(number);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("por_vl_ago");
        column.setHeader("Ago");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(number);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("por_vl_set");
        column.setHeader("Set");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(number);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("por_vl_out");
        column.setHeader("Out");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(number);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("por_vl_nov");
        column.setHeader("Nov");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(number);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("por_vl_dez");
        column.setHeader("Dez");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(number);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("colEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        
        column.setRenderer(getEditarRender());
        configs.add(column);
        povoaConta();

        
    }

    public void povoaConta() {

        AsyncCallback<List<Plc_plano_contasT>> callback = new AsyncCallback<List<Plc_plano_contasT>>() {

            @Override
            public void onFailure(Throwable caught) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onSuccess(List<Plc_plano_contasT> result) {
                for (Plc_plano_contasT plc : result) {
                    treeContas.put(plc.getPlc_nr_id(), plc);
                }
            }
        };
        Plc_plano_contasServiceAsync serviceAsync = GWT.create(Plc_plano_contasService.class);
        serviceAsync.getAllSub(callback);
    }

    public void btnAtualizarAction(ButtonEvent be) {
        super.btnAtualizarAction(be);
    }

    public void btnNovoAction(ButtonEvent be) {
        Por_previsao_orcamentoInsertGWT por_previsao_orcamentoInsertGWT = new Por_previsao_orcamentoInsertGWT();
        por_previsao_orcamentoInsertGWT.setPor_previsao_orcamentoConsult(this);
        por_previsao_orcamentoInsertGWT.setModal(true);
        por_previsao_orcamentoInsertGWT.show();
    }

    private GridCellRenderer<Por_previsao_orcamentoT> getEditarRender() {
        return new GridCellRenderer<Por_previsao_orcamentoT>() {

            public Object render(final Por_previsao_orcamentoT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Por_previsao_orcamentoT> store, Grid<Por_previsao_orcamentoT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Por_previsao_orcamentoUpdateDeleteGWT por_previsao_orcamentoUpdateDeleteGWT = new Por_previsao_orcamentoUpdateDeleteGWT();
                        por_previsao_orcamentoUpdateDeleteGWT.setPor_previsao_orcamentoConsult(Por_previsao_orcamentoConsultGWT.this);
                        por_previsao_orcamentoUpdateDeleteGWT.load(model);
                        por_previsao_orcamentoUpdateDeleteGWT.setVisible(true);
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
         String url = Por_previsao_orcamentoDAOGWT.PAGE_REPORT;  
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
        AsyncCallback<List<Por_previsao_orcamentoT>> callback = new AsyncCallback<List<Por_previsao_orcamentoT>>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<Por_previsao_orcamentoT> result) {
                if (grid != null) {
                    grid.removeFromParent();
                }
                ListStore<Por_previsao_orcamentoT> list = new ListStore<Por_previsao_orcamentoT>();
                list.add(result);

                ColumnModel cm = new ColumnModel(configs);

                PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                PagingLoader<PagingLoadResult<Por_previsao_orcamentoT>> loader = new BasePagingLoader<PagingLoadResult<Por_previsao_orcamentoT>>(proxy);
                loader.setRemoteSort(true);

                ListStore<Por_previsao_orcamentoT> store = new ListStore<Por_previsao_orcamentoT>(loader);
                store.add(list.getModels());

                getToolBarPage().setPageSize(20);
                getToolBarPage().bind(loader);
                loader.load(0, 20);

                grid = new Grid<Por_previsao_orcamentoT>(store, cm);
                grid.setColumnReordering(true);
                grid.setId("grid");
                grid.setLoadMask(true);

                grid.setStyleAttribute("borderTop", "none");
                grid.setBorders(true);
                grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                cpMain.add(grid);
                cpMain.layout();
                getCpMaster().layout();
            }
        };

        Por_previsao_orcamentoServiceAsync por_previsao_orcamentoAsync = GWT.create(Por_previsao_orcamentoService.class);
        por_previsao_orcamentoAsync.getAll(fieldAno.getValue().intValue(),callback);
    }
}
