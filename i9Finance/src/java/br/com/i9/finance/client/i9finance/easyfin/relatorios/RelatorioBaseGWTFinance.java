/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.finance.client.i9finance.easyfin.relatorios;

import br.com.easynet.gwt.client.report.RelatorioBaseGWT;
import br.com.i9.finance.client.Constantes;
import br.com.i9.finance.client.PortalAccordionI9FINANCEGWT;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author marcos
 */
public class RelatorioBaseGWTFinance extends RelatorioBaseGWT {

    public final String JSP_DOWNLOAD = "download.jsp?link=.";
    

    public RelatorioBaseGWTFinance() {
        setHeaderVisible(false);
        
    }
    public String getUsuarioLogadoREL(){
        return "usu_usuarioT.usu_nr_id="+PortalAccordionI9FINANCEGWT.getUsuarioLogado().getUsu_nr_id();
    }



    @Override
    public void download(String url_download) {
        
        url_download = url_download.replace("?", "|");
        //url_download = url_download.substring(10, url_download.length());
        final String url = url_download.replace("&", ";");
        Timer timer = new Timer() {
            @Override
            public void run() {
                final com.extjs.gxt.ui.client.widget.Window winDownload = new com.extjs.gxt.ui.client.widget.Window();
                winDownload.setVisible(true);
                winDownload.setHeading("Download do arquivo ");
                LabelField txtDownload = new LabelField("AGUARDE!....");
                winDownload.setUrl(Constantes.URL + JSP_DOWNLOAD + url);
                winDownload.setSize(500, 200);
            }
        };
        timer.schedule(50);// espera 1 segundos para poder exibir a janela para download do arquivo
    }
    
    

}
