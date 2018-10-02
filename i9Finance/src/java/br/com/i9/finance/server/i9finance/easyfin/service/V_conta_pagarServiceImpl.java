package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;
import br.com.easynet.easyportal.jb.EasySecurityJB;
//@WebServlet(name = "For_fornecedorService", urlPatterns = {"/br.com.i9.finance.Main/rpc/for_fornecedorservice"})

@WebServlet(name = "V_conta_pagarService", urlPatterns = {"/br.com.i9.finance.Main/rpc/v_conta_pagarservice"})
public class V_conta_pagarServiceImpl extends RemoteServiceServlet implements V_conta_pagarService {

    @Override
    public void insert(V_conta_pagarT v_conta_pagarT) throws Exception {
        V_conta_pagarBL v_conta_pagarBL = new V_conta_pagarBL();
        v_conta_pagarBL.insert(v_conta_pagarT);
    }

    @Override
    public V_conta_pagarT findById(V_conta_pagarT v_conta_pagarT) throws Exception {
        V_conta_pagarBL v_conta_pagarBL = new V_conta_pagarBL();
        return v_conta_pagarBL.findbyid(v_conta_pagarT);
    }

    @Override
    public void delete(V_conta_pagarT v_conta_pagarT) throws Exception {
        V_conta_pagarBL v_conta_pagarBL = new V_conta_pagarBL();
        v_conta_pagarBL.delete(v_conta_pagarT);
    }

    @Override
    public void update(V_conta_pagarT v_conta_pagarT) throws Exception {
        V_conta_pagarBL v_conta_pagarBL = new V_conta_pagarBL();
        v_conta_pagarBL.update(v_conta_pagarT);
    }

    @Override
    public List<V_conta_pagarT> getAll(Date dt_inicio, Date dt_final, String pago) throws Exception {
        V_conta_pagarBL v_conta_pagarBL = new V_conta_pagarBL();
        return v_conta_pagarBL.consult(dt_inicio, dt_final, pago);
    }

}
