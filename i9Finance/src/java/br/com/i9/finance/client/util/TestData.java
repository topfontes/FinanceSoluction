/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.util;

import com.google.gwt.i18n.client.DateTimeFormat;

/**
 *
 * @author marcos
 */
public class TestData {

    public static Folder getTreeModel() {
        DateTimeFormat f = DateTimeFormat.getFormat("yyyy-mm-dd");
        Folder[] folders = new Folder[]{
            new Folder("General Administration", new Folder[]{
                new Folder("General Manager", new EmployeeTreeNode[]{
                    new EmployeeTreeNode("Hollie Voss", 150000, f.parse("2006-05-01")),
                    new EmployeeTreeNode("Heriberto Rush", 150000, f.parse("2007-08-01")),}),
                new Folder("Executive", new EmployeeTreeNode[]{
                    new EmployeeTreeNode("Christina Blake", 45000, f.parse("2008-11-01")),
                    new EmployeeTreeNode("Chad Andrews", 45000, f.parse("2008-07-01")),}),}),
            new Folder("Information Technology", new Folder[]{
                new Folder("Senior S/W Engineer", new EmployeeTreeNode[]{
                    new EmployeeTreeNode("Dirk Newman", 70000, f.parse("2007-08-21")),
                    new EmployeeTreeNode("Emerson Milton", 72000, f.parse("2009-05-07")),
                    new EmployeeTreeNode("Gail Horton", 680000, f.parse("2008-05-01")),}),
                new Folder("S/W Engineer", new EmployeeTreeNode[]{
                    new EmployeeTreeNode("Claudio Engle", 50000, f.parse("2007-02-01")),
                    new EmployeeTreeNode("Buster misjenou", 52000, f.parse("2009-06-10")),
                    new EmployeeTreeNode("Bell Snedden", 50000, f.parse("2008-12-01")),
                    new EmployeeTreeNode("Benito Meeks", 55000, f.parse("2006-05-01")),}),}),
            new Folder("Marketing", new Folder[]{
                new Folder("Executive", new EmployeeTreeNode[]{
                    new EmployeeTreeNode("Candice Carson", 50000, f.parse("2007-08-21")),
                    new EmployeeTreeNode("Mildred Starnes", 50000, f.parse("2008-05-01")),
                    new EmployeeTreeNode("Claudio Engle", 50000, f.parse("2009-06-15")),}),}),};

        Folder root = new Folder("root");
        for (int i = 0; i < folders.length; i++) {
            root.add((Folder) folders[i]);
        }

        return root;
    }
}
