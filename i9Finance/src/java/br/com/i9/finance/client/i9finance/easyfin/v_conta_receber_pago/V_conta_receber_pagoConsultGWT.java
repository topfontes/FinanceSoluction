/*
 * EasyNet JDragon
 */
package br.com.i9.finance.client.i9finance.easyfin.v_conta_receber_pago;

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
public class V_conta_receber_pagoConsultGWT extends CPConsultarBaseGWT {

  private Grid<V_conta_receber_pagoT> grid = null;
  private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

  public V_conta_receber_pagoConsultGWT() {
    setHeaderVisible(false);
    this.setSize("500", "400");
    final NumberFormat currency = NumberFormat.getCurrencyFormat();
    final NumberFormat number = NumberFormat.getFormat("0.00");
    final NumberCellRenderer<Grid<V_conta_receber_pagoT>> numberRenderer = new NumberCellRenderer<Grid<V_conta_receber_pagoT>>(currency);
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
            column.setId("dt_pagamento");
            column.setHeader("Dt_pagamento");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("valor");
            column.setHeader("Valor");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("id_cli_fab");
            column.setHeader("Id_cli_fab");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("nome");
            column.setHeader("Nome");
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
            column.setId("forma");
            column.setHeader("Forma");
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
            column.setId("banco");
            column.setHeader("Banco");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("pago");
            column.setHeader("Pago");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("parcela");
            column.setHeader("Parcela");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("documento");
            column.setHeader("Documento");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("dt_emissao");
            column.setHeader("Dt_emissao");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("vencimento");
            column.setHeader("Vencimento");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("obs");
            column.setHeader("Obs");
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
            column.setId("cartao");
            column.setHeader("Cartao");
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
    column.setId("colEditar");
    column.setWidth(30);
    column.setAlignment(HorizontalAlignment.CENTER);
    column.setRenderer(getEditarRender());
    configs.add(column);

    load();
  }

  public void btnAtualizarAction(ButtonEvent be){
    super.btnAtualizarAction(be);
  }

  public void btnNovoAction(ButtonEvent be) {
    V_conta_receber_pagoInsertGWT v_conta_receber_pagoInsertGWT = new V_conta_receber_pagoInsertGWT();
    v_conta_receber_pagoInsertGWT.setV_conta_receber_pagoConsult(this);
    v_conta_receber_pagoInsertGWT.setModal(true);
    v_conta_receber_pagoInsertGWT.show();
  }
  private GridCellRenderer<V_conta_receber_pagoT> getEditarRender() {
    return new GridCellRenderer<V_conta_receber_pagoT>() {

      public Object render(final V_conta_receber_pagoT model, String property, ColumnData config, final int rowIndex,
        final int colIndex, ListStore<V_conta_receber_pagoT> store, Grid<V_conta_receber_pagoT> grid) {

        Button b = new Button();
        b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

        public void handleEvent(ButtonEvent be) {
          V_conta_receber_pagoUpdateDeleteGWT v_conta_receber_pagoUpdateDeleteGWT = new V_conta_receber_pagoUpdateDeleteGWT();
          v_conta_receber_pagoUpdateDeleteGWT.setV_conta_receber_pagoConsult(V_conta_receber_pagoConsultGWT.this);
          v_conta_receber_pagoUpdateDeleteGWT.load(model);
          v_conta_receber_pagoUpdateDeleteGWT.setVisible(true);
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
   * @param formato
   */
  public void export(String formato ) {
        //FORMAT_CSV
        //FORMAT_PDF
        //FORMAT_TXT
/*
	String url = V_conta_receber_pagoDAOGWT.PAGE_REPORT;  
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
    AsyncCallback<List<V_conta_receber_pagoT>> callback = new AsyncCallback<List<V_conta_receber_pagoT>>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(List<V_conta_receber_pagoT> result) {
          if (grid !=  null) {
            grid.removeFromParent();
          }
	  ListStore<V_conta_receber_pagoT> list = new ListStore<V_conta_receber_pagoT>();
  	  list.add(result);

          ColumnModel cm = new ColumnModel(configs);

          PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
          PagingLoader<PagingLoadResult<V_conta_receber_pagoT>> loader = new BasePagingLoader<PagingLoadResult<V_conta_receber_pagoT>>(proxy);
          loader.setRemoteSort(true);

          ListStore<V_conta_receber_pagoT> store = new ListStore<V_conta_receber_pagoT>(loader);
          store.add(list.getModels());

          getToolBarPage().setPageSize(20);
          getToolBarPage().bind(loader);
          loader.load(0, 20);

          grid = new Grid<V_conta_receber_pagoT>(store, cm);
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
    
    V_conta_receber_pagoServiceAsync v_conta_receber_pagoAsync = GWT.create(V_conta_receber_pagoService.class);
    v_conta_receber_pagoAsync.getAll(callback);
  }
}
