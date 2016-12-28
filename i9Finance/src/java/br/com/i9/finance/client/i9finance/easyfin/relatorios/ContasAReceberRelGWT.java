/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.relatorios;

import br.com.easynet.gwt.client.report.RelatorioBaseGWT;
import br.com.i9.finance.client.Constantes;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.google.gwt.user.client.Window;
import java.util.Date;

/**
 *
 * @author marcos
 */
public class ContasAReceberRelGWT extends RelatorioBaseGWTFinance {

    private RadioGroup radioGroup = new RadioGroup();
    private Radio rAberto = new Radio();
    private Radio rQuitado = new Radio();

    public ContasAReceberRelGWT() {
        btnFiltrar.setText("Visualizar");
        setHeaderVisible(false);

        addPeriodo();

        addOpcoes();
        addBtnFiltrar();
        addBtnExportar();
        getDtInicio().setValue(new Date());
        getDtFim().setValue(new Date());

    }

    public void addOpcoes() {
        rAberto.setBoxLabel("Em Aberto");
        rQuitado.setBoxLabel("Quitados");
        radioGroup.add(rAberto);
        radioGroup.add(rQuitado);
        radioGroup.setValue(rAberto);
        getToolBarMaster().add(radioGroup);
    }

    @Override
    public void filtrar() {

        getCpMaster().setUrl(getURL() + TIPO_PDF);
        Window.alert(getURL()+TIPO_PDF);

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
        url.append("&status=");
        url.append(radioGroup.getValue() == rAberto ? "F" : "T");
        url.append("&").append(getUsuarioLogadoREL());

        return url.toString();
    }

    public String getURL() {
        return Constantes.URL + Constantes.PATH_RELATORIO + "V_conta_receber/v_conta_receberReport.jsp?op=imprimir" + getParam();
    }

}
