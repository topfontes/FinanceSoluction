/*
 * EasyNet JDragon
 */
package br.com.i9.finance.client.i9finance.easyfin.v_conta_receber;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.client.i9finance.easyfin.ctr_conta_recebe.Ctr_conta_recebeInsertGWT;
import br.com.i9.finance.client.i9finance.easyfin.ctr_conta_recebe.Ctr_conta_recebeUpdateDeleteGWT;

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
import br.com.i9.finance.client.i9finance.easyfin.v_lancamentos.PagamentosTitulosReceberGWT;
import br.com.i9.finance.client.icones.icons.Icones;
import br.com.i9.finance.client.util.BaixaTitulosReceberGWT;
import br.com.i9.finance.client.util.TituloReceber_PagarGWT;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.google.gwt.user.client.Window;
import java.util.Map;

/**
 *
 * @author geoleite
 */
public class V_conta_receberConsultGWT extends TituloReceber_PagarGWT {

    private EditorGrid<V_conta_receberT> grid = null;
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    public V_conta_receberConsultGWT() {
        setHeaderVisible(false);
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("#,##0.00");
        final NumberCellRenderer<Grid<V_conta_receberT>> numberRenderer = new NumberCellRenderer<Grid<V_conta_receberT>>(currency);

//        RowNumberer numero = new RowNumberer();
//        configs.add(numero);
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
        columnValor.setHeader("Saldo");
        columnValor.setWidth(90);
        columnValor.setNumberFormat(number);
        columnValor.setRenderer(new GridCellRenderer<V_conta_receberT>() {
            @Override
            public String render(V_conta_receberT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<V_conta_receberT> store, Grid<V_conta_receberT> grid) {
                NumberFormat format = NumberFormat.getFormat("#,##0.00");
                config.style = "background-color: #F1F2F4";
                return "<span style='align:right'>" + format.format(model.getSaldo()) + "</span>";
            }
        });

        columnValor.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        columnValor.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
        columnValor.setAlignment(HorizontalAlignment.RIGHT);

        columnValor.setSummaryType(SummaryType.SUM);

        SummaryColumnConfig<Double> columnEmissao = new SummaryColumnConfig<Double>();

        columnEmissao.setId(
                "dt_emissao");
        columnEmissao.setHeader(
                "Dt. Emissao");
        columnEmissao.setWidth(
                90);
        columnEmissao.setAlignment(HorizontalAlignment.LEFT);

        columnEmissao.setDateTimeFormat(dtf);

        SummaryColumnConfig<Double> columnVen = new SummaryColumnConfig<Double>();

        columnVen.setId(
                "vencimento");
        columnVen.setHeader(
                "Vencimento");
        columnVen.setWidth(
                100);
        columnVen.setAlignment(HorizontalAlignment.LEFT);

        columnVen.setDateTimeFormat(dtf);

        SummaryColumnConfig<Double> columnDtPag = new SummaryColumnConfig<Double>();

        columnDtPag.setId(
                "dt_pagamento");
        columnDtPag.setHeader(
                "Dt. Pagamento");
        columnDtPag.setWidth(
                100);
        columnDtPag.setAlignment(HorizontalAlignment.LEFT);

        columnDtPag.setDateTimeFormat(dtf);

        SummaryColumnConfig<Double> columnObs = new SummaryColumnConfig<Double>();

        columnObs.setId(
                "obs");
        columnObs.setHeader(
                "Obs");
        columnObs.setWidth(
                200);
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

        columnbaixa.setId(
                "colBaixa");
        columnbaixa.setWidth(
                30);
        columnbaixa.setAlignment(HorizontalAlignment.CENTER);

        columnbaixa.setRenderer(getBaixaRender());
        configs.add(columnbaixa);

        SummaryColumnConfig columnPag = new SummaryColumnConfig();

        columnPag.setId(
                "colBaixa");
        columnPag.setWidth(
                30);
        columnPag.setAlignment(HorizontalAlignment.CENTER);

        columnPag.setRenderer(getPagamentosRender());
        configs.add(columnPag);

        SummaryColumnConfig columnEdit = new SummaryColumnConfig();

        columnEdit.setId(
                "colEditar");
        columnEdit.setWidth(
                30);
        columnEdit.setAlignment(HorizontalAlignment.CENTER);

        columnEdit.setRenderer(getEditarRender());
        configs.add(columnEdit);
        rApagar.setBoxLabel("A Receber");
        load();
    }

    public void btnAtualizarAction(ButtonEvent be) {
        super.btnAtualizarAction(be);
    }

    public void btnNovoAction(ButtonEvent be) {
        Ctr_conta_recebeInsertGWT ctr_conta_recebeInsertGWT = new Ctr_conta_recebeInsertGWT();
        ctr_conta_recebeInsertGWT.setV_conta_receberConsultGWT(this);
        ctr_conta_recebeInsertGWT.setModal(true);
        ctr_conta_recebeInsertGWT.show();
    }

    private GridCellRenderer<V_conta_receberT> getEditarRender() {
        return new GridCellRenderer<V_conta_receberT>() {

            public Object render(final V_conta_receberT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<V_conta_receberT> store, Grid<V_conta_receberT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Ctr_conta_recebeUpdateDeleteGWT ctr_conta_recebeUpdateDeleteGWT = new Ctr_conta_recebeUpdateDeleteGWT();
                        ctr_conta_recebeUpdateDeleteGWT.setV_conta_receberConsultGWT(V_conta_receberConsultGWT.this);

                        ctr_conta_recebeUpdateDeleteGWT.load(model);
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

    private GridCellRenderer<V_conta_receberT> getPagamentosRender() {
        return new GridCellRenderer<V_conta_receberT>() {

            public Object render(final V_conta_receberT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<V_conta_receberT> store, Grid<V_conta_receberT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        PagamentosTitulosReceberGWT pagamentosTitulosGWT = new PagamentosTitulosReceberGWT();
                        pagamentosTitulosGWT.setModal(true);
                        pagamentosTitulosGWT.load(model);
                        pagamentosTitulosGWT.show();
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

    private GridCellRenderer<V_conta_receberT> getBaixaRender() {
        return new GridCellRenderer<V_conta_receberT>() {

            public Object render(final V_conta_receberT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<V_conta_receberT> store, Grid<V_conta_receberT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        BaixaTitulosReceberGWT baixaTitulosGWT = new BaixaTitulosReceberGWT(model);
                        baixaTitulosGWT.setConsultGWT(V_conta_receberConsultGWT.this);
                        baixaTitulosGWT.setModal(true);
                        baixaTitulosGWT.show();
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
         String url = V_conta_receberDAOGWT.PAGE_REPORT;  
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
        AsyncCallback<List<V_conta_receberT>> callback = new AsyncCallback<List<V_conta_receberT>>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<V_conta_receberT> result) {
                if (grid != null) {
                    grid.removeFromParent();
                }

                NumberFormat format = NumberFormat.getFormat("#,##0.00");

                AggregationRowConfig<V_conta_receberT> aggregation = new AggregationRowConfig<V_conta_receberT>();
                aggregation.setHtml("documento", "Total Geral");
                aggregation.setSummaryType("saldo", SummaryType.SUM);
                aggregation.setSummaryFormat("saldo", NumberFormat.getFormat("#,##0.00"));

                ColumnModel cm = new ColumnModel(configs);
                cm.addAggregationRow(aggregation);

                PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(result);
                PagingLoader<PagingLoadResult<V_conta_receberT>> loader = new BasePagingLoader<PagingLoadResult<V_conta_receberT>>(proxy);
                loader.setRemoteSort(true);

                GroupingStore<V_conta_receberT> store = new GroupingStore<V_conta_receberT>(loader);
                store.add(result);
                store.groupBy("nome");

                getToolBarPage().setPageSize(20);
                getToolBarPage().bind(loader);
                loader.load(0, 20);

                GroupSummaryView summary = new GroupSummaryView();
                summary.setForceFit(true);
                summary.setShowGroupedColumn(false);

                grid = new EditorGrid<V_conta_receberT>(store, cm);
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

        V_conta_receberServiceAsync v_conta_receberAsync = GWT.create(V_conta_receberService.class);
        v_conta_receberAsync.getAll(dtInicio.getValue(), dtFim.getValue(), radioGroup.getValue() == rPago ? "T" : "F", callback);
    }
}
