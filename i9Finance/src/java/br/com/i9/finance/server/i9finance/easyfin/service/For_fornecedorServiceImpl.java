package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;
import br.com.easynet.easyportal.jb.EasySecurityJB;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

@WebServlet(name = "For_fornecedorService", urlPatterns = {"/br.com.i9.finance.Main/rpc/for_fornecedorservice"})
public class For_fornecedorServiceImpl extends RemoteServiceServlet implements For_fornecedorService {

    public Usu_usuarioT getUsuarioLogado() {
        return (Usu_usuarioT) getThreadLocalRequest().getSession().getAttribute(EasySecurityJB.USER_PRINCIPAL);
    }

    public void insert(For_fornecedorT for_fornecedorT) throws Exception {
        For_fornecedorBL for_fornecedorBL = new For_fornecedorBL();
        for_fornecedorBL.insert(for_fornecedorT,getUsuarioLogado());
    }

    public For_fornecedorT findById(For_fornecedorT for_fornecedorT) throws Exception {
        For_fornecedorBL for_fornecedorBL = new For_fornecedorBL();
        return for_fornecedorBL.findbyid(for_fornecedorT);
    }

    public List<For_fornecedorT> getAll() throws Exception {
        For_fornecedorBL for_fornecedorBL = new For_fornecedorBL();
        return for_fornecedorBL.consult(getUsuarioLogado());
    }

    public void delete(For_fornecedorT for_fornecedorT) throws Exception {
        For_fornecedorBL for_fornecedorBL = new For_fornecedorBL();
        for_fornecedorBL.delete(for_fornecedorT);
    }

    public void update(For_fornecedorT for_fornecedorT) throws Exception {
        For_fornecedorBL for_fornecedorBL = new For_fornecedorBL();
        for_fornecedorBL.update(for_fornecedorT);
    }

 
}
