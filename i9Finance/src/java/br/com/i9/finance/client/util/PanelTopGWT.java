/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.util;

import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;

/**
 *
 * @author marcos
 */

public class PanelTopGWT extends LayoutContainer {

    public PanelTopGWT() {
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(5);
        setLayout(layout);
        setEnabled(false);
    }

    public void addComponent(Component titile, Component field) {
        
        add(titile);
        add(field);
    }
}
