/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.relatorios;

import br.com.easynet.gwt.client.report.RelatorioBaseGWT;
import br.com.i9.finance.client.Constantes;
import br.com.i9.finance.client.PortalAccordionI9FINANCEGWT;
import com.google.gwt.user.client.Window;
import java.util.Date;

/**
 *
 * @author marcos
 */
public class Dre_RelGWT extends RelatorioBaseGWTFinance{

    public Dre_RelGWT() {
        btnFiltrar.setText("Visualizar");
        setHeaderVisible(false);
        addPeriodo();
        addBtnFiltrar();
        addBtnExportar();
        getDtInicio().setValue(new Date());
        getDtFim().setValue(new Date());
    }
    
    @Override
    public void filtrar() {

        getCpMaster().setUrl(getURL() + TIPO_PDF);
        //Window.alert(getURL() + TIPO_PDF);

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
        url.append("&").append(getUsuarioLogadoREL());
        return url.toString();
    }

    public String getURL() {
        return Constantes.URL + Constantes.PATH_RELATORIO + "dre/dre.jsp?op=imprimir" + getParam();
    }

}
