package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;
import br.com.easynet.easyportal.jb.EasySecurityJB;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

@WebServlet(name = "Ctr_conta_recebeService", urlPatterns = {"/br.com.i9.finance.Main/rpc/ctr_conta_recebeservice"})
public class Ctr_conta_recebeServiceImpl extends RemoteServiceServlet implements Ctr_conta_recebeService {

    public Usu_usuarioT getUsuarioLogado() {
        return (Usu_usuarioT) getThreadLocalRequest().getSession().getAttribute(EasySecurityJB.USER_PRINCIPAL);
    }       
    
    public void insert(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        Ctr_conta_recebeBL ctr_conta_recebeBL = new Ctr_conta_recebeBL();
        ctr_conta_recebeBL.insert(ctr_conta_recebeT,getUsuarioLogado());
    }

    public Ctr_conta_recebeT findById(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        Ctr_conta_recebeBL ctr_conta_recebeBL = new Ctr_conta_recebeBL();
        return ctr_conta_recebeBL.findbyid(ctr_conta_recebeT);
    }

    public List<Ctr_conta_recebeT> getAll() throws Exception {
        Ctr_conta_recebeBL ctr_conta_recebeBL = new Ctr_conta_recebeBL();
        return ctr_conta_recebeBL.consult();
    }

    public void delete(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        Ctr_conta_recebeBL ctr_conta_recebeBL = new Ctr_conta_recebeBL();
        ctr_conta_recebeBL.delete(ctr_conta_recebeT);
    }

    public void update(Ctr_conta_recebeT ctr_conta_recebeT) throws Exception {
        Ctr_conta_recebeBL ctr_conta_recebeBL = new Ctr_conta_recebeBL();
        ctr_conta_recebeBL.update(ctr_conta_recebeT);
    }

    @Override
    public void updateBaixa(Ctr_conta_recebeT ctr_conta_recebeT, int conta_devedora) throws Exception {
        Ctr_conta_recebeBL ctr_conta_recebeBL = new Ctr_conta_recebeBL();
        ctr_conta_recebeBL.updateBaixa(ctr_conta_recebeT,conta_devedora,getUsuarioLogado());
    }
}
