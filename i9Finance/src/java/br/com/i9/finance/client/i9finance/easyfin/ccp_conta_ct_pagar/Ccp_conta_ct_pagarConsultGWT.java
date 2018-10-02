/*
 * EasyNet JDragon
 */
package br.com.i9.finance.client.i9finance.easyfin.ccp_conta_ct_pagar;

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
public class Ccp_conta_ct_pagarConsultGWT extends CPConsultarBaseGWT {

    private Grid<Ccp_conta_ct_pagarT> grid = null;
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    public Ccp_conta_ct_pagarConsultGWT() {
        setHeaderVisible(false);
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Ccp_conta_ct_pagarT>> numberRenderer = new NumberCellRenderer<Grid<Ccp_conta_ct_pagarT>>(currency);
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
        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
        ColumnConfig column = null;
        RowNumberer numero = new RowNumberer();
        column = new ColumnConfig();
        configs.add(numero);

        column = new ColumnConfig();
        column.setId("ccp_nr_id");
        column.setHeader("Ccp_nr_id");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ctp_nr_id");
        column.setHeader("Ctp_nr_id");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plc_nr_id");
        column.setHeader("Plc_nr_id");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ccp_valor");
        column.setHeader("Ccp_valor");
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
        Ccp_conta_ct_pagarInsertGWT ccp_conta_ct_pagarInsertGWT = new Ccp_conta_ct_pagarInsertGWT();
        ccp_conta_ct_pagarInsertGWT.setCcp_conta_ct_pagarConsult(this);
        ccp_conta_ct_pagarInsertGWT.setModal(true);
        ccp_conta_ct_pagarInsertGWT.show();
    }

    private GridCellRenderer<Ccp_conta_ct_pagarT> getEditarRender() {
        return new GridCellRenderer<Ccp_conta_ct_pagarT>() {

            public Object render(final Ccp_conta_ct_pagarT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Ccp_conta_ct_pagarT> store, Grid<Ccp_conta_ct_pagarT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Ccp_conta_ct_pagarUpdateDeleteGWT ccp_conta_ct_pagarUpdateDeleteGWT = new Ccp_conta_ct_pagarUpdateDeleteGWT();
                        ccp_conta_ct_pagarUpdateDeleteGWT.setCcp_conta_ct_pagarConsult(Ccp_conta_ct_pagarConsultGWT.this);
                        ccp_conta_ct_pagarUpdateDeleteGWT.load(model);
                        ccp_conta_ct_pagarUpdateDeleteGWT.setVisible(true);
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
	String url = Ccp_conta_ct_pagarDAOGWT.PAGE_REPORT;  
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
        AsyncCallback<List<Ccp_conta_ct_pagarT>> callback = new AsyncCallback<List<Ccp_conta_ct_pagarT>>() {
            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<Ccp_conta_ct_pagarT> result) {
                if (grid != null) {
                    grid.removeFromParent();
                }
                ListStore<Ccp_conta_ct_pagarT> list = new ListStore<Ccp_conta_ct_pagarT>();
                list.add(result);

                ColumnModel cm = new ColumnModel(configs);

                PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                PagingLoader<PagingLoadResult<Ccp_conta_ct_pagarT>> loader = new BasePagingLoader<PagingLoadResult<Ccp_conta_ct_pagarT>>(proxy);
                loader.setRemoteSort(true);

                ListStore<Ccp_conta_ct_pagarT> store = new ListStore<Ccp_conta_ct_pagarT>(loader);
                store.add(list.getModels());

                getToolBarPage().setPageSize(20);
                getToolBarPage().bind(loader);
                loader.load(0, 20);

                grid = new Grid<Ccp_conta_ct_pagarT>(store, cm);
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

        Ccp_conta_ct_pagarServiceAsync ccp_conta_ct_pagarAsync = GWT.create(Ccp_conta_ct_pagarService.class);
        ccp_conta_ct_pagarAsync.getAll(callback);
    }
}
