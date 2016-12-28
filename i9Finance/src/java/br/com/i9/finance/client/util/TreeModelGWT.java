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
public class TreeModelGWT extends BaseTreeModel implements Serializable {

    private static int ID = 0;

    public TreeModelGWT() {
        set("id", ID++);
    }

    public TreeModelGWT(String name) {
        set("id", ID++);
        set("name", name);
    }

    public TreeModelGWT(int id, String name, int id_super) {
        set("id", id);
        set("name", name);
        set("id_super", id_super);
    }

    public TreeModelGWT(String name, BaseTreeModel[] children) {
        this(name);
        for (int i = 0; i < children.length; i++) {
            add(children[i]);
        }
    }

    public Integer getId() {
        return (Integer) get("id");
    }

    public int getId_super() {
        return ((Integer) get("id_super")).intValue();
    }

    public String getName() {
        return (String) get("name");
    }

    public String toString() {
        return getName();
    }
}
