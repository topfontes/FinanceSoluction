package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;
import br.com.easynet.easyportal.jb.EasySecurityJB;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

@WebServlet(name = "Plc_plano_contasService", urlPatterns = {"/br.com.i9.finance.Main/rpc/plc_plano_contasservice"})
public class Plc_plano_contasServiceImpl extends RemoteServiceServlet implements Plc_plano_contasService {

    public Usu_usuarioT getUsuarioLogado() {
        return (Usu_usuarioT) getThreadLocalRequest().getSession().getAttribute(EasySecurityJB.USER_PRINCIPAL);
    }        
    
    
    public void insert(Plc_plano_contasT plc_plano_contasT) throws Exception {
        Plc_plano_contasBL plc_plano_contasBL = new Plc_plano_contasBL();
        plc_plano_contasBL.insert(plc_plano_contasT,getUsuarioLogado());
    }
    

    public Plc_plano_contasT findById(Plc_plano_contasT plc_plano_contasT) throws Exception {
        Plc_plano_contasBL plc_plano_contasBL = new Plc_plano_contasBL();
        return plc_plano_contasBL.findbyid(plc_plano_contasT);
    }

    public List<Plc_plano_contasT> getAll() throws Exception {
        Plc_plano_contasBL plc_plano_contasBL = new Plc_plano_contasBL();
        return plc_plano_contasBL.consult(getUsuarioLogado());
    }

    public void delete(Plc_plano_contasT plc_plano_contasT) throws Exception {
        Plc_plano_contasBL plc_plano_contasBL = new Plc_plano_contasBL();
        plc_plano_contasBL.delete(plc_plano_contasT);
    }

    public void update(Plc_plano_contasT plc_plano_contasT) throws Exception {
        Plc_plano_contasBL plc_plano_contasBL = new Plc_plano_contasBL();
        plc_plano_contasBL.update(plc_plano_contasT);
    }

    @Override
    public List<Plc_plano_contasT> getAllSuper() throws Exception {
        Plc_plano_contasBL plc_plano_contasBL = new Plc_plano_contasBL();
        return plc_plano_contasBL.consultSuper(getUsuarioLogado());
    }

    @Override
    public List<Plc_plano_contasT> getAllSub() throws Exception {
        Plc_plano_contasBL plc_plano_contasBL = new Plc_plano_contasBL();
        return plc_plano_contasBL.consultSub(getUsuarioLogado());
    }
}
