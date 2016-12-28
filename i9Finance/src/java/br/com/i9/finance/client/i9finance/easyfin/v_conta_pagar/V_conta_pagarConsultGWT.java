/*
 * EasyNet JDragon
 */
package br.com.i9.finance.client.i9finance.easyfin.v_conta_pagar;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9.finance.client.i9finance.easyfin.ctp_conta_pagar.Ctp_conta_pagarInsertGWT;
import br.com.i9.finance.client.i9finance.easyfin.ctp_conta_pagar.Ctp_conta_pagarUpdateDeleteGWT;

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
import br.com.i9.finance.client.i9finance.easyfin.v_lancamentos.PagamentosTitulosPagarGWT;
import br.com.i9.finance.client.i9finance.easyfin.v_lancamentos.PagamentosTitulosReceberGWT;
import br.com.i9.finance.client.icones.icons.Icones;
import br.com.i9.finance.client.util.BaixaTitulosPagarGWT;
import br.com.i9.finance.client.util.BaixaTitulosReceberGWT;
import br.com.i9.finance.client.util.TituloReceber_PagarGWT;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import java.util.Map;

/**
 *
 * @author geoleite
 */
public class V_conta_pagarConsultGWT extends TituloReceber_PagarGWT {

    private Grid<V_conta_pagarT> grid = null;
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    public V_conta_pagarConsultGWT() {
        setHeaderVisible(false);
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<V_conta_pagarT>> numberRenderer = new NumberCellRenderer<Grid<V_conta_pagarT>>(currency);
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

        SummaryColumnConfig<Integer> columnDoc = new SummaryColumnConfig<Integer>();
        columnDoc.setId("documento");
        columnDoc.setHeader("Documento");
        columnDoc.setWidth(90);
        columnDoc.setAlignment(HorizontalAlignment.LEFT);
        columnDoc.setSummaryType(SummaryType.COUNT);

        columnDoc.setSummaryRenderer(new SummaryRenderer() {

            public String render(Number value, Map<String, Number> data) {
                return value.intValue() > 1 ? "(" + value.intValue() + " Títulos)" : "(1 Título)";
            }
        });
        configs.add(columnDoc);

        SummaryColumnConfig<Double> columnCli = new SummaryColumnConfig<Double>();
        columnCli.setId("nome");
        columnCli.setHeader("Cliente");
        columnCli.setWidth(200);
        columnCli.setAlignment(HorizontalAlignment.LEFT);

        SummaryColumnConfig<Double> columnForma = new SummaryColumnConfig<Double>();
        columnForma.setId("forma");
        columnForma.setHeader("Forma Pag.");
        columnForma.setWidth(150);
        columnForma.setAlignment(HorizontalAlignment.LEFT);

        SummaryColumnConfig<Double> columnParc = new SummaryColumnConfig<Double>();
        columnParc.setId("parcela");
        columnParc.setHeader("Parc.");
        columnParc.setWidth(50);
        columnParc.setAlignment(HorizontalAlignment.LEFT);

        SummaryColumnConfig<Double> columnValor = new SummaryColumnConfig<Double>();
        columnValor.setId("saldo");
        columnValor.setHeader("Valor");

        columnValor.setRenderer(new GridCellRenderer<V_conta_pagarT>() {
            @Override
            public Object render(V_conta_pagarT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<V_conta_pagarT> store, Grid<V_conta_pagarT> grid) {
                NumberFormat format = NumberFormat.getFormat("#,##0.00");
                config.style = "background-color: #F1F2F4";

                return "<span style='align:right'>" + format.format(model.getSaldo()) + "</span>";
            }
        });

        columnValor.setWidth(90);
        columnValor.setNumberFormat(number);
        columnValor.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        columnValor.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
        columnValor.setAlignment(HorizontalAlignment.RIGHT);
        columnValor.setSummaryType(SummaryType.SUM);

        SummaryColumnConfig<Double> columnEmissao = new SummaryColumnConfig<Double>();
        columnEmissao.setId("dt_emissao");
        columnEmissao.setHeader("Dt. Emissao");
        columnEmissao.setWidth(90);
        columnEmissao.setAlignment(HorizontalAlignment.LEFT);
        columnEmissao.setDateTimeFormat(dtf);

        SummaryColumnConfig<Double> columnVen = new SummaryColumnConfig<Double>();
        columnVen.setId("vencimento");
        columnVen.setHeader("Vencimento");
        columnVen.setWidth(100);
        columnVen.setAlignment(HorizontalAlignment.LEFT);
        columnVen.setDateTimeFormat(dtf);

        SummaryColumnConfig<Double> columnDtPag = new SummaryColumnConfig<Double>();
        columnDtPag.setId("dt_pagamento");
        columnDtPag.setHeader("Dt. Pagamento");
        columnDtPag.setWidth(100);
        columnDtPag.setAlignment(HorizontalAlignment.LEFT);
        columnDtPag.setDateTimeFormat(dtf);

        SummaryColumnConfig<Double> columnObs = new SummaryColumnConfig<Double>();
        columnObs.setId("obs");
        columnObs.setHeader("Obs");
        columnObs.setWidth(200);
        columnObs.setAlignment(HorizontalAlignment.LEFT);
        columnObs.setDateTimeFormat(dtf);

        configs.add(columnCli);
        configs.add(columnForma);
        configs.add(columnParc);
        configs.add(columnValor);
        configs.add(columnEmissao);
        configs.add(columnVen);
        configs.add(columnDtPag);
        configs.add(columnObs);

        SummaryColumnConfig columnbaixa = new SummaryColumnConfig();
        columnbaixa.setId("colBaixa");
        columnbaixa.setWidth(30);
        columnbaixa.setAlignment(HorizontalAlignment.CENTER);
        columnbaixa.setRenderer(getBaixaRender());
        configs.add(columnbaixa);

        SummaryColumnConfig columnPag = new SummaryColumnConfig();
        columnPag.setId("colBaixa");
        columnPag.setWidth(30);
        columnPag.setAlignment(HorizontalAlignment.CENTER);
        columnPag.setRenderer(getPagamentosRender());
        configs.add(columnPag);

        SummaryColumnConfig columnEdit = new SummaryColumnConfig();
        columnEdit.setId("colEditar");
        columnEdit.setWidth(30);
        columnEdit.setAlignment(HorizontalAlignment.CENTER);
        columnEdit.setRenderer(getEditarRender());
        configs.add(columnEdit);
        rApagar.setBoxLabel("A Pagar");

        load();

    }

    private GridCellRenderer<V_conta_pagarT> getPagamentosRender() {
        return new GridCellRenderer<V_conta_pagarT>() {

            public Object render(final V_conta_pagarT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<V_conta_pagarT> store, Grid<V_conta_pagarT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        PagamentosTitulosPagarGWT pagamentosTitulosPagarGWT = new PagamentosTitulosPagarGWT();
                        pagamentosTitulosPagarGWT.setModal(true);
                        pagamentosTitulosPagarGWT.load(model);
                        pagamentosTitulosPagarGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Pagamentos do Título");
                b.setIcon(Icones.ICONS.anexar());
                b.setId("btnpgto");

                return b;
            }
        };
    }

    private GridCellRenderer<V_conta_pagarT> getBaixaRender() {
        return new GridCellRenderer<V_conta_pagarT>() {

            public Object render(final V_conta_pagarT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<V_conta_pagarT> store, Grid<V_conta_pagarT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        BaixaTitulosPagarGWT baixaTitulosPagarGWT = new BaixaTitulosPagarGWT(model);
                        baixaTitulosPagarGWT.setConsultGWT(V_conta_pagarConsultGWT.this);
                        baixaTitulosPagarGWT.setModal(true);
                        baixaTitulosPagarGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Baixa do Título");
                b.setIcon(Icones.ICONS.view());
                b.setId("btnbaixa");

                return b;
            }
        };
    }

    public void btnAtualizarAction(ButtonEvent be) {
        super.btnAtualizarAction(be);
    }

    public void btnNovoAction(ButtonEvent be) {
        Ctp_conta_pagarInsertGWT ctp_conta_pagarInsertGWT = new Ctp_conta_pagarInsertGWT();
        ctp_conta_pagarInsertGWT.setV_conta_pagarConsultGWT(this);
        ctp_conta_pagarInsertGWT.setModal(true);
        ctp_conta_pagarInsertGWT.show();
    }

    private GridCellRenderer<V_conta_pagarT> getEditarRender() {
        return new GridCellRenderer<V_conta_pagarT>() {

            public Object render(final V_conta_pagarT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<V_conta_pagarT> store, Grid<V_conta_pagarT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Ctp_conta_pagarUpdateDeleteGWT ctp_conta_pagarUpdateDeleteGWT = new Ctp_conta_pagarUpdateDeleteGWT();
                        ctp_conta_pagarUpdateDeleteGWT.setV_conta_pagarConsultGWT(V_conta_pagarConsultGWT.this);
                        ctp_conta_pagarUpdateDeleteGWT.load(model);
                        ctp_conta_pagarUpdateDeleteGWT.setVisible(true);
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
         String url = V_conta_pagarDAOGWT.PAGE_REPORT;  
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
        AsyncCallback<List<V_conta_pagarT>> callback = new AsyncCallback<List<V_conta_pagarT>>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<V_conta_pagarT> result) {
                if (grid != null) {
                    grid.removeFromParent();
                }

                NumberFormat format = NumberFormat.getFormat("#,##0.00");

                AggregationRowConfig<V_conta_pagarT> aggregation = new AggregationRowConfig<V_conta_pagarT>();
                aggregation.setHtml("documento", "Total Geral");
                aggregation.setSummaryType("saldo", SummaryType.SUM);
                aggregation.setSummaryFormat("saldo", NumberFormat.getFormat("#,##0.00"));

                ColumnModel cm = new ColumnModel(configs);
                cm.addAggregationRow(aggregation);

                PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(result);
                PagingLoader<PagingLoadResult<V_conta_pagarT>> loader = new BasePagingLoader<PagingLoadResult<V_conta_pagarT>>(proxy);
                loader.setRemoteSort(true);

                GroupingStore<V_conta_pagarT> store = new GroupingStore<V_conta_pagarT>(loader);
                store.add(result);
                store.groupBy("nome");

                getToolBarPage().setPageSize(20);
                getToolBarPage().bind(loader);
                loader.load(0, 20);

                GroupSummaryView summary = new GroupSummaryView();
                summary.setForceFit(true);
                summary.setShowGroupedColumn(false);

                grid = new EditorGrid<V_conta_pagarT>(store, cm);
                grid.setStripeRows(true);
                grid.setView(summary);
                grid.getView().setShowDirtyCells(false);

                grid.setColumnReordering(true);
                grid.setId("grid");
                grid.setLoadMask(true);

                grid.setStyleAttribute("borderTop", "none");
                grid.setBorders(true);
                grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                cpMain.add(grid);
                getCpMaster().layout();

            }
        };

        V_conta_pagarServiceAsync v_conta_pagarAsync = GWT.create(V_conta_pagarService.class);
        v_conta_pagarAsync.getAll(dtInicio.getValue(), dtFim.getValue(), radioGroup.getValue() == rPago ? "T" : "F", callback);
    }
}
