package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "V_conta_receber_pagoService", urlPatterns = {"/br.com.i9.finance.Main/rpc/v_conta_receber_pagoservice"})
public class V_conta_receber_pagoServiceImpl extends RemoteServiceServlet implements V_conta_receber_pagoService {

	public void insert(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception {
	  V_conta_receber_pagoBL v_conta_receber_pagoBL = new V_conta_receber_pagoBL();
	  v_conta_receber_pagoBL.insert(v_conta_receber_pagoT); 
	}

        public V_conta_receber_pagoT findById(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception {
	  V_conta_receber_pagoBL v_conta_receber_pagoBL = new V_conta_receber_pagoBL();
	  return v_conta_receber_pagoBL.findbyid(v_conta_receber_pagoT); 
	}

    	public List<V_conta_receber_pagoT> getAll() throws Exception {
	  V_conta_receber_pagoBL v_conta_receber_pagoBL = new V_conta_receber_pagoBL();
	  return v_conta_receber_pagoBL.consult(); 
	}

	public void delete(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception {
	  V_conta_receber_pagoBL v_conta_receber_pagoBL = new V_conta_receber_pagoBL();
	  v_conta_receber_pagoBL.delete(v_conta_receber_pagoT); 
	}

	public void update(V_conta_receber_pagoT v_conta_receber_pagoT) throws Exception {
	  V_conta_receber_pagoBL v_conta_receber_pagoBL = new V_conta_receber_pagoBL();
	  v_conta_receber_pagoBL.update(v_conta_receber_pagoT); 
	}
}
