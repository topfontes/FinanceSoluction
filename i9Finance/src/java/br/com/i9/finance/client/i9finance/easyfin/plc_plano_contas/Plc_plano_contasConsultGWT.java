/*
 * EasyNet JDragon
 */
package br.com.i9.finance.client.i9finance.easyfin.plc_plano_contas;

import static br.com.easynet.gwt.client.CPBaseGWT.ICONS;

import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.easynet.gwt.client.CPConsultarBaseGWT;


import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.Listener;


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
import br.com.i9.finance.client.util.TreeModelGWT;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridCellRenderer;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridSelectionModel;

/**
 *
 * @author geoleite
 */
public class Plc_plano_contasConsultGWT extends CPConsultarBaseGWT {

    private TreeGrid<ModelData> grid = null;
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private List<Plc_plano_contasT> listPlc;

    public Plc_plano_contasConsultGWT() {
        setHeaderVisible(false);
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Plc_plano_contasT>> numberRenderer = new NumberCellRenderer<Grid<Plc_plano_contasT>>(currency);

        ColumnConfig column = null;
        RowNumberer numero = new RowNumberer();
        column = new ColumnConfig();
        configs.add(numero);

        column = new ColumnConfig();
        column.setId("name");
        column.setHeader("Conta");
        column.setRenderer(new TreeGridCellRenderer<ModelData>());
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
        Plc_plano_contasInsertGWT plc_plano_contasInsertGWT = new Plc_plano_contasInsertGWT();
        plc_plano_contasInsertGWT.setPlc_plano_contasConsult(this);
        plc_plano_contasInsertGWT.setModal(true);
        plc_plano_contasInsertGWT.show();
    }

    private GridCellRenderer<BaseModel> getEditarRender() {
        return new GridCellRenderer<BaseModel>() {

            public Object render(final BaseModel model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<BaseModel> store, Grid<BaseModel> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Plc_plano_contasUpdateDeleteGWT plc_plano_contasUpdateDeleteGWT = new Plc_plano_contasUpdateDeleteGWT();
                        plc_plano_contasUpdateDeleteGWT.setPlc_plano_contasConsult(Plc_plano_contasConsultGWT.this);
                        Plc_plano_contasT plc_plano_contasT = new Plc_plano_contasT();
                        plc_plano_contasT.setPlc_nr_id(Integer.parseInt(model.get("id").toString()));
                        plc_plano_contasUpdateDeleteGWT.load(plc_plano_contasT);
                        plc_plano_contasUpdateDeleteGWT.setVisible(true);
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
         String url = Plc_plano_contasDAOGWT.PAGE_REPORT;  
         if (FORMAT_CSV.equals(formato)) {
         url += "?op=imprimir&tipo=PDF&download=true";
         } else if (FORMAT_PDF.equals(formato)) {
         url += "?op=imprimir&tipo=CSV&download=true";
         } else {
         url += "?op=imprimir&tipo=TXT&download=true";
         }
         */
    }

    private void montarTreeModel(TreeModelGWT menu) {

        List<Plc_plano_contasT> filhos = getFilhos(menu.getId());

        for (Plc_plano_contasT plcT : filhos) {
            TreeModelGWT newMenu = new TreeModelGWT(plcT.getPlc_nr_id(), plcT.getPlc_tx_nome(), plcT.getPlc_nr_id_super());
            menu.add(newMenu);
            montarTreeModel(newMenu);
        }
    }

    private List<Plc_plano_contasT> getFilhos(int setNrId) {
        List<Plc_plano_contasT> filhos = new ArrayList<Plc_plano_contasT>();
        for (Plc_plano_contasT plcT : listPlc) {
            if (plcT.getPlc_nr_id_super() == setNrId) {
                filhos.add(plcT);
            }
        }
        return filhos;
    }

    public void load() {
        AsyncCallback<List<Plc_plano_contasT>> callback = new AsyncCallback<List<Plc_plano_contasT>>() {

            public void onFailure(Throwable caught) {
                MessageBox.alert("ATENÇÃO", caught.getMessage(), null);
            }

            public void onSuccess(List<Plc_plano_contasT> result) {
                if (getGrid() != null) {
                    getGrid().removeFromParent();
                }
                listPlc = result;

//                Folder model = TestData.getTreeModel();
//                TreeStore<ModelData> store = new TreeStore<ModelData>();
//                store.add(model.getChildren(), true);
//                ColumnConfig name = new ColumnConfig("name", "Name", 100);
//                name.setRenderer(new TreeGridCellRenderer<ModelData>());
//                ColumnConfig salary = new ColumnConfig("salary", "Salary", 100);
//                ColumnConfig date = new ColumnConfig("joiningdate", "Joining Date", 100);
//                ColumnModel cm = new ColumnModel(Arrays.asList(name, salary, date));

                //ColumnModel cm = new ColumnModel(configs);
//                PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(result);
//                PagingLoader<PagingLoadResult<Classes_itens_contratoT>> loader = new BasePagingLoader<PagingLoadResult<Classes_itens_contratoT>>(proxy);
//                loader.setRemoteSort(true);
//
//                getToolBarPage().setPageSize(20);
//                getToolBarPage().bind(loader);
//                loader.load(0, 20);
                
                
//                TreeModelGWT tree = new TreeModelGWT(0, "", -1);
//                montarTreeModel(tree);                   
                
//                TreeStore<ModelData> store = new TreeStore<ModelData>();
//                store.add(tree.getChildren(),true);
//                TreeStore<ModelData> store = new TreeStore<ModelData>();
//                br.com.i9.portal.client.MontarTreeGWT montarTrreGWT = new br.com.i9.portal.client.MontarTreeGWT(result, "plc_nr_id_super", "plc_nr_id", "plc_tx_nome");
//                store.add(montarTrreGWT.getListModelData().getChildren(), true);
                
                            
                
                
                TreeModelGWT tree = new TreeModelGWT(0, "", -1);
                montarTreeModel(tree);                         

                TreeStore<ModelData> store = new TreeStore<ModelData>();
                store.add(tree.getChildren(),true);


                ColumnModel cm = new ColumnModel(configs);
                setGrid(new TreeGrid<ModelData>(store, cm));
                getGrid().setColumnReordering(true);
                getGrid().setId("grid");
                getGrid().setAutoExpandColumn("name");
                getGrid().setTrackMouseOver(false);
                grid.setId("plc_nr_id");
                getGrid().setStateful(true);
                getGrid().getStyle().setLeafIcon(ICONS.importation());
                getGrid().setLoadMask(true);

                getGrid().setStyleAttribute("borderTop", "none");
                getGrid().setBorders(true);
                getGrid().setSelectionModel(new TreeGridSelectionModel<ModelData>());
                getCpMaster().add(getGrid());
                grid.getView().refresh(true);
                getCpMaster().layout();
            }
        };

        Plc_plano_contasServiceAsync plc_plano_contasAsync = GWT.create(Plc_plano_contasService.class);
        plc_plano_contasAsync.getAll(callback);
    }

    /**
     * @return the grid
     */
    public TreeGrid<ModelData> getGrid() {
        return grid;
    }

    /**
     * @param grid the grid to set
     */
    public void setGrid(TreeGrid<ModelData> grid) {
        this.grid = grid;
    }
}
