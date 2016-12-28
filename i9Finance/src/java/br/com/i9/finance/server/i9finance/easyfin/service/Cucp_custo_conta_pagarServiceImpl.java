package br.com.i9.finance.server.i9finance.easyfin.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.*;
import br.com.i9.finance.client.i9finance.easyfin.service.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;
import br.com.i9.finance.server.bl.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Cucp_custo_conta_pagarService", urlPatterns = {"/br.com.i9.finance.Main/rpc/cucp_custo_conta_pagarservice"})
public class Cucp_custo_conta_pagarServiceImpl extends RemoteServiceServlet implements Cucp_custo_conta_pagarService {

	public void insert(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception {
	  Cucp_custo_conta_pagarBL cucp_custo_conta_pagarBL = new Cucp_custo_conta_pagarBL();
	  cucp_custo_conta_pagarBL.insert(cucp_custo_conta_pagarT); 
	}

        public Cucp_custo_conta_pagarT findById(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception {
	  Cucp_custo_conta_pagarBL cucp_custo_conta_pagarBL = new Cucp_custo_conta_pagarBL();
	  return cucp_custo_conta_pagarBL.findbyid(cucp_custo_conta_pagarT); 
	}

    	public List<Cucp_custo_conta_pagarT> getAll() throws Exception {
	  Cucp_custo_conta_pagarBL cucp_custo_conta_pagarBL = new Cucp_custo_conta_pagarBL();
	  return cucp_custo_conta_pagarBL.consult(); 
	}

	public void delete(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception {
	  Cucp_custo_conta_pagarBL cucp_custo_conta_pagarBL = new Cucp_custo_conta_pagarBL();
	  cucp_custo_conta_pagarBL.delete(cucp_custo_conta_pagarT); 
	}

	public void update(Cucp_custo_conta_pagarT cucp_custo_conta_pagarT) throws Exception {
	  Cucp_custo_conta_pagarBL cucp_custo_conta_pagarBL = new Cucp_custo_conta_pagarBL();
	  cucp_custo_conta_pagarBL.update(cucp_custo_conta_pagarT); 
	}
}
