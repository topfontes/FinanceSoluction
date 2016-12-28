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
import com.extjs.gxt.ui.client.data.BaseTreeModel;  
import java.util.Date;
  
public class EmployeeTreeNode extends BaseTreeModel {  
 private static final long serialVersionUID = 1L;  
  
public EmployeeTreeNode() {  
  }  
  
  public EmployeeTreeNode(String name, double salary, Date joiningdate) {  
    set("name", name);  
    set("salary", salary);  
    set("joiningdate", joiningdate);  
  }  
  
  public Date getJoiningdate() {  
    return (Date) get("joiningdate");  
  }  
  
  public String getName() {  
    return (String) get("name");  
  }  
  
  public double getSalary() {  
    Double salary = (Double) get("salary");  
    return salary.doubleValue();  
  }  
  public String toString() {  
    return getName();  
  }  
}  
