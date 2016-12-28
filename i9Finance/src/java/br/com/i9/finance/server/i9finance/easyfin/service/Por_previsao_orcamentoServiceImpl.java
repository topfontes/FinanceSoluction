package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;
import br.com.easynet.easyportal.jb.EasySecurityJB;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

@WebServlet(name = "Por_previsao_orcamentoService", urlPatterns = {"/br.com.i9.finance.Main/rpc/por_previsao_orcamentoservice"})
public class Por_previsao_orcamentoServiceImpl extends RemoteServiceServlet implements Por_previsao_orcamentoService {
   
    public Usu_usuarioT getUsuarioLogado() {
        return (Usu_usuarioT) getThreadLocalRequest().getSession().getAttribute(EasySecurityJB.USER_PRINCIPAL);
    }
    
    
    public void insert(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        Por_previsao_orcamentoBL por_previsao_orcamentoBL = new Por_previsao_orcamentoBL();
        por_previsao_orcamentoBL.insert(por_previsao_orcamentoT,getUsuarioLogado());
    }

    public Por_previsao_orcamentoT findById(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        Por_previsao_orcamentoBL por_previsao_orcamentoBL = new Por_previsao_orcamentoBL();
        return por_previsao_orcamentoBL.findbyid(por_previsao_orcamentoT);
    }

    public void delete(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        Por_previsao_orcamentoBL por_previsao_orcamentoBL = new Por_previsao_orcamentoBL();
        por_previsao_orcamentoBL.delete(por_previsao_orcamentoT);
    }

    public void update(Por_previsao_orcamentoT por_previsao_orcamentoT) throws Exception {
        Por_previsao_orcamentoBL por_previsao_orcamentoBL = new Por_previsao_orcamentoBL();
        por_previsao_orcamentoBL.update(por_previsao_orcamentoT);
    }

    @Override
    public List<Por_previsao_orcamentoT> getAll(int ano) throws Exception {
        Por_previsao_orcamentoBL por_previsao_orcamentoBL = new Por_previsao_orcamentoBL();
        return por_previsao_orcamentoBL.consult(ano,getUsuarioLogado());
    }
}
