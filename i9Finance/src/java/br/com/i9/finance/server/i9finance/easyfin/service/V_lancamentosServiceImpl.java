package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;
import br.com.easynet.easyportal.jb.EasySecurityJB;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

@WebServlet(name = "V_lancamentosService", urlPatterns = {"/br.com.i9.finance.Main/rpc/v_lancamentosservice"})
public class V_lancamentosServiceImpl extends RemoteServiceServlet implements V_lancamentosService {

    public Usu_usuarioT getUsuarioLogado() {
        return (Usu_usuarioT) getThreadLocalRequest().getSession().getAttribute(EasySecurityJB.USER_PRINCIPAL);
    }    
    
    public void insert(V_lancamentosT v_lancamentosT) throws Exception {
        V_lancamentosBL v_lancamentosBL = new V_lancamentosBL();
        v_lancamentosBL.insert(v_lancamentosT);
    }

    public V_lancamentosT findById(V_lancamentosT v_lancamentosT) throws Exception {
        V_lancamentosBL v_lancamentosBL = new V_lancamentosBL();
        return v_lancamentosBL.findbyid(v_lancamentosT);
    }

    public void delete(V_lancamentosT v_lancamentosT) throws Exception {
        V_lancamentosBL v_lancamentosBL = new V_lancamentosBL();
        v_lancamentosBL.delete(v_lancamentosT);
    }

    public void update(V_lancamentosT v_lancamentosT) throws Exception {
        V_lancamentosBL v_lancamentosBL = new V_lancamentosBL();
        v_lancamentosBL.update(v_lancamentosT);
    }

    @Override
    public List<V_lancamentosT> getAll(Date dt_inicio, Date dt_final, int plc_nr_id) throws Exception {
        Usu_usuarioT usuT = (Usu_usuarioT) getThreadLocalRequest().getSession().getAttribute(EasySecurityJB.USER_PRINCIPAL);
        V_lancamentosBL v_lancamentosBL = new V_lancamentosBL();
        return v_lancamentosBL.consult(dt_inicio, dt_final, plc_nr_id, getUsuarioLogado());

    }

    @Override
    public List<V_lancamentosT> getAllContaReceber(int ctr_nr_id) throws Exception {
        V_lancamentosBL v_lancamentosBL = new V_lancamentosBL();
        return v_lancamentosBL.consultRecebimento(ctr_nr_id);
    }

    @Override
    public List<V_lancamentosT> getAllContaPagar(int ctp_nr_id) throws Exception {
        V_lancamentosBL v_lancamentosBL = new V_lancamentosBL();
        return v_lancamentosBL.consultPagamento(ctp_nr_id);
    }



}
