package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "V_conta_pagar_pago_contaService", urlPatterns = {"/br.com.i9.finance.Main/rpc/v_conta_pagar_pago_contaservice"})
public class V_conta_pagar_pago_contaServiceImpl extends RemoteServiceServlet implements V_conta_pagar_pago_contaService {

	public void insert(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception {
	  V_conta_pagar_pago_contaBL v_conta_pagar_pago_contaBL = new V_conta_pagar_pago_contaBL();
	  v_conta_pagar_pago_contaBL.insert(v_conta_pagar_pago_contaT); 
	}

        public V_conta_pagar_pago_contaT findById(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception {
	  V_conta_pagar_pago_contaBL v_conta_pagar_pago_contaBL = new V_conta_pagar_pago_contaBL();
	  return v_conta_pagar_pago_contaBL.findbyid(v_conta_pagar_pago_contaT); 
	}

    	public List<V_conta_pagar_pago_contaT> getAll() throws Exception {
	  V_conta_pagar_pago_contaBL v_conta_pagar_pago_contaBL = new V_conta_pagar_pago_contaBL();
	  return v_conta_pagar_pago_contaBL.consult(); 
	}

	public void delete(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception {
	  V_conta_pagar_pago_contaBL v_conta_pagar_pago_contaBL = new V_conta_pagar_pago_contaBL();
	  v_conta_pagar_pago_contaBL.delete(v_conta_pagar_pago_contaT); 
	}

	public void update(V_conta_pagar_pago_contaT v_conta_pagar_pago_contaT) throws Exception {
	  V_conta_pagar_pago_contaBL v_conta_pagar_pago_contaBL = new V_conta_pagar_pago_contaBL();
	  v_conta_pagar_pago_contaBL.update(v_conta_pagar_pago_contaT); 
	}
}
