/*
 * EasyNet JDragon
 */
package br.com.i9.finance.client.i9finance.easyfin.int_intervalo_parcelamento;

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
public class Int_intervalo_parcelamentoConsultGWT extends CPConsultarBaseGWT {

  private Grid<Int_intervalo_parcelamentoT> grid = null;
  private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

  public Int_intervalo_parcelamentoConsultGWT() {
    setHeaderVisible(false);
    this.setSize("500", "400");
    final NumberFormat currency = NumberFormat.getCurrencyFormat();
    final NumberFormat number = NumberFormat.getFormat("0.00");
    final NumberCellRenderer<Grid<Int_intervalo_parcelamentoT>> numberRenderer = new NumberCellRenderer<Grid<Int_intervalo_parcelamentoT>>(currency);
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
            column.setId("int_nr_id");
            column.setHeader("Int_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("int_nr_dia");
            column.setHeader("Int_nr_dia");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("int_perc_valor");
            column.setHeader("Int_perc_valor");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("par_nr_id");
            column.setHeader("Par_nr_id");
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
    Int_intervalo_parcelamentoInsertGWT int_intervalo_parcelamentoInsertGWT = new Int_intervalo_parcelamentoInsertGWT();
    int_intervalo_parcelamentoInsertGWT.setInt_intervalo_parcelamentoConsult(this);
    int_intervalo_parcelamentoInsertGWT.setModal(true);
    int_intervalo_parcelamentoInsertGWT.show();
  }
  private GridCellRenderer<Int_intervalo_parcelamentoT> getEditarRender() {
    return new GridCellRenderer<Int_intervalo_parcelamentoT>() {

      public Object render(final Int_intervalo_parcelamentoT model, String property, ColumnData config, final int rowIndex,
        final int colIndex, ListStore<Int_intervalo_parcelamentoT> store, Grid<Int_intervalo_parcelamentoT> grid) {

        Button b = new Button();
        b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

        public void handleEvent(ButtonEvent be) {
          Int_intervalo_parcelamentoUpdateDeleteGWT int_intervalo_parcelamentoUpdateDeleteGWT = new Int_intervalo_parcelamentoUpdateDeleteGWT();
          int_intervalo_parcelamentoUpdateDeleteGWT.setInt_intervalo_parcelamentoConsult(Int_intervalo_parcelamentoConsultGWT.this);
          int_intervalo_parcelamentoUpdateDeleteGWT.load(model);
          int_intervalo_parcelamentoUpdateDeleteGWT.setVisible(true);
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
	String url = Int_intervalo_parcelamentoDAOGWT.PAGE_REPORT;  
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
    AsyncCallback<List<Int_intervalo_parcelamentoT>> callback = new AsyncCallback<List<Int_intervalo_parcelamentoT>>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(List<Int_intervalo_parcelamentoT> result) {
          if (grid !=  null) {
            grid.removeFromParent();
          }
	  ListStore<Int_intervalo_parcelamentoT> list = new ListStore<Int_intervalo_parcelamentoT>();
  	  list.add(result);

          ColumnModel cm = new ColumnModel(configs);

          PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
          PagingLoader<PagingLoadResult<Int_intervalo_parcelamentoT>> loader = new BasePagingLoader<PagingLoadResult<Int_intervalo_parcelamentoT>>(proxy);
          loader.setRemoteSort(true);

          ListStore<Int_intervalo_parcelamentoT> store = new ListStore<Int_intervalo_parcelamentoT>(loader);
          store.add(list.getModels());

          getToolBarPage().setPageSize(20);
          getToolBarPage().bind(loader);
          loader.load(0, 20);

          grid = new Grid<Int_intervalo_parcelamentoT>(store, cm);
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
    
    Int_intervalo_parcelamentoServiceAsync int_intervalo_parcelamentoAsync = GWT.create(Int_intervalo_parcelamentoService.class);
    int_intervalo_parcelamentoAsync.getAll(callback);
  }
}
