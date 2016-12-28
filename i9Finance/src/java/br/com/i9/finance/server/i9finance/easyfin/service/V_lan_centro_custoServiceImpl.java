package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "V_lan_centro_custoService", urlPatterns = {"/br.com.i9.finance.Main/rpc/v_lan_centro_custoservice"})
public class V_lan_centro_custoServiceImpl extends RemoteServiceServlet implements V_lan_centro_custoService {

	public void insert(V_lan_centro_custoT v_lan_centro_custoT) throws Exception {
	  V_lan_centro_custoBL v_lan_centro_custoBL = new V_lan_centro_custoBL();
	  v_lan_centro_custoBL.insert(v_lan_centro_custoT); 
	}

        public V_lan_centro_custoT findById(V_lan_centro_custoT v_lan_centro_custoT) throws Exception {
	  V_lan_centro_custoBL v_lan_centro_custoBL = new V_lan_centro_custoBL();
	  return v_lan_centro_custoBL.findbyid(v_lan_centro_custoT); 
	}

    	public List<V_lan_centro_custoT> getAll() throws Exception {
	  V_lan_centro_custoBL v_lan_centro_custoBL = new V_lan_centro_custoBL();
	  return v_lan_centro_custoBL.consult(); 
	}

	public void delete(V_lan_centro_custoT v_lan_centro_custoT) throws Exception {
	  V_lan_centro_custoBL v_lan_centro_custoBL = new V_lan_centro_custoBL();
	  v_lan_centro_custoBL.delete(v_lan_centro_custoT); 
	}

	public void update(V_lan_centro_custoT v_lan_centro_custoT) throws Exception {
	  V_lan_centro_custoBL v_lan_centro_custoBL = new V_lan_centro_custoBL();
	  v_lan_centro_custoBL.update(v_lan_centro_custoT); 
	}
}
