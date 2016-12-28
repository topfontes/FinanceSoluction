/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.util;

/**
 *
 * @author marcos
 */
  
import java.io.Serializable;  
  
import com.extjs.gxt.ui.client.data.BaseTreeModel;  
  
public class Folder extends BaseTreeModel implements Serializable {  
 private static final long serialVersionUID = 1L;  
private static int ID = 0;  
    
  public Folder() {  
    set("id", ID++);  
  }  
  
  public Folder(String name) {  
    set("id", ID++);  
    set("name", name);  
  }  
  
  public Folder(String name, BaseTreeModel[] children) {  
    this(name);  
    for (int i = 0; i < children.length; i++) {  
      add(children[i]);  
    }  
  }  
  
  public Integer getId() {  
    return (Integer) get("id");  
  }  
  
  public String getName() {  
    return (String) get("name");  
  }  
  
  public String toString() {  
    return getName();  
  }  
  
}