package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "V_conta_receberService", urlPatterns = {"/br.com.i9.finance.Main/rpc/v_conta_receberservice"})
public class V_conta_receberServiceImpl extends RemoteServiceServlet implements V_conta_receberService {
    
    public void insert(V_conta_receberT v_conta_receberT) throws Exception {
        V_conta_receberBL v_conta_receberBL = new V_conta_receberBL();
        v_conta_receberBL.insert(v_conta_receberT);
    }
    
    public V_conta_receberT findById(V_conta_receberT v_conta_receberT) throws Exception {
        V_conta_receberBL v_conta_receberBL = new V_conta_receberBL();
        return v_conta_receberBL.findbyid(v_conta_receberT);
    }
    
    public void delete(V_conta_receberT v_conta_receberT) throws Exception {
        V_conta_receberBL v_conta_receberBL = new V_conta_receberBL();
        v_conta_receberBL.delete(v_conta_receberT);
    }
    
    public void update(V_conta_receberT v_conta_receberT) throws Exception {
        V_conta_receberBL v_conta_receberBL = new V_conta_receberBL();
        v_conta_receberBL.update(v_conta_receberT);
    }
    
    @Override
    public List<V_conta_receberT> getAll(Date dt_inicio, Date dt_final, String pago) throws Exception {
        V_conta_receberBL v_conta_receberBL = new V_conta_receberBL();
        return v_conta_receberBL.consult(dt_inicio, dt_final, pago);
    }
    
}
