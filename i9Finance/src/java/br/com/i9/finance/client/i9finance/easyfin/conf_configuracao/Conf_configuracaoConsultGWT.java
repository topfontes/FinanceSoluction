/*
 * EasyNet JDragon
 */
package br.com.i9.finance.client.i9finance.easyfin.conf_configuracao;

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
public class Conf_configuracaoConsultGWT extends CPConsultarBaseGWT {

  private Grid<Conf_configuracaoT> grid = null;
  private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

  public Conf_configuracaoConsultGWT() {
    setHeaderVisible(false);
    this.setSize("500", "400");
    final NumberFormat currency = NumberFormat.getCurrencyFormat();
    final NumberFormat number = NumberFormat.getFormat("0.00");
    final NumberCellRenderer<Grid<Conf_configuracaoT>> numberRenderer = new NumberCellRenderer<Grid<Conf_configuracaoT>>(currency);
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
            column.setId("conf_plc_nr_id_juros_recebido");
            column.setHeader("Conf_plc_nr_id_juros_recebido");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("conf_plc_nr_id_desconto_consedido");
            column.setHeader("Conf_plc_nr_id_desconto_consedido");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("conf_plc_nr_id_desconto_recebido");
            column.setHeader("Conf_plc_nr_id_desconto_recebido");
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
            column.setId("conf_plc_nr_id_taxa_cartao");
            column.setHeader("Conf_plc_nr_id_taxa_cartao");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("conf_tx_lancamento_auto_taxa_cartao");
            column.setHeader("Conf_tx_lancamento_auto_taxa_cartao");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("conf_plc_nr_id_juros_consedido");
            column.setHeader("Conf_plc_nr_id_juros_consedido");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("conf_tx_baixa_cartao_automatico");
            column.setHeader("Conf_tx_baixa_cartao_automatico");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("conf_nr_id");
            column.setHeader("Conf_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("conf_plc_nr_id_default");
            column.setHeader("Conf_plc_nr_id_default");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("conf_plc_nr_id_caixa");
            column.setHeader("Conf_plc_nr_id_caixa");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("conf_tx_lan_auto_conta_vinc_ctr");
            column.setHeader("Conf_tx_lan_auto_conta_vinc_ctr");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("conf_tx_lan_auto_conta_vinc_ctp");
            column.setHeader("Conf_tx_lan_auto_conta_vinc_ctp");
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
    Conf_configuracaoInsertGWT conf_configuracaoInsertGWT = new Conf_configuracaoInsertGWT();
    conf_configuracaoInsertGWT.setConf_configuracaoConsult(this);
    conf_configuracaoInsertGWT.setModal(true);
    conf_configuracaoInsertGWT.show();
  }
  private GridCellRenderer<Conf_configuracaoT> getEditarRender() {
    return new GridCellRenderer<Conf_configuracaoT>() {

      public Object render(final Conf_configuracaoT model, String property, ColumnData config, final int rowIndex,
        final int colIndex, ListStore<Conf_configuracaoT> store, Grid<Conf_configuracaoT> grid) {

        Button b = new Button();
        b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

        public void handleEvent(ButtonEvent be) {
          Conf_configuracaoUpdateDeleteGWT conf_configuracaoUpdateDeleteGWT = new Conf_configuracaoUpdateDeleteGWT();
          conf_configuracaoUpdateDeleteGWT.setConf_configuracaoConsult(Conf_configuracaoConsultGWT.this);
          conf_configuracaoUpdateDeleteGWT.load(model);
          conf_configuracaoUpdateDeleteGWT.setVisible(true);
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
	String url = Conf_configuracaoDAOGWT.PAGE_REPORT;  
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
    AsyncCallback<List<Conf_configuracaoT>> callback = new AsyncCallback<List<Conf_configuracaoT>>() {

      public void onFailure(Throwable caught) {
      	MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
      }

      public void onSuccess(List<Conf_configuracaoT> result) {
          if (grid !=  null) {
            grid.removeFromParent();
          }
	  ListStore<Conf_configuracaoT> list = new ListStore<Conf_configuracaoT>();
  	  list.add(result);

          ColumnModel cm = new ColumnModel(configs);

          PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
          PagingLoader<PagingLoadResult<Conf_configuracaoT>> loader = new BasePagingLoader<PagingLoadResult<Conf_configuracaoT>>(proxy);
          loader.setRemoteSort(true);

          ListStore<Conf_configuracaoT> store = new ListStore<Conf_configuracaoT>(loader);
          store.add(list.getModels());

          getToolBarPage().setPageSize(20);
          getToolBarPage().bind(loader);
          loader.load(0, 20);

          grid = new Grid<Conf_configuracaoT>(store, cm);
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
    
    Conf_configuracaoServiceAsync conf_configuracaoAsync = GWT.create(Conf_configuracaoService.class);
    conf_configuracaoAsync.getAll(callback);
  }
}
