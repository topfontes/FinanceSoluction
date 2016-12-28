/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.util;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.easynet.gwt.client.i18n.EasyLabels;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import java.util.Date;

/**
 *
 * @author marcos
 */
public class TituloReceber_PagarGWT extends CPConsultarBaseGWT {

    protected ContentPanel cpMain = new ContentPanel(new FillLayout());
    protected DateField dtInicio = new DateField();
    protected DateField dtFim = new DateField();
    protected RadioGroup radioGroup = new RadioGroup();
    protected Radio rPago = new Radio();
    protected Radio rApagar = new Radio();
    protected ToolBar toolBar = new ToolBar();
    protected EasyLabels easyLabels = GWT.create(EasyLabels.class);
    protected Button btnFiltrar = new Button(easyLabels.filter(),ICONS.filter());
    protected DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");

    public TituloReceber_PagarGWT() {
        cpMain.setHeaderVisible(false);
        cpMain.setBodyBorder(false);
        cpMain.setBorders(false);
        getCpMaster().add(cpMain);
        cpMain.setTopComponent(toolBar);
        
        addPeriodo();
        addStatus();
        addBtnFiltrar();
        
        btnFiltrar.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                load();
            }
        });        
    }


    public void addStatus() {
        
        rPago.setBoxLabel("Pago");
        rApagar.setBoxLabel("A pagar");
        radioGroup.add(rPago);
        radioGroup.add(rApagar);        
        radioGroup.setValue(rApagar);
        toolBar.add(new LabelToolItem(easyLabels.status()));
        toolBar.add(radioGroup);
        toolBar.add(new SeparatorToolItem());
        toolBar.add(new SeparatorToolItem());
    }

    public void addPeriodo() {
        toolBar.add(new LabelToolItem("Período :"));
        toolBar.add(dtInicio);
        dtInicio.setValue(new Date());
        dtFim.setValue(new Date());
        dtFim.getPropertyEditor().setFormat(dtf);
        dtInicio.getPropertyEditor().setFormat(dtf);
        toolBar.add(new LabelToolItem(" a "));
        toolBar.add(dtFim);
        toolBar.add(new SeparatorToolItem());
        toolBar.add(new SeparatorToolItem());
    }

    public void addBtnFiltrar() {
        toolBar.add(btnFiltrar);
        toolBar.add(new SeparatorToolItem());
        toolBar.add(new SeparatorToolItem());
    }
        
    
}
