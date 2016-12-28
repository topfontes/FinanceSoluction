/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.util;

import br.com.i9.finance.client.i9finance.easyfin.transfer.Plc_plano_contasT;
import br.com.i9.portal.client.portal.portal.transfer.Men_menuTGWT;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import java.util.List;

/**
 *
 * @author marcos
 */
public class UtilGWT {

    public static LayoutContainer getColumnLayoutContainer(Field componet, String caption) {
        FormData formData = new FormData("100%");
        //formData.setMargins(new Margins(4));
        LayoutContainer column = new LayoutContainer(new FormLayout(FormPanel.LabelAlign.TOP));

        column.setStyleAttribute("padding", "4px");
        componet.setFieldLabel(caption);
        column.add(componet, formData);
        return column;
    }
    public static int getCodigoSetorRaiz(List<Plc_plano_contasT> listSet) {
        int codRaiz = Integer.MAX_VALUE;
        for (int i = 0; i < listSet.size(); i++) {
            //Men_menuTGWT menT = listSet.get(i);
            Plc_plano_contasT model = listSet.get(i);
            if (codRaiz > model.getPlc_nr_id()) {
                codRaiz = (int) model.getPlc_nr_id();
            }
        }
        return codRaiz;
    }    

}
