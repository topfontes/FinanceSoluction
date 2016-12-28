/*
 * EasyNet JDragon
 */
package br.com.i9.finance.client.i9finance.easyfin.fop_forma_pagamento;

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
public class Fop_forma_pagamentoConsultGWT extends CPConsultarBaseGWT {

    private Grid<Fop_forma_pagamentoT> grid = null;
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    public Fop_forma_pagamentoConsultGWT() {
        setHeaderVisible(false);
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Fop_forma_pagamentoT>> numberRenderer = new NumberCellRenderer<Grid<Fop_forma_pagamentoT>>(currency);
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

//        column = new ColumnConfig();
//        column.setId("fop_tx_status");
//        column.setHeader("stauts");
//        column.setWidth(200);
//        column.setAlignment(HorizontalAlignment.LEFT);
//        configs.add(column);

        column = new ColumnConfig();
        column.setId("fop_tx_nome");
        column.setHeader("Nome");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

//        column = new ColumnConfig();
//        column.setId("loj_nr_id");
//        column.setHeader("Loj_nr_id");
//        column.setWidth(200);
//        column.setAlignment(HorizontalAlignment.LEFT);
//        configs.add(column);

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
        Fop_forma_pagamentoInsertGWT fop_forma_pagamentoInsertGWT = new Fop_forma_pagamentoInsertGWT();
        fop_forma_pagamentoInsertGWT.setFop_forma_pagamentoConsult(this);
        fop_forma_pagamentoInsertGWT.setModal(true);
        fop_forma_pagamentoInsertGWT.show();
    }

    private GridCellRenderer<Fop_forma_pagamentoT> getEditarRender() {
        return new GridCellRenderer<Fop_forma_pagamentoT>() {

            public Object render(final Fop_forma_pagamentoT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Fop_forma_pagamentoT> store, Grid<Fop_forma_pagamentoT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Fop_forma_pagamentoUpdateDeleteGWT fop_forma_pagamentoUpdateDeleteGWT = new Fop_forma_pagamentoUpdateDeleteGWT();
                        fop_forma_pagamentoUpdateDeleteGWT.setFop_forma_pagamentoConsult(Fop_forma_pagamentoConsultGWT.this);
                        fop_forma_pagamentoUpdateDeleteGWT.load(model);
                        fop_forma_pagamentoUpdateDeleteGWT.setVisible(true);
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
         String url = Fop_forma_pagamentoDAOGWT.PAGE_REPORT;  
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
        AsyncCallback<List<Fop_forma_pagamentoT>> callback = new AsyncCallback<List<Fop_forma_pagamentoT>>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<Fop_forma_pagamentoT> result) {
                if (grid != null) {
                    grid.removeFromParent();
                }
                ListStore<Fop_forma_pagamentoT> list = new ListStore<Fop_forma_pagamentoT>();
                list.add(result);

                ColumnModel cm = new ColumnModel(configs);

                PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                PagingLoader<PagingLoadResult<Fop_forma_pagamentoT>> loader = new BasePagingLoader<PagingLoadResult<Fop_forma_pagamentoT>>(proxy);
                loader.setRemoteSort(true);

                ListStore<Fop_forma_pagamentoT> store = new ListStore<Fop_forma_pagamentoT>(loader);
                store.add(list.getModels());

                getToolBarPage().setPageSize(20);
                getToolBarPage().bind(loader);
                loader.load(0, 20);

                grid = new Grid<Fop_forma_pagamentoT>(store, cm);
                grid.setColumnReordering(true);
                grid.setId("grid");
                grid.setLoadMask(true);

                grid.setStyleAttribute("borderTop", "none");
                grid.setBorders(true);
                grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                getCpMaster().add(grid);
                getCpMaster().layout();
            }
        };

        Fop_forma_pagamentoServiceAsync fop_forma_pagamentoAsync = GWT.create(Fop_forma_pagamentoService.class);
        fop_forma_pagamentoAsync.getAll(callback);
    }
}
