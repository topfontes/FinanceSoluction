/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.relatorios;

import br.com.i9.finance.client.Constantes;
import br.com.i9.finance.client.i9finance.easyfin.service.Plc_plano_contasService;
import br.com.i9.finance.client.i9finance.easyfin.service.Plc_plano_contasServiceAsync;
import br.com.i9.finance.client.i9finance.easyfin.transfer.Plc_plano_contasT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marcos
 */
public class RazaoAnalitico_RelGWT extends RelatorioBaseGWTFinance {
    
    private ComboBox<Plc_plano_contasT> cb_Conta = new ComboBox<Plc_plano_contasT>();
    private RadioGroup radioGroup = new RadioGroup();
    private Radio rTodos = new Radio();
    private Radio rEntradas = new Radio();
    private Radio rSaidas = new Radio();
    private RadioGroup radioOrdem = new RadioGroup();
    private Radio rcrescente = new Radio();
    private Radio rdecrescentes = new Radio();
    
    public RazaoAnalitico_RelGWT() {
        
        btnFiltrar.setText("Visualizar");
        setHeaderVisible(false);
        
        addPeriodo();
        getToolBarMaster().add(cb_Conta);
        addOpcoes();
        addOrdem();
        addBtnFiltrar();
        addBtnExportar();
        povoaConta();
        getDtInicio().setValue(new Date());
        getDtFim().setValue(new Date());
        
    }
    
    @Override
    public void filtrar() {
        
        getCpMaster().setUrl(getURL() + TIPO_PDF);
        
    }
    
    @Override
    public void exportarPDF() {
        download(getURL() + TIPO_PDF);
    }
    
    @Override
    public void exportarXLS() {
        download(getURL() + TIPO_XLS);
    }
    
    public String getParam() {
        
        StringBuffer url = new StringBuffer();
        url.append("&dtInicio=");
        url.append(getDtfDate().format(getDtInicio().getValue()));
        url.append("&dtFim=");
        url.append(getDtfDate().format(getDtFim().getValue()));
        url.append("&plc_nr_id=");
        url.append(cb_Conta.getValue().getPlc_nr_id());
        url.append("&status=");
        url.append(radioGroup.getValue() == rTodos ? "T" : radioGroup.getValue() == rEntradas ? "E" : "S");
        url.append("&orderby=");
        url.append(radioOrdem.getValue()==rcrescente?"ASC":"DESC");
        url.append("&").append(getUsuarioLogadoREL());
        return url.toString();
    }
    
    public String getURL() {
        return Constantes.URL + Constantes.PATH_RELATORIO + "razao_analitico/razao_analitico.jsp?op=imprimir" + getParam();
    }
    
    public void addOpcoes() {
        rTodos.setBoxLabel("Tudo");
        rEntradas.setBoxLabel("Entrada");
        rSaidas.setBoxLabel("Saidas");
        radioGroup.add(rTodos);
        radioGroup.add(rEntradas);
        radioGroup.add(rSaidas);
        radioGroup.setValue(rTodos);
        getToolBarMaster().add(radioGroup);
    }
    public void addOrdem() {
        rcrescente.setBoxLabel("Crescente");
        rdecrescentes.setBoxLabel("Decrescente");
        rSaidas.setBoxLabel("Saidas");
        radioOrdem.add(rcrescente);
        radioOrdem.add(rdecrescentes);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(radioOrdem);
        radioOrdem.setValue(rcrescente);
    }
    public void povoaConta() {
        cb_Conta.setWidth(250);
        cb_Conta.setWidth(Constantes.widthField);
        cb_Conta.setDisplayField("plc_tx_nome");
        cb_Conta.setEmptyText("Selecione a super conta");
        cb_Conta.setTriggerAction(ComboBox.TriggerAction.ALL);
        cb_Conta.setMinChars(2);
        
        AsyncCallback<List<Plc_plano_contasT>> callback = new AsyncCallback<List<Plc_plano_contasT>>() {
            
            @Override
            public void onFailure(Throwable caught) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
            @Override
            public void onSuccess(List<Plc_plano_contasT> result) {
                ListStore<Plc_plano_contasT> store = new ListStore<Plc_plano_contasT>();
                store.add(result);
                cb_Conta.setStore(store);
                cb_Conta.getListView().refresh();
            }
        };
        Plc_plano_contasServiceAsync serviceAsync = GWT.create(Plc_plano_contasService.class);
        serviceAsync.getAllSub(callback);
    }
    
}
