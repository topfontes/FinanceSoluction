/*
 * EasyNet JDragon
 */
package br.com.i9.finance.client.i9finance.easyfin.ctr_conta_recebe;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.CPConsultarBaseGWT;

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
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.i18n.client.NumberFormat;

import br.com.i9.finance.client.i9finance.easyfin.service.*;

/**
 *
 * @author geoleite
 */
public class Ctr_conta_recebeConsultGWT extends CPConsultarBaseGWT {

    private Grid<Ctr_conta_recebeT> grid = null;
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    public Ctr_conta_recebeConsultGWT() {
        setHeaderVisible(false);
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Ctr_conta_recebeT>> numberRenderer = new NumberCellRenderer<Grid<Ctr_conta_recebeT>>(currency);

        ColumnConfig column = null;
        RowNumberer numero = new RowNumberer();
        column = new ColumnConfig();
        configs.add(numero);

        column = new ColumnConfig();


        column = new ColumnConfig();
        column.setId("cli_nr_id");
        column.setHeader("Cli_nr_id");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ctr_nr_doc");
        column.setHeader("Ctr_nr_doc");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ctr_dt_emissao");
        column.setHeader("Ctr_dt_emissao");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ctr_dt_vencimento");
        column.setHeader("Ctr_dt_vencimento");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("fop_nr_id");
        column.setHeader("Fop_nr_id");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ctr_tx_pago");
        column.setHeader("Ctr_tx_pago");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ban_nr_id");
        column.setHeader("Ban_nr_id");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ctr_valor");
        column.setHeader("Ctr_valor");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ctr_tx_parcela");
        column.setHeader("Ctr_tx_parcela");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ctr_dt_pagamento");
        column.setHeader("Ctr_dt_pagamento");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("car_nr_id");
        column.setHeader("Car_nr_id");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ctr_vl_pago");
        column.setHeader("Ctr_vl_pago");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ctr_saldo");
        column.setHeader("Ctr_saldo");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("loj_nr_id");
        column.setHeader("Loj_nr_id");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ctr_tx_obs");
        column.setHeader("Ctr_tx_obs");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ctr_tx_tipo_vinculo");
        column.setHeader("Ctr_tx_tipo_vinculo");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ctr_nr_id_vinculo");
        column.setHeader("Ctr_nr_id_vinculo");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
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
        Ctr_conta_recebeInsertGWT ctr_conta_recebeInsertGWT = new Ctr_conta_recebeInsertGWT();
        //ctr_conta_recebeInsertGWT.setCtr_conta_recebeConsult(this);
        ctr_conta_recebeInsertGWT.setModal(true);
        ctr_conta_recebeInsertGWT.show();
    }

    private GridCellRenderer<Ctr_conta_recebeT> getEditarRender() {
        return new GridCellRenderer<Ctr_conta_recebeT>() {

            public Object render(final Ctr_conta_recebeT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Ctr_conta_recebeT> store, Grid<Ctr_conta_recebeT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Ctr_conta_recebeUpdateDeleteGWT ctr_conta_recebeUpdateDeleteGWT = new Ctr_conta_recebeUpdateDeleteGWT();
                        //ctr_conta_recebeUpdateDeleteGWT.setCtr_conta_recebeConsult(Ctr_conta_recebeConsultGWT.this);
                        //ctr_conta_recebeUpdateDeleteGWT.load(model);
                        ctr_conta_recebeUpdateDeleteGWT.setVisible(true);
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
         String url = Ctr_conta_recebeDAOGWT.PAGE_REPORT;  
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
        AsyncCallback<List<Ctr_conta_recebeT>> callback = new AsyncCallback<List<Ctr_conta_recebeT>>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<Ctr_conta_recebeT> result) {
                if (grid != null) {
                    grid.removeFromParent();
                }
                ListStore<Ctr_conta_recebeT> list = new ListStore<Ctr_conta_recebeT>();
                list.add(result);

                ColumnModel cm = new ColumnModel(configs);

                PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                PagingLoader<PagingLoadResult<Ctr_conta_recebeT>> loader = new BasePagingLoader<PagingLoadResult<Ctr_conta_recebeT>>(proxy);
                loader.setRemoteSort(true);

                ListStore<Ctr_conta_recebeT> store = new ListStore<Ctr_conta_recebeT>(loader);
                store.add(list.getModels());

                getToolBarPage().setPageSize(20);
                getToolBarPage().bind(loader);
                loader.load(0, 20);

                grid = new Grid<Ctr_conta_recebeT>(store, cm);
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

        Ctr_conta_recebeServiceAsync ctr_conta_recebeAsync = GWT.create(Ctr_conta_recebeService.class);
        ctr_conta_recebeAsync.getAll(callback);
    }
}
