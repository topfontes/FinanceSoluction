/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.util;

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import java.io.Serializable;

/**
 *
 * @author marcos
 */
public class ModelTreeGWT extends BaseTreeModel implements Serializable{
    
    public static final String ID = "id";
    public static final String DISPLAY = "display";
    public ModelTreeGWT[] children;
    //private static int MAXID = 0; 

    public ModelTreeGWT(long id, String display) {
        set(ID, id);
        set(DISPLAY, display);
    }
    
    public ModelTreeGWT(long id, String display, ModelTreeGWT[] children) {
        set(ID, id);
        set(DISPLAY, display);
        
    }
    
    public String getDisplay() {
        return get(DISPLAY) == null ? "" : (String) get(DISPLAY);
    }
    
    public long getId_super() {
        return get(ID) == null ? 0 : ((Long) get(ID)).intValue();
    }


}
