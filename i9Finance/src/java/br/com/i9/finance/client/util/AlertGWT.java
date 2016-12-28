/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.util;

import br.com.i9.finance.client.icones.icons.Icones;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.ui.Image;
import java.util.List;

/**
 *
 * @author marcos
 */
public class AlertGWT extends Window {

    /**
     * 
     * @param list - lista dos campos a serem adiconados
     * @param autoMsgPreenchimento - concatenar com a msg de peenchimento obrigatório
     */
    public static void showInfor(List<String> list, boolean autoMsgPreenchimento) {

        Button button = new Button("OK", Icones.ICONS.ok_green());
        ToolBar bar = new ToolBar();
        bar.setAlignment(Style.HorizontalAlignment.CENTER);
        bar.add(button);

        final AlertGWT alertGWT = new AlertGWT();
        alertGWT.setSize(400, getheigth(list.size()));
        alertGWT.setScrollMode(Style.Scroll.AUTOY);

        alertGWT.setBottomComponent(bar);
        alertGWT.setHeading("INFORMAÇÃO");
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(4);
        alertGWT.setModal(true);
        ContentPanel container = new ContentPanel(layout);
        container.setHeaderVisible(false);
        container.getElement().getStyle().setBackgroundColor("white");
        alertGWT.add(container);
        
        
        for (String item : list) {
            container.add(new Image("images/checklist.png"));
            container.add(new LabelField(item + getMsgPreenchimento(autoMsgPreenchimento)));
        }
        alertGWT.setVisible(true);

        button.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                alertGWT.setVisible(false);
            }
        });
    }
    private static String getMsgPreenchimento(boolean preenchimento){
        return preenchimento ?" tem peenchimento obrigatório!":"";
    }

    public static int getheigth(int itens) {
        
        int height = 0;
        if (itens > 5) {
            height = 250;
        }else{
            height = (28 * itens) + 60;
        }

        return height;
    }

}
