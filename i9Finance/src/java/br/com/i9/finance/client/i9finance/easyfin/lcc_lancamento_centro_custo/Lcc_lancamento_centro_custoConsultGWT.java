/*
 * EasyNet JDragon
 */
package br.com.i9.finance.client.i9finance.easyfin.lcc_lancamento_centro_custo;

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
public class Lcc_lancamento_centro_custoConsultGWT extends CPConsultarBaseGWT {

  private Grid<Lcc_lancamento_centro_custoT> grid = null;
  private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

  public Lcc_lancamento_centro_custoConsultGWT() {
    setHeaderVisible(false);
    this.setSize("500", "400");
    final NumberFormat currency = NumberFormat.getCurrencyFormat();
    final NumberFormat number = NumberFormat.getFormat("0.00");
    final NumberCellRenderer<Grid<Lcc_lancamento_centro_custoT>> numberRenderer = new NumberCellRenderer<Grid<Lcc_lancamento_centro_custoT>>(currency);
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
            column.setId("lcc_nr_id");
            column.setHeader("Lcc_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("cen_nr_id");
            column.setHeader("Cen_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("lcc_dt_lancamento");
            column.setHeader("Lcc_dt_lancamento");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("lcc_valor");
            column.setHeader("Lcc_valor");
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
            column.setId("lan_nr_id");
            column.setHeader("Lan_nr_id");
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
    Lcc_lancamento_centro_custoInsertGWT lcc_lancamento_centro_custoInsertGWT = new Lcc_lancamento_centro_custoInsertGWT();
    lcc_lancamento_centro_custoInsertGWT.setLcc_lancamento_centro_custoConsult(this);
    lcc_lancamento_centro_custoInsertGWT.setModal(true);
    lcc_lancamento_centro_custoInsertGWT.show();
  }
  private GridCellRenderer<Lcc_lancamento_centro_custoT> getEditarRender() {
    return new GridCellRenderer<Lcc_lancamento_centro_custoT>() {

      public Object render(final Lcc_lancamento_centro_custoT model, String property, ColumnData config, final int rowIndex,
        final int colIndex, ListStore<Lcc_lancamento_centro_custoT> store, Grid<Lcc_lancamento_centro_custoT> grid) {

        Button b = new Button();
        b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

        public void handleEvent(ButtonEvent be) {
          Lcc_lancamento_centro_custoUpdateDeleteGWT lcc_lancamento_centro_custoUpdateDeleteGWT = new Lcc_lancamento_centro_custoUpdateDeleteGWT();
          lcc_lancamento_centro_custoUpdateDeleteGWT.setLcc_lancamento_centro_custoConsult(Lcc_lancamento_centro_custoConsultGWT.this);
          lcc_lancamento_centro_custoUpdateDeleteGWT.load(model);
          lcc_lancamento_centro_custoUpdateDeleteGWT.setVisible(true);
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
	String url = Lcc_lancamento_centro_custoDAOGWT.PAGE_REPORT;  
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
    AsyncCallback<List<Lcc_lancamento_centro_custoT>> callback = new AsyncCallback<List<Lcc_lancamento_centro_custoT>>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(List<Lcc_lancamento_centro_custoT> result) {
          if (grid !=  null) {
            grid.removeFromParent();
          }
	  ListStore<Lcc_lancamento_centro_custoT> list = new ListStore<Lcc_lancamento_centro_custoT>();
  	  list.add(result);

          ColumnModel cm = new ColumnModel(configs);

          PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
          PagingLoader<PagingLoadResult<Lcc_lancamento_centro_custoT>> loader = new BasePagingLoader<PagingLoadResult<Lcc_lancamento_centro_custoT>>(proxy);
          loader.setRemoteSort(true);

          ListStore<Lcc_lancamento_centro_custoT> store = new ListStore<Lcc_lancamento_centro_custoT>(loader);
          store.add(list.getModels());

          getToolBarPage().setPageSize(20);
          getToolBarPage().bind(loader);
          loader.load(0, 20);

          grid = new Grid<Lcc_lancamento_centro_custoT>(store, cm);
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
    
    Lcc_lancamento_centro_custoServiceAsync lcc_lancamento_centro_custoAsync = GWT.create(Lcc_lancamento_centro_custoService.class);
    lcc_lancamento_centro_custoAsync.getAll(callback);
  }
}
