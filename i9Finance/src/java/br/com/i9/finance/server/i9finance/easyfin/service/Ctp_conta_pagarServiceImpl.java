package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;
import br.com.easynet.easyportal.jb.EasySecurityJB;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

@WebServlet(name = "Ctp_conta_pagarService", urlPatterns = {"/br.com.i9.finance.Main/rpc/ctp_conta_pagarservice"})
public class Ctp_conta_pagarServiceImpl extends RemoteServiceServlet implements Ctp_conta_pagarService {

    public Usu_usuarioT getUsuarioLogado() {
        return (Usu_usuarioT) getThreadLocalRequest().getSession().getAttribute(EasySecurityJB.USER_PRINCIPAL);
    }       
    
    public void insert(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        Ctp_conta_pagarBL ctp_conta_pagarBL = new Ctp_conta_pagarBL();
        ctp_conta_pagarBL.insert(ctp_conta_pagarT,getUsuarioLogado());
    }

    public Ctp_conta_pagarT findById(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        Ctp_conta_pagarBL ctp_conta_pagarBL = new Ctp_conta_pagarBL();
        return ctp_conta_pagarBL.findbyid(ctp_conta_pagarT);
    }

    public List<Ctp_conta_pagarT> getAll() throws Exception {
        Ctp_conta_pagarBL ctp_conta_pagarBL = new Ctp_conta_pagarBL();
        return ctp_conta_pagarBL.consult();
    }

    public void delete(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        Ctp_conta_pagarBL ctp_conta_pagarBL = new Ctp_conta_pagarBL();
        ctp_conta_pagarBL.delete(ctp_conta_pagarT);
    }

    public void update(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        Ctp_conta_pagarBL ctp_conta_pagarBL = new Ctp_conta_pagarBL();
        ctp_conta_pagarBL.update(ctp_conta_pagarT);
    }

    @Override
    public void updateBaixa(Ctp_conta_pagarT ctp_conta_pagarT, int conta_credora) throws Exception {
        Ctp_conta_pagarBL ctp_conta_pagarBL = new Ctp_conta_pagarBL();
        ctp_conta_pagarBL.updateBaixa(ctp_conta_pagarT, conta_credora,getUsuarioLogado());
    }

}
