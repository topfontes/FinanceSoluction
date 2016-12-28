/*
 * EasyNet JDragon
 */
package br.com.i9.finance.client.i9finance.easyfin.ban_banco;

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
public class Ban_bancoConsultGWT extends CPConsultarBaseGWT {

    private Grid<Ban_bancoT> grid = null;
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    public Ban_bancoConsultGWT() {
        setHeaderVisible(false);
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Ban_bancoT>> numberRenderer = new NumberCellRenderer<Grid<Ban_bancoT>>(currency);
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
        column.setId("ban_tx_nome");
        column.setHeader("Banco");
        column.setWidth(200);
        
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ban_tx_status");
        column.setHeader("Status");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        column.setRenderer(new GridCellRenderer<Ban_bancoT>() {

            @Override
            public String render(Ban_bancoT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Ban_bancoT> store, Grid<Ban_bancoT> grid) {
                return model.getBan_tx_status().equalsIgnoreCase("A") ? "Ativo" : "Inativo";
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
        Ban_bancoInsertGWT ban_bancoInsertGWT = new Ban_bancoInsertGWT();
        ban_bancoInsertGWT.setBan_bancoConsult(this);
        ban_bancoInsertGWT.setModal(true);
        ban_bancoInsertGWT.show();
    }

    private GridCellRenderer<Ban_bancoT> getEditarRender() {
        return new GridCellRenderer<Ban_bancoT>() {

            public Object render(final Ban_bancoT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Ban_bancoT> store, Grid<Ban_bancoT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Ban_bancoUpdateDeleteGWT ban_bancoUpdateDeleteGWT = new Ban_bancoUpdateDeleteGWT();
                        ban_bancoUpdateDeleteGWT.setBan_bancoConsult(Ban_bancoConsultGWT.this);
                        ban_bancoUpdateDeleteGWT.load(model);
                        ban_bancoUpdateDeleteGWT.setVisible(true);
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
         String url = Ban_bancoDAOGWT.PAGE_REPORT;  
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
        AsyncCallback<List<Ban_bancoT>> callback = new AsyncCallback<List<Ban_bancoT>>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<Ban_bancoT> result) {
                if (grid != null) {
                    grid.removeFromParent();
                }
                ListStore<Ban_bancoT> list = new ListStore<Ban_bancoT>();
                list.add(result);

                ColumnModel cm = new ColumnModel(configs);

                PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                PagingLoader<PagingLoadResult<Ban_bancoT>> loader = new BasePagingLoader<PagingLoadResult<Ban_bancoT>>(proxy);
                loader.setRemoteSort(true);

                ListStore<Ban_bancoT> store = new ListStore<Ban_bancoT>(loader);
                store.add(list.getModels());

                getToolBarPage().setPageSize(20);
                getToolBarPage().bind(loader);
                loader.load(0, 20);

                grid = new Grid<Ban_bancoT>(store, cm);
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

        Ban_bancoServiceAsync ban_bancoAsync = GWT.create(Ban_bancoService.class);
        ban_bancoAsync.getAll(callback);
    }
}
