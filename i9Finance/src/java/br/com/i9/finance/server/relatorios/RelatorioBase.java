package br.com.i9.finance.server.relatorios;

import br.com.i9.finance.server.bl.SystemBusinessBase;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import java.text.ParseException;
import java.util.Date;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

/**
 *
 * @author i9ti
 */
public class RelatorioBase extends br.com.easynet.relatorio.RelatorioBase {

    protected SystemBusinessBase systemBase = new SystemBusinessBase();
    protected String urlPathlogo;
    protected Usu_usuarioT usu_usuarioT = new Usu_usuarioT();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
        getParameters().put("urlPathlogo", application.getRealPath("images/logomarca.png"));
        
        System.out.println("path "+application.getRealPath("images/logomarca.png"));
        
    }

    public Date getDateFormat(String data) throws ParseException{
        return format.parse(data);
    }
     
    public void imprimir(){
        
    }

    /**
     * @return the usu_usuarioT
     */
    public Usu_usuarioT getUsu_usuarioT() {
        return usu_usuarioT;
    }

    /**
     * @param usu_usuarioT the usu_usuarioT to set
     */
    public void setUsu_usuarioT(Usu_usuarioT usu_usuarioT) {
        this.usu_usuarioT = usu_usuarioT;
    }

}
