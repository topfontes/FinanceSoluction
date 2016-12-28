package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;
import br.com.easynet.easyportal.jb.EasySecurityJB;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

@WebServlet(name = "Lan_lancamentoService", urlPatterns = {"/br.com.i9.finance.Main/rpc/lan_lancamentoservice"})
public class Lan_lancamentoServiceImpl extends RemoteServiceServlet implements Lan_lancamentoService {

    public Usu_usuarioT getUsuarioLogado() {
        return (Usu_usuarioT) getThreadLocalRequest().getSession().getAttribute(EasySecurityJB.USER_PRINCIPAL);
    }

    public void insert(Lan_lancamentoT lan_lancamentoT) throws Exception {
        Lan_lancamentoBL lan_lancamentoBL = new Lan_lancamentoBL();
        lan_lancamentoBL.insert(lan_lancamentoT,getUsuarioLogado());
    }

    public Lan_lancamentoT findById(Lan_lancamentoT lan_lancamentoT) throws Exception {
        Lan_lancamentoBL lan_lancamentoBL = new Lan_lancamentoBL();
        return lan_lancamentoBL.findbyid(lan_lancamentoT);
    }

    public List<Lan_lancamentoT> getAll() throws Exception {
        Lan_lancamentoBL lan_lancamentoBL = new Lan_lancamentoBL();
        return lan_lancamentoBL.consult();
    }

    public void delete(Lan_lancamentoT lan_lancamentoT) throws Exception {
        Lan_lancamentoBL lan_lancamentoBL = new Lan_lancamentoBL();
        lan_lancamentoBL.delete(lan_lancamentoT);
    }

    public void update(Lan_lancamentoT lan_lancamentoT) throws Exception {
        Lan_lancamentoBL lan_lancamentoBL = new Lan_lancamentoBL();
        lan_lancamentoBL.update(lan_lancamentoT);
    }
}
