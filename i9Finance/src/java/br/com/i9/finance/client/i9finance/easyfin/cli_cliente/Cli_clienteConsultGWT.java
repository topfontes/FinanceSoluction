/*
 * EasyNet JDragon
 */
package br.com.i9.finance.client.i9finance.easyfin.cli_cliente;

import br.com.i9.finance.client.Constantes;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;
import br.com.easynet.gwt.client.CPConsultarBaseGWT;

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

/**
 *
 * @author geoleite
 */
public class Cli_clienteConsultGWT extends CPConsultarBaseGWT {

    private Grid<Cli_clienteT> grid = null;
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    public Cli_clienteConsultGWT() {
        setHeaderVisible(false);
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Cli_clienteT>> numberRenderer = new NumberCellRenderer<Grid<Cli_clienteT>>(currency);
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
        ColumnConfig column = null;
        RowNumberer numero = new RowNumberer();
        column = new ColumnConfig();
        configs.add(numero);


        column = new ColumnConfig();
        column.setId("cli_tx_nome");
        column.setHeader("Nome");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);
 
        column = new ColumnConfig();
        column.setId("cli_tx_rg_inscricao");
        column.setHeader("Inscrição");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);


        column = new ColumnConfig();
        column.setId("cli_tx_cpf_cnpj");
        column.setHeader("CPF/CNPJ");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("cli_tx_email");
        column.setHeader("E-mail");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);


        column = new ColumnConfig();
        column.setId("cli_tx_contato");
        column.setHeader("Contato");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("cli_tx_status");
        column.setHeader("Status");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.LEFT);
        column.setRenderer(new GridCellRenderer<Cli_clienteT>() {

            @Override
            public String render(Cli_clienteT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Cli_clienteT> store, Grid<Cli_clienteT> grid) {
                return model.getCli_tx_status().equalsIgnoreCase("A")?"Ativo":"Inativo";
            }
        });
        configs.add(column);


        column = new ColumnConfig();
        column.setId("colEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);

        load();
    }

    public void btnAtualizarAction(ButtonEvent be) {
        super.btnAtualizarAction(be);
    }

    public void btnNovoAction(ButtonEvent be) {
        Cli_clienteInsertGWT cli_clienteInsertGWT = new Cli_clienteInsertGWT();
        cli_clienteInsertGWT.setCli_clienteConsult(this);
        cli_clienteInsertGWT.setModal(true);
        cli_clienteInsertGWT.show();
    }

    private GridCellRenderer<Cli_clienteT> getEditarRender() {
        return new GridCellRenderer<Cli_clienteT>() {

            public Object render(final Cli_clienteT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Cli_clienteT> store, Grid<Cli_clienteT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Cli_clienteUpdateDeleteGWT cli_clienteUpdateDeleteGWT = new Cli_clienteUpdateDeleteGWT();
                        cli_clienteUpdateDeleteGWT.setCli_clienteConsult(Cli_clienteConsultGWT.this);
                        cli_clienteUpdateDeleteGWT.load(model);
                        cli_clienteUpdateDeleteGWT.setVisible(true);
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
         String url = Cli_clienteDAOGWT.PAGE_REPORT;  
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
        AsyncCallback<List<Cli_clienteT>> callback = new AsyncCallback<List<Cli_clienteT>>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<Cli_clienteT> result) {
                if (grid != null) {
                    grid.removeFromParent();
                }
                ListStore<Cli_clienteT> list = new ListStore<Cli_clienteT>();
                list.add(result);

                ColumnModel cm = new ColumnModel(configs);

                PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                PagingLoader<PagingLoadResult<Cli_clienteT>> loader = new BasePagingLoader<PagingLoadResult<Cli_clienteT>>(proxy);
                loader.setRemoteSort(true);

                ListStore<Cli_clienteT> store = new ListStore<Cli_clienteT>(loader);
                store.add(list.getModels());

                getToolBarPage().setPageSize(20);
                getToolBarPage().bind(loader);
                loader.load(0, 20);

                grid = new Grid<Cli_clienteT>(store, cm);
                grid.setColumnReordering(true);
                grid.setId("grid");
                grid.setLoadMask(true);

                grid.setStyleAttribute("borderTop", "none");
                grid.setBorders(true);
                grid.setAutoExpandColumn("cli_tx_nome");
                grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                getCpMaster().add(grid);
                getCpMaster().layout();
            }
        };

        Cli_clienteServiceAsync cli_clienteAsync = GWT.create(Cli_clienteService.class);
        cli_clienteAsync.getAll(callback);
    }
}
