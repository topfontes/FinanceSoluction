/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.v_lancamentos;

import static br.com.easynet.gwt.client.CPBaseGWT.ICONS;
import br.com.i9.finance.client.i9finance.easyfin.service.V_lancamentosService;
import br.com.i9.finance.client.i9finance.easyfin.service.V_lancamentosServiceAsync;
import br.com.i9.finance.client.i9finance.easyfin.transfer.V_conta_receberT;
import br.com.i9.finance.client.i9finance.easyfin.transfer.V_lancamentosT;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */
public class PagamentosTitulosReceberGWT extends Window {

    private Grid<V_lancamentosT> grid = null;
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
    private TextArea tx_historico = new TextArea();

    public PagamentosTitulosReceberGWT() {
        setHeight("Pagamentos do título");
        setSize(430, 300);
        setLayout(new FillLayout());

        this.setSize("400", "350");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("#,##0.00");
        final NumberCellRenderer<Grid<V_lancamentosT>> numberRenderer = new NumberCellRenderer<Grid<V_lancamentosT>>(currency);

        ColumnConfig column = null;
        RowNumberer numero = new RowNumberer();
        column = new ColumnConfig();
        configs.add(numero);

        column = new ColumnConfig();
        column.setId("lan_dt_lancamento");
        column.setHeader("Data");
        column.setWidth(80);
        column.setAlignment(Style.HorizontalAlignment.LEFT);
        column.setDateTimeFormat(dtf);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("plc_tx_debito");
        column.setHeader("Conta de saída");
        column.setAlignment(Style.HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("lan_valor");
        column.setHeader("Valor");
        column.setWidth(100);
        column.setAlignment(Style.HorizontalAlignment.RIGHT);
        column.setNumberFormat(number);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("colEditar");
        column.setWidth(30);
        column.setAlignment(Style.HorizontalAlignment.CENTER);
        column.setRenderer(getDelRender());
        configs.add(column);
        FieldSet fieldSet = new FieldSet();
        fieldSet.setHeading("Observação");
        fieldSet.setHeight(70);
        fieldSet.setLayout(new FillLayout());
        fieldSet.add(tx_historico);
        tx_historico.setReadOnly(true);
        setBottomComponent(fieldSet);

    }

    private GridCellRenderer<V_lancamentosT> getDelRender() {
        return new GridCellRenderer<V_lancamentosT>() {

            public Object render(final V_lancamentosT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<V_lancamentosT> store, Grid<V_lancamentosT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {

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

    public void load(V_conta_receberT v_conta_receberT) {
        AsyncCallback<List<V_lancamentosT>> callback = new AsyncCallback<List<V_lancamentosT>>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<V_lancamentosT> result) {
                if (grid != null) {
                    grid.removeFromParent();
                }
                ListStore<V_lancamentosT> list = new ListStore<V_lancamentosT>();
                list.add(result);

                AggregationRowConfig<V_conta_receberT> aggregation = new AggregationRowConfig<V_conta_receberT>();
                aggregation.setHtml("plc_tx_debito", "Total Pago");
                aggregation.setSummaryType("lan_valor", SummaryType.SUM);
                aggregation.setSummaryFormat("lan_valor", NumberFormat.getFormat("#,##0.00"));                 
                
                ColumnModel cm = new ColumnModel(configs);
                cm.addAggregationRow(aggregation);

                ListStore<V_lancamentosT> store = new ListStore<V_lancamentosT>();
                store.add(list.getModels());

                grid = new Grid<V_lancamentosT>(store, cm);
                grid.setAutoExpandColumn("plc_tx_debito");
                grid.setColumnReordering(true);
                grid.setId("grid");
                grid.setLoadMask(true);

                grid.setStyleAttribute("borderTop", "none");
                grid.setBorders(true);
                grid.getSelectionModel().setSelectionMode(Style.SelectionMode.SINGLE);
                grid.getSelectionModel().addSelectionChangedListener(new SelectionChangedListener<V_lancamentosT>() {

                    @Override
                    public void selectionChanged(SelectionChangedEvent<V_lancamentosT> se) {
                        tx_historico.setValue(se.getSelectedItem().getLan_tx_historico());
                    }
                });

                if (result.size() > 0) {
                    grid.getSelectionModel().select(0, true);
                }

                add(grid);
                layout();

            }
        };

        V_lancamentosServiceAsync v_lancamentosAsync = GWT.create(V_lancamentosService.class);
        v_lancamentosAsync.getAllContaReceber(v_conta_receberT.getCtr_nr_id(), callback);
    }

}
